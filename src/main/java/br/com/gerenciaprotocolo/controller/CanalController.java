package br.com.gerenciaprotocolo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import br.com.gerenciaprotocolo.model.Canal;
import br.com.gerenciaprotocolo.service.CanalService;

@RestController
@RequestMapping("/api/canais")
public class CanalController {

    @Autowired
    private CanalService canalService;

    @GetMapping
    public List<Canal> getAllCanais() {
        return canalService.findAll();
    }

    @PostMapping
    public Canal createCanal(@RequestBody Canal canal) {
        return canalService.create(canal);
    }

    @GetMapping("/{id}")
    public Canal getCanalById(@PathVariable Long id) {
        return canalService.findById(id);
    }

    @PutMapping("/{id}")
    public Canal updateCanal(@PathVariable Long id, @RequestBody Canal canalDetails) {
        return canalService.update(id, canalDetails);
    }

    @PutMapping("/{idCanal}/{idProtocolo}")
    public Canal removeProtocolo(@PathVariable Long idCanal, @PathVariable Long idProtocolo) {
        return canalService.removeProtocolo(idCanal, idProtocolo);
    }

    @DeleteMapping("/{id}")
    public void deleteCanal(@PathVariable Long id) {
        canalService.delete(id);
    }
}
