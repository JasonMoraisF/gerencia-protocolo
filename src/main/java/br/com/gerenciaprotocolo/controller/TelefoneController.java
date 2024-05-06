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

import br.com.gerenciaprotocolo.model.Telefone;
import br.com.gerenciaprotocolo.repository.TelefoneRepository;

@RestController
@RequestMapping("/api/telefones")
public class TelefoneController {

    @Autowired
    private TelefoneRepository telefoneRepository;

    @GetMapping
    public List<Telefone> getAllTelefones(){
        return telefoneRepository.findAll();
    }

    @GetMapping("/{id}")
    public Telefone getTelefoneById(@PathVariable Long id){
        return telefoneRepository.findById(id).orElse(null);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public Telefone createTelefone(@RequestBody Telefone telefone){
        return telefoneRepository.save(telefone);
    }


    @PutMapping("/{id}")
    public Telefone updateTelefone(@PathVariable Long id, @RequestBody Telefone telefoneDetails){
        Telefone telefone = telefoneRepository.findById(id).orElse(null);
        if(telefone != null){
            telefone.setNumero(telefoneDetails.getNumero());
            telefone.setDdd(telefoneDetails.getDdd());
            telefone.setTipoTelefone(telefoneDetails.getTipoTelefone());
            return telefoneRepository.save(telefone);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteTelefone(@PathVariable Long id){
        telefoneRepository.deleteById(id);
    }
    

}
