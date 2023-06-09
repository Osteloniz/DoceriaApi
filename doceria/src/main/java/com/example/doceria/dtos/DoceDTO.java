package com.example.doceria.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class DoceDTO {

    private Long id;
    private String nome;
    private String ingredientes;
    private Integer qtdCurtidas;
    private Long categoriaId;
    
}
