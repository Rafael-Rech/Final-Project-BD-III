package com.example.trabalhofinal.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.trabalhofinal.domain.model.Jogo;
import com.example.trabalhofinal.domain.model.Usuario;

public interface JogoRepository extends JpaRepository<Jogo, Long>{
    List<Jogo> findByUsuario(Usuario usuario);
}
