package com.lisovskiy.kinogluk.controller;

import com.lisovskiy.kinogluk.service.impl.CatalogServiceImpl;
import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.OverrideAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = CatalogController.class)
@OverrideAutoConfiguration(enabled = true)
public class CatalogControllerMockitoTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private CatalogController catalogController;

    @Autowired
    private CatalogServiceImpl catalogService;

    @Before
    public void setUp() {
        catalogService = Mockito.mock(CatalogServiceImpl.class);
        catalogController = new CatalogController(catalogService);
        mockMvc = standaloneSetup(catalogController).build();
    }

    @After
    public void tearDown() {
        mockMvc = null;
        catalogController = null;
        catalogService = null;
    }

    @Test
    public void findAllTest() throws Exception {
        mockMvc.perform(get("/v1/games/catalog")
                .contentType("application/json"))
                //.andDo(print())
                .andExpect(status().isOk());
                //.andExpect(jsonPath("$.catalog").exists());
                //.andExpect(jsonPath("$.catalog[*].catalogId").isNotEmpty());
    }
}
