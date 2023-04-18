package com.gestion.etablissement.scolaire.ml.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestion.etablissement.scolaire.ml.entity.Users;
import com.gestion.etablissement.scolaire.ml.exception.UserNotFoundException;
import com.gestion.etablissement.scolaire.ml.repository.UsersRepository;

@Service
public class UsersServices {
	@Autowired
	private UsersRepository usersRepository;
	
	public Users getUsersById(Long id) {
		return usersRepository.findUsersById(id).orElseThrow(() -> new UserNotFoundException("Cet utilisateur d'indentifiant " + id + "n'existe pas sorry"));
	}
	public Users saveUsers(Users users) {
		return usersRepository.save(users);
	}
	public Users updateUsers(Users users) {
		return usersRepository.saveAndFlush(users);
	}
	public void deleteUsers(Users users) {
		usersRepository.delete(users);
	}
	public void deleteUsersById(Long id) {
		usersRepository.deleteById(id);
	}
	public List<Users> getAllUsers(){
		return usersRepository.findAll();
	}
	public Users getUsersByEmailAndPassword(String email,String password) {
		return usersRepository.findUsersByEmailAndPassword(email,password).orElseThrow(() -> new UserNotFoundException("Cet Utilisateur d'email :" + email + " et mot de passe :" + password + " n'existe pas sorry"));
	}
	public String getTypesUsers(String email,String password) {
		Users users = getUsersByEmailAndPassword(email, password);
		if(users.getTypeUsers().name().equalsIgnoreCase("etudiant")) {
			return "{\"message\":\"Etudiant\"}";
		}else if(users.getTypeUsers().name().equalsIgnoreCase("enseignant")) {
			return "{\"message\":\"Enseignant\"}";
		}else if(users.getTypeUsers().name().equalsIgnoreCase("secretaire")) {
			return "{\"message\":\"Secretaire\"}";
		}else if(users.getTypeUsers().name().equalsIgnoreCase("directeur")) {
			return "{\"message\":\"Directeur\"}";
		}else if(users.getTypeUsers().name().equalsIgnoreCase("censeur")) {
			return "{\"message\":\"Censeur\"}";
		}else if(users.getTypeUsers().name().equalsIgnoreCase("surveillant")) {
			return "{\"message\":\"Surveillant\"}";
		}else if(users.getTypeUsers().name().equalsIgnoreCase("proviseur")) {
			return "{\"message\":\"Proviseur\"}";
		}else if(users.getTypeUsers().name().equalsIgnoreCase("econome")) {
			return "{\"message\":\"Econome\"}";
		}
		else if(users.getTypeUsers().name().equalsIgnoreCase("administrateur"))
			return "{\"message\":\"Administrateur\"}";
		
		else
			return "null";
	}
}
