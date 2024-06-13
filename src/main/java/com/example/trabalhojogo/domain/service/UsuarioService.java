package com.example.trabalhojogo.domain.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.trabalhojogo.domain.dto.UsuarioRequestDTO;
import com.example.trabalhojogo.domain.dto.UsuarioResponseDTO;
import com.example.trabalhojogo.domain.exception.BadRequestException;
import com.example.trabalhojogo.domain.exception.ResourceNotFoundException;
import com.example.trabalhojogo.domain.model.Usuario;
import com.example.trabalhojogo.domain.repository.UsuarioRepository;

@Service
public class UsuarioService implements ICRUDService<UsuarioRequestDTO, UsuarioResponseDTO>{
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;


    @Override
    public List<UsuarioResponseDTO> obterTodos() {
        List<Usuario> usuarios = usuarioRepository.findAll();
        return usuarios.stream().map(usuario -> mapper.map(usuario, UsuarioResponseDTO.class)).collect(Collectors.toList());
    }

    @Override
    public UsuarioResponseDTO obterPorId(Long id) {
        Optional<Usuario> usuario = usuarioRepository.findById(id);
        if(usuario.isEmpty()){
            throw new ResourceNotFoundException("Não foi possível encontrar usuário com o id " + id);
        }
        return mapper.map(usuario.get(), UsuarioResponseDTO.class);
    }

    @Override
    public UsuarioResponseDTO cadastrar(UsuarioRequestDTO dto) {
        if(dto.getEmail() == null || dto.getSenha() == null){
            throw new BadRequestException("Email e senha são obrigatórios");
        }
        Optional<Usuario> optUs = usuarioRepository.findByEmail(dto.getEmail());
        if(optUs.isPresent()){
            throw new BadRequestException("Já existe um usuário com este email");
        }
        Usuario usuario = mapper.map(dto, Usuario.class);
        usuario.setDataCadastro(new Date());
        //Criptografar senha
        String senha = passwordEncoder.encode(usuario.getSenha());
        usuario.setSenha(senha);
        usuario = usuarioRepository.save(usuario);
        return mapper.map(usuario, UsuarioResponseDTO.class);
    }

    @Override
    public UsuarioResponseDTO atualizar(Long id, UsuarioRequestDTO dto) {
        UsuarioResponseDTO usuarioBanco = obterPorId(id);
        if(dto.getEmail() == null || dto.getSenha() == null){
            throw new BadRequestException("Email e senha são obrigatórios");
        }
        Usuario usuario = mapper.map(dto, Usuario.class);
        usuario.setSenha(dto.getSenha());
        usuario.setId(id);
        usuario.setDataCadastro(usuarioBanco.getDataCadastro());
        usuario.setDataInativacao(usuarioBanco.getDataInativacao());
        usuario = usuarioRepository.save(usuario);
        return mapper.map(usuario, UsuarioResponseDTO.class);
    }

    @Override
    public void deletar(Long id) {
        Optional<Usuario> optUsuario = usuarioRepository.findById(id);
        if(optUsuario.isEmpty()){
            throw new ResourceNotFoundException("Não foi possível encontrar o usuário com id " + id);

        }
        Usuario usuario = optUsuario.get();
        usuario.setDataInativacao(new Date());
        usuarioRepository.save(usuario);
    }
}
