package mre.spring.facture.models;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.time.Instant;

@Data
@Entity
public class Depense{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "le montant ne peut être nul")
    @Positive(message = "le montant de la rentree d'argent doit au minimum être de 1 euros")
    private Double amount;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Instant date;

    @Size(min = 10, max = 255,
            message = "la description doit contenir suffisamment d'indications")
    @NotEmpty
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_CATEGORY")
    private Category category;

//    private User origine;
//    private Destinataire destinataire;


    @PrePersist
    public void setDate() {
        this.date = Instant.now();
    }

}
