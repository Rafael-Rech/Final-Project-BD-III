package com.example.trabalhofinal.domain.dto.jogo;


public class JogoRequestDTO {
    private Long id;
    private String nome;
    private String produtora;
    private String genero;
    private String plataforma;
    private Integer ano;
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
    public String getPlataforma() {
        return plataforma;
    }
    public void setPlataforma(String plataforma) {
        this.plataforma = plataforma;
    }
    public Integer getAno() {
        return ano;
    }
    public void setAno(Integer ano) {
        this.ano = ano;
    }
}
