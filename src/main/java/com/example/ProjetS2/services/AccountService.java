package com.example.ProjetS2.services;

import com.example.ProjetS2.entities.Matiere;
import com.example.ProjetS2.entities.Role;
import com.example.ProjetS2.entities.Utilisateur;

import java.util.List;

public interface AccountService {
    public Utilisateur findUserByUser(String codeUser);
    public Role addRole(Role roles);
    public Utilisateur addUser(Utilisateur user);
    public Utilisateur AddRoles(String username, String rolename);
    public  List<Matiere>MatierReclamtion(Long id,Long idsemestre);

}
