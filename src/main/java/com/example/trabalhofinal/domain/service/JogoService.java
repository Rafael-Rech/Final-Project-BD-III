package com.example.trabalhofinal.domain.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.example.trabalhofinal.domain.dto.jogo.JogoRequestDTO;
import com.example.trabalhofinal.domain.dto.jogo.JogoResponseDTO;
import com.example.trabalhofinal.domain.exception.ResourceNotFoundException;
import com.example.trabalhofinal.domain.model.Jogo;
import com.example.trabalhofinal.domain.model.Usuario;
import com.example.trabalhofinal.domain.repository.JogoRepository;

@Service
public class JogoService implements ICRUDService<JogoRequestDTO, JogoResponseDTO> {
    @Autowired
    private ModelMapper mapper;

    @Autowired
    private JogoRepository repository;

    @Override
    public List<JogoResponseDTO> obterTodos() {
        Usuario usuario = (Usuario) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        List<Jogo> lista = repository.findByUsuario(usuario);
        return lista.stream().map(jogo -> mapper.map(jogo, JogoResponseDTO.class)).collect(Collectors.toList());
    }

    @Override
    public JogoResponseDTO obterPorId(Long id) {
        Optional<Jogo> optJogo = repository.findById(id);
        if(optJogo.isEmpty()){
            throw new ResourceNotFoundException("Não existe jogo com o id " + id);
        }
        Usuario usuario = (Usuario) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if(optJogo.get().getUsuario().getId() != usuario.getId()){
            throw new ResourceNotFoundException("O jogo com id " + id + " não pertence a este usuário!");
        }
        return mapper.map(optJogo.get(), JogoResponseDTO.class);
    }

    @Override
    public JogoResponseDTO cadastrar(JogoRequestDTO dto) {
        Jogo jogo = mapper.map(dto, Jogo.class);
        Usuario usuario = (Usuario) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        jogo.setUsuario(usuario);
        jogo.setId(null);
        jogo = repository.save(jogo);
        return mapper.map(jogo, JogoResponseDTO.class);
    }

    @Override
    public JogoResponseDTO atualizar(Long id, JogoRequestDTO dto) {
        obterPorId(id);
        Jogo jogo = mapper.map(dto, Jogo.class);
        Usuario usuario = (Usuario) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        jogo.setUsuario(usuario);
        jogo.setId(id);
        jogo = repository.save(jogo);
        return mapper.map(jogo, JogoResponseDTO.class);
    }

    @Override
    public void deletar(Long id) {
        obterPorId(id);
        repository.deleteById(id);
    }
    
}
