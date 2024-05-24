package br.com.gerenciaprotocolo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.gerenciaprotocolo.model.SituacaoProtocolo;
import br.com.gerenciaprotocolo.repository.SituacaoProtocoloRepository;

@RestController
@RequestMapping("/api/situacaoProtocolo")
public class SituacaoProtocoloController {

    @Autowired
    private SituacaoProtocoloRepository situacaoProtocoloRepository;

    @GetMapping
    public List<SituacaoProtocolo> getAllSituacaoProtocolos(){
        return situacaoProtocoloRepository.findAll();
    }

    @PostMapping
    public SituacaoProtocolo createSituacaoProtocolo(@RequestBody SituacaoProtocolo situacaoProtocolo){
        return situacaoProtocoloRepository.save(situacaoProtocolo);
    }

    @GetMapping("/{id}")
    public SituacaoProtocolo geSituacaoProtocolo(@PathVariable Long id){
        return situacaoProtocoloRepository.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
        public SituacaoProtocolo updatedSituacaoProtocolo(@PathVariable Long id, @RequestBody SituacaoProtocolo situacaoProtocoloDetails){
            SituacaoProtocolo situacaoProtocolo = situacaoProtocoloRepository.findById(id).orElse(null);
            if (situacaoProtocolo != null){
                return situacaoProtocoloRepository.save(situacaoProtocolo);
            }
            return null;
        }
        
    

    @DeleteMapping("/{id}")
    public void deleteSituacaoProtocolo(@PathVariable Long id){
        situacaoProtocoloRepository.deleteById(id);
    }        
}
     

