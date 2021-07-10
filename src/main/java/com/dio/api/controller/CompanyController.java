package com.dio.api.controller;

import com.dio.api.model.Company;
import com.dio.api.service.CompanyService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/companies")
public class CompanyController {

    @Autowired
    private CompanyService companyService;


    @GetMapping
    public ResponseEntity<List<Company>> findAll() {
        List<Company> list = companyService.findAll();
        return  ResponseEntity.ok().body(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Company> findById(@PathVariable Long id) {
        return ResponseEntity.ok().body(companyService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Company> create (@RequestBody Company obj) {
        Company newObj = companyService.create(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Company> updateCompany (@PathVariable Long id, @RequestBody Company obj) {
        obj = companyService.update(id, obj);
        return ResponseEntity.ok().body(obj);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        companyService.delete(id);

        return ResponseEntity.noContent().build();
    }
}
