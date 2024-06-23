package com.example.trabalhojogo.domain.service;

import com.example.trabalhojogo.domain.dto.dashboard.DashboardResponseDTO;
import com.example.trabalhojogo.domain.dto.jogo.JogoResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class DashboardService {

    @Autowired
    private JogoService jogoService;

    public DashboardResponseDTO obterDadosDashboard() {
        List<JogoResponseDTO> jogos = jogoService.obterTodos();

        int totalJogos = jogos.size();

        Map<String, Integer> jogosPorPlataforma = jogos.stream()
                .collect(Collectors.groupingBy(jogo -> jogo.getPlataforma().name(), Collectors.summingInt(e -> 1)));

        Map<String, Integer> jogosPorGenero = jogos.stream()
                .collect(Collectors.groupingBy(JogoResponseDTO::getGenero, Collectors.summingInt(e -> 1)));

        double taxaMediaConclusao = jogos.stream()
                .mapToInt(JogoResponseDTO::getTaxaConclusao)
                .average().orElse(0.0);

        Integer taxaConclusao = (int) Math.round(taxaMediaConclusao);

        return new DashboardResponseDTO(totalJogos, jogosPorPlataforma, jogosPorGenero, taxaConclusao, jogos);
    }
}