package mre.spring.facture.models;


import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.Month;
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

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate createdAt;

//    @ManyToOne
//    private ApiUser apiUser;

    @OneToMany(mappedBy = "account", fetch = FetchType.LAZY)
    @Valid
    private Set<Depense> depenses = new HashSet<>();

    @OneToMany(mappedBy = "account", fetch = FetchType.LAZY)
    @Valid
    private Set<Rentree> rentrees = new HashSet<>();

    public void setName(String name) {
        Month month = this.createdAt.getMonth();
        String monthStr = month.name();

        this.name = name + " " + monthStr;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = LocalDate.now();
    }
}
