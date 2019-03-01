package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import model.Formation;
import service.FormationService;

@CrossOrigin
@RestController

public class FormationController {
	@Autowired
	private FormationService serviceFormation;

	// Récuperer tous les formations
	@GetMapping("/formations")
	public List<Formation> FormationAll() {
		return serviceFormation.ListeFormations();
	}

	// Récupérer formation par code formation
	@GetMapping("/formations/{id}")
	public Formation FormationByCode(@PathVariable String id) {
		return serviceFormation.findFormationByCode(id);
	}

	// Récupérer formation par nom
	@GetMapping("/formations/nom/{nom}")
	public Formation FormationByName(@PathVariable String nom) {
		return serviceFormation.findFormationByName(nom);
	}

	// Créer une formation
	@RequestMapping(method = RequestMethod.POST, value = "/formations")
	public void addFormation(@RequestBody Formation formation) {
		serviceFormation.addFormation(formation);
	}

	// Update formation
	@RequestMapping(method = RequestMethod.PUT, value = "/formations")
	public void updateFormation(@RequestBody Formation formation) {
		serviceFormation.UpdateFormation(formation);
	}

	// Supprimer formation par codeFormation
	@RequestMapping(method = RequestMethod.DELETE, value = "/formations/{codeFormation}")
	public void deleteFormationParCode(@PathVariable String codeFormation) {
		serviceFormation.deleteFormation(codeFormation);
	}

	// Supprimer toutes les formations
	@RequestMapping(method = RequestMethod.DELETE, value = "/formations")
	public void deleteAllFormations() {
		serviceFormation.deleteFormations();
	}

}
