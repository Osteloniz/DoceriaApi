package com.example.doceria.services;

import java.util.List;

import com.example.doceria.dtos.CategoriaDTO;
import com.example.doceria.dtos.DadosCategoriaDTO;
import com.example.doceria.dtos.DadosDoceDTO;
import com.example.doceria.models.Categoria;

public interface CategoriaService {

    Categoria salvar(CategoriaDTO dto);

    DadosCategoriaDTO obterCategoriaPorId(Long id);

    void remover(Long id);

    void editar(Long id, CategoriaDTO categoriaDTO);

    List<DadosCategoriaDTO> obterTodos();
    
}
