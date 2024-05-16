package br.com.gerenciaprotocolo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gerenciaprotocolo.model.Canal;
import br.com.gerenciaprotocolo.model.Protocolo;
import br.com.gerenciaprotocolo.repository.CanalRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class CanalService {
    @Autowired
    private CanalRepository canalRepository;

    public List<Canal> findAll() {
        return canalRepository.findAll();
    }

    public Canal create(Canal canal) {
        return canalRepository.save(canal);
    }

    public Canal findById(Long id) {
        return canalRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Canal não encontrada com o ID: " + id));
    }

    public Canal update(Long id, Canal canalDetails) {
        Canal existingCanal = canalRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Canal não encontrada com o ID: " + id));
        existingCanal.setTipoCanal(canalDetails.getTipoCanal());

        return canalRepository.save(existingCanal);
    }

    public Canal removeProtocolo(Long idCanal,Long idProtocolo){
        Canal existingCanal = canalRepository.findById(idCanal).orElseThrow(() -> new EntityNotFoundException("Canal não encontrada com o ID: " + idCanal));
        List<Protocolo> protocolos = existingCanal.getProtocolos();
        protocolos.remove(idProtocolo.intValue()-1);
        existingCanal.setProtocolos(protocolos);

        return canalRepository.save(existingCanal);
    }

    public Canal delete(Long id) {
        Canal existingCanal = canalRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Canal não encontrada com o ID: " + id));
        canalRepository.deleteById(id);

        return existingCanal;
    }
}
