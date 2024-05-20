package com.example.challenge.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@Builder
public class Cliente {

  @Id
  private Integer id;
  private String nombre;
  private String apellidos;
  private String tipoDocumento;
  private String numeroDocumento;

}
