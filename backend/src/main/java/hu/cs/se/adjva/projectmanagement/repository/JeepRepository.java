package hu.cs.se.adjva.projectmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import hu.cs.se.adjva.projectmanagement.model.Jeep;

/**
 * PenRepository
 */
@Repository
public interface JeepRepository extends JpaRepository<Jeep, Integer>{

    
}
