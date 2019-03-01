package repository;

import org.springframework.data.jpa.repository.JpaRepository;

import model.Candidat;

public interface CandidatRepository extends JpaRepository<Candidat,String> {
     
}
