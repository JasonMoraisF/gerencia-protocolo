package br.com.gerenciaprotocolo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.gerenciaprotocolo.model.Titular;
import br.com.gerenciaprotocolo.service.TitularService;

@RestController
@RequestMapping("/api/titulares")
public class TitularController {

    @Autowired
    private TitularService titularService;
    
    @GetMapping
    public List<Titular> getAllTitulares(){
        return titularService.findAll();
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public Titular createTitular(@RequestBody Titular titular){
        Titular savedTitular = titularService.saveTitular(titular);
        return savedTitular;
    }

    @GetMapping("/{id}")
    public Titular getTitularById(@PathVariable Long id){
        return titularService.findById(id);
    }

    @PutMapping("/{id}")
    public Titular updateTitular(@PathVariable Long id, @RequestBody Titular titularDetails){
        return titularService.updateTitular(id, titularDetails);

    }

    @DeleteMapping("/{id}")
    public void deleteTitular(@PathVariable Long id){
        titularService.deleteTitular(id);
    }

}
