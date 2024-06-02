package br.com.gerenciaprotocolo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gerenciaprotocolo.model.SituacaoProtocolo;
import br.com.gerenciaprotocolo.repository.FuncionarioRepository;
import br.com.gerenciaprotocolo.repository.SituacaoProtocoloRepository;
import jakarta.persistence.EntityNotFoundException;

@Service
public class SituacaoProtocoloService {
    
    @Autowired
    private SituacaoProtocoloRepository situacaoProtocoloRepository;

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    public SituacaoProtocolo saveSituacaoProtocolo(SituacaoProtocolo situacaoProtocolo){
        SituacaoProtocolo savedSituacaoProtocolo = situacaoProtocoloRepository.save(situacaoProtocolo);
        savedSituacaoProtocolo.setFuncionario(situacaoProtocolo.getFuncionario());
        return situacaoProtocolo;
    }

    public SituacaoProtocolo updateSituacaoProtocolo(Long situacaoProtocoloId, SituacaoProtocolo updatedSituacaoProtocolo){
        SituacaoProtocolo existingSituacaoProtocolo = situacaoProtocoloRepository.findById(situacaoProtocoloId).orElseThrow(() -> new EntityNotFoundException("Situacao Protocolo nao encontrada:" + situacaoProtocoloId));

        existingSituacaoProtocolo.setResposta(updatedSituacaoProtocolo.getResposta());
        existingSituacaoProtocolo.setStatus(updatedSituacaoProtocolo.getStatus());
        existingSituacaoProtocolo.setFuncionario(updatedSituacaoProtocolo.getFuncionario());
        return situacaoProtocoloRepository.save(existingSituacaoProtocolo);
    }

    public SituacaoProtocolo findById(Long id){
        return situacaoProtocoloRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Situacao Protocolo nao encontrada: " + id));
    }
    
    public List<SituacaoProtocolo> findAll(){
        return situacaoProtocoloRepository.findAll();
    }

    public void deleteSituacaoProtocolo(Long id){
        situacaoProtocoloRepository.deleteById(id);
    }


}
