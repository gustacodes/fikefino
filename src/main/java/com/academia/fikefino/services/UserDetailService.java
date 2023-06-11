package com.academia.fikefino.services;

import com.academia.fikefino.entities.Usuario;
import com.academia.fikefino.repositories.UsuarioRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailService implements UserDetailsService {

    private final UsuarioRepository usuarioRepository;

    public UserDetailService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String user) throws UsernameNotFoundException {
        Usuario u = usuarioRepository.findByUser(user);

        if(u == null) {
            throw new UsernameNotFoundException("No user found for "+ user + ".");
        }
        return u;
    }
}
