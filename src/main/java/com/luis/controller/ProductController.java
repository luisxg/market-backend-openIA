package com.luis.controller;

import com.luis.dto.ProductDTO;
import com.luis.exception.ModelNotFoundException;
import com.luis.model.Category;
import com.luis.model.Product;
import com.luis.service.IProductService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.math.BigDecimal;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

//@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private IProductService service;

    @Autowired
    private ModelMapper mapper;

    @GetMapping
    public ResponseEntity<List<ProductDTO>>  findAll(){
        List<ProductDTO> dtoList = service.findAll().stream().map(obj -> mapper.map(obj,ProductDTO.class)).collect(Collectors.toList());
        return new ResponseEntity<>(dtoList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> findById(@PathVariable("id") Integer id){
        ProductDTO dto;
        Product obj = service.findById(id);
        if (obj == null) {
            throw new ModelNotFoundException("ID not found "+id);
        }else {
            dto = mapper.map(obj,ProductDTO.class);
        }
        return new ResponseEntity<>(dto,HttpStatus.OK);

    }

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody ProductDTO objDTO){
        Product obj = service.save(mapper.map(objDTO,Product.class));
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdProduct()).toUri();

        return ResponseEntity.created(location).build();
    }

    @PutMapping
    public ResponseEntity<Product> update(@RequestBody ProductDTO objDTO){

        Product obj = service.findById(objDTO.getIdProduct());

        if (obj == null) {
            throw new ModelNotFoundException("ID not found "+objDTO.getIdProduct());
        }else {
            return new ResponseEntity<>(service.update(mapper.map(objDTO, Product.class)),HttpStatus.OK);
        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable("id") Integer id){
        Product obj = service.findById(id);

        if (obj == null) {
            throw new ModelNotFoundException("ID not found "+id);
        }else {
            service.delete(id);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/searchName/{name}")
    public ResponseEntity<ProductDTO> findById(@PathVariable("name") String name){
        ProductDTO dto = new ProductDTO(0,"00000000","null", new BigDecimal(0),0,"null",new Category());
        Product obj = service.findByName(name);
        if (obj == null) {
            return new ResponseEntity<>(dto,HttpStatus.OK);
        }else {
            dto = mapper.map(obj,ProductDTO.class);
        }
        return new ResponseEntity<>(dto,HttpStatus.OK);

    }
}
