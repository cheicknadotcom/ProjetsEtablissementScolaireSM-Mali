package com.gestion.etablissement.scolaire.ml.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gestion.etablissement.scolaire.ml.entity.Materiel;

public interface MaterielRepository extends JpaRepository<Materiel,Long> {

}
