package org.example.projectbibiliotheque.entities;


import jakarta.persistence.*;

@Entity
public class Administrateur extends Personne{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long idAdmin;
    @Column (name = "Role")
    String role;



}
