package org.example.projectbibiliotheque.repositories;

import org.example.projectbibiliotheque.entities.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface EtudiantRepository extends JpaRepository<Etudiant, Long> {




}
