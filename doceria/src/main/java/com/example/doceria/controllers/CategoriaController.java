package com.example.doceria.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.doceria.dtos.CategoriaDTO;
import com.example.doceria.models.Categoria;
import com.example.doceria.services.CategoriaService;

@RestController
@RequestMapping("api/Categoria")
public class CategoriaController {
    private CategoriaService categoriaService;

    public CategoriaController(CategoriaService categoriaService){
        this.categoriaService = categoriaService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Categoria salvar(@RequestBody CategoriaDTO dto){
        return categoriaService.salvar(dto);

    }

    
}
