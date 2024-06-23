package com.example.trabalhojogo.domain.dto.dashboard;

import com.example.trabalhojogo.domain.dto.jogo.JogoResponseDTO;
import java.util.List;
import java.util.Map;

public class DashboardResponseDTO {
    private int totalJogos;
    private Map<String, Integer> jogosPorPlataforma;
    private Map<String, Integer> jogosPorGenero;
    private Integer taxaConclusao;
    private List<JogoResponseDTO> jogos;

    public DashboardResponseDTO() {}

    public DashboardResponseDTO(int totalJogos, Map<String, Integer> jogosPorPlataforma, Map<String, Integer> jogosPorGenero, Integer taxaConclusao, List<JogoResponseDTO> jogos) {
        this.totalJogos = totalJogos;
        this.jogosPorPlataforma = jogosPorPlataforma;
        this.jogosPorGenero = jogosPorGenero;
        this.taxaConclusao = taxaConclusao;
        this.jogos = jogos;
    }

    public int getTotalJogos() {
        return totalJogos;
    }

    public void setTotalJogos(int totalJogos) {
        this.totalJogos = totalJogos;
    }

    public Map<String, Integer> getJogosPorPlataforma() {
        return jogosPorPlataforma;
    }

    public void setJogosPorPlataforma(Map<String, Integer> jogosPorPlataforma) {
        this.jogosPorPlataforma = jogosPorPlataforma;
    }

    public Map<String, Integer> getJogosPorGenero() {
        return jogosPorGenero;
    }

    public void setJogosPorGenero(Map<String, Integer> jogosPorGenero) {
        this.jogosPorGenero = jogosPorGenero;
    }

    public double gettaxaConclusao() {
        return taxaConclusao;
    }

    public void settaxaConclusao(Integer taxaConclusao) {
        this.taxaConclusao = taxaConclusao;
    }

    public List<JogoResponseDTO> getJogos() {
        return jogos;
    }

    public void setJogos(List<JogoResponseDTO> jogos) {
        this.jogos = jogos;
    }
}