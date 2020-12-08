package mre.spring.facture.models;


import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "compte")
@NamedEntityGraph(name = "account.loadDepensesAndRentree", attributeNodes = {
        @NamedAttributeNode("depenses"),
        @NamedAttributeNode("rentrees")
})
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    @NotNull
    private String name;

    private LocalDate createdAt;
    private LocalDate month;

//    @ManyToOne
//    private ApiUser apiUser;

    @OneToMany(mappedBy = "account", fetch = FetchType.LAZY)
    private Set<Depense> depenses = new HashSet<>();

    @OneToMany(mappedBy = "account", fetch = FetchType.LAZY)
    private Set<Rentree> rentrees = new HashSet<>();
}
