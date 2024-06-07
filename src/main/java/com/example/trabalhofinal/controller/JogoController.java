package com.example.trabalhofinal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.trabalhofinal.domain.dto.jogo.JogoRequestDTO;
import com.example.trabalhofinal.domain.dto.jogo.JogoResponseDTO;
import com.example.trabalhofinal.domain.service.JogoService;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/jogo")
public class JogoController {
    @Autowired

    private JogoService service;

    @GetMapping
    public ResponseEntity<List<JogoResponseDTO>> obterTodos(){
        return ResponseEntity.ok(service.obterTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<JogoResponseDTO> obterPorId(@PathVariable Long id){
        return ResponseEntity.ok(service.obterPorId(id));
    }

    @PostMapping
    public ResponseEntity<JogoResponseDTO> cadastrar(@RequestBody JogoRequestDTO dto){
        JogoResponseDTO jogoResponseDTO = service.cadastrar(dto);
        return new ResponseEntity<>(jogoResponseDTO, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<JogoResponseDTO> atualizar(@PathVariable Long id, @RequestBody JogoRequestDTO dto){
        JogoResponseDTO jogoResponseDTO = service.atualizar(id, dto);
        return ResponseEntity.ok(jogoResponseDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar(@PathVariable Long id){
        service.deletar(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
