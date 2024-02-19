package com.github.springdata_asterixapi;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@SpringBootTest
@AutoConfigureMockMvc
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
class AsterixControllerTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private CharacterRepo repo;

    @Test
    void getAllCharacters_returnEmptyList_whenCalledInitially() throws Exception {
        //GIVEN
        List<Character> characters = List.of();
        //WHEN & THEN
        mvc.perform(MockMvcRequestBuilders.get("/api/asterix/characters"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(characters.toString()));
    }

//    @Test
//    void getCharacterByName() {
//        //GIVEN
//
//        //WHEN & THEN
//    }
//
//    @Test
//    void getCharacterById() {
//        //GIVEN
//        //WHEN & THEN
//    }
//
//    @Test
//    void getCharacterByAge() {
//        //GIVEN
//        //WHEN & THEN
//    }
//
//    @Test
//    void getCharacterByProfession() {
//        //GIVEN
//        //WHEN & THEN
//    }
//
//    @Test
//    void getAverageAgeByProfession() {
//        //GIVEN
//        //WHEN & THEN
//    }

    @Test
    void saveCharacter_returnNewCharacter_whenCalledWIthValidJSON() throws Exception {
        //GIVEN
        //WHEN & THEN
        mvc.perform(MockMvcRequestBuilders.post("/api/asterix/characters/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("""
                                {
                                "name": "Jessi",
                                "age" : 30,
                                "profession":  "Bouldern"
                                }
                                """))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json("""
                        {
                        "name": "Jessi",
                        "age" : 30,
                        "profession":  "Bouldern"
                        }
                        """))
                .andExpect(jsonPath("$.id").exists());
    }

//    @Test
//    void updateCharacterById() {
//        //GIVEN
//        //WHEN & THEN
//    }
//
//    @Test
//    void deleteCharacterById() {
//        //GIVEN
//        //WHEN & THEN
//    }
}