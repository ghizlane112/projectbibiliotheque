package org.example.projectbibiliotheque.entities;


import jakarta.persistence.*;

@Entity
public class Enseignant  extends Personne{

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private long idEnseignant;
   @Column(name = "Matier Enseignant")
  String MatierEnseignant;






}
