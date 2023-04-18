package com.gestion.etablissement.scolaire.ml.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gestion.etablissement.scolaire.ml.entity.Cours;

public interface CoursRepository extends JpaRepository<Cours,Long> {

}
