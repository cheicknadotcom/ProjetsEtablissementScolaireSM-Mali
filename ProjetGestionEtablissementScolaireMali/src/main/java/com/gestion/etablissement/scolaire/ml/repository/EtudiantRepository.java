package com.gestion.etablissement.scolaire.ml.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gestion.etablissement.scolaire.ml.entity.Etudiant;

public interface EtudiantRepository extends JpaRepository<Etudiant, Long> {


	Optional<Etudiant> findEtudiantById(Long id);

	Optional<Etudiant> findEtudiantByNumeroMatricule(String numeroMatricule);
}
