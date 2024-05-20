package com.example.challenge.repository;

import com.example.challenge.dto.Cliente;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface ClienteRepository extends R2dbcRepository<Cliente, Integer> {


  Mono<Cliente> findByIdAndNombreAndApellidosAndTipoDocumentoAndNumeroDocumento(Integer id, String nombre, String apellidos, String tipoDocumento, String numeroDocumento);


}
