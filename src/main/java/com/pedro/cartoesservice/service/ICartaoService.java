package com.pedro.cartoesservice.service;

import com.pedro.cartoesservice.model.Cartao;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ICartaoService {

    List<Cartao> findAll();

    Page<Cartao> findAll(Pageable pageable);

    @Query(
            value = "SELECT c.id_cartao, x.ativo, x.cpf_cnpj, x.cvv_cartao, x.data_validade, x.nome, x.numero " +
                    "FROM Cartao x right join cartao_usuario c on x.id_cartao = c.id_cartao " +
                    "where c.id_user = :idUser and c.id_cartao = :idCartao",
            nativeQuery = true)
    Cartao findByIdCartaoAndIdUser(@Param("idCartao") Integer idCartao, @Param("idUser") Integer idUser);

    @Modifying
    @Query(
            value =
                    "DELETE from cartao_usuario c where c.id_user = :idUser and c.id_cartao = :idCartao ",
            nativeQuery = true)
    void deleteByNumero(@Param("idUser") Integer idUser, @Param("idCartao") Integer idCartao) throws Exception;

    Cartao save(Cartao cartao, Integer id_user);

    Cartao update(Integer idCartao, Integer idUser, Cartao cartao) throws Exception;

    @Modifying
    @Query(
            value =
                    "INSERT INTO public.cartao_usuario (id_user, id_cartao) VALUES (:idUser, :idCartao)",
            nativeQuery = true)
    void cartaoUsuarioSave(@Param("idCartao") Integer idCartao, @Param("idUser") Integer idUser);

    @Query(
            value = "SELECT c.id_cartao, x.ativo, x.cpf_cnpj, x.cvv_cartao, x.data_validade, x.nome, x.numero " +
                    "FROM Cartao x right join cartao_usuario c on x.id_cartao = c.id_cartao where c.id_user = :idUser",
            nativeQuery = true)
    List<Cartao> findByUser(@Param("idUser") Integer idUser);
}
