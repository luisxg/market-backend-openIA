package com.luis.controller;

import com.luis.dto.ClientDTO;
import com.luis.exception.ModelNotFoundException;
import com.luis.model.Client;
import com.luis.service.IClientService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

//@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/clients")
public class ClientController {

    @Autowired
    private IClientService service;

    @Autowired
    private ModelMapper mapper;

    @GetMapping
    public ResponseEntity<List<ClientDTO>>  findAll(){
        List<ClientDTO> dtoList = service.findAll().stream().map(obj -> mapper.map(obj,ClientDTO.class)).collect(Collectors.toList());
        return new ResponseEntity<>(dtoList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClientDTO> findById(@PathVariable("id") Integer id){
        ClientDTO dto;
        Client obj = service.findById(id);
        if (obj == null) {
            throw new ModelNotFoundException("ID not found "+id);
        }else {
            dto = mapper.map(obj,ClientDTO.class);
        }
        return new ResponseEntity<>(dto,HttpStatus.OK);

    }

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody ClientDTO objDTO){
        Client obj = service.save(mapper.map(objDTO,Client.class));
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdClient()).toUri();

        return ResponseEntity.created(location).build();
    }

    @PutMapping
    public ResponseEntity<Client> update(@RequestBody ClientDTO objDTO){

        Client obj = service.findById(objDTO.getIdClient());

        if (obj == null) {
            throw new ModelNotFoundException("ID not found "+objDTO.getIdClient());
        }else {
            return new ResponseEntity<>(service.update(mapper.map(objDTO, Client.class)),HttpStatus.OK);
        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable("id") Integer id){
        Client obj = service.findById(id);

        if (obj == null) {
            throw new ModelNotFoundException("ID not found "+id);
        }else {
            service.delete(id);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
