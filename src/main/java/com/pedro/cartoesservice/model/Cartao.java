package com.pedro.cartoesservice.model;

        import javax.persistence.*;
        import javax.validation.constraints.NotBlank;
        import javax.validation.constraints.NotNull;

@Entity
public class Cartao {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cartao", nullable = false)
    private Integer id;

    @Column(name = "cvv_cartao", nullable = false)
    @NotBlank(message = "O cvv é obrigatório para o cadastro do cartão")
    private String cvv;

    @Column(name = "data_validade", nullable = false)
    @NotNull(message = "A data de validade é obrigatório para o cadastro do cartão")
    private String dataValidade;

    @Column(name = "nome", nullable = false)
    @NotBlank(message = "O nome é obrigatório para o cadastro do cartão")
    private String nome;

    @Column(name = "numero", nullable = false)
    @NotBlank(message = "O nome é obrigatório para o cadastro do cartão")
    private String numero;

    @Column(name = "ativo", nullable = false)
    @NotNull(message = "É obrigatório informar se o cartão está ativo ou não para compras")
    private Boolean ativo;

    @Column(name = "cpf_cnpj", nullable = false)
    @NotBlank(message = "É obrigatório informar o cpf ou cnpj relacionado ao cartão")
    private String cpfCnpj;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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