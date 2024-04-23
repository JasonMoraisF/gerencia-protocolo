package br.com.gerenciaprotocolo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import br.com.gerenciaprotocolo.model.Protocolo;
import br.com.gerenciaprotocolo.repository.ProtocoloRepository;

import java.util.List;

@RestController
@RequestMapping("/api/protocolos")
public class ProtocoloController {

    @Autowired
    private ProtocoloRepository protocoloRepository;

    @GetMapping
    public List<Protocolo> getAllProtocolos() {
        return protocoloRepository.findAll();
    }

    @PostMapping
    public Protocolo createProtocolo(@RequestBody Protocolo protocolo) {
        return protocoloRepository.save(protocolo);
    }

    @GetMapping("/{id}")
    public Protocolo getProtocoloById(@PathVariable Long id) {
        return protocoloRepository.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public Protocolo updateProtocolo(@PathVariable Long id, @RequestBody Protocolo protocoloDetails) {
        Protocolo protocolo = protocoloRepository.findById(id).orElse(null);
        if (protocolo != null) {
            return protocoloRepository.save(protocolo);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteProtocolo(@PathVariable Long id) {
        protocoloRepository.deleteById(id);
    }
}