package mre.spring.facture.models;

import javax.persistence.*;

@Entity
public class OtherUser{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;
    private String email;

    @Enumerated(value = EnumType.STRING)
    private Lien lien;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Lien getLien() {
        return lien;
    }

    public void setLien(Lien lien) {
        this.lien = lien;
    }
}
