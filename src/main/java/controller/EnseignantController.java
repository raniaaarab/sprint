package controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import model.Enseignant;
import repository.EnseignantRepository;
import service.EnseignantService;

@CrossOrigin
@RestController
@RequestMapping("/")
public class EnseignantController {

	@Autowired
	private EnseignantService enseignantservice;

	// Recuperer tous les candidats
	@GetMapping("/enseignants")
	public List<Enseignant> getAllCandidat() {

		return enseignantservice.getAllEnseignant();
	}

	// Recuperer candidat par id
	@GetMapping("enseignants/{noenseignant}")
	public Optional<Enseignant> getEnseignant(@PathVariable int noenseignant) {
		return enseignantservice.getEnseignant(noenseignant);
	}

	// recuperer candidat par nom
	@GetMapping("enseignants/nom/{nom}")
	public Enseignant findCandidatByName(@PathVariable String nom) {
		return enseignantservice.findEnseignantByName(nom);
	}

	// recuperer candidat par universite
	@GetMapping("enseignants/emailUbo/{emailUbo}")
	public Enseignant findCandidatByEmailUbo(@PathVariable String emailUbo) {
		return enseignantservice.findEnseignantByEmailUbo(emailUbo);
	}

	// creer candidat
	@RequestMapping(method = RequestMethod.POST, value = "/enseignants")
	public void addEnseignant(@RequestBody Enseignant enseignant) {
		enseignantservice.addEnseignant(enseignant);
	}

	// supprimer tous les candidats
	@RequestMapping(method = RequestMethod.DELETE, value = "/enseignants")
	public void deleteAllEnseignant() {
		enseignantservice.deleteAllEnseignant();
	}
}
