package com.example.doceria.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.doceria.dtos.CategoriaDTO;
import com.example.doceria.dtos.DadosCategoriaDTO;
import com.example.doceria.exceptions.RegraNegocioException;
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

    @Override
    public DadosCategoriaDTO obterCategoriaPorId(Long id) {
        return categoriaRepository.findById(id).map((Categoria c) -> {
            return DadosCategoriaDTO.builder()
                    .id(c.getId())
                    .nome(c.getNome())
                    .build();
        }).orElseThrow(() -> new RegraNegocioException("Categoria não encontrada"));
    }

    @Override
    public void remover(Long id) {
        categoriaRepository.deleteById(id);
    }

    @Override
    public void editar(Long id, CategoriaDTO categoriaDTO) {
        Categoria categoria = categoriaRepository.findById(id)
                .orElseThrow(() -> new RegraNegocioException("Categoria não encontrada"));
        categoria.setNome(categoriaDTO.getNome());
        categoriaRepository.save(categoria);
    }

    @Override
    public List<DadosCategoriaDTO> obterTodos() {
        return categoriaRepository.findAll().stream().map((Categoria c) -> {
            return DadosCategoriaDTO.builder()
                    .id(c.getId())
                    .nome(c.getNome())
                    .build();
        }).collect(Collectors.toList());
    }

}
