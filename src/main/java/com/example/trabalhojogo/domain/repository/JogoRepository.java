package com.example.trabalhojogo.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.trabalhojogo.domain.model.Jogo;
import com.example.trabalhojogo.domain.model.Usuario;

public interface JogoRepository extends JpaRepository<Jogo, Long> {
    List<Jogo> findByUsuario(Usuario usuario);
}
