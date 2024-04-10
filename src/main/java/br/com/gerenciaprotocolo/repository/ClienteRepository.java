package br.com.gerenciaprotocolo.repository;

import br.com.gerenciaprotocolo.model.Cliente;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long>{
    
}
