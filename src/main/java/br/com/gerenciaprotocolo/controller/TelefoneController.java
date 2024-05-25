package br.com.gerenciaprotocolo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.gerenciaprotocolo.model.Telefone;
import br.com.gerenciaprotocolo.service.TelefoneService;

@RestController
@RequestMapping("/api/telefones")
public class TelefoneController {


    @Autowired
    private TelefoneService telefoneService;

    @GetMapping
    public List<Telefone> getAllTelefones(){
        return telefoneService.findAllTelefones();
    }

    @GetMapping("/{id}")
    public Telefone getTelefoneById(@PathVariable Long id){
        return telefoneService.findTelefoneById(id);
    }


    @PutMapping("/{id}")
    public Telefone updateTelefone(@PathVariable Long id, @RequestBody Telefone telefoneDetails){
       return telefoneService.updateTelefone(id, telefoneDetails);
    }

    @DeleteMapping("/{id}")
    public void deleteTelefone(@PathVariable Long id){
        telefoneService.deleteTelefone(id);
    }
    

}
