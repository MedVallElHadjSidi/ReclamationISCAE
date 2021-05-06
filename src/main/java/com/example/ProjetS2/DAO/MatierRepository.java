package com.example.ProjetS2.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ProjetS2.entities.Matiere;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MatierRepository extends JpaRepository<Matiere, String> {

    @Query("select distinct  m from Matiere m where m.filiere.idFiliere=:f and m.semestre.idSemester=:s")
    public List<Matiere> MateierSemester(@Param("f") Long id,@Param("s")Long idsemestre);


}
