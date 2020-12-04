package mre.spring.facture.models;

import lombok.Data;

import javax.persistence.*;
import java.time.Instant;

@Data
@Entity
public class Depense{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double amount;
    private Instant date;
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
