package com.dio.api.controller;

import com.dio.api.model.Calendario;
import com.dio.api.service.CalendarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "calendario")
public class CalendarioController {

    @Autowired
    private CalendarioService service;

    @GetMapping
    public ResponseEntity<List<Calendario>> findAll() {
        List<Calendario> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Calendario> findById(@PathVariable Long id) {
        Calendario obj = service.findById(id);
        return  ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public ResponseEntity<Calendario> create(@RequestBody Calendario obj) {
        Calendario newObj = service.create(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return  ResponseEntity.created(uri).build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Calendario> update (@PathVariable Long id, @RequestBody Calendario obj) {
        obj = service.update(id, obj);
        return  ResponseEntity.ok().body(obj);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
