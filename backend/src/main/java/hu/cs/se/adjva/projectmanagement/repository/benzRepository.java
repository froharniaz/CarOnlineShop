package hu.cs.se.adjva.projectmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import hu.cs.se.adjva.projectmanagement.model.benz;

@Repository
 public interface benzRepository extends JpaRepository<benz,Integer>{

    
}
