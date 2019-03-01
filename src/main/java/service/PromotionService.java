package service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.Promotion;
import model.PromotionPK;
import repository.PromotionRepository;

@Service
public class PromotionService {
	@Autowired
	PromotionRepository promotionrepository;

	// Recuperer tous les candidats
	public List<Promotion> recupererToutesLesPromotions() {

		return promotionrepository.findAll();
	}

	public List<Promotion> recupererPromotionParLieuRentree(String lieuRentree) {
		List<Promotion> listeDesPromotion = promotionrepository.findAll();
		return listeDesPromotion.stream().filter(t -> t.getLieuRentree().equals(lieuRentree))
				.collect(Collectors.toList());
	}

	public Promotion recupererPromotionParSigle(String siglePromotion) {
		List<Promotion> listeDesPromotion = promotionrepository.findAll();
		return listeDesPromotion.stream().filter(t -> t.getSiglePromotion().equals(siglePromotion)).findFirst().get();
	}

	public void supprimerPromotions() {
		promotionrepository.deleteAll();
	}

	public void creerPromotion(Promotion promotion) {
		promotionrepository.save(promotion);
	}

	public Optional<Promotion> recupererPromotionParId(String formation, String anneeUniversitaire) {

		return promotionrepository.findById(new PromotionPK(anneeUniversitaire, formation));
	}

	public void supprimerPromotion(String formation, String anneeUniversitaire) {
		PromotionPK promotionpk = new PromotionPK();
		promotionpk.setAnneeUniversitaire(anneeUniversitaire);
		promotionpk.setFormation(formation);
		promotionrepository.deleteById(promotionpk);
	}

}