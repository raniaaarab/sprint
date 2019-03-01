package repository;

import org.springframework.data.jpa.repository.JpaRepository;

import model.Formation;

public interface FormationRepository extends JpaRepository<Formation,String> {

}
