package com.gestion.etablissement.scolaire.ml.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestion.etablissement.scolaire.ml.entity.PayementScolaire;
import com.gestion.etablissement.scolaire.ml.repository.PayementScolaireRepository;

@Service
public class PayementScolaireServices {
	@Autowired
	private PayementScolaireRepository payementScolaireRepository;
	
	public PayementScolaire savePayementScolaire(PayementScolaire payementScolaire) {
		return payementScolaireRepository.save(payementScolaire);
	}
	
}
