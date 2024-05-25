package br.com.gerenciaprotocolo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gerenciaprotocolo.repository.ProtocoloRepository;

@Service
public class Protocolo {
    
    @Autowired
    private ProtocoloRepository protocoloRepository;

    public Protocolo createProtocolo(Protocolo protocolo){
        return protocoloRepository.save(protocolo);
    }

}
