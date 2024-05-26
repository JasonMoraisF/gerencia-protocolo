package br.com.gerenciaprotocolo.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gerenciaprotocolo.model.Protocolo;
import br.com.gerenciaprotocolo.repository.ClienteRepository;
import br.com.gerenciaprotocolo.repository.ProtocoloRepository;
import jakarta.persistence.EntityNotFoundException;

@Service
public class ProtocoloService {
    
    @Autowired
    private ProtocoloRepository protocoloRepository;


    public Protocolo createProtocolo(Protocolo protocolo){
        if(protocolo.getDataAbertura() == null){
            protocolo.setDataAbertura(LocalDateTime.now());
            protocolo.calcularDataPrazo(protocolo);
        }
            return protocoloRepository.save(protocolo);
    }

    public List<Protocolo> findAll(){
        return protocoloRepository.findAll();
    }

    public Protocolo findByProtocolo(Long id){
        return protocoloRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Protocolo inexistente: " + id));
    }

    public Protocolo updateProtocolo(Long id, Protocolo updatedProtocolo){
        Protocolo existingProtocolo = protocoloRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Protocolo inexistente: " + id));


        //FALTANDO DATES
        existingProtocolo.setDepartamento(updatedProtocolo.getDepartamento());
        existingProtocolo.setAgilizar(updatedProtocolo.getAgilizar());
        existingProtocolo.setPropensãoBacen(updatedProtocolo.getPropensãoBacen());
        existingProtocolo.setDevido(updatedProtocolo.getDevido());
        existingProtocolo.setProcedente(updatedProtocolo.getProcedente());
        existingProtocolo.setSituacaoProtocolo(updatedProtocolo.getSituacaoProtocolo());
        return protocoloRepository.save(existingProtocolo);
    }

    public void deleteProtocolo(Long id){
        protocoloRepository.deleteById(id);
    }



}
