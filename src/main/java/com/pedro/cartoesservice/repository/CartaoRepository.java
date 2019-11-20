package com.pedro.cartoesservice.repository;

import com.pedro.cartoesservice.model.Cartao;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CartaoRepository extends JpaRepository<Cartao, Integer> {

    List<Cartao> findAll();

    Page<Cartao> findAll(Pageable pageable);

    Page<Cartao> findByNumero(String numero, Pageable pageable);

    Cartao findByNumero(String numero);

    void deleteByNumero(String numero);

    List<Cartao> findByIdUser(Integer idUser);
}
