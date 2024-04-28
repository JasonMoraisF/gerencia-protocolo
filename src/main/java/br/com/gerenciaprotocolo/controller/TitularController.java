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
import br.com.gerenciaprotocolo.repository.TitularRepository;

@RestController
@RequestMapping("/api/titulares")
public class TitularController {

    @Autowired
    private TitularRepository titularRepository;
    
    @GetMapping
    public List<Titular> getAllTitulares(){
        return titularRepository.findAll();
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public Titular createTitular(@RequestBody Titular titular){
        return titularRepository.save(titular);
    }

    @GetMapping("/{id}")
    public Titular geTitularById(@PathVariable Long id){
        return titularRepository.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public Titular updateTitular(@PathVariable Long id, @RequestBody Titular titularDetails){
        Titular titular = titularRepository.findById(id).orElse(null);
        if(titular != null){
            titular.setCpf(titularDetails.getCpf());
            titular.setNome(titularDetails.getNome());
            titular.setEmail(titularDetails.getEmail());
            titular.setProfissao(titularDetails.getProfissao());
            return titularRepository.save(titular);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteTitular(@PathVariable Long id){
        titularRepository.deleteById(id);
    }

}
