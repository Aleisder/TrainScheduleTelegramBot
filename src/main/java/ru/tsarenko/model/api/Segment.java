package ru.tsarenko.model.api;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;

import java.time.LocalTime;

public class Segment {
    @Getter
    @SerializedName("thread")
    private Thread thread;

    @SerializedName("duration")
    private Integer duration;

    @SerializedName("departure")
    private String departure;

    @SerializedName("arrival")
    private String arrival;

    public String getDurationFormatted() {
        var durationMin = duration / 60;
        if (durationMin < 60)
            return String.format("%d мин", durationMin);
        if (durationMin == 60)
            return String.format("%d ч", durationMin / 60);
        return String.format("%d ч %d мин", durationMin / 60, durationMin % 60);
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