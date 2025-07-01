package com.thales.agendadortarefas.infraStructure.security;


import com.thales.agendadortarefas.Business.Dto.UsuarioDTO;
import com.thales.agendadortarefas.infraStructure.client.UsuarioClient;
import com.thales.usuario.infraStructure.entity.Usuario;
import com.thales.usuario.infraStructure.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl {

    @Autowired
    private UsuarioClient client;


    // Implementação do método para carregar detalhes do usuário pelo e-mail
    @Override

    public UserDetails carregaDadosUsuario(String email, String token){

        UsuarioDTO usuarioDTO = client.buscaUsuarioPorEmail(email, token);
        return User
                .withUsername(usuarioDTO.getEmail()) // Define o nome de usuário como o e-mail
                .password(usuarioDTO.getSenha()) // Define a senha do usuário
                .build(); // Constrói o objeto UserDetails
    }
}
