package br.com.gerenciaprotocolo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gerenciaprotocolo.model.Titular;
import br.com.gerenciaprotocolo.repository.TitularRepository;
import jakarta.persistence.EntityNotFoundException;

@Service
public class TitularService {

    @Autowired
    private TitularRepository titularRepository;

    public Titular saveTitular(Titular titular){
        return titularRepository.save(titular);
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

    public Titular findByTitular(Long id){
        return titularRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Titular nao encontrado com o ID: " + id));
    }
}
