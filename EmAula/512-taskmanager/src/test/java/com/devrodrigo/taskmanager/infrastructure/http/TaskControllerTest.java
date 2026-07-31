package com.devrodrigo.taskmanager.infrastructure.http;

import com.jayway.jsonpath.JsonPath;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.restdocs.RestDocumentationContextProvider;
import org.springframework.restdocs.RestDocumentationExtension;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import tools.jackson.databind.ObjectMapper;

import java.util.HashMap;
import java.util.Map;

import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.documentationConfiguration;
import static org.springframework.restdocs.payload.PayloadDocumentation.*;
import static org.springframework.restdocs.request.RequestDocumentation.parameterWithName;
import static org.springframework.restdocs.request.RequestDocumentation.pathParameters;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith({RestDocumentationExtension.class, SpringExtension.class})
@SpringBootTest
class TaskControllerTest {
    // // Spring REST Docs
    MockMvc mockMvc;
    @BeforeEach
    void setUp(WebApplicationContext webApplicationContext, RestDocumentationContextProvider restDocumentation) {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext)
                .apply(documentationConfiguration(restDocumentation))
                .build();
    }

    // Permite conversão entre Json e objeto e vice-versa
    @Autowired
    ObjectMapper objectMapper;

    @Test
    void create() throws Exception {
        Map<String, String> taskRequest = new HashMap();
        taskRequest.put("title", "Aprender Spring");
        taskRequest.put("description", "Ler doc oficial");

        String responseJson = this.mockMvc.perform(
                post("/tasks")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(taskRequest))
            )
            .andExpect(status().isCreated())
            .andDo(document("create-task",
                    requestFields(
                            fieldWithPath("title").description("Titulo da terefa"),
                            fieldWithPath("description").description("Descrição detalhada")
                    ),
                    responseFields(
                            fieldWithPath("id").description("Identificador único da terefa"),
                            fieldWithPath("title").description("Titulo da terefa"),
                            fieldWithPath("description").description("Descrição detalhada"),
                            fieldWithPath("status").description("Status da terefa")
                    )
            ))
            .andReturn()
            .getResponse()
            .getContentAsString();

        String generatedId = JsonPath.read(responseJson, "$.id");

        this.mockMvc.perform(
                get("/tasks/{id}", generatedId)
                        .accept(MediaType.APPLICATION_JSON)
            )
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.id").value(generatedId))
            .andExpect(jsonPath("$.title").value("Aprender Spring"))
            .andDo(document("get-task-by-id",
                    pathParameters(
                            parameterWithName("id").description("Identificador único da terefa")
                    ),
                    responseFields(
                            fieldWithPath("id").description("Identificador único da terefa"),
                            fieldWithPath("title").description("Titulo da terefa"),
                            fieldWithPath("description").description("Descrição detalhada"),
                            fieldWithPath("status").description("Status da terefa")
                    )
            ));



    }

    @Test
    void list() {
    }

    @Test
    void read() {
    }

    @Test
    void delete() {
    }

    @Test
    void update() {
    }
}