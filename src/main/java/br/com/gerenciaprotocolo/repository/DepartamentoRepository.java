package br.com.gerenciaprotocolo.repository;

import org.springframework.stereotype.Repository;
import br.com.gerenciaprotocolo.model.Departamento;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface DepartamentoRepository extends JpaRepository<Departamento, Long> {
    Optional<Departamento> findByNome(String nome);
} 


