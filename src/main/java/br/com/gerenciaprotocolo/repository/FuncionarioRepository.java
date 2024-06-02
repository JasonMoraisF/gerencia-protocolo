package br.com.gerenciaprotocolo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.gerenciaprotocolo.model.Funcionario;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario,Long>{
    
}
