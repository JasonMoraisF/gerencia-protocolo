package br.com.gerenciaprotocolo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gerenciaprotocolo.model.Cliente;
import br.com.gerenciaprotocolo.model.Protocolo;
import br.com.gerenciaprotocolo.repository.ClienteRepository;
import br.com.gerenciaprotocolo.repository.ProtocoloRepository;
import br.com.gerenciaprotocolo.repository.TelefoneRepository;
import jakarta.persistence.EntityNotFoundException;

@Service
public class ClienteService {
    
    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private TelefoneRepository telefoneRepository;

    @Autowired
    private ProtocoloRepository protocoloRepository;

    public Cliente saveCliente(Cliente cliente){
        Cliente savedCliente;
        savedCliente = clienteRepository.save(cliente);
        Protocolo protocolo = savedCliente.getProtocolo();

        if(protocolo.getDataPrazo()== null){
            protocolo.calcularDataPrazo(protocolo);
            protocolo = protocoloRepository.save(protocolo);

        }
        if(savedCliente.getTelefones() != null &&!savedCliente.getTelefones().isEmpty()){
            savedCliente.getTelefones().forEach(telefone ->{
                telefone.setCliente(savedCliente);
                telefoneRepository.save(telefone);
            });
        }
        return savedCliente;
    }

    public Cliente updateCliente(Long cliente_id, Cliente updatedCliente){
        Cliente existingCliente = clienteRepository.findById(cliente_id).orElseThrow(() -> new EntityNotFoundException("Cliente nao encontrado com o ID: " + cliente_id));
        
        existingCliente.setNome(updatedCliente.getNome());
        existingCliente.setCpf(updatedCliente.getCpf());
        existingCliente.setEmail(updatedCliente.getEmail());
        return clienteRepository.save(existingCliente);
    }

    public void deleteCliente(Long id){
        clienteRepository.deleteById(id);
    }

    public Cliente findByCliente(Long id){
        return clienteRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Cliente nao encontrado pelo ID: " + id));
        
    }
    public List<Cliente> findAll(){
        return clienteRepository.findAll();
    }

}
