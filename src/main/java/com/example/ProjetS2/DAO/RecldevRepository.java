package com.example.ProjetS2.DAO;

import org.springframework.data.domain.Pageable;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.ProjetS2.entities.ReclamarionDevoir;
import com.example.ProjetS2.entities.Reclamation;

public interface RecldevRepository extends JpaRepository<ReclamarionDevoir, Long>{
	 @Query("select hd  from ReclamarionDevoir hd where hd.interaction=true")
	    public Page<ReclamarionDevoir> Historiques(Pageable pageable);


  
}
