package com.gestion.etablissement.scolaire.ml.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gestion.etablissement.scolaire.ml.entity.Classe;

public interface ClasseRepository extends JpaRepository<Classe,Long> {

}
