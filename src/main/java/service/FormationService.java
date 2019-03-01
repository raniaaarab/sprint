package service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.Formation;
import repository.FormationRepository;

@Service
public class FormationService {

	@Autowired
	FormationRepository formationRepository;

	// Récuperer la liste des formations
	public List<Formation> ListeFormations() {
		return formationRepository.findAll();
	}

	// Récuperer formation par code formation
	public Formation findFormationByCode(String codeFormation) {

		List<Formation> formations = formationRepository.findAll();
		return formations.stream().filter(t -> t.getCodeFormation().equals(codeFormation)).findFirst().get();
	}

	// Récuperer formation par nom formation
	public Formation findFormationByName(String nomFormation) {

		List<Formation> formationsParNom = formationRepository.findAll();
		return formationsParNom.stream().filter(t -> t.getNomFormation().equals(nomFormation)).findFirst().get();
	}

	// Créer une formation
	public void addFormation(Formation formation) {
		formationRepository.save(formation);

	}

	// update formation
	public void UpdateFormation(Formation formation) {
		formationRepository.save(formation);

	}

	// Supprimer une formation par code formation
	public void deleteFormation(String codeFormation) {
		formationRepository.deleteById(codeFormation);
	}

	// Supprimer toutes les formations:
	public void deleteFormations() {
		formationRepository.deleteAll();
	}

}
