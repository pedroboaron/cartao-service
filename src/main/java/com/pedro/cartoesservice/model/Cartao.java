package com.pedro.cartoesservice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
public class Cartao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cartao", nullable = false)
    private Integer id;

    @Column(name = "id_user", nullable = false)
    @NotNull(message = "O idUser é obrigatório para o cadastro do cartão")
    private Integer idUser;

    @Column(name = "cvv_cartao", nullable = false)
    @NotBlank(message = "O cvv é obrigatório para o cadastro do cartão")
    private String cvv;

    @Column(name = "data_validade", nullable = false)
    @NotNull(message = "A data de validade é obrigatório para o cadastro do cartão")
    private String dataValidade;

    @Column(name = "nome", nullable = false)
    @NotBlank(message = "O nome é obrigatório para o cadastro do cartão")
    private String nome;

    @Column(name = "numero", nullable = false, unique = true)
    @NotBlank(message = "O nome é obrigatório para o cadastro do cartão")
    private String numero;

    @Column(name = "ativo", nullable = false)
    @NotNull(message = "É obrigatório informar se o cartão está ativo ou não para compras")
    private Boolean ativo;

    @Column(name = "cpf_cnpj", nullable = false, unique = true)
    @NotBlank(message = "É obrigatório informar o cpf ou cnpj relacionado ao cartão")
    private String cpfCnpj;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public String getDataValidade() {
        return dataValidade;
    }

    public void setDataValidade(String dataValidade) {
        this.dataValidade = dataValidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public String getCpfCnpj() {
        return cpfCnpj;
    }

    public void setCpfCnpj(String cpfCnpj) {
        this.cpfCnpj = cpfCnpj;
    }
}
