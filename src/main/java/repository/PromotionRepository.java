package repository;

import org.springframework.data.jpa.repository.JpaRepository;

import model.Promotion;
import model.PromotionPK;

public interface PromotionRepository extends JpaRepository<Promotion,PromotionPK>{

}
