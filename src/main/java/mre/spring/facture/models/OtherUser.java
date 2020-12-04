package mre.spring.facture.models;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "other_user")
public class OtherUser{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "email")
    private String email;

    @Enumerated(value = EnumType.STRING)
    private Lien lien;
}
