package com.pedro.cartoesservice.repository;

import com.pedro.cartoesservice.model.Cartao;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CartaoRepository extends JpaRepository<Cartao, Long> {

    List<Cartao> findAll();

    Page<Cartao> findAll(Pageable pageable);

    Page<Cartao> findByNumero(String numero, Pageable pageable);

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

    @Query(
            value = "SELECT c.id_cartao, x.ativo, x.cpf_cnpj, x.cvv_cartao, x.data_validade, x.nome, x.numero " +
                    "FROM Cartao x right join cartao_usuario c on x.id_cartao = c.id_cartao where c.id_user = :idUser",
            nativeQuery = true)
    List<Cartao> findByUser(@Param("idUser") Integer idUser);

    @Modifying
    @Query(
            value =
                    "INSERT INTO public.cartao_usuario (id_user, id_cartao) VALUES (:idUser, :id_cartao)",
            nativeQuery = true)
    void cartaoUsuarioSave(@Param("id_cartao") Integer id_cartao, @Param("idUser") Integer idUser);
}
