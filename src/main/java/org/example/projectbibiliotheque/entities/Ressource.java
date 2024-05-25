package org.example.projectbibiliotheque.entities;


import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.ArrayList;
import java.util.Date;

import java.util.List;

@Entity
public class Ressource {
@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long idRessource;
@Column(name = "Titre")
  String titre;
@DateTimeFormat(pattern = "yyyy-MM-dd")
Date datePublication;
//private List<Enseignant> ListEnseignant;


}
