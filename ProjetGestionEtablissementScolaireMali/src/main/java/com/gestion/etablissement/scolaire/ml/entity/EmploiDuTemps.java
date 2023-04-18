package com.gestion.etablissement.scolaire.ml.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;



@Entity
@Table(name = "T_EmploiDuTemps")
public class EmploiDuTemps {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "DateCours")
	private Date dateCours;
	@Column(name = "Libelle")
	private String libelle;
	@Column(name = "HeureCours")
	private Date heureCours;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getDateCours() {
		return dateCours;
	}
	public void setDateCours(Date dateCours) {
		this.dateCours = dateCours;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public Date getHeureCours() {
		return heureCours;
	}
	public void setHeureCours(Date heureCours) {
		this.heureCours = heureCours;
	}

//	private Classe classe;
//	private Cours cours;
	
}
