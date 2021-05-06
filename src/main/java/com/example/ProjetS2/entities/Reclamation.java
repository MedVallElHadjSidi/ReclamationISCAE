package com.example.ProjetS2.entities;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

@Entity @Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public class Reclamation {
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Long idReclamation;
	private String nomMatiere;
	private double notAffiche;
	private String descriptionReclamation;
	private String typeReclamation;
	private String semestre;

	private boolean interaction;
	


	@ManyToOne
    private Utilisateur utilisateur;


		public boolean isInteraction() {
		return interaction;
	}



	public void setInteraction(boolean interaction) {
		this.interaction = interaction;
	}



	public void setNotAffiche(double notAffiche) {
		this.notAffiche = notAffiche;
	}



	    public String getSemestre() {
		return semestre;
	}



	public Reclamation(String nomMatiere, double notAffiche, String descriptionReclamation, String typeReclamation,
				String semestre, boolean interaction, Utilisateur utilisateur) {
			super();
			this.nomMatiere = nomMatiere;
			this.notAffiche = notAffiche;
			this.descriptionReclamation = descriptionReclamation;
			this.typeReclamation = typeReclamation;
			this.semestre = semestre;
			this.interaction = interaction;
			this.utilisateur = utilisateur;
		}



	public Reclamation(Long idReclamation, String nomMatiere, double notAffiche, String descriptionReclamation,
				String typeReclamation, String semestre, boolean interaction, Utilisateur utilisateur) {
			super();
			this.idReclamation = idReclamation;
			this.nomMatiere = nomMatiere;
			this.notAffiche = notAffiche;
			this.descriptionReclamation = descriptionReclamation;
			this.typeReclamation = typeReclamation;
			this.semestre = semestre;
			this.interaction = interaction;
			this.utilisateur = utilisateur;
		}



	public Reclamation(String nomMatiere, double notAffiche, String descriptionReclamation, String typeReclamation,
				String semestre, Utilisateur utilisateur) {
			super();
			this.nomMatiere = nomMatiere;
			this.notAffiche = notAffiche;
			this.descriptionReclamation = descriptionReclamation;
			this.typeReclamation = typeReclamation;
			this.semestre = semestre;
			this.utilisateur = utilisateur;
		}



	public void setSemestre(String semestre) {
		this.semestre = semestre;
	}




	public Reclamation(Long idReclamation, String nomMatiere, double notAffiche, String descriptionReclamation,
				String typeReclamation, String semestre, Utilisateur utilisateur) {
			super();
			this.idReclamation = idReclamation;
			this.nomMatiere = nomMatiere;
			this.notAffiche = notAffiche;
			this.descriptionReclamation = descriptionReclamation;
			this.typeReclamation = typeReclamation;
			this.semestre = semestre;
			this.utilisateur = utilisateur;
		}



	public Reclamation(String nomMatiere, double notAffiche, String descriptionReclamation, String typeReclamation,
				Utilisateur utilisateur) {
			super();
			this.nomMatiere = nomMatiere;
			this.notAffiche = notAffiche;
			this.descriptionReclamation = descriptionReclamation;
			this.typeReclamation = typeReclamation;
			this.utilisateur = utilisateur;
		}



	public Reclamation(Long idReclamation, String nomMatiere, double notAffiche, String descriptionReclamation,
				String typeReclamation, Utilisateur utilisateur) {
			super();
			this.idReclamation = idReclamation;
			this.nomMatiere = nomMatiere;
			this.notAffiche = notAffiche;
			this.descriptionReclamation = descriptionReclamation;
			this.typeReclamation = typeReclamation;
			this.utilisateur = utilisateur;
		}



	public Reclamation() {
		super();
	}



	public Long getIdReclamation() {
		return idReclamation;
	}



	public void setIdReclamation(Long idReclamation) {
		this.idReclamation = idReclamation;
	}



	public String getNomMatiere() {
		return nomMatiere;
	}



	public void setNomMatiere(String nomMatiere) {
		this.nomMatiere = nomMatiere;
	}



	public double getNotAffiche() {
		return notAffiche;
	}



	public void setNotAffiché(double notAffiche) {
		this.notAffiche = notAffiche;
	}



	public String getDescriptionReclamation() {
		return descriptionReclamation;
	}



	public void setDescriptionReclamation(String descriptionReclamation) {
		this.descriptionReclamation = descriptionReclamation;
	}



	public String getTypeReclamation() {
		return typeReclamation;
	}



	public void setTypeReclamation(String typeReclamation) {
		this.typeReclamation = typeReclamation;
	}



	public Utilisateur getUtilisateur() {
		return utilisateur;
	}



	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}
	
	

}
