package com.gestion.etablissement.scolaire.ml.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gestion.etablissement.scolaire.ml.entity.PayementScolaire;

public interface PayementScolaireRepository extends JpaRepository<PayementScolaire, Long> {
	
}
