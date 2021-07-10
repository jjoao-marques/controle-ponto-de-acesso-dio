package com.dio.api.controller;

import com.dio.api.model.User;
import com.dio.api.model.UserCategory;
import com.dio.api.service.UserCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/userCategories")
public class UserCategoryController {

    @Autowired
    private UserCategoryService service;

    @GetMapping
    public ResponseEntity<List<UserCategory>> findAll() {
        List<UserCategory> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<UserCategory> findById (@PathVariable Long id) {
        UserCategory obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public ResponseEntity<UserCategory> create (@RequestBody UserCategory obj) {
        UserCategory newObj = service.create(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();

        return ResponseEntity.created(uri).build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<UserCategory> update(@PathVariable Long id, @RequestBody UserCategory obj) {
        obj = service.update(id, obj);
        return  ResponseEntity.ok().body(obj);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete (Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
