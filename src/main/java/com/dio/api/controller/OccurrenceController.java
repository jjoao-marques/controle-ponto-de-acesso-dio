package com.dio.api.controller;

import com.dio.api.model.Occurrence;
import com.dio.api.service.OccurrenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/occurrences")
public class OccurrenceController {

    @Autowired
    private OccurrenceService service;

    @GetMapping
    public ResponseEntity<List<Occurrence>> findAll() {
        List<Occurrence> list = service.findAll();
        return  ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Occurrence> findById(@PathVariable Long id) {
        Occurrence obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public ResponseEntity<Occurrence> create(@RequestBody Occurrence obj) {
        Occurrence newObj = service.create(obj);
        URI uri  = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return  ResponseEntity.created(uri).build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Occurrence> update (@PathVariable Long id, @RequestBody Occurrence obj) {
        obj = service.update(id, obj);
        return  ResponseEntity.ok().body(obj);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete (@PathVariable Long id) {
        service.delete(id);
        return  ResponseEntity.noContent().build();
    }
}
