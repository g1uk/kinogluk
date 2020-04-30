package com.lisovskiy.kinogluk.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lisovskiy.kinogluk.entity.Genre;
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
public class GenreControllerMockitoTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    public void findAllTest() throws Exception {
        mockMvc.perform(get("/v1/games/genre")
        .contentType("application/json"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void findByTitleTest() throws Exception {
        String title = "rpg";
        mockMvc.perform(get("/v1/games/genre/{gerneTitle}", title)
        .contentType("application/json"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void createTest() throws Exception {
        String title = "adventure";
        Genre genre = new Genre();
        genre.setTitle(title);
        mockMvc.perform(post("/v1/games/genre/create")
        .contentType("application/json")
        .content(objectMapper.writeValueAsString(genre)))
                .andDo(print())
                .andExpect(status().isCreated());
    }

    @Test
    public void updateTest() throws Exception {
        String title = "quest";
        int id = 152;
        Genre genre = new Genre();
        genre.setTitle(title);
        mockMvc.perform(post("/v1/games/genre/update/{genreId}", id)
        .contentType("application/json")
        .content(objectMapper.writeValueAsString(genre)))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void deleteByIdTest() throws Exception {
        int id = 152;
        mockMvc.perform(post("/v1/games/genre/{genreId}", id)
        .contentType("application/json"))
                .andDo(print())
                .andExpect(status().isNoContent());
    }

    @Test
    public void deleteByTitleTest() throws Exception {
        String title = "adventure";
        mockMvc.perform(post("/v1/games/genre/delete")
        .contentType("application/json")
        .content(title))
                .andDo(print())
                .andExpect(status().isNoContent());
    }
}
