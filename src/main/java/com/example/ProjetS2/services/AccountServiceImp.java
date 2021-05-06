package com.example.ProjetS2.services;

import com.example.ProjetS2.DAO.MatierRepository;
import com.example.ProjetS2.DAO.RoleRepository;
import com.example.ProjetS2.DAO.UtilisateurRepository;
import com.example.ProjetS2.entities.Matiere;
import com.example.ProjetS2.entities.Role;
import com.example.ProjetS2.entities.Utilisateur;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AccountServiceImp  implements  AccountService{
    @Autowired
    private UtilisateurRepository utilisateurRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    private MatierRepository matierRepository;

    @Override
    public Utilisateur findUserByUser(String codeUser) {

        return utilisateurRepository.findByUsername(codeUser);
    }

    @Override
    public Role addRole(Role roles) {
        return roleRepository.save(roles);
    }


    @Override
    public Utilisateur addUser(Utilisateur user) {
        String passwdBrpt=bCryptPasswordEncoder.encode(user.getPassword());
        user.setPassword(passwdBrpt);
        return utilisateurRepository.save(user);
    }
    @Override
    public Utilisateur AddRoles(String username, String rolename) {
        Role role=roleRepository.findByRoleName(rolename);
        Utilisateur utilisateur=utilisateurRepository.findByUsername(username);
        utilisateur.getRoles().add(role);

        return utilisateur;


    }

    @Override
    public List<Matiere> MatierReclamtion(Long id, Long idsemestre) {
        return matierRepository.MateierSemester(id,idsemestre);
    }

}
