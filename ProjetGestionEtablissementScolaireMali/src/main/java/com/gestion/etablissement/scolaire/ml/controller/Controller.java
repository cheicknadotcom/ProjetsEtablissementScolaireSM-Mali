package com.gestion.etablissement.scolaire.ml.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.gestion.etablissement.scolaire.ml.confFile.ConfigurationFileDataBase;
import com.gestion.etablissement.scolaire.ml.entity.Etudiant;
import com.gestion.etablissement.scolaire.ml.entity.Users;
import com.gestion.etablissement.scolaire.ml.services.EtudiantsServices;
import com.gestion.etablissement.scolaire.ml.services.UsersServices;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/SchoolManagement")
public class Controller {
	@Autowired
	private EtudiantsServices etudiantsServices;
	@Autowired
	private UsersServices usersServices;
	/*************************************Gestion des Users************************************************************/
	@PostMapping(path = "/creationDBUsers/{File}", consumes = {"multipart/form-data"})
	public ResponseEntity<?> createDataBasesUsers(@RequestParam("File") MultipartFile file){
		if(ConfigurationFileDataBase.isExcelFile(file)) {
			try {
				ConfigurationFileDataBase.createDataBaseUsers(file.getInputStream());
				return ResponseEntity.ok(Map.of("Message","La base est cree avec success"));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return ResponseEntity.badRequest().body("Mauvais requeste la base n'est pas creer sorrry!!!");
	}
	@PostMapping("/saveUsers")
	public ResponseEntity<Users> ajouterUsers(@RequestBody Users users){
		return new ResponseEntity<Users>(usersServices.saveUsers(users),HttpStatus.ACCEPTED);
	}
	@PutMapping("/updateUsers")
	public ResponseEntity<Users> updateUsers(@RequestBody Users users){
		return new ResponseEntity<Users>(usersServices.updateUsers(users),HttpStatus.ACCEPTED);
	}
	@GetMapping("/getAllUsers")
	public ResponseEntity<List<Users>> getAllUsers(){
		return new ResponseEntity<List<Users>>(usersServices.getAllUsers(),HttpStatus.OK);
	}
	@DeleteMapping("/deleteUsers")
	public ResponseEntity<?> deleteUsers(@RequestBody Users users){
		usersServices.deleteUsers(users);
		return ResponseEntity.ok(Map.of("Message","Cet utilisateur a ete supprime avec  success!!!"));
	}
	@DeleteMapping("/deleteUsersById/{Id}")
	public ResponseEntity<HttpStatus> deleteUsersById(@PathVariable("Id") Long id){
		usersServices.deleteUsersById(id);
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
	}
	/*************************************Gestion des Etudiants************************************************************/
	@PostMapping("/saveEtudiant")
	public ResponseEntity<Etudiant> ajouterEtudiant(@RequestBody Etudiant etudiant){
		return new ResponseEntity<Etudiant>(etudiantsServices.saveEtudiant(etudiant),HttpStatus.ACCEPTED);
	}
	@PutMapping("/updateEtudiant")
	public ResponseEntity<Etudiant> updateEtudiant(@RequestBody Etudiant etudiant){
		return new ResponseEntity<Etudiant>(etudiantsServices.updateEtudiant(etudiant),HttpStatus.OK);
	}
	@DeleteMapping("/deleteEtudiant")
	public ResponseEntity<?> deleteEtudiant(@RequestBody Etudiant etudiant){
		etudiantsServices.deleteEtudiant(etudiant);
		return ResponseEntity.ok(Map.of("Message","Etudiant supprime avec success..."));
	}
	@DeleteMapping("/deleteEtudiantByid/{Id}")
	public ResponseEntity<?> deleteEtudiant(@PathVariable("Id") Long id){
		etudiantsServices.deleteEtudiantById(id);
		return ResponseEntity.ok(Map.of("Message","Etudiant supprimer avec success..."));
	}
	/*************************************Gestion des Administrations************************************************************/
	
}
