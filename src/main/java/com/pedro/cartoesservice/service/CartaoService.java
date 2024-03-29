package com.pedro.cartoesservice.service;

import com.pedro.cartoesservice.model.Cartao;
import com.pedro.cartoesservice.repository.CartaoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class CartaoService implements ICartaoService {

    @Autowired
    private CartaoRepository cartaoRepository;

    @Override
    public Cartao findByNumero(String numero) {
        return cartaoRepository.findByNumero(numero);
    }

    @Transactional
    @Override
    public void deleteByNumero(String numero) {
        cartaoRepository.deleteByNumero(numero);
    }

    @Override
    public Cartao save(Cartao cartao) {
        return cartaoRepository.save(cartao);
    }

    @Transactional
    @Override
    public Cartao update(Integer idCartao, Cartao cartao) throws Exception {
        Cartao cartaoSalvo = this.cartaoRepository.findById(idCartao).get();

        if (Objects.isNull(cartaoSalvo)) {
            throw new Exception("Cartão não existe no banco de dados" + idCartao);
        }

        BeanUtils.copyProperties(cartao, cartaoSalvo, "id");

        return cartaoRepository.save(cartaoSalvo);
    }

    @Override
    public List<Cartao> findByIdUser(Integer idUser) {
        return cartaoRepository.findByIdUser(idUser);
    }

    @Override
    public Cartao findById(Integer idCartao) {
        return cartaoRepository.findById(idCartao).get();
    }

    @Override
    public void deleteById(Integer idCartao) {

    }
}
