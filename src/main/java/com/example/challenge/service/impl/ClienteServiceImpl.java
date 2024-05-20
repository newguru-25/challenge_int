package com.example.challenge.service.impl;


import com.example.challenge.dto.Cliente;
import com.example.challenge.repository.ClienteRepository;
import com.example.challenge.service.ClienteService;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class ClienteServiceImpl implements ClienteService {


  public static final String NOT_FOUND = "no hay elementos";
  @Autowired
  ClienteRepository clienteRepository;

  public Mono<Cliente> findClient(Map<String, String> clienteParam) {
    return clienteRepository.findByIdAndNombreAndApellidosAndTipoDocumentoAndNumeroDocumento(
        Integer.valueOf(clienteParam.get("id")), clienteParam.get("nombre"),
        clienteParam.get("apellidos"), clienteParam.get("tipoDocumento"),
        clienteParam.get("numeroDocumento")
    ).switchIfEmpty(Mono.error(new NoSuchElementException(NOT_FOUND)));
  }


  public Mono<Cliente> save(Cliente cliente) {
   return clienteRepository.findById(cliente.getId()).map(Optional::of).defaultIfEmpty(Optional.empty())
        .flatMap(cliente1 -> {
          if (cliente1.isPresent()) {
            cliente.setId(cliente1.get().getId());
            return clienteRepository.save(cliente);
          }
          return Mono.error(new RuntimeException("No se encontro ningun registro"));
        });
  }

}
