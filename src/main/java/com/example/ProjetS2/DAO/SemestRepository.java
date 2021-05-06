package com.example.ProjetS2.DAO;

import com.example.ProjetS2.entities.Matiere;
import com.example.ProjetS2.entities.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ProjetS2.entities.Semestre;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface SemestRepository extends JpaRepository<Semestre, Long>{

    public Semestre findByNomSemester(String code);

}
