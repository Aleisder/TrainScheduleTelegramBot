package ru.tsarenko.model;

import com.google.gson.annotations.SerializedName;

import java.time.LocalTime;

public class Segment {
    @SerializedName("thread")
    private Thread thread;

    @SerializedName("duration")
    private Integer duration;

    @SerializedName("departure")
    private String departure;

    @SerializedName("arrival")
    private String arrival;

    public Integer getDuration() {
        return duration / 60;
    }

    public LocalTime getDeparture() {
        return LocalTime.parse(departure.substring(11, 19));
    }

    public String getDepartureFormatted() {
        return departure.substring(11, 16);
    }

    public String getArrivalFormatted() {
        return arrival.substring(11, 16);
    }
}