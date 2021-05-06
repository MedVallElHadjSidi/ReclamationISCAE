package com.example.ProjetS2.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ProjetS2.entities.Utilisateur;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Repository;

@Repository
public interface UtilisateurRepository extends JpaRepository<Utilisateur,String> {
    public Utilisateur findByUsername(String code);
}
