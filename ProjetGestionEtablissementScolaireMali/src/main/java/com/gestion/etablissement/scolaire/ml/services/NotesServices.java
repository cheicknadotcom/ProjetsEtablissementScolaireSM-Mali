package com.gestion.etablissement.scolaire.ml.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestion.etablissement.scolaire.ml.entity.Notes;
import com.gestion.etablissement.scolaire.ml.repository.NoteRepository;

@Service
public class NotesServices {
	@Autowired
	private NoteRepository noteRepository;
	public Notes saveNotes(Notes notes) {
		return noteRepository.save(notes);
	}
	public Notes updateNotes(Notes notes) {
		return noteRepository.saveAndFlush(notes);
	}
	public void deleteNotes(Notes notes) {
		noteRepository.delete(notes);
	}
	public void deleteNotesById(Long id) {
		noteRepository.deleteById(id);
	}
	public List<Notes>	getAllNotes(){
		return noteRepository.findAll();
	}
//	public Notes getNotesByLibelle(String libelle) {
//		return noteRepository.findNotesByLibelle(libelle).orElseThrow(() -> new UserNotFoundException("Cette Note n'existe pas sorry!!!!"));
//	}
}
