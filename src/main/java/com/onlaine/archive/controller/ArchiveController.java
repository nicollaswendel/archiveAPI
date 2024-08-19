package com.onlaine.archive.controller;

import com.onlaine.archive.domain.Archive;
import com.onlaine.archive.service.ArchiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/archive")
public class ArchiveController {

    @Autowired
    private ArchiveService service;

    @GetMapping
    public ResponseEntity<List<Archive>> listAll(){
        List<Archive> archive = service.listAll();
        return ResponseEntity.ok(archive);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Archive> getById(@PathVariable int id){
        Optional<Archive> optArchive = service.getById(id);

        if(optArchive.isEmpty()){
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(optArchive.get());
        }
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<Archive> getByName(@PathVariable String name){
        Optional<Archive> nameArchive = service.getByName(name);
        if(nameArchive.isEmpty()){
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(nameArchive.get());
        }
    }

    @PostMapping
    public ResponseEntity<Archive> save(@RequestBody Archive archive){
        Archive saved = service.save(archive);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping
    public ResponseEntity<Archive> update(@RequestBody Archive archive){
        Archive update = service.save(archive);
        return ResponseEntity.ok(update);
    }
}