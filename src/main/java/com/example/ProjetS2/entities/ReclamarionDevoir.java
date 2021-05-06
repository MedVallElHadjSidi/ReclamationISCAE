package com.example.ProjetS2.entities;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;

@Entity

public class ReclamarionDevoir  extends Reclamation{
	
	private double notReel;
	

	public ReclamarionDevoir() {
		super();
	}


	public double getNotReel() {
		return notReel;
	}


	public void setNotReel(double notReel) {
		this.notReel = notReel;
	}


	public ReclamarionDevoir(String nomMatiere, double notAffiche, String descriptionReclamation,
			String typeReclamation, String semestre, Utilisateur utilisateur, double notReel) {
		super(nomMatiere, notAffiche, descriptionReclamation, typeReclamation, semestre, utilisateur);
		this.notReel = notReel;
	}


	public ReclamarionDevoir(String nomMatiere, double notAffiche, String descriptionReclamation,
			String typeReclamation, Utilisateur utilisateur, double notReel) {
		super(nomMatiere, notAffiche, descriptionReclamation, typeReclamation, utilisateur);
		this.notReel = notReel;
	}
	
	




}
