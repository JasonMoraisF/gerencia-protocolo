package br.com.gerenciaprotocolo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import br.com.gerenciaprotocolo.model.Canal;
import br.com.gerenciaprotocolo.repository.CanalRepository;

@RestController
@RequestMapping("/api/canais")
public class CanalController {

    @Autowired
    private CanalRepository canalRepository;

    @GetMapping
    public List<Canal> getAllCanais() {
        return canalRepository.findAll();
    }

    @PostMapping
    public Canal createCanal(@RequestBody Canal canal) {
        return canalRepository.save(canal);
    }

    @GetMapping("/{id}")
    public Canal getCanalById(@PathVariable Long id) {
        return canalRepository.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public Canal updateCanal(@PathVariable Long id, @RequestBody Canal canalDetails) {
        Canal canal = canalRepository.findById(id).orElse(null);
        if (canal != null) {
            //canal.setTipoCanal(canalDetails.getTipoCanal());
            return canalRepository.save(canal);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteCanal(@PathVariable Long id) {
        canalRepository.deleteById(id);
    }
}
