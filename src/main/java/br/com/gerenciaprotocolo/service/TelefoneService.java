package br.com.gerenciaprotocolo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gerenciaprotocolo.model.Telefone;
import br.com.gerenciaprotocolo.repository.TelefoneRepository;
import jakarta.persistence.EntityNotFoundException;

@Service
public class TelefoneService {
    
    @Autowired
    private TelefoneRepository telefoneRepository; 

    public Telefone saveTelefone(Telefone telefone){
        return telefoneRepository.save(telefone);
        
    }

    public Telefone updateTelefone(Long id, Telefone updatedTelefone){
        Telefone existentTelefone = telefoneRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Telefone nao existente"));
            existentTelefone.setNumero(updatedTelefone.getNumero());
            existentTelefone.setDdd(updatedTelefone.getDdd());
            existentTelefone.setTipoTelefone(updatedTelefone.getTipoTelefone());
            return telefoneRepository.save(existentTelefone);

    }
    
    public void deleteTelefone(Long id){
        telefoneRepository.deleteById(id);
    }

    public Telefone findByTelefone(Long id){
        return telefoneRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Telefone inexistente"));
    }

    
}
