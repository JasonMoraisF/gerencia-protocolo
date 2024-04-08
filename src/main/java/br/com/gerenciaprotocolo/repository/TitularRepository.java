package br.com.gerenciaprotocolo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.gerenciaprotocolo.model.Titular;

@Repository
public interface TitularRepository extends JpaRepository<Titular,Long> {
    
}
