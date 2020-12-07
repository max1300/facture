package mre.spring.facture.models;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
@Entity
@Table(name = "other_user")
public class OtherUser{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    @NotEmpty(message = "le prénom ne peut pas être omis")
    @Size(min = 5, message = "le prenom doit au moins contenir 5 caractères")
    private String firstName;

    @Column(name = "last_name")
    @NotEmpty(message = "le nom ne peut pas être omis")
    @Size(min = 5, message = "le nom doit au moins contenir 5 caractères")
    private String lastName;

    @Column(name = "email")
    @Email(message = "l'email doit être valide")
    private String email;

    @Enumerated(value = EnumType.STRING)
    private Lien lien;
}
