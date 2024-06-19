package org.example.projectbibiliotheque.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.ArrayList;
import java.util.Date;

import java.util.List;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Ressource {
@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long idRessource;
@Column(name = "Titre")
  String titre;
String Image;
@DateTimeFormat(pattern = "yyyy-MM-dd")
Date datePublication;
//private List<Enseignant> ListEnseignant;


}
