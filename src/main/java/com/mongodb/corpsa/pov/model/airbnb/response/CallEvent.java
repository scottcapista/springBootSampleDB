package com.mongodb.corpsa.pov.model.airbnb.response;

import lombok.Getter;

import java.time.Duration;
import java.time.Instant;
import java.time.temporal.TemporalUnit;
import java.util.StringJoiner;
@Getter
public class CallEvent {
    private final String call;
    private final Instant startTime;
    private Instant endTime;
    private Duration eventDuration;

    public CallEvent(String call, Instant startTime) {
        this.call = call;
        this.startTime = startTime;
    }

    public CallEvent closeEvent(Instant endTime){
        this.endTime = endTime;
        this.eventDuration = Duration.between(this.startTime, this.endTime);
        return this;
    }

    public long getEventDuration() {
        return this.eventDuration.toMillis();
    }


    @Override
    public String toString() {
        return new StringJoiner(", ", CallEvent.class.getSimpleName() + "[", "]")
                .add("call='" + call + "'")
                .add("startTime=" + startTime)
                .add("endTime=" + endTime)
                .add("eventTime=" + eventDuration)
                .toString();
    }
}

