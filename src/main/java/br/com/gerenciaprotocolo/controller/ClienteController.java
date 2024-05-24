package br.com.gerenciaprotocolo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import br.com.gerenciaprotocolo.model.Cliente;
import br.com.gerenciaprotocolo.service.ClienteService;
import jakarta.persistence.EntityNotFoundException;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {
 
    @Autowired
    private ClienteService clienteService;

     @Autowired

    @GetMapping
    public List<Cliente> getAllClientes() {
        return clienteService.findAll();
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public Cliente createCliente(@RequestBody Cliente cliente) {
        return clienteService.saveCliente(cliente);
    }
 
    @GetMapping("/{id}")
    public Cliente getClienteById(@PathVariable Long id) {
        return clienteService.findByCliente(id);
    }

    @PutMapping("/{id}")
    public Cliente updateCliente(@PathVariable Long id, @RequestBody Cliente clienteDetails) {
        return clienteService.updateCliente(id, clienteDetails);
    }

    @DeleteMapping("/{id}")
    public void deleteCliente(@PathVariable Long id) {
        clienteService.deleteCliente(id);
    }
}
