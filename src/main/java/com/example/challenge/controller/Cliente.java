package com.example.challenge.controller;

import com.example.challenge.service.ClienteService;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;


@RestController
@RequestMapping("/cliente")
public class Cliente {


  @Autowired
  ClienteService clienteService;

  @GetMapping()
  public Mono<com.example.challenge.dto.Cliente> getCliente(
      @RequestParam Map<String, String> clientParams
  ) {
    return clienteService.findClient(clientParams);
  }

  @PostMapping()
  public Mono<com.example.challenge.dto.Cliente> postCliente(
      @RequestBody com.example.challenge.dto.Cliente cliente
  ) {
    return clienteService.save(cliente);
  }


}
