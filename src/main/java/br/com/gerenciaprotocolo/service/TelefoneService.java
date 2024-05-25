package br.com.gerenciaprotocolo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gerenciaprotocolo.model.Telefone;
import br.com.gerenciaprotocolo.repository.TelefoneRepository;
import jakarta.persistence.EntityNotFoundException;

@Service
public class TelefoneService {
    
    @Autowired
    private TelefoneRepository telefoneRepository; 


    public List<Telefone> findAllTelefones(){
        return telefoneRepository.findAll();
    }

    public Telefone findTelefoneById(Long id){
        return telefoneRepository.findById(id).orElse(null);
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
    
}
