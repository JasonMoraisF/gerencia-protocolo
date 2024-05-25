package br.com.gerenciaprotocolo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import br.com.gerenciaprotocolo.model.Protocolo;
import br.com.gerenciaprotocolo.repository.ProtocoloRepository;
import br.com.gerenciaprotocolo.service.ProtocoloService;

import java.util.List;

@RestController
@RequestMapping("/api/protocolos")
public class ProtocoloController {

    @Autowired
    private ProtocoloService protocoloService;

    @GetMapping
    public List<Protocolo> getAllProtocolos() {
        return protocoloService.findAll();
    }

    @PostMapping
    public Protocolo createProtocolo(@RequestBody Protocolo protocolo) {
        return protocoloService.createProtocolo(protocolo);
    }

    @GetMapping("/{id}")
    public Protocolo getProtocoloById(@PathVariable Long id) {
        return protocoloService.findByProtocolo(id);
    }

    @PutMapping("/{id}")
    public Protocolo updateProtocolo(@PathVariable Long id, @RequestBody Protocolo protocoloDetails) {
        return protocoloService.updateProtocolo(id, protocoloDetails);
    }

    @DeleteMapping("/{id}")
    public void deleteProtocolo(@PathVariable Long id) {
        protocoloService.deleteProtocolo(id);
    }
}