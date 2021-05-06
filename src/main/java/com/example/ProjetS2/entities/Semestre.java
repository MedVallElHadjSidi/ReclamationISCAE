package com.example.ProjetS2.entities;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Semestre {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idSemester;
	private String nomSemester;
	@OneToMany(mappedBy = "semestre")
	private Collection<Matiere>matiere;

	public Long getIdSemester() {
		return idSemester;
	}

	public String getNomSemester() {
		return nomSemester;
	}

	public Collection<Matiere> getMatiere() {
		return matiere;
	}

	public void setIdSemester(Long idSemester) {
		this.idSemester = idSemester;
	}

	public void setNomSemester(String nomSemester) {
		this.nomSemester = nomSemester;
	}

	public void setMatiere(Collection<Matiere> matiere) {
		this.matiere = matiere;
	}

	public Semestre(String nomSemester) {
		this.nomSemester = nomSemester;
	}

	public Semestre(Long idSemester, String nomSemester) {
		this.idSemester = idSemester;
		this.nomSemester = nomSemester;
	}

	public Semestre() {
		super();
	}
	
}
