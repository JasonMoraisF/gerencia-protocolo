package br.com.gerenciaprotocolo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import br.com.gerenciaprotocolo.model.Conta;
import br.com.gerenciaprotocolo.model.Funcionario;
import br.com.gerenciaprotocolo.repository.FuncionarioRepository;


@RestController
@RequestMapping("/api/funcionarios")
public class FuncionarioController {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @GetMapping
    public List<Funcionario> getAllFuncionarios() {
        return funcionarioRepository.findAll();
    }

    @PostMapping
    public Funcionario createFuncionario(@RequestBody Funcionario funcionario) {
        return funcionarioRepository.save(funcionario);
    }

    @GetMapping("/{id}")
    public Funcionario getFuncionarioById(@PathVariable Long id) {
        return funcionarioRepository.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public Funcionario updateFuncionario(@PathVariable Long id, @RequestBody Funcionario funcionarioDetails) {
        Funcionario funcionario = funcionarioRepository.findById(id).orElse(null);
        if (funcionario != null) {
            funcionario.setNome(funcionarioDetails.getNome());
            funcionario.setEmail(funcionarioDetails.getEmail());
            funcionario.setDepartamento(funcionarioDetails.getDepartamento());
            funcionario.setCargos(funcionarioDetails.getCargos());
            return funcionarioRepository.save(funcionario);
        }
        return null;
    }
    @DeleteMapping("/{id}")
    public void deleteFuncionario(@PathVariable Long id) {
        funcionarioRepository.deleteById(id);
    }
}
