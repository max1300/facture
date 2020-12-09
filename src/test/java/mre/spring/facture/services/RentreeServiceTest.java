package mre.spring.facture.services;

import mre.spring.facture.dto.mappers.RentreeMapper;
import mre.spring.facture.dto.mappers.RentreeMapperImpl;
import mre.spring.facture.dto.modelsdto.RentreeDto;
import mre.spring.facture.models.Rentree;
import mre.spring.facture.repositories.RentreeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class RentreeServiceTest {


    @Mock
    RentreeRepository repository;

    @InjectMocks
    RentreeService rentreeService;

    List<Rentree> rentrees;

    @BeforeEach
    void setUp() {
        Rentree etrennes = new Rentree();
        etrennes.setId(1L);
        etrennes.setDescription("etrennes");
        etrennes.setAmount(50.0);

        Rentree remboursement_dettes = new Rentree();
        remboursement_dettes.setId(2L);
        remboursement_dettes.setAmount(14.2);
        remboursement_dettes.setDescription("remboursement dettes");

        rentrees = Arrays.asList(etrennes, remboursement_dettes);
    }

    @Test
    void save() {
        when(repository.save(rentrees.get(0))).thenReturn(rentrees.get(0));

        Rentree save = repository.save(rentrees.get(0));

        assertEquals(save.getDescription(), rentrees.get(0).getDescription());
    }

    @Test
    void allRentrees() {
        when(repository.findAll()).thenReturn(rentrees);

        List<Rentree> all = repository.findAll();

        assertEquals(all.size(), rentrees.size());
        assertEquals(all.get(0).getDescription(), rentrees.get(0).getDescription());
        assertEquals(all.get(1).getDescription(), rentrees.get(1).getDescription());

    }

    @Test
    void getById() {
        when(repository.findById(1L)).thenReturn(Optional.of(rentrees.get(0)));
        Optional<Rentree> optionalRentree = repository.findById(1L);

        Rentree rentree = optionalRentree.orElse(null);

        assertEquals(rentree.getDescription(), rentrees.get(0).getDescription());

    }
}