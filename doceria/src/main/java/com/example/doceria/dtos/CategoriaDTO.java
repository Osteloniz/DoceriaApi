package com.example.doceria.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class CategoriaDTO {

    private Long id;
    private String nome;
    private String ingredientes;
    private String qtdCurtidas;
    
}
