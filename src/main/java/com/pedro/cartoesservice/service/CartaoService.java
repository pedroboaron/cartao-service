package com.pedro.cartoesservice.service;

import com.pedro.cartoesservice.model.Cartao;
import com.pedro.cartoesservice.model.Usuario;
import com.pedro.cartoesservice.repository.CartaoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class CartaoService implements ICartaoService {

    @Autowired
    private CartaoRepository cartaoRepository;

    @Override
    public List<Cartao> findAll() {
        return cartaoRepository.findAll();
    }

    @Override
    public Page<Cartao> findAll(Pageable pageable) {
        return cartaoRepository.findAll(pageable);
    }

    @Override
    public Cartao findByIdCartaoAndIdUser(Integer idCartao, Integer idUser) {
        return cartaoRepository.findByIdCartaoAndIdUser(idCartao,idUser);
    }

    @Transactional
    @Override
    public void deleteByNumero(Integer idUser, Integer idCartao) throws Exception{
        cartaoRepository.deleteByNumero(idUser, idCartao);
    }

    @Transactional
    @Override
    public Cartao save(Cartao cartao, Integer id_user) {
        cartao = cartaoRepository.save(cartao);
        cartaoRepository.cartaoUsuarioSave(cartao.getId(), id_user);
        return cartao;
    }

    @Transactional
    @Override
    public Cartao update(Integer idCartao, Integer idUser, Cartao cartao) throws Exception {
        Cartao cartaoSalvo = this.cartaoRepository.findByIdCartaoAndIdUser(idCartao,idUser);

        if (Objects.isNull(cartaoSalvo)) {
            throw new Exception("Cartão não existe no banco de dados" + idCartao);
        }

        BeanUtils.copyProperties(cartao, cartaoSalvo, "id");

        return cartaoRepository.save(cartaoSalvo);
    }

    @Override
    public List<Cartao> findByUser(Integer id) {
        return cartaoRepository.findByUser(id);
    }

    @Override
    public void cartaoUsuarioSave(Integer idUser, Integer idCartao)  {}

}
