package org.example.projectbibiliotheque.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
public class Personne {
    String Nom;
    String Prenom;
    String Email;
    String Password;
}
