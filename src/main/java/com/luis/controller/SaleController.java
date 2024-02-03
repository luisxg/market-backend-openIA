package com.luis.controller;

import com.luis.dto.SaleDTO;
import com.luis.exception.ModelNotFoundException;
import com.luis.model.Sale;
import com.luis.service.ISaleService;
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
@RequestMapping("/sales")
public class SaleController {

    @Autowired
    private ISaleService service;

    @Autowired
    private ModelMapper mapper;

    @GetMapping
    public ResponseEntity<List<SaleDTO>>  findAll(){
        List<SaleDTO> dtoList = service.findAll().stream().map(obj -> mapper.map(obj,SaleDTO.class)).collect(Collectors.toList());
        return new ResponseEntity<>(dtoList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SaleDTO> findById(@PathVariable("id") Integer id){
        SaleDTO dto;
        Sale obj = service.findById(id);
        if (obj == null) {
            throw new ModelNotFoundException("ID not found "+id);
        }else {
            dto = mapper.map(obj,SaleDTO.class);
        }
        return new ResponseEntity<>(dto,HttpStatus.OK);

    }

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody SaleDTO objDTO){
        Sale obj = service.save(mapper.map(objDTO,Sale.class));
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdSale()).toUri();

        return ResponseEntity.created(location).build();
    }

    @PutMapping
    public ResponseEntity<Sale> update(@RequestBody SaleDTO objDTO){

        Sale obj = service.findById(objDTO.getIdSale());

        if (obj == null) {
            throw new ModelNotFoundException("ID not found "+objDTO.getIdSale());
        }else {
            return new ResponseEntity<>(service.update(mapper.map(objDTO, Sale.class)),HttpStatus.OK);
        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable("id") Integer id){
        Sale obj = service.findById(id);

        if (obj == null) {
            throw new ModelNotFoundException("ID not found "+id);
        }else {
            service.delete(id);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
