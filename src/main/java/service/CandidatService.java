package service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.Candidat;
import repository.CandidatRepository;

@Service
public class CandidatService {
	@Autowired
	CandidatRepository candidatrepository;

	// Recuperer tous les candidats
	public List<Candidat> getAllCandidat() {

		return candidatrepository.findAll();
	}

	// recuperer candidat par id
	public Optional<Candidat> getCandidat(String id) {
		return candidatrepository.findById(id);
	}

	// retourner un candidat par nom:
	public Candidat findCandidatByName(String nom) {
		List<Candidat> listeDesCandidat = candidatrepository.findAll();
		return listeDesCandidat.stream().filter(t -> t.getNom().equals(nom)).findFirst().get();
	}

	// retourner un candidat par universite:
	public Candidat findCandidatByUniversite(String universite) {
		List<Candidat> listeDesCandidat = candidatrepository.findAll();
		return listeDesCandidat.stream().filter(t -> t.getUniversiteOrigine().equals(universite)).findFirst().get();
	}

	// ajouter un candidat
	public void addCandidat(Candidat candidat) {
		candidatrepository.save(candidat);
	}

	// supprimer un candidat
	public void deleteCandidat(String id) {
		candidatrepository.deleteById(id);
	}

	// supprimer tous les candidats
	public void deleteAllCandidat() {
		candidatrepository.deleteAll();
	}

}
