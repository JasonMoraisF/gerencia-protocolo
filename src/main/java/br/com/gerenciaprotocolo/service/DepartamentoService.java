package br.com.gerenciaprotocolo.service;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.gerenciaprotocolo.model.Conta;
import br.com.gerenciaprotocolo.model.Departamento;
import br.com.gerenciaprotocolo.repository.DepartamentoRepository;
 
@Service
public class DepartamentoService {

    @Autowired
    private DepartamentoRepository departamentoRepository;

    public Departamento saveDepartamento(Departamento departamento) {
        return departamentoRepository.save(departamento);
    }

    public Departamento updatedDepartamento(Long departamentoID, String name) {
        Departamento existingDepartamento = departamentoRepository.findById(departamentoID)
                .orElseThrow(
                        () -> new EntityNotFoundException("Departamento não encontrado com o ID: " + departamentoID));

        existingDepartamento.setDepartamentoID(departamentoID);
        existingDepartamento.setNome(name);
        return departamentoRepository.save(existingDepartamento);
    }

    
    public Iterable<Departamento> findAll() {
        return departamentoRepository.findAll();
    }
    
    public Departamento findById(Long departamentoID) {
        return departamentoRepository.findById(departamentoID).orElseThrow(
            () -> new EntityNotFoundException("Departamento não encontrado com o ID: " + departamentoID));
        }
        
    }

