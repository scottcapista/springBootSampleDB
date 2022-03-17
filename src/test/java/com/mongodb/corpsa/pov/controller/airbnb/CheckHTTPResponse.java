package com.mongodb.corpsa.pov.controller.airbnb;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.corpsa.pov.model.airbnb.listingsandreviews.ListingsAndReviews;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.*;


@WebMvcTest(AirbnbRestController.class)
@ContextConfiguration({"classpath*:application.properties"})
public class CheckHTTPResponse {
    @Autowired
    MockMvc mockMvc;
    @Autowired
    ObjectMapper mapper;

//    @MockBean
//    PatientRecordRepository patientRecordRepository;
/*
    @Test
    public void getAllRecords_success() throws Exception {
        List<ListingsAndReviews> listingsAndReviews = new ArrayList<>()
        mockMvc.perform(MockMvcRequestBuilders
                        .get("/airbnb/listings/")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
 */
}