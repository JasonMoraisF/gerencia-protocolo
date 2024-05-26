package br.com.gerenciaprotocolo.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gerenciaprotocolo.model.Canal;
import br.com.gerenciaprotocolo.model.Cliente;
import br.com.gerenciaprotocolo.model.Protocolo;
import br.com.gerenciaprotocolo.repository.CanalRepository;
import br.com.gerenciaprotocolo.repository.ClienteRepository;
import br.com.gerenciaprotocolo.repository.ProtocoloRepository;
import jakarta.persistence.EntityNotFoundException;

@Service
public class ProtocoloService {
    
    @Autowired
    private ProtocoloRepository protocoloRepository;

    @Autowired
    private CanalRepository canalRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    public Protocolo createProtocolo(Protocolo protocolo){
        if(protocolo.getDataAbertura() == null){
            protocolo.setDataAbertura(LocalDateTime.now());
            protocolo.calcularDataPrazo(protocolo);
        }
        Cliente cliente = clienteRepository.save(protocolo.getClienteId());
        Canal novoCanal = canalRepository.findByTipoCanal(protocolo.getCanal().getTipoCanal()).orElseThrow(() -> new EntityNotFoundException("Canal com nome " + protocolo.getCanal().getTipoCanal() + " não encontrado")); 
        protocolo.setClienteId(cliente);
        protocolo.setCanal(novoCanal);
        protocolo.setAgilizar(null);
        protocolo.setPropensaoBacen(null);
        protocolo.setDevido(null);
        protocolo.setDataUltimaAcao(null);
        protocolo.setDataRecebimento(null);
        protocolo.setSituacaoProtocolo(null);
        protocolo.setDepartamento(null);
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
        existingProtocolo.setDataUltimaAcao(LocalDateTime.now());
        if(updatedProtocolo.getDataRecebimento()==null){
            existingProtocolo.setDataRecebimento(LocalDateTime.now());
        }

        existingProtocolo.setDepartamento(updatedProtocolo.getDepartamento());
        existingProtocolo.setAgilizar(updatedProtocolo.getAgilizar());
        existingProtocolo.setPropensaoBacen(updatedProtocolo.getPropensaoBacen());
        existingProtocolo.setDevido(updatedProtocolo.getDevido());
        existingProtocolo.setProcedente(updatedProtocolo.getProcedente());
        existingProtocolo.setSituacaoProtocolo(updatedProtocolo.getSituacaoProtocolo());
        return protocoloRepository.save(existingProtocolo);
    }

    public void deleteProtocolo(Long id){
        protocoloRepository.deleteById(id);
    }



}
