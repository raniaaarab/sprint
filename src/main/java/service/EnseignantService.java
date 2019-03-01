package service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.Candidat;
import model.Enseignant;
import repository.CandidatRepository;
import repository.EnseignantRepository;

@Service
public class EnseignantService {
	@Autowired
	EnseignantRepository enseignantrepository;

	// Recuperer tous les candidats
	public List<Enseignant> getAllEnseignant() {

		return enseignantrepository.findAll();
	}

	// recuperer candidat par id
	public Optional<Enseignant> getEnseignant(int noenseignant) {
		return enseignantrepository.findById(noenseignant);
	}

	// retourner un candidat par nom:
	public Enseignant findEnseignantByName(String nom) {
		List<Enseignant> listeDesCandidat = enseignantrepository.findAll();
		return listeDesCandidat.stream().filter(t -> t.getNom().equals(nom)).findFirst().get();
	}

	// retourner un candidat par universite:
	public Enseignant findEnseignantByEmailUbo(String email) {
		List<Enseignant> listeDesCandidat = enseignantrepository.findAll();
		return listeDesCandidat.stream().filter(t -> t.getEmailUbo().equals(email)).findFirst().get();
	}

	// retourner un candidat par universite:
	public Enseignant findEnseignantByNoEnseignant(int noenseignant) {
		List<Enseignant> listeDesCandidat = enseignantrepository.findAll();
		return listeDesCandidat.stream().filter(t -> t.getNoEnseignant() == (noenseignant)).findFirst().get();
	}

	// ajouter un candidat
	public void addEnseignant(Enseignant enseignant) {
		enseignantrepository.save(enseignant);
	}

	// supprimer tous les candidats
	public void deleteAllEnseignant() {
		enseignantrepository.deleteAll();
	}

}
