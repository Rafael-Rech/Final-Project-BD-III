package com.example.trabalhojogo.domain.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.example.trabalhojogo.domain.dto.jogo.JogoRequestDTO;
import com.example.trabalhojogo.domain.dto.jogo.JogoResponseDTO;
import com.example.trabalhojogo.domain.exception.ResourceNotFoundException;
import com.example.trabalhojogo.domain.model.Jogo;
import com.example.trabalhojogo.domain.model.Usuario;
import com.example.trabalhojogo.domain.repository.JogoRepository;

@Service
public class JogoService implements ICRUDService<JogoRequestDTO, JogoResponseDTO>{
    @Autowired
    private JogoRepository jogoRepository;
    @Autowired
    private ModelMapper mapper;


    @Override
    public List<JogoResponseDTO> obterTodos() {
        Usuario usuario = (Usuario) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        List<Jogo> lista = jogoRepository.findByUsuario(usuario);
        return lista.stream().map((jogo) -> mapper.map(jogo, JogoResponseDTO.class)).collect(Collectors.toList());
    }
    @Override
    public JogoResponseDTO obterPorId(Long id) {
        Optional<Jogo> optJogo = jogoRepository.findById(id);
        if(optJogo.isEmpty()){
            throw new ResourceNotFoundException("Não foi possíven encontrar um jogo com o id " + id);
        }
        Usuario usuario = (Usuario) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if(usuario.getId() != optJogo.get().getUsuario().getId()){
            throw new ResourceNotFoundException("O jogo com o id " + id + " não pertence a este usuário");
        }
        return mapper.map(optJogo.get(), JogoResponseDTO.class);
    }
    @Override
    public JogoResponseDTO cadastrar(JogoRequestDTO dto) {
        Jogo jogo = mapper.map(dto, Jogo.class);
        Usuario usuario = (Usuario) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        jogo.setUsuario(usuario);
        jogo.setId(null);
        jogo = jogoRepository.save(jogo);
        return mapper.map(jogo, JogoResponseDTO.class);
    }
    @Override
    public JogoResponseDTO atualizar(Long id, JogoRequestDTO dto) {
        obterPorId(id);
        Jogo jogo = mapper.map(dto, Jogo.class);
        Usuario usuario = (Usuario) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        jogo.setUsuario(usuario);
        jogo.setId(id);
        jogo = jogoRepository.save(jogo);
        return mapper.map(jogo, JogoResponseDTO.class);
    }
    @Override
    public void deletar(Long id) {
        obterPorId(id);
        jogoRepository.deleteById(id);
    }
}
