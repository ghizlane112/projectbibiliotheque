package org.example.projectbibiliotheque.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor

public  abstract class Personne {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Long id;

    String Nom;
    String Prenom;
    String Email;
    String Password;


}
