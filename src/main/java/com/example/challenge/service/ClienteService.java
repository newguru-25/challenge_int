package com.example.challenge.service;

import com.example.challenge.dto.Cliente;
import java.util.Map;
import reactor.core.publisher.Mono;

public interface ClienteService {

  Mono<Cliente> save(Cliente cliente);
  Mono<Cliente> findClient(Map<String, String> clienteParam);
//
//  Mono<ExchangeCurrency> findById(int id);
//
//  Mono<ExchangeCurrency> update(int id, ExchangeCurrency exchangeCurrency);

}
