package com.example.doceria.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.doceria.models.Doce;

public interface DoceRepository extends JpaRepository<Doce, Long>{

    List<Doce> findDoceById(Long id);

    List<Doce> findByNomeLike(String nome);
    
    //List<Doce> findByNameOrderQtdCurtidasDesc(Integer qtdCurtidas);
    

}
