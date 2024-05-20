package br.com.gerenciaprotocolo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gerenciaprotocolo.model.SituacaoProtocolo;
import br.com.gerenciaprotocolo.repository.SituacaoProtocoloRepository;
import jakarta.persistence.EntityNotFoundException;

@Service
public class SituacaoProtocoloService {
    
    @Autowired
    private SituacaoProtocoloRepository situacaoProtocoloRepository;


    public SituacaoProtocolo saveSituacaoProtocolo(SituacaoProtocolo situacaoProtocolo){
        return situacaoProtocoloRepository.save(situacaoProtocolo);
    }

    public SituacaoProtocolo updateSituacaoProtocolo(Long situacaoProtocoloId, SituacaoProtocolo updatedSituacaoProtocolo){
        SituacaoProtocolo existingSituacaoProtocolo = situacaoProtocoloRepository.findById(situacaoProtocoloId).orElseThrow(() -> new EntityNotFoundException("Situacao Protocolo nao encontrada:" + situacaoProtocoloId));

        existingSituacaoProtocolo.setResposta(updatedSituacaoProtocolo.getResposta());
        existingSituacaoProtocolo.setStatus(updatedSituacaoProtocolo.getStatus());
        existingSituacaoProtocolo.setFuncionarios(updatedSituacaoProtocolo.getFuncionarios());
        return situacaoProtocoloRepository.save(existingSituacaoProtocolo);
    }

    public SituacaoProtocolo findById(Long id){
        return situacaoProtocoloRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Situacao Protocolo nao encontrada: " + id));
    }


}
