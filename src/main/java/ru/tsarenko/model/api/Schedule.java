package ru.tsarenko.model.api;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;

import java.time.LocalTime;
import java.util.Arrays;

@Getter
public class Schedule {
    @SerializedName("search")
    private Search search;

    @SerializedName("segments")
    private Segment[] segments;

    public String getFormatted() {
        var builder = new StringBuilder(
                String.format(
                        "Ближайшие электрички по маршруту %s - %s на сегодня:\n\n",
                        search.getFrom().getTitle(),
                        search.getTo().getTitle()
                )
        );
        for (var flight : Arrays.stream(segments).filter(it -> it.getDeparture().isAfter(LocalTime.now())).toList()) {
            var row = String.format(
                    "%s - %s | %s\n",
                    flight.getDepartureFormatted(),
                    flight.getArrivalFormatted(),
                    flight.getDurationFormatted()
            );
            builder.append(row);
            builder.append(flight.getThread().getTitle());
            builder.append("\n\n");
        }
        return builder.toString();
    }
}
