package com.example.ProjetS2.DAO;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.ProjetS2.entities.Matiere;
import com.example.ProjetS2.entities.Reclamation;

public interface ReclamRepository extends JpaRepository<Reclamation, Long>{
	
	  @Query("select rm  from Reclamation rm where rm.interaction=false")
	    public Page<Reclamation> NouveauxReclamation(Pageable pageable);
 
	  @Query("select hs  from Reclamation hs where hs.interaction=true")
	    public Page<Reclamation> Historiques(Pageable pageable);
	  
	  @Query("select hr  from Reclamation hr,Utilisateur u where  hr.utilisateur.code =u.code and  hr.utilisateur.code like:x  and  hr.nomMatiere like:y and hr.semestre like:z")
	    public Page<Reclamation> ChercherHistoriques(@Param("x")String mat,@Param("y")String matiere,@Param("z")String semestre,Pageable pageable);



}
