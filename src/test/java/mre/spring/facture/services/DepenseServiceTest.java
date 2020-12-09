package mre.spring.facture.services;

import mre.spring.facture.models.Depense;
import mre.spring.facture.repositories.DepenseRepository;
import mre.spring.facture.repositories.DepenseRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class DepenseServiceTest {

    @Mock
    DepenseRepository repository;

    @InjectMocks
    DepenseService depenseService;

    List<Depense> depenses;

    @BeforeEach
    void setUp() {
        Depense etrennes = new Depense();
        etrennes.setId(1L);
        etrennes.setDescription("etrennes");
        etrennes.setAmount(50.0);

        Depense remboursement_dettes = new Depense();
        remboursement_dettes.setId(2L);
        remboursement_dettes.setAmount(14.2);
        remboursement_dettes.setDescription("remboursement dettes");

        depenses = Arrays.asList(etrennes, remboursement_dettes);
    }

    @Test
    void save() {
        when(repository.save(depenses.get(0))).thenReturn(depenses.get(0));

        Depense save = repository.save(depenses.get(0));

        assertEquals(save.getDescription(), depenses.get(0).getDescription());
    }

    @Test
    void allDepenses() {
        when(repository.findAll()).thenReturn(depenses);

        List<Depense> all = repository.findAll();

        assertEquals(all.size(), depenses.size());
        assertEquals(all.get(0).getDescription(), depenses.get(0).getDescription());
        assertEquals(all.get(1).getDescription(), depenses.get(1).getDescription());

    }

    @Test
    void getById() {
        when(repository.findById(1L)).thenReturn(Optional.of(depenses.get(0)));
        Optional<Depense> optionalDepense = repository.findById(1L);

        Depense depense = optionalDepense.orElse(null);

        assertEquals(depense.getDescription(), depenses.get(0).getDescription());

    }
}