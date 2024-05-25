package br.com.gerenciaprotocolo.service;

import br.com.gerenciaprotocolo.model.Funcionario;
import br.com.gerenciaprotocolo.repository.FuncionarioRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    public Funcionario saveFuncionario(Funcionario funcionario) {
        return funcionarioRepository.save(funcionario);
    }

    public Funcionario updateFuncionario(Long funcionarioId, Funcionario updatedFuncionario) {
        Funcionario existingFuncionario = funcionarioRepository.findById(funcionarioId)
               .orElseThrow(() -> new EntityNotFoundException("Funcionário não encontrado com o ID: " + funcionarioId));

        // Atualizando os campos do funcionário existente com os novos valores
        existingFuncionario.setNome(updatedFuncionario.getNome());
        existingFuncionario.setEmail(updatedFuncionario.getEmail());
        existingFuncionario.setDepartamento(updatedFuncionario.getDepartamento());
        existingFuncionario.setCargos(updatedFuncionario.getCargos());

        return funcionarioRepository.save(existingFuncionario);
    }

    public void deleteFuncionario(Long funcionarioId) {
        funcionarioRepository.deleteById(funcionarioId);
    }

    public Funcionario findById(Long id) {
        return funcionarioRepository.findById(id)
               .orElseThrow(() -> new EntityNotFoundException("Funcionário não encontrado com o ID: " + id));
    }

    public List<Funcionario> findAll() {
        return funcionarioRepository.findAll();
    }
}

