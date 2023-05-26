package com.example.doceria.services;

import org.springframework.stereotype.Service;

import com.example.doceria.dtos.CategoriaDTO;
import com.example.doceria.models.Categoria;
import com.example.doceria.repositories.CategoriaRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CategoriaServiceImpl implements CategoriaService {

    private final CategoriaRepository categoriaRepository;

    @Override
    public Categoria salvar(CategoriaDTO dto) {
        Categoria categ = new Categoria();
        categ.setNome(dto.getNome());
        return categoriaRepository.save(categ);
    }
    
}
