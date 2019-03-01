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

import model.Promotion;
import repository.PromotionRepository;
import service.PromotionService;

@CrossOrigin
@RestController
@RequestMapping("/")
public class PromotionController {

	@Autowired
	PromotionRepository promotionrepository;

	@Autowired
	private PromotionService promotionservice;

	// Recuperer toutes les promotions
	@GetMapping("/promotions")
	public List<Promotion> recupererToutesLesPromotions() {

		return promotionservice.recupererToutesLesPromotions();
	}

	// Récuperer promotions par formation et par anne universitaire
	@GetMapping("promotions/{formation}/{anneeUniversitaire}")
	public Optional<Promotion> recupererPromotionParId(@PathVariable String formation,
			@PathVariable String anneeUniversitaire) {
		return promotionservice.recupererPromotionParId(formation, anneeUniversitaire);
	}

	// Récuperer promotion par le lieu de rentrée
	@GetMapping("promotions/siglePromotion/{siglePromotion}")
	public Promotion recupererPromotionParSigle(@PathVariable String siglePromotion) {
		return promotionservice.recupererPromotionParSigle(siglePromotion);
	}

	// Récuperer promotion par nom
	@GetMapping("promotions/lieuRentree/{lieuRentree}")
	public List<Promotion> recupererPromotionParLieuRentree(@PathVariable String lieuRentree) {
		return promotionservice.recupererPromotionParLieuRentree(lieuRentree);
	}

	// Ajouter promotion
	@RequestMapping(method = RequestMethod.POST, value = "/promotions")
	public void creerPromotion(@RequestBody Promotion promotion) {
		promotionservice.creerPromotion(promotion);
	}

	// Supprimer promotionn par formation et année universitaire
	@RequestMapping(method = RequestMethod.DELETE, value = "/promotions/{formation}/{anneeUniversitaire}")
	public void supprimerPromotion(@PathVariable String formation, @PathVariable String anneeUniversitaire) {
		promotionservice.supprimerPromotion(formation, anneeUniversitaire);
	}

	// Supprimer tous les promotions
	@RequestMapping(method = RequestMethod.DELETE, value = "/promotions")
	public void supprimerPromotions() {
		promotionservice.supprimerPromotions();
	}

}