package com.dio.api.controller;

import com.dio.api.model.AccessLevel;
import com.dio.api.service.AccessLevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "accessLevel")
public class AccessLevelController {

    @Autowired
    private AccessLevelService service;

    @GetMapping
    public ResponseEntity<List<AccessLevel>> findAll() {
        List<AccessLevel> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<AccessLevel> findById(@PathVariable Long id) {
        AccessLevel obj = service.findById(id);
        return  ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public ResponseEntity<AccessLevel> create(@RequestBody AccessLevel obj) {
        AccessLevel newObj = service.create(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return  ResponseEntity.created(uri).build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<AccessLevel> update (@PathVariable Long id, @RequestBody AccessLevel obj) {
        obj = service.update(id, obj);
        return  ResponseEntity.ok().body(obj);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
