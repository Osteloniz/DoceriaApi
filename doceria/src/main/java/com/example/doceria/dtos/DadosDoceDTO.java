package com.example.doceria.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class DadosDoceDTO {

    private Long id;
    private String nome;
    private String ingredientes;
    private Integer qtdCurtidas;
    private CategoriaDTO categoria;
}
