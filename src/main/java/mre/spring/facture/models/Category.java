package mre.spring.facture.models;


import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
@Entity
public class Category{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    private Long id;

    @NotEmpty(message = "le nom ne peut pas être omis")
    @Size(min = 5, message = "le nom doit au moins contenir 5 caractères")
    private String nom;

    @Size(min = 10, max = 255,
            message = "la description doit contenir suffisamment d'indications")
    @NotEmpty
    private String description;

}
