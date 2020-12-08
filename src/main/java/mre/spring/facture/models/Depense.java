package mre.spring.facture.models;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Data
@Entity
@NamedEntityGraph(name = "depense.loadCategory",
        attributeNodes = @NamedAttributeNode("category"))
public class Depense{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "depense_id")
    private Long id;

    @NotNull(message = "le montant ne peut être nul")
    @Positive(message = "le montant de la rentree d'argent doit au minimum être de 1 euros")
    private Double amount;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate date;

    @Size(min = 10, max = 255,
            message = "la description doit contenir suffisamment d'indications")
    @NotEmpty
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="category_id")
    @Valid
    private Category category;

    @ManyToOne(fetch = FetchType.LAZY)
    private Account account;


    @PrePersist
    public void setDate() {
        this.date = LocalDate.now();
    }

}
