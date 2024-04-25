package br.com.gerenciaprotocolo.controller;

import java.util.List;

// import org.apache.tomcat.util.http.parser.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import br.com.gerenciaprotocolo.model.Conta;
import br.com.gerenciaprotocolo.repository.ContaRepository;

@RestController
@RequestMapping("/api/contas")
public class ContaController {

    @Autowired
    private ContaRepository contaRepository;

    @GetMapping
    public List<Conta> getAllContas() {
        return contaRepository.findAll();
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public Conta createConta(@RequestBody Conta conta) {
        return contaRepository.save(conta);
    }

    @GetMapping("/{id}")
    public Conta getContaById(@PathVariable Long id) {
        return contaRepository.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public Conta updateConta(@PathVariable Long id, @RequestBody Conta contaDetails) {
        Conta conta = contaRepository.findById(id).orElse(null);
        if (conta != null) {
            conta.setAgencia(contaDetails.getAgencia());
            conta.setNumeroConta(contaDetails.getNumeroConta());
            conta.setTipoClienteID(contaDetails.getTipoClienteID());
            conta.setStatusConta(contaDetails.getStatusConta());
            return contaRepository.save(conta);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteConta(@PathVariable Long id) {
        contaRepository.deleteById(id);
    }
}
