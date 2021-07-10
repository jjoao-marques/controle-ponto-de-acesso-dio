package com.dio.api.controller;

import com.dio.api.model.BancoDeHoras;
import com.dio.api.model.BancoDeHoras;
import com.dio.api.service.BancoDeHorasService;
import com.dio.api.service.BancoDeHorasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "bancoDeHoras")
public class BancoDeHorasController {

    @Autowired
    private BancoDeHorasService service;

    @GetMapping
    public ResponseEntity<List<BancoDeHoras>> findAll() {
        List<BancoDeHoras> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<BancoDeHoras> findById(@PathVariable Long id) {
        BancoDeHoras obj = service.findById(id);
        return  ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public ResponseEntity<BancoDeHoras> create(@RequestBody BancoDeHoras obj) {
        BancoDeHoras newObj = service.create(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getBancoDeHorasId()).toUri();
        return  ResponseEntity.created(uri).build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<BancoDeHoras> update (@PathVariable Long id, @RequestBody BancoDeHoras obj) {
        obj = service.update(id, obj);
        return  ResponseEntity.ok().body(obj);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
