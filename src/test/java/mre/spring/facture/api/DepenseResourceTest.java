package mre.spring.facture.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import mre.spring.facture.dto.modelsdto.DepenseDto;
import mre.spring.facture.models.Depense;
import mre.spring.facture.services.DepenseServiceInterface;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.List;

@ExtendWith(MockitoExtension.class)
class DepenseResourceTest {

    @Mock
    DepenseServiceInterface serviceInterface;

    @InjectMocks
    DepenseResource depenseResource;

    MockMvc mockMvc;

    List<DepenseDto> depenses;

    private JacksonTester<DepenseDto> jsonDepenseDto;
    private JacksonTester<Depense> jsonDepense;

    @BeforeEach
    void setUp() {
        JacksonTester.initFields(this, new ObjectMapper());
        mockMvc = MockMvcBuilders.
                standaloneSetup(depenseResource).build();

        DepenseDto achat_noel = DepenseDto.builder().id(1L).montant(17.2).description("achat noel").build();
        DepenseDto essence = DepenseDto.builder().id(2L).montant(72.0).description("essence").build();
        depenses = Arrays.asList(achat_noel, essence);
    }

    @Test
    void allDepenses() throws Exception {
        when(serviceInterface.allDepenses()).thenReturn(depenses);

        MockHttpServletResponse response = mockMvc.perform(
                get("/depenses").accept(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.length()", is(2)))
                .andReturn()
                .getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());

        verify(serviceInterface, times(1)).allDepenses();
    }

    @Test
    void getOne() throws Exception {
        when(serviceInterface.getById(2L)).thenReturn(depenses.get(1));

        MockHttpServletResponse response = mockMvc.perform(
                get("/depenses/2").accept(MediaType.APPLICATION_JSON))
                .andReturn()
                .getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo(
                jsonDepenseDto.write(DepenseDto.builder().id(2L).montant(72.0).description("essence").build())
                        .getJson());

    }

    @Test
    void create() throws Exception {
        mockMvc.perform(
                post("/depenses")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonDepenseDto.write(DepenseDto.builder().montant(102.0).description("essence chère").build()).getJson())
                )
                .andExpect(status().isOk());

    }

}