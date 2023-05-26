package com.example.doceria.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.doceria.models.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {




    @Query("select d from Categoria d left join fetch d.doces ds where d.id = :id")
    Categoria findCategoriaFetchDoce(@Param("id") Long id);
    
    
}
