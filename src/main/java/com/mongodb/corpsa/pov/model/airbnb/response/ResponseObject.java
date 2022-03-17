package com.mongodb.corpsa.pov.model.airbnb.response;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;

import java.security.PublicKey;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringJoiner;

@Getter
public class ResponseObject {
    private int responseCode;
    private String responseDesc;
    private Object data;
    @JsonIgnore
    private final Stack<CallEvent> callEventStack = new Stack<>();
    private final ArrayList<CallEvent> callEvents = new ArrayList<>();

    public ResponseObject(String call) {
        CallEvent callEvent = new CallEvent(call, Instant.now());
        callEventStack.push(callEvent);
    }

    public void startNewEvent(String call){
        CallEvent newEvent = new CallEvent(call, Instant.now());
        callEventStack.push(newEvent);
    }

    public void closeEvent(){
        callEvents.add(callEventStack.pop().closeEvent(Instant.now()));
    }

    public ResponseObject setResponse(int responseCode, String responseDesc){
        closeEvent();
        this.responseCode = responseCode;
        this.responseDesc = responseDesc;
        return this;
    }
    public ResponseObject setResponse(int responseCode, String responseDesc, Object data){
        closeEvent();
        if (callEventStack.empty()) {
            this.responseCode = responseCode;
            this.responseDesc = responseDesc;
            this.data = data;
        } else {
            String error = "Eventstack not Empty.  Cannot close response";
            this.responseDesc = error;
            this.responseCode = 500;
            throw new RuntimeException(error);
        }
        return this;
    }

    @JsonIgnore
    public CallEvent getLastFinishedEvent(){
        return callEvents.get(callEvents.size() - 1);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", ResponseObject.class.getSimpleName() + "[", "]")
                .add("responseCode=" + responseCode)
                .add("responseDesc='" + responseDesc + "'")
                .add("data=" + data)
                .add("callEventStack=" + callEventStack)
                .add("callEvents=" + callEvents)
                .toString();
    }


}


