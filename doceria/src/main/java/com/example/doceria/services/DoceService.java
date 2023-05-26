package com.example.doceria.services;

import java.util.List;

import com.example.doceria.dtos.DadosDoceDTO;
import com.example.doceria.dtos.DoceDTO;
import com.example.doceria.models.Doce;

public interface DoceService {

    Doce salvar(DoceDTO doceDTO);
    DadosDoceDTO obterDocePorId(Long id);
    void remover(Long id);
    void editar(Long id, DoceDTO doceDTO);
    void addCurtida(Long id, DoceDTO doceDTO);
    List<DadosDoceDTO> obterTodos();
    
}
