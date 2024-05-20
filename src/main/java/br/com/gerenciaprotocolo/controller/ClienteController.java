package br.com.gerenciaprotocolo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import br.com.gerenciaprotocolo.model.Cliente;
import br.com.gerenciaprotocolo.repository.ClienteRepository;
import br.com.gerenciaprotocolo.repository.TelefoneRepository;
import jakarta.persistence.EntityNotFoundException;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {
 
    @Autowired
    private ClienteRepository clienteRepository;

     @Autowired
    private TelefoneRepository telefoneRepository;

    @GetMapping
    public List<Cliente> getAllClientes() {
        return clienteRepository.findAll();
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public Cliente createCliente(@RequestBody Cliente cliente) {
        Cliente savedCliente;
        savedCliente = clienteRepository.save(cliente);
        
        if(savedCliente.getTelefones() != null &&!savedCliente.getTelefones().isEmpty()){
            savedCliente.getTelefones().forEach(telefone ->{
                telefone.setCliente(savedCliente);
                telefoneRepository.save(telefone);
            });
        }
        return savedCliente;
    }
 
    @GetMapping("/{id}")
    public Cliente getClienteById(@PathVariable Long id) {
        return clienteRepository.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public Cliente updateCliente(@PathVariable Long id, @RequestBody Cliente clienteDetails) {
        Cliente cliente = clienteRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Cliente nao encontrado com o ID: " + id));
        if (cliente != null) {
            cliente.setCpf(clienteDetails.getCpf());
            cliente.setNome(clienteDetails.getNome());
            cliente.setEmail(clienteDetails.getEmail());
            return clienteRepository.save(cliente);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteCliente(@PathVariable Long id) {
        clienteRepository.deleteById(id);
    }
}
