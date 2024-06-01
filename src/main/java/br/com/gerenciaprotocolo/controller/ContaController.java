package br.com.gerenciaprotocolo.controller;

import java.util.List;

// import org.apache.tomcat.util.http.parser.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import br.com.gerenciaprotocolo.model.Conta;
import br.com.gerenciaprotocolo.service.ContaService;
 
@RestController
@RequestMapping("/api/contas")
public class ContaController {

    @Autowired
    private ContaService contaService;

    @GetMapping
    public List<Conta> getAllContas() {
        return contaService.findAll();
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public Conta createConta(@RequestBody Conta conta) {
        return contaService.createConta(conta);
    }

    @GetMapping("/{id}")
    public Conta getContaById(@PathVariable Long id) {
        return contaService.findById(id);
    }

    @PutMapping("/{id}")
    public Conta updateConta(@PathVariable Long id, @RequestBody Conta contaDetails) {
        return contaService.updateConta(id, contaDetails);
    }

    @DeleteMapping("/{id}")
    public void deleteConta(@PathVariable Long id) {
        contaService.deleteConta(id);
    }
}
