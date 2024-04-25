package br.com.gerenciaprotocolo.service;

import br.com.gerenciaprotocolo.model.Conta;
import br.com.gerenciaprotocolo.repository.ContaRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContaService {

    @Autowired
    private ContaRepository contaRepository;

    public Conta saveConta(Conta conta) {
        return contaRepository.save(conta);
    }

    public Conta updateConta(Long contaId, Conta updatedConta) {
        Conta existingConta = contaRepository.findById(contaId).orElseThrow(() -> new EntityNotFoundException("Conta não encontrada com o ID: " + contaId));

        existingConta.setAgencia(updatedConta.getAgencia());
        existingConta.setNumeroConta(updatedConta.getNumeroConta());
        existingConta.setTipoClienteID(updatedConta.getTipoClienteID());
        return contaRepository.save(existingConta);
    }

    public void deleteConta(Long contaId) {
        contaRepository.deleteById(contaId);
    }

    public Conta findById(Long id) {
        return contaRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Conta não encontrada com o ID: " + id));
    }
}
