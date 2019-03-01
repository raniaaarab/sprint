package repository;

import org.springframework.data.jpa.repository.JpaRepository;

import model.Enseignant;

public interface EnseignantRepository extends JpaRepository<Enseignant,Integer> {

}
