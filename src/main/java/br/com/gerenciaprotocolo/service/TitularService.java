package br.com.gerenciaprotocolo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gerenciaprotocolo.model.Canal;
import br.com.gerenciaprotocolo.model.Telefone;
import br.com.gerenciaprotocolo.model.Titular;
import br.com.gerenciaprotocolo.repository.TelefoneRepository;
import br.com.gerenciaprotocolo.repository.TitularRepository;
import jakarta.persistence.EntityNotFoundException;

@Service
public class TitularService {
    
    @Autowired
    private TitularRepository titularRepository;
    
    @Autowired
    private TelefoneRepository telefoneRepository;
    
    public List<Titular> findAll() {
        return titularRepository.findAll();
    }
    public Titular findById(Long id) {
        return titularRepository.findById(id).orElse(null);

    }
    
    public Titular saveTitular(Titular titular){
        Titular savedTitular = titularRepository.save(titular);
        List<Telefone> telefones = new ArrayList<>();
        if(savedTitular.getTelefones()!= null &&!titular.getTelefones().isEmpty()) {
            savedTitular.getTelefones().forEach(telefone ->{
                telefone.setTitular(savedTitular);
                telefoneRepository.save(telefone);
            });
        }
        return savedTitular;
    }   

    public Titular updateTitular(Long titularID, Titular updatedTitular){
        Titular existingTitular = titularRepository.findById(titularID).orElseThrow(() -> new EntityNotFoundException("Titular não encontrado com o ID: " + titularID));

        // existingTitular.setTitularID(updatedTitular.getTitularID());
        existingTitular.setCpf(updatedTitular.getCpf());
        existingTitular.setNome(updatedTitular.getNome());
        existingTitular.setEmail(updatedTitular.getEmail());
        existingTitular.setProfissao(updatedTitular.getProfissao());
        return titularRepository.save(existingTitular);
    }

    public void deleteTitular(Long titularID){
        titularRepository.deleteById(titularID);
    }

}
