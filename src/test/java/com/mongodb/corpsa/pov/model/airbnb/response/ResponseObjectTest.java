package com.mongodb.corpsa.pov.model.airbnb.response;

import com.mongodb.corpsa.pov.model.airbnb.listingsandreviews.Review;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Instant;

import static org.junit.jupiter.api.Assertions.*;

class ResponseObjectTest {

    private final static Logger LOGGER = LoggerFactory.getLogger(ResponseObjectTest.class);
    ResponseObject responseObject;
    @BeforeEach
    void setUp() {
        responseObject = new ResponseObject("Test");
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void basicCloseEvent() {
        this.responseObject.closeEvent();
        assertAll("Event Object",
                () -> assertEquals("Test", this.responseObject.getLastFinishedEvent().getCall()),
                () -> assertTrue(this.responseObject.getLastFinishedEvent().getEventDuration() > 0),
                () -> assertTrue(this.responseObject.getCallEventStack().isEmpty())
        );
    }

    @Test
    void closeMultipleEvents(){
        this.responseObject.startNewEvent("event2");
        LOGGER.info(this.responseObject.toString());
        assertAll("Multiple Events none closed",
                ()-> assertEquals("event2", this.responseObject.getCallEventStack().peek().getCall()),
                ()-> assertNull(this.responseObject.getCallEventStack().peek().getEndTime()),
                ()-> assertTrue(this.responseObject.getCallEvents().isEmpty()),
                ()-> assertEquals(2, this.responseObject.getCallEventStack().size())
        );
        this.responseObject.closeEvent();
        assertAll("Multiple Events one closed",
                ()-> assertEquals("event2", this.responseObject.getLastFinishedEvent().getCall()),
                ()-> assertNotNull(this.responseObject.getLastFinishedEvent().getEndTime()),
                ()-> assertEquals(1, this.responseObject.getCallEvents().size()),
                ()-> assertEquals(1, this.responseObject.getCallEventStack().size())
        );
        this.responseObject.closeEvent();
        assertAll("Multiple Events one closed",
                ()-> assertEquals("Test", this.responseObject.getLastFinishedEvent().getCall()),
                ()-> assertNotNull(this.responseObject.getLastFinishedEvent().getEndTime()),
                ()-> assertEquals(2, this.responseObject.getCallEvents().size()),
                ()-> assertEquals(0, this.responseObject.getCallEventStack().size())
        );
    }

    @Test
    void closeResponse() throws InterruptedException {
        Review review = new Review("12345", Instant.now(), "438967", "3248975", "Jane Peacock", "This Place was great");
        Thread.sleep(1);
        this.responseObject.setResponse(200,"Success", review);
        LOGGER.info(this.responseObject.toString());
        assertAll("Status Completed",
                ()-> assertEquals(200, this.responseObject.getResponseCode()),
                ()-> assertEquals("Success", this.responseObject.getResponseDesc()),
                ()-> assertEquals(review, this.responseObject.getData()),
                ()-> assertEquals(0, this.responseObject.getCallEventStack().size()),
                ()-> assertEquals(1, this.responseObject.getCallEvents().size()),
                ()-> assertEquals("Test", this.responseObject.getLastFinishedEvent().getCall()),
                ()-> assertTrue(this.responseObject.getLastFinishedEvent().getEventDuration() > 0)
        );
    }
    @Test
    void closeResponseError(){
        Review review = new Review("12345", Instant.now(), "438967", "3248975", "Jane Peacock", "This Place was great");
        this.responseObject.startNewEvent("event2");
        assertThrows(RuntimeException.class,
                () -> this.responseObject.setResponse(200,"Success", review)
        );
        assertAll("Exception Response",
                ()-> assertEquals(500, this.responseObject.getResponseCode()),
                ()-> assertEquals("Eventstack not Empty.  Cannot close response", this.responseObject.getResponseDesc())
        );
    }



}