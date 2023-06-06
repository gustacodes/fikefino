package com.academia.fikefino.services;

import com.academia.fikefino.entities.Admin;
import com.academia.fikefino.repositories.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class AdminService /*implements UserDetailsService*/ {

    @Autowired
    private AdminRepository adminRepository;

    public Admin save(Admin admin) {
        return adminRepository.save(admin);
    }

    public List<Admin> findAll() {
        return adminRepository.findAll();
    }

    public void deleteById(Long id) {
        adminRepository.deleteById(id);
    }

    /*@Override
    public UserDetails loadUserByUsername(String usuario) throws UsernameNotFoundException {
        Admin admin = adminRepository.findByUsuario(usuario);
        if (usuario == null) {
            throw new UsernameNotFoundException("Usuário não encontrado");

        } return admin;
    }*/
}
