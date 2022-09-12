package org.myorg;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
public class GreetApplicationTest {
    @Test
    @DisplayName("Springboot application should load")
    void contextTest(){

    }

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("hello api should have success response")
    void greetTest() throws Exception {
       this.mockMvc.perform(MockMvcRequestBuilders.get("/api/hello"))
               .andExpect(MockMvcResultMatchers.status().isOk())
               .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
               .andExpect(MockMvcResultMatchers.jsonPath("$.message",org.hamcrest.Matchers.is("Hello, there")));
    }
}
