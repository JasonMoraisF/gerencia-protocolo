package br.com.gerenciaprotocolo.service;

import br.com.gerenciaprotocolo.model.Conta;
import br.com.gerenciaprotocolo.repository.ContaRepository;
import jakarta.persistence.EntityNotFoundException;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContaService {

    @Autowired  
    private ContaRepository contaRepository;
    @Autowired
    private TitularService titularService;

    public Conta saveConta(Conta conta) {
        Conta savedConta = contaRepository.save(conta);
        if(savedConta.getTitular() != null){
            titularService.saveTitular(savedConta.getTitular());
        }
        return savedConta;
    }

    public Conta updateConta(Long contaId, Conta updatedConta) {
        Conta existingConta = contaRepository.findById(contaId).orElseThrow(() -> new EntityNotFoundException("Conta não encontrada com o ID: " + contaId));

        existingConta.setAgencia(updatedConta.getAgencia());
        existingConta.setNumeroConta(updatedConta.getNumeroConta());
        existingConta.setTipoCliente(updatedConta.getTipoCliente());
        return contaRepository.save(existingConta);
    }

    public void deleteConta(Long contaId) {
        contaRepository.deleteById(contaId);
    }

    public Conta findById(Long id) {
        return contaRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Conta não encontrada com o ID: " + id));
    }

    public List<Conta> findAll(){
        return contaRepository.findAll();
    }
}
