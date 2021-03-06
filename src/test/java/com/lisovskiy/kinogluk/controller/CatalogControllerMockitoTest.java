package com.lisovskiy.kinogluk.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lisovskiy.kinogluk.entity.Catalog;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//@ExtendWith(SpringExtension.class)
//@WebMvcTest(controllers = CatalogController.class)
//@OverrideAutoConfiguration(enabled = true)
@SpringBootTest
@AutoConfigureMockMvc
public class CatalogControllerMockitoTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

//    @Autowired
//    private CatalogController catalogController;
//
//    @Autowired
//    private CatalogServiceImpl catalogService;
//
//    @Before
//    public void setUp() {
//        catalogService = Mockito.mock(CatalogServiceImpl.class);
//        catalogController = new CatalogController(catalogService);
//        mockMvc = standaloneSetup(catalogController).build();
//    }
//
//    @After
//    public void tearDown() {
//        mockMvc = null;
//        catalogController = null;
//        catalogService = null;
//    }

    @Test
    public void findAllTest() throws Exception {
        mockMvc.perform(get("/v1/games/catalog")
                .contentType("application/json"))
                .andDo(print())
                .andExpect(status().isOk());
//                .andExpect(jsonPath("$.catalog").exists())
//                .andExpect(jsonPath("$.catalog[*].catalogId").isNotEmpty());
    }

    @Test
    public void findByTitle() throws Exception {
        mockMvc.perform(get("/v1/games/catalog/{catalogTitle}", "Best rpg games")
        .contentType("application/json"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void createTest() throws Exception {
        Catalog catalog = new Catalog();
        catalog.setTitle("want to play");
        mockMvc.perform(post("/v1/games/catalog/create")
                .contentType("application/json")
        .content(objectMapper.writeValueAsString(catalog)))
                .andDo(print())
                .andExpect(status().isCreated());
    }

    @Test
    public void deleteByIdTest() throws Exception {
        mockMvc.perform(post("/v1/games/catalog/{catalogId}", 67)
        .contentType("application/json"))
                .andDo(print())
                .andExpect(status().isNoContent());
    }

    @Test
    public void deleteByTitleTest() throws Exception {
        String title = "want to play";
        mockMvc.perform(post("/v1/games/catalog/delete")
        .contentType("application/json")
        .content(title))
                .andDo(print())
                .andExpect(status().isNoContent());
    }

    @Test
    public void updateTest() throws Exception {
        String title = "favourite";
        int id = 62;
        Catalog catalog = new Catalog();
        catalog.setTitle(title);
        mockMvc.perform(post("/v1/games/catalog/update/{catalogId}", id)
        .contentType("application/json")
        .content(objectMapper.writeValueAsString(catalog)))
                .andDo(print())
                .andExpect(status().isOk());
    }
}
