package com.example.doceria.services;

import com.example.doceria.dtos.CategoriaDTO;
import com.example.doceria.models.Categoria;

public interface CategoriaService {

    Categoria salvar(CategoriaDTO dto);
    
}
