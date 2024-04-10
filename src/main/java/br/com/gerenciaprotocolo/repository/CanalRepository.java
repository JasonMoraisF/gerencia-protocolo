package br.com.gerenciaprotocolo.repository;

import org.springframework.stereotype.Repository;
import br.com.gerenciaprotocolo.model.Canal;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface CanalRepository extends JpaRepository<Canal,Long>{
    
}
