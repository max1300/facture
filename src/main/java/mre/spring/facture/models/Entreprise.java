package mre.spring.facture.models;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "entreprise")
public class Entreprise{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nom")
    private String nom;
}
