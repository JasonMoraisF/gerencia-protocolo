package br.com.gerenciaprotocolo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.gerenciaprotocolo.model.TipoCliente;

@Repository
public interface TipoClienteRepository extends JpaRepository<TipoCliente,Long>{
    
}
