package com.example.doceria.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.doceria.dtos.DadosDoceDTO;
import com.example.doceria.dtos.DoceDTO;
import com.example.doceria.models.Doce;
import com.example.doceria.services.DoceService;

@RestController
@RequestMapping("api/doce")
public class DoceController {

    private DoceService doceService;

    public DoceController(DoceService doceService) {
        this.doceService = doceService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Doce salvar(@RequestBody DoceDTO doceDTO) {
        Doce d = doceService.salvar(doceDTO);
        return d;

    }

    @GetMapping("{id}")
    public DadosDoceDTO getDocesPorId(@PathVariable long id) {
        return doceService.obterDocePorId(id);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteDoce(@PathVariable Long id) {
        doceService.remover(id);
    }

    @PutMapping("{id}")
    public void editDoce(@PathVariable Long id, @RequestBody DoceDTO dto) {
        doceService.editar(id, dto);

    }

    @GetMapping
    public List<DadosDoceDTO> getDoces() {
        return doceService.obterTodos();
    }

}
