package com.navisharma.RestApiUnitTesting.rest;

import com.navisharma.RestApiUnitTesting.model.Student;
import com.navisharma.RestApiUnitTesting.service.IGreetings;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.assertj.MockMvcTester;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import tools.jackson.databind.ObjectMapper;


import static org.junit.jupiter.api.Assertions.assertEquals;

@WebMvcTest(GreetingsController.class)
public class GreetingsControllerTest
{
    @MockitoBean
    private IGreetings service;

    //Create Mock Http Request
    @Autowired
    private MockMvc mockMvc;

    @Test
    @Disabled
    void testGetWishes()  throws Exception
    {
        //Mocking
        Mockito.when(service.generateWish("Navi")).thenReturn("Good Morning");   // It will not actually invoke service.generateWish method Because the actual behaviour of this method while
        // running the test case is not considered It will see Good Morning only Because it is not actually invoking the unit Because it will consider this fake scenerio It will consider this mock of this actual behaviour

        //RequestObject     //It is Just to create a fake HTTP request Object
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/greet");
        ResultActions result = mockMvc.perform(requestBuilder);
        MvcResult mvcResult = result.andReturn();
        MockHttpServletResponse response = mvcResult.getResponse();
        int statusCode = response.getStatus();


        //Assertion
        assertEquals(200,statusCode);
    }


    @Test
    void testAddStudent() throws Exception
    {
        //Mocking
        Mockito.when(service.addStudent(ArgumentMatchers.any())).thenReturn(true);   //Whenever service.addStudent() is called with ANY argument -> return true


        Student student = new Student(1,"Rohan","Bengaluru");

        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(student);

        //RequestBuilder
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/add")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json);
        ResultActions result = mockMvc.perform(requestBuilder);
        MvcResult mvcResult = result.andReturn();
        MockHttpServletResponse response = mvcResult.getResponse();
        int statusCode = response.getStatus();

        //Assertion
        assertEquals(200,statusCode);

    }

}
