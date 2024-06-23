package com.example.trabalhojogo.controller;

import com.example.trabalhojogo.domain.dto.dashboard.DashboardResponseDTO;
import com.example.trabalhojogo.domain.service.DashboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/dashboard")
public class DashboardController {

    @Autowired
    private DashboardService dashboardService;

    @GetMapping
    public ResponseEntity<DashboardResponseDTO> obterDadosDashboard() {
        DashboardResponseDTO dashboardData = dashboardService.obterDadosDashboard();
        return ResponseEntity.ok(dashboardData);
    }
}