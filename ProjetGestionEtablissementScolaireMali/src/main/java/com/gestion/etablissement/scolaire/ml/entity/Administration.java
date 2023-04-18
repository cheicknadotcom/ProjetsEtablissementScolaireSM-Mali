package com.gestion.etablissement.scolaire.ml.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "T_Administration")
public class Administration extends Users {
	@Column(name = "Diplome")
	private String diplome;
	@Column(name = "Competence")
	private String competence;
	@Column(name = "Experience")
	private String experience;
//	@ManyToMany(mappedBy = "t_profile_id",fetch = FetchType.EAGER)
//	private Set<Profile> profile = new HashSet<>();
}
