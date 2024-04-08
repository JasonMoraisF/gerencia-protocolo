package br.com.gerenciaprotocolo.repository;

import br.com.gerenciaprotocolo.model.Cargos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CargosRepository extends JpaRepository<Cargos, Long>{
    
}
