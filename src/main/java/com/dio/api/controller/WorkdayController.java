package com.dio.api.controller;

import com.dio.api.model.Workday;
import com.dio.api.service.WorkdayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/workday")
public class WorkdayController {

    @Autowired
    private WorkdayService workdayService;

    @PostMapping
    public ResponseEntity<Workday> create (@RequestBody Workday workday) {
        Workday newWorkday = workdayService.create(workday);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newWorkday.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @GetMapping
    public ResponseEntity<List<Workday>> findAll () {
        List<Workday> listWorkday =  workdayService.findAll();
        return ResponseEntity.ok().body(listWorkday);
    }


    @GetMapping(value = "/{id}")
    public ResponseEntity<Workday> findById(@PathVariable Long id) {
        Workday workday = workdayService.findById(id);
        return ResponseEntity.ok().body(workday);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Workday> updateWorday (@PathVariable Long id, @RequestBody Workday obj) {
         obj = workdayService.update(id, obj) ;
        return ResponseEntity.ok().body(obj);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete (@PathVariable Long id) {
        workdayService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
