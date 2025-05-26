package com.l2.packaging.integration;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.l2.packaging.repository.PedidoRepository;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class PedidoControllerIntegrationTest extends AbstractionContainerBaseTest {
        @Autowired
        private MockMvc mockMvc;
        @Autowired
        private PedidoRepository pedidoRepository;
        @Autowired
        private ObjectMapper objectMapper;
        String payloadTest;

        @BeforeEach
        public void setUp() {
                pedidoRepository.deleteAll();
                try {
                        payloadTest = new String(Files.readAllBytes(
                                        Paths.get("src/test/java/com/l2/packaging/resources/payloadTestRequest.json")));
                } catch (IOException e) {
                        e.printStackTrace();
                }
        }

        @Test
        void givenPedidoPayloadDto_whenCreatePedido_thenReturnPedidoPayloadDto()
                        throws JsonProcessingException, Exception {
                // when - action or behaviour that we are goint test
                ResultActions result = mockMvc.perform(post("/api/pedido/v1/new")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(payloadTest));
                // then - verify the result or output expected
                result.andExpect(status().isOk()).andExpect(jsonPath("$.pedidos.size()",
                                is(objectMapper.readTree(payloadTest).get("pedidos").size())));
        }
}
