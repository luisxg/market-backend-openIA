package com.luis.controller;

import com.luis.dto.CategoryDTO;
import com.luis.exception.ModelNotFoundException;
import com.luis.model.Category;
import com.luis.repo.ICategoryRepo;
import com.luis.service.ICategoryService;
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
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    private ICategoryService service;

    @Autowired
    private ModelMapper mapper;

    @GetMapping
    public ResponseEntity<List<CategoryDTO>>  findAll(){
        List<CategoryDTO> dtoList = service.findAll().stream().map(obj -> mapper.map(obj,CategoryDTO.class)).collect(Collectors.toList());
        return new ResponseEntity<>(dtoList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryDTO> findById(@PathVariable("id") Integer id){
        CategoryDTO dto;
        Category obj = service.findById(id);
        if (obj == null) {
            throw new ModelNotFoundException("ID not found "+id);
        }else {
            dto = mapper.map(obj,CategoryDTO.class);
        }
        return new ResponseEntity<>(dto,HttpStatus.OK);

    }

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody CategoryDTO objDTO){
        Category obj = service.save(mapper.map(objDTO,Category.class));
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdCategory()).toUri();

        return ResponseEntity.created(location).build();
    }

    @PutMapping
    public ResponseEntity<Category> update(@RequestBody CategoryDTO objDTO){

        Category obj = service.findById(objDTO.getIdCategory());

        if (obj == null) {
            throw new ModelNotFoundException("ID not found "+objDTO.getIdCategory());
        }else {
            return new ResponseEntity<>(service.update(mapper.map(objDTO, Category.class)),HttpStatus.OK);
        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable("id") Integer id){
        Category obj = service.findById(id);

        if (obj == null) {
            throw new ModelNotFoundException("ID not found "+id);
        }else {
            service.delete(id);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
