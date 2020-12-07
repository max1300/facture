package mre.spring.facture.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import mre.spring.facture.dto.mappers.RentreeMapper;
import mre.spring.facture.dto.modelsdto.DepenseDto;
import mre.spring.facture.dto.modelsdto.RentreeDto;
import mre.spring.facture.models.Depense;
import mre.spring.facture.services.DepenseServiceInterface;
import mre.spring.facture.services.RentreeServiceInterface;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
class RentreeResourceTest {

    @Mock
    RentreeServiceInterface serviceInterface;

    @Mock
    RentreeMapper rentreeMapper;

    @InjectMocks
    RentreeResource rentreeResource;

    MockMvc mockMvc;

    List<RentreeDto> rentrees;

    private JacksonTester<RentreeDto> jsonRentreeDto;

    @BeforeEach
    void setUp() {
        JacksonTester.initFields(this, new ObjectMapper());
        mockMvc = MockMvcBuilders.
                standaloneSetup(rentreeResource).build();

        RentreeDto salaire = RentreeDto.builder().id(1L).amount(17.2).description("salaire").build();
        RentreeDto mutuelle = RentreeDto.builder().id(2L).amount(72.0).description("mutuelle").build();
        rentrees = Arrays.asList(salaire, mutuelle);
    }

    @Test
    void allDepenses() throws Exception {
        when(serviceInterface.allRentrees()).thenReturn(rentrees);

        MockHttpServletResponse response = mockMvc.perform(
                get("/rentrees").accept(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.length()", is(2)))
                .andReturn()
                .getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());

        verify(serviceInterface, times(1)).allRentrees();
    }

    @Test
    void getOne() throws Exception {
        when(serviceInterface.getById(2L)).thenReturn(rentrees.get(1));

        MockHttpServletResponse response = mockMvc.perform(
                get("/rentrees/2").accept(MediaType.APPLICATION_JSON))
                .andReturn()
                .getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo(
                jsonRentreeDto.write(RentreeDto.builder().id(2L).amount(72.0).description("mutuelle").build())
                        .getJson());

        verify(serviceInterface, times(1)).getById(2L);

    }

    @Test
    void create() throws Exception {
        RentreeDto essence_chère = RentreeDto.builder().amount(102.0).description("essence chère").build();

        mockMvc.perform(
                post("/rentrees")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonRentreeDto.write(essence_chère).getJson())
        )
                .andExpect(status().isOk());

    }
}