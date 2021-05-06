package com.example.ProjetS2.entities;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Filiere {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idFiliere;
	private String nomFiliere;
	@OneToMany(mappedBy = "filiere")
	private Collection<Utilisateur>utilisateurs;
	
	 @OneToMany (mappedBy = "filiere")
		private Collection<Matiere>matiere;

	public Collection<Matiere> getMatiere() {
		return matiere;
	}

	public void setMatiere(Collection<Matiere> matiere) {
		this.matiere = matiere;
	}

	public Long getIdFiliere() {
		return idFiliere;
	}

	public String getNomFiliere() {
		return nomFiliere;
	}

	public void setIdFiliere(Long idFiliere) {
		this.idFiliere = idFiliere;
	}

	public void setNomFiliere(String nomFiliere) {
		this.nomFiliere = nomFiliere;
	}

	public Filiere(String nomFiliere) {
		this.nomFiliere = nomFiliere;
	}

	public Filiere(Long idFiliere, String nomFiliere) {
		this.idFiliere = idFiliere;
		this.nomFiliere = nomFiliere;
	}

	public Filiere() {
	}
}
