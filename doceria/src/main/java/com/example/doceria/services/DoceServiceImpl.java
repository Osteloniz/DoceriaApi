package com.example.doceria.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.doceria.dtos.CategoriaDTO;
import com.example.doceria.dtos.DadosDoceDTO;
import com.example.doceria.dtos.DoceDTO;
import com.example.doceria.exceptions.RegraNegocioException;
import com.example.doceria.models.Categoria;
import com.example.doceria.models.Doce;
import com.example.doceria.repositories.CategoriaRepository;
import com.example.doceria.repositories.DoceRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DoceServiceImpl implements DoceService {
    private final DoceRepository doceRepository;
    private final CategoriaRepository categoriaRepository;

    @Override
    @Transactional
    public Doce salvar(DoceDTO doceDTO) {
        Categoria categoria = categoriaRepository.findById(doceDTO.getCategoriaId())
                .orElseThrow(() -> new RegraNegocioException("Categoria Não Encotrada"));

        Doce doce = new Doce();
        doce.setNome(doceDTO.getNome());
        doce.setIngredientes(doceDTO.getIngredientes());
        doce.setQtdCurtidas(doceDTO.getQtdCurtidas());
        doce.setCategoria(categoria);
        return doceRepository.save(doce);

    }

    @Override
    public DadosDoceDTO obterDocePorId(Long id) {
        return doceRepository.findById(id).map((Doce d) -> {
            return DadosDoceDTO.builder()
                    .id(d.getId())
                    .nome(d.getNome())
                    .ingredientes(d.getIngredientes())
                    .qtdCurtidas(d.getQtdCurtidas())

                    .categoria(CategoriaDTO.builder()
                            .id(d.getCategoria().getId())
                            .nome(d.getCategoria().getNome())
                            .build())
                    .build();

        }).orElseThrow(() -> new RegraNegocioException("Doce não Encotrado"));
    }

    @Override
    @Transactional
    public void addCurtida(Long id, DoceDTO doceDTO) {
        Doce doce = doceRepository.findById(id)
                .orElseThrow(() -> new RegraNegocioException("Doce Não encontrado"));
        Categoria categoria = categoriaRepository.findById(doceDTO.getCategoriaId())
                .orElseThrow(() -> new RegraNegocioException("Categoria Não Encontrada"));

        doce.setNome(doceDTO.getNome());
        doce.setIngredientes(doceDTO.getIngredientes());
        doce.setQtdCurtidas(doceDTO.getQtdCurtidas());
        doce.setCategoria(categoria);
        doceRepository.save(doce);
    }

    @Override
    @Transactional
    public void remover(Long id) {
        doceRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void editar(Long id, DoceDTO doceDTO) {
        Doce doce = doceRepository.findById(id).orElseThrow(() -> new RegraNegocioException("Doce Não Encotrado"));

        Categoria categoria = categoriaRepository.findById(doceDTO.getCategoriaId())
                .orElseThrow(() -> new RegraNegocioException("Categoria não Encontrada"));

        doce.setNome(doceDTO.getNome());
        doce.setIngredientes(doceDTO.getIngredientes());
        doce.setQtdCurtidas(doceDTO.getQtdCurtidas());
        doce.setCategoria(categoria);

        doceRepository.save(doce);

    }

    @Override
    @Transactional
    public List<DadosDoceDTO> obterTodos() {
        return doceRepository.findAll().stream().map((Doce d) -> {
            return DadosDoceDTO.builder()
                    .id(d.getId())
                    .nome(d.getNome())
                    .ingredientes(d.getIngredientes())
                    .qtdCurtidas(d.getQtdCurtidas())
                    .categoria(CategoriaDTO.builder()
                            .id(d.getCategoria().getId())
                            .nome(d.getCategoria().getNome())
                            .build())
                    .build();
        }).collect(Collectors.toList());
    }

}
