package org.example.projectbibiliotheque.entities;


import jakarta.persistence.*;

@Entity
public class Etudiant  extends Personne{

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY )
  private long id;
@Column(name = "Niveaux Etude ")
    int NiveauEtud;






}
