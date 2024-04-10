package br.com.gerenciaprotocolo.repository;

import br.com.gerenciaprotocolo.model.Conta;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContaRepository extends JpaRepository<Conta, Long>{
    
}
