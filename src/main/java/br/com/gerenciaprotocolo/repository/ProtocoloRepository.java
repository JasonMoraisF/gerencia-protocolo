package br.com.gerenciaprotocolo.repository;

import br.com.gerenciaprotocolo.model.Protocolo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProtocoloRepository extends JpaRepository<Protocolo, Long>{
}
