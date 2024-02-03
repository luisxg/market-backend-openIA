package com.luis.controller;

import com.luis.dto.PayModeDTO;
import com.luis.exception.ModelNotFoundException;
import com.luis.model.PayMode;
import com.luis.service.IPayModeService;
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
@RequestMapping("/paymodes")
public class PayModeController {

    @Autowired
    private IPayModeService service;

    @Autowired
    private ModelMapper mapper;

    @GetMapping
    public ResponseEntity<List<PayModeDTO>>  findAll(){
        List<PayModeDTO> dtoList = service.findAll().stream().map(obj -> mapper.map(obj,PayModeDTO.class)).collect(Collectors.toList());
        return new ResponseEntity<>(dtoList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PayModeDTO> findById(@PathVariable("id") Integer id){
        PayModeDTO dto;
        PayMode obj = service.findById(id);
        if (obj == null) {
            throw new ModelNotFoundException("ID not found "+id);
        }else {
            dto = mapper.map(obj,PayModeDTO.class);
        }
        return new ResponseEntity<>(dto,HttpStatus.OK);

    }

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody PayModeDTO objDTO){
        PayMode obj = service.save(mapper.map(objDTO,PayMode.class));
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdPayMode()).toUri();

        return ResponseEntity.created(location).build();
    }

    @PutMapping
    public ResponseEntity<PayMode> update(@RequestBody PayModeDTO objDTO){

        PayMode obj = service.findById(objDTO.getIdPayMode());

        if (obj == null) {
            throw new ModelNotFoundException("ID not found "+objDTO.getIdPayMode());
        }else {
            return new ResponseEntity<>(service.update(mapper.map(objDTO, PayMode.class)),HttpStatus.OK);
        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable("id") Integer id){
        PayMode obj = service.findById(id);

        if (obj == null) {
            throw new ModelNotFoundException("ID not found "+id);
        }else {
            service.delete(id);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
