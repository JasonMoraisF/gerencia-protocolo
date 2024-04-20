package br.com.gerenciaprotocolo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.gerenciaprotocolo.model.Telefone;

@Repository
public interface TelefoneRepository extends JpaRepository<Telefone,Long> {

    
}