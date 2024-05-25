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
import br.com.gerenciaprotocolo.service.SituacaoProtocoloService;

@RestController
@RequestMapping("/api/situacaoProtocolo")
public class SituacaoProtocoloController {

    @Autowired
    private SituacaoProtocoloService situacaoProtocoloService;

    @GetMapping
    public List<SituacaoProtocolo> getAllSituacaoProtocolos(){
        return situacaoProtocoloService.findAll();
    }

    @PostMapping
    public SituacaoProtocolo createSituacaoProtocolo(@RequestBody SituacaoProtocolo situacaoProtocolo){
        return situacaoProtocoloService.saveSituacaoProtocolo(situacaoProtocolo);
    }

    @GetMapping("/{id}")
    public SituacaoProtocolo geSituacaoProtocolo(@PathVariable Long id){
        return situacaoProtocoloService.findById(id);
    }

    @PutMapping("/{id}")
        public SituacaoProtocolo updatedSituacaoProtocolo(@PathVariable Long id, @RequestBody SituacaoProtocolo situacaoProtocoloDetails){
            return situacaoProtocoloService.updateSituacaoProtocolo(id, situacaoProtocoloDetails);
        }
        
    @DeleteMapping("/{id}")
    public void deleteSituacaoProtocolo(@PathVariable Long id){
        situacaoProtocoloService.deleteSituacaoProtocolo(id);
    }        
}
     

