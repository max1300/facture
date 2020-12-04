package mre.spring.facture.models;


import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Category{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String description;

    @OneToMany(fetch = FetchType.LAZY)
    private List<Depense> depenses = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY)
    private List<Rentree> rentrees = new ArrayList<>();

}
