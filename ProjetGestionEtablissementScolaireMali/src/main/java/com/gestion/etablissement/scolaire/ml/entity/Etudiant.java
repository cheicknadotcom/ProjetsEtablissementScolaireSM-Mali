package com.gestion.etablissement.scolaire.ml.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import jakarta.persistence.Entity;
@Entity
@Table(name = "T_Etudiant",uniqueConstraints = {@UniqueConstraint(columnNames = "numeroMatricule")})
public class Etudiant extends Users{
	@Column(name = "NumeroMatricule")
	private String numeroMatricule;
	@Column(name = "Promotion")
	private String promotion;
	@Column(name = "ExtraitImage")
	private String extraitImage;
	
	public Etudiant() {super();}
	public Etudiant(String nom, String prenom, String adresse, String telephone, TypeUsers typeUsers, String matricule,
			String email, String password, Date dateNaissance, String imageUsers) {
		super(nom, prenom, adresse, telephone, typeUsers, matricule, email, password, dateNaissance, imageUsers);
	}
	public Etudiant(String nom, String prenom, String adresse, String telephone, TypeUsers typeUsers, String matricule,
			String email, String password, Date dateNaissance, String imageUsers,String promotion,String numeroMatri) {
		super(nom, prenom, adresse, telephone, typeUsers, matricule, email, password, dateNaissance, imageUsers);
		this.numeroMatricule = numeroMatri;
		this.promotion = promotion;
	}
	public String getPromotion() {
		return promotion;
	}
	public void setPromotion(String promotion) {
		this.promotion = promotion;
	}
	public String getNumeroMatricule() {
		return numeroMatricule;
	}
	public void setNumeroMatricule(String numeroMatricule) {
		this.numeroMatricule = numeroMatricule;
	}
	public String getExtraitImage() {
		return extraitImage;
	}
	public void setExtraitImage(String extraitImage) {
		this.extraitImage = extraitImage;
	}
}
