package br.com.gerenciaprotocolo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.gerenciaprotocolo.model.SituacaoProtocolo;

@Repository
public interface SituacaoProtocoloRepository extends JpaRepository<SituacaoProtocolo,Long> {
    
}
