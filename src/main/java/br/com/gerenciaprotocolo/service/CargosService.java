package br.com.gerenciaprotocolo.service;

import br.com.gerenciaprotocolo.model.Cargos;
import br.com.gerenciaprotocolo.model.Funcionario;
import br.com.gerenciaprotocolo.repository.CargosRepository;
import jakarta.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CargosService {

    @Autowired
    private CargosRepository cargoRepository;
 
    public Cargos findById(Long id) {
        return cargoRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Cargo não encontrada com o ID: " + id));
    }

    public Cargos saveCargos(Cargos cargo){
        return cargoRepository.save(cargo);
    }

    public Cargos updateCargos(Long id ,Cargos cargo){
        
        Cargos existingCargos = cargoRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Cargo não encontrada com o ID: " + id));
        existingCargos.setTipoCargos(cargo.getTipoCargos());
        return cargoRepository.save(existingCargos);
    }

    public Cargos removeFuncionario(Long idFuncionario , long idCargo){
        
        Cargos existingCargos = cargoRepository.findById(idCargo).orElseThrow(() -> new EntityNotFoundException("Cargo não encontrada com o ID: " + idCargo));
        List<Funcionario> funcionarios = existingCargos.getFuncionarios();
        funcionarios.remove(idFuncionario-1);

        return cargoRepository.save(existingCargos);
    }

    public Cargos deleteCargo(Long id){

        Cargos existingCargos = cargoRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Cargo não encontrada com o ID: " + id));
        cargoRepository.deleteById(id);
    
        return existingCargos;
    }

}
