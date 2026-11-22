package br.edu.exemplo;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
class ProdutoControllerIntegrationTest {

 @Autowired
 MockMvc mockMvc;

 @Autowired
 ObjectMapper objectMapper;

 @Test
 void deveCadastrarProdutoPelaApi() throws Exception {
  String json = """
                {
                    "nome": "Mouse",
                    "preco": 80.0
                }
                """;

  mockMvc.perform(post("/produtos")
                  .contentType(MediaType.APPLICATION_JSON)
                  .content(json))
          .andExpect(status().isOk())
          .andExpect(jsonPath("$.id").isNumber())
          .andExpect(jsonPath("$.nome").value("Mouse"))
          .andExpect(jsonPath("$.preco").value(80.0));
 }

 @Test
 void deveBuscarProdutoPelaApi() throws Exception {
  String json = """
                {
                    "nome": "Mouse",
                    "preco": 80.0
                }
                """;

  String respostaPost = mockMvc.perform(post("/produtos")
                  .contentType(MediaType.APPLICATION_JSON)
                  .content(json))
          .andExpect(status().isOk())
          .andReturn()
          .getResponse()
          .getContentAsString();

  JsonNode jsonNode = objectMapper.readTree(respostaPost);
  long id = jsonNode.get("id").asLong();

  mockMvc.perform(get("/produtos/{id}", id))
          .andExpect(status().isOk())
          .andExpect(jsonPath("$.id").value(id))
          .andExpect(jsonPath("$.nome").value("Mouse"))
          .andExpect(jsonPath("$.preco").value(80.0));
 }
}