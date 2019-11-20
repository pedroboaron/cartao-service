package com.pedro.cartoesservice.service;

import com.pedro.cartoesservice.model.Cartao;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICartaoService {

    Cartao findByNumero(String numero);

    void deleteByNumero(String numero);

    Cartao save(Cartao cartao);

    Cartao update(Integer idCartao, Cartao cartao) throws Exception;

    List<Cartao> findByIdUser(Integer idUser);

    Cartao findById(Integer idCartao);

    void deleteById(Integer idCartao);
}
