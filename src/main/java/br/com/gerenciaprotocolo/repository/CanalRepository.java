package br.com.gerenciaprotocolo.repository;

import org.springframework.stereotype.Repository;
import br.com.gerenciaprotocolo.model.Canal;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

@Repository
public interface CanalRepository extends JpaRepository<Canal,Long>{
    @Query("SELECT c FROM Canal c WHERE c.TipoCanal = :tipoCanal")
    Optional<Canal> findByTipoCanal(@Param("tipoCanal") String tipoCanal);
}
