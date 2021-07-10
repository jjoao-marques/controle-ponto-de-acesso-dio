package com.dio.api.controller;

import com.dio.api.model.TypeDate;
import com.dio.api.service.TypeDateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/dataTypes")
public class TypeDateController {

    @Autowired
    private TypeDateService service;

    @GetMapping
    public ResponseEntity<List<TypeDate>> findAll() {
        List<TypeDate> list = service.findAll();
        return  ResponseEntity.ok().body(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TypeDate> findById(@PathVariable Long id) {
        TypeDate obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public ResponseEntity<TypeDate> create(@RequestBody TypeDate obj) {
        TypeDate newObj = service.create(obj);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return  ResponseEntity.created(uri).build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<TypeDate> update (@PathVariable Long id, @RequestBody TypeDate obj) {
        obj = service.update(id, obj);
        return ResponseEntity.ok().body(obj);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
