package com.gestion.etablissement.scolaire.ml.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gestion.etablissement.scolaire.ml.entity.Notes;

public interface NoteRepository extends JpaRepository<Notes, Long> {

	//Optional<Notes> findNotesByLibelle(String libelle);

}
