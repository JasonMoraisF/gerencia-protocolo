package br.com.gerenciaprotocolo.service;

import jakarta.persistence.EntityNotFoundException;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.gerenciaprotocolo.model.Departamento;
import br.com.gerenciaprotocolo.repository.DepartamentoRepository;
 
@Service
public class DepartamentoService {

    @Autowired
    private DepartamentoRepository departamentoRepository;

    public Departamento saveDepartamento(Departamento departamento) {
        return departamentoRepository.save(departamento);
    }

    public Departamento updatedDepartamento(Long departamentoID, Departamento departamento) {
        Departamento existingDepartamento = departamentoRepository.findById(departamentoID)
                .orElseThrow(
                        () -> new EntityNotFoundException("Departamento não encontrado com o ID: " + departamentoID));
        existingDepartamento.setNome(departamento.getNome());
        return departamentoRepository.save(existingDepartamento);
    }

    
    public List<Departamento> findAll() {
        return departamentoRepository.findAll();
    }
    
    public Departamento findById(Long departamentoID) {
        return departamentoRepository.findById(departamentoID).orElseThrow(
            () -> new EntityNotFoundException("Departamento não encontrado com o ID: " + departamentoID));
        }
    public Departamento deleteByID(Long departamentoID){
        Departamento existingDepartamento = departamentoRepository.findById(departamentoID)
                .orElseThrow(
                        () -> new EntityNotFoundException("Departamento não encontrado com o ID: " + departamentoID));
        departamentoRepository.deleteById(departamentoID);
        return existingDepartamento;
    }    

    }

