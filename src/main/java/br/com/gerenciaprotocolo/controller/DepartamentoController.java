package br.com.gerenciaprotocolo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import br.com.gerenciaprotocolo.model.Departamento;
import br.com.gerenciaprotocolo.repository.DepartamentoRepository;
 
@RestController
@RequestMapping("/api/departamentos")
public class DepartamentoController {

    @Autowired
    private DepartamentoRepository departamentoRepository;

    @GetMapping
    public List<Departamento> getAllDepartamentos() {
        return departamentoRepository.findAll();
    }

    @PostMapping
    public Departamento createDepartamento(@RequestBody Departamento departamento) {
        return departamentoRepository.save(departamento);
    }

    @GetMapping("/{id}")
    public Departamento getDepartamentoById(@PathVariable Long id) {
        return departamentoRepository.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public Departamento updateDepartamento(@PathVariable Long id, @RequestBody Departamento departamentoDetails) {
        Departamento departamento = departamentoRepository.findById(id).orElse(null);
        if (departamento != null) {
           // departamento.setNome(departamentoDetails.getNome());
            return departamentoRepository.save(departamento);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteDepartamento(@PathVariable Long id) {
        departamentoRepository.deleteById(id);
    }
}
