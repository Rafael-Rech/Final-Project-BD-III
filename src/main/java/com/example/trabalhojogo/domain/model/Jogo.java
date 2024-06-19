package com.example.trabalhojogo.domain.model;

import com.example.trabalhojogo.domain.Enum.EPlataforma;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "jogo")
public class Jogo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String produtora;

    private String genero;

    private EPlataforma plataforma;

    private Integer ano;

    private Integer taxaConclusao;

    @ManyToOne
    @JoinColumn(name="idUsuario")
    private Usuario usuario;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getProdutora() {
        return produtora;
    }

    public void setProdutora(String produtora) {
        this.produtora = produtora;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public EPlataforma getPlataforma() {
        return plataforma;
    }

    public void setPlataforma(EPlataforma plataforma) {
        this.plataforma = plataforma;
    }

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Integer getTaxaConclusao() {
        return taxaConclusao;
    }

    public void setTaxaConclusao(Integer taxaConclusao) {
        this.taxaConclusao = taxaConclusao;
    }
}
