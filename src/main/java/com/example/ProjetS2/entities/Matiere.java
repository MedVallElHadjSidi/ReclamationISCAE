package com.example.ProjetS2.entities;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Matiere {
	@Id
	private String codeMatiere;
	private String nomMatiere;
	@ManyToOne()
	private Filiere filiere;
	@ManyToOne
	private Semestre semestre;


	public Filiere getFiliere() {
		return filiere;
	}

	public void setFiliere(Filiere filiere) {
		this.filiere = filiere;
	}

	public Matiere(String codeMatiere, String nomMatiere,  Semestre semestre,Filiere filiere) {
		this.codeMatiere = codeMatiere;
		this.nomMatiere = nomMatiere;
		this.filiere = filiere;
		this.semestre = semestre;
	}

	public Semestre getSemestre() {
		return semestre;
	}
	public void setSemestre(Semestre semestre) {
		this.semestre = semestre;
	}
	public Matiere(String cod_Matiere, String nom_Matiere, Semestre semestre) {
		super();
		this.codeMatiere = cod_Matiere;
		this.nomMatiere = nom_Matiere;
		this.semestre = semestre;
	}
	public String getCodeMatiere() {
		return codeMatiere;
	}
	public void setCodeMatiere(String cod_Matiere) {
		this.codeMatiere = cod_Matiere;
	}
	public String getNomMatiere() {
		return nomMatiere;
	}
	public void setNomMatiere(String nom_Matiere) {
		this.nomMatiere = nom_Matiere;
	}
	public Matiere(String cod_Matiere) {
		super();
		this.codeMatiere = cod_Matiere;
	}
	public Matiere(String cod_Matiere, String nom_Matiere) {
		super();
		this.codeMatiere = cod_Matiere;
		this.nomMatiere = nom_Matiere;
	}

	public Matiere() {
		super();
	}


}
