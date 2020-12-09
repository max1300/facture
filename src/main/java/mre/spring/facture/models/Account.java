package mre.spring.facture.models;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "compte")
@NamedEntityGraph(name = "account.loadDepensesAndRentree", attributeNodes = {
        @NamedAttributeNode("depenses"),
        @NamedAttributeNode("rentrees")
})
@NamedQuery(name = "Account.findByCreatedAt", query = "SELECT a FROM Account a WHERE a.createdAt = :date")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    @NotNull
    private String nom;

    @DateTimeFormat(pattern = "MM/yyyy")
    @Column(name = "created_at")
    private LocalDate createdAt;


//    @ManyToOne
//    private ApiUser apiUser;

    @OneToMany(mappedBy = "account", fetch = FetchType.LAZY)
    @JsonIgnoreProperties({"account"})
    @Valid
    private Set<Depense> depenses = new HashSet<>();

    @OneToMany(mappedBy = "account", fetch = FetchType.LAZY)
    @JsonIgnoreProperties({"account"})
    @Valid
    private Set<Rentree> rentrees = new HashSet<>();



    @PrePersist
    public void setCreatedAt() {
        this.createdAt = LocalDate.now();
    }

    public void addRentree(Rentree rentree){
        this.rentrees.add(rentree);
        rentree.setAccount(this);
    }

    public void addDepense(Depense depense){
        this.depenses.add(depense);
        depense.setAccount(this);
    }

    public void removeRentree(Rentree rentree){
        this.rentrees.remove(rentree);
    }

    public void removeDepense(Depense depense){
        this.depenses.remove(depense);
    }
}
