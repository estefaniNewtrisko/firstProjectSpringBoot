package com.example.seconddemo.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.seconddemo.models.Essen;
import com.example.seconddemo.repository.EssenRepository;

@RestController
@RequestMapping("/api/v1")
public class EssenController {
    
    @Autowired
    private EssenRepository essenRepository;

    @GetMapping("/essens")
    public List < Essen > getAllEssen() {
        return essenRepository.findAll();
    }

    @GetMapping("/essen/{id}")
    public ResponseEntity < Essen > getEssenById(@PathVariable(value = "id") Integer id)
    throws ResourceNotFoundException {
        Essen essen = essenRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Essen not found for this id :: " + id));
        return ResponseEntity.ok().body(essen);
    }

    @PostMapping("/save")
    public Essen createEssen(@Valid @RequestBody Essen essen) {
        return essenRepository.save(essen);
    }

    @PutMapping("/essen/{id}")
    public ResponseEntity < Essen > updateEssen(@PathVariable(value = "id") Integer id,
        @Valid @RequestBody Essen essenDetails) throws ResourceNotFoundException {
        Essen essen = essenRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Essen not found for this id :: " + id));

        essen.setTitle(essenDetails.getTitle());
        essen.setPreis(essenDetails.getPreis());
        essen.setKoch_id(essenDetails.getKoch_id());
        final Essen updatedEssen = essenRepository.save(essen);
        return ResponseEntity.ok(updatedEssen);
    }

    @DeleteMapping("/essen/{id}")
    public Map < String, Boolean > deleteEssen(@PathVariable(value = "id") Integer id)
    throws ResourceNotFoundException {
        Essen essen = essenRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Essen not found for this id :: " + id));

        essenRepository.delete(essen);
        Map < String, Boolean > response = new HashMap < > ();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
