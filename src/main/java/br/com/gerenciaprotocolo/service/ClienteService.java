package br.com.gerenciaprotocolo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gerenciaprotocolo.model.Cliente;
import br.com.gerenciaprotocolo.repository.ClienteRepository;
import jakarta.persistence.EntityNotFoundException;

@Service
public class ClienteService {
    
    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente saveCliente(Cliente cliente){
        return clienteRepository.save(cliente);
    }

    public Cliente updateCliente(Long cliente_id, Cliente updatedCliente){
        Cliente existingCliente = clienteRepository.findById(cliente_id).orElseThrow(() -> new EntityNotFoundException("Cliente nao encontrado com o ID: " + cliente_id));
        
        existingCliente.setNome(updatedCliente.getNome());
        existingCliente.setCpf(updatedCliente.getCpf());
        existingCliente.setEmail(updatedCliente.getEmail());
        //TIPOCLIENTE
        return clienteRepository.save(existingCliente);
    }

    public void deleteCliente(Long id){
        clienteRepository.deleteById(id);
    }

    public Cliente findByCliente(Long id){
        return clienteRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Cliente nao encontrado pelo ID: " + id));
        
    }

}
