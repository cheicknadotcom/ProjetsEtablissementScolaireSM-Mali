package com.gestion.etablissement.scolaire.ml.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;



@Entity
@Table(name = "T_Enseignant")
public class Enseignant extends Users {
	@Column(name = "Experience")
	private String experience;
	@Column(name = "Competence")
	private String competence;
	@Column(name = "HeureDisponible")
	private Date heureDisponible;
	public Enseignant(String nom, String prenom, String adresse, String telephone, TypeUsers typeUsers,
			String matricule, String email, String password, Date dateNaissance, String experience, String competence,
			Date heureDisponible) {
		super(nom, prenom, adresse, telephone, typeUsers, matricule, email, password, dateNaissance);
		this.experience = experience;
		this.competence = competence;
		this.heureDisponible = heureDisponible;
	}
	public Enseignant() {
		super();
	}
	public String getExperience() {
		return experience;
	}
	public void setExperience(String experience) {
		this.experience = experience;
	}
	public String getCompetence() {
		return competence;
	}
	public void setCompetence(String competence) {
		this.competence = competence;
	}
	public Date getHeureDisponible() {
		return heureDisponible;
	}
	public void setHeureDisponible(Date heureDisponible) {
		this.heureDisponible = heureDisponible;
	}
	@Override
	public String toString() {
		return "Enseignant [experience=" + experience + ", competence=" + competence + ", heureDisponible="
				+ heureDisponible + "]";
	}
	public void presenteEnseignant() {
		System.out.println(toString());
	}
}
