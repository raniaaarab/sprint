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

import model.Candidat;
import repository.CandidatRepository;
import service.CandidatService;

@CrossOrigin
@RestController

public class CandidatController {

	@Autowired
	private CandidatService candidatservice;

	// Recuperer tous les candidats
	@GetMapping("/candidats")
	public List<Candidat> getAllCandidat() {

		return candidatservice.getAllCandidat();
	}

	// Recuperer candidat par id
	@GetMapping("candidats/{id}")
	public Optional<Candidat> getCandidat(@PathVariable String id) {
		return candidatservice.getCandidat(id);
	}

	// recuperer candidat par nom
	@GetMapping("candidats/nom/{nom}")
	public Candidat findCandidatByName(@PathVariable String nom) {
		return candidatservice.findCandidatByName(nom);
	}

	// recuperer candidat par universite
	@GetMapping("candidats/universite/{universite}")
	public Candidat findCandidatByUniversite(@PathVariable String universite) {
		return candidatservice.findCandidatByUniversite(universite);
	}

	// creer candidat
	@RequestMapping(method = RequestMethod.POST, value = "/candidats")
	public void addCandidat(@RequestBody Candidat candidat) {
		candidatservice.addCandidat(candidat);
	}

	// supprimer candidat par id
	@RequestMapping(method = RequestMethod.DELETE, value = "candidats/{id}")
	public void deleteCandidat(@PathVariable String id) {
		candidatservice.deleteCandidat(id);
	}

	// supprimer tous les candidats
	@RequestMapping(method = RequestMethod.DELETE, value = "candidats")
	public void deleteAllCandidat() {
		candidatservice.deleteAllCandidat();
	}

}
