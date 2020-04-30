package com.lisovskiy.kinogluk.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lisovskiy.kinogluk.entity.Company;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class CompanyControllerMockitoTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    public void findAllTest() throws Exception {
        mockMvc.perform(get("/v1/games/company")
        .contentType("application/json"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void findByTitleTest() throws Exception {
        String title = "cd red project";
        mockMvc.perform(get("/v1/games/company/{companyTitle}", title)
        .contentType("application/json"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void createTest() throws Exception {
        Company company = new Company();
        company.setTitle("Guerilla");
        mockMvc.perform(post("/v1/games/company/create")
        .contentType("application/json")
        .content(objectMapper.writeValueAsString(company)))
                .andDo(print())
                .andExpect(status().isCreated());
    }

    @Test
    public void deleteByIdTest() throws Exception {
        int id = 63;
        mockMvc.perform(post("/v1/games/company/{companyId}", id)
        .contentType("application/json"))
                .andDo(print())
                .andExpect(status().isNoContent());
    }

    @Test
    public void deleteByTitleTest() throws Exception {
        String title = "Guerilla";
        mockMvc.perform(post("/v1/games/company/delete")
        .contentType("application/json")
        .content(title))
                .andDo(print())
                .andExpect(status().isNoContent());
    }

    @Test
    public void updateTest() throws Exception {
        String title = "Santa Monica";
        int id = 61;
        Company company = new Company();
        company.setTitle(title);
        mockMvc.perform(post("/v1/games/company/update/{companyId}", id)
        .contentType("application/json")
        .content(objectMapper.writeValueAsString(company)))
                .andDo(print())
                .andExpect(status().isOk());
    }


}
