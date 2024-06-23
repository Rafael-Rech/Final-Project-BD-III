package com.example.trabalhojogo.domain.dto.jogo;

import com.example.trabalhojogo.domain.Enum.EPlataforma;

public class JogoResponseDTO {
    private Long id;
    private String nome;
    private String produtora;
    private String genero;
    private EPlataforma plataforma;
    private Integer ano;
    private Integer taxaConclusao;
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
    public Integer getTaxaConclusao() {
        return taxaConclusao;
    }

    public void setTaxaConclusao(Integer taxaConclusao) {
        this.taxaConclusao = taxaConclusao;
    }
}
