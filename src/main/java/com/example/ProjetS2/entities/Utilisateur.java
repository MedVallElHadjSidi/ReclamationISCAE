package com.example.ProjetS2.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
@Entity
public class Utilisateur {
    @Id
    private  String code;
    private  String nom;
    private  String email;
    @Column(unique = true)
    private String username;
    private String password;
    @ManyToMany(fetch = FetchType.EAGER)
    private Collection<Role> roles;

    public Filiere getFiliere() {
        return filiere;
    }

    @ManyToOne
    private Filiere filiere;

    @OneToMany(mappedBy = "utilisateur")
	private Collection<Reclamation>reclamation;
	



	public Utilisateur(String code, String nom, String email, String username, String password, Filiere filiere) {
		super();
		this.code = code;
		this.nom = nom;
		this.email = email;
		this.username = username;
		this.password = password;
		this.filiere = filiere;
	}

	public Utilisateur() {
    }

    public String getCode() {
        return code;
    }

    public String getNom() {
        return nom;
    }

    public String getEmail() {
        return email;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public Collection<Role> getRoles() {
        return roles;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRoles(Collection<Role> roles) {
        this.roles = roles;
    }

    public Utilisateur(String code, String nom, String email, String username, String password) {
        this.code = code;
        this.nom = nom;
        this.email = email;
        this.username = username;
        this.password = password;
    }
}
