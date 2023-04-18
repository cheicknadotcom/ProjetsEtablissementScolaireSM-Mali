package com.gestion.etablissement.scolaire.ml.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestion.etablissement.scolaire.ml.entity.Etudiant;
import com.gestion.etablissement.scolaire.ml.exception.UserNotFoundException;
import com.gestion.etablissement.scolaire.ml.repository.EtudiantRepository;
@Service
public class EtudiantsServices {
	@Autowired
	private EtudiantRepository etudiantRepository;
	
	public  Etudiant saveEtudiant(Etudiant etudiant) {
		return etudiantRepository.save(etudiant);
	}
	public Etudiant updateEtudiant(Etudiant etudiant) {
		return etudiantRepository.saveAndFlush(etudiant);
	}
	public List<Etudiant> getAllEtudiant(){
		return etudiantRepository.findAll();
	}
	public Etudiant getEtudiantById(Long id) {
		return etudiantRepository.findEtudiantById(id).orElseThrow(() -> new UserNotFoundException("Cet etudiant n'exist pas sorry!!!"));
	}
	public void deleteEtudiant(Etudiant etudiant) {
		
		etudiantRepository.delete(getEtudiantById(etudiant.getId()));
	}
	public void deleteEtudiantById(Long id) {
		etudiantRepository.deleteById(id);
	}
	public Etudiant getEtudiantByNumeroMatricule(String numeroMatricule) {
		return etudiantRepository.findEtudiantByNumeroMatricule(numeroMatricule).orElseThrow(() -> new UserNotFoundException("Cet Etudiant Numero Matricule : " + numeroMatricule + "n'existe pas sorry"));
	}
}
