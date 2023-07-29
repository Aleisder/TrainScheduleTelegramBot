package ru.tsarenko.util;

import org.apache.http.client.utils.URIBuilder;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class UrlBuilder {

    public String getSearchScheduleUrl(String fromStationCode, String toStationCode) {
        try {
            return new URIBuilder()
                    .setPath("/search/")
                    .addParameter("format", "json")
                    .addParameter("system", "esr")
                    .addParameter("transport_types", "suburban")
                    .addParameter("from", fromStationCode)
                    .addParameter("to", toStationCode)
                    .addParameter("page", "1")
                    .addParameter("date", LocalDate.now().toString())
                    .build()
                    .toString();
        } catch (Exception e) {
            return "Произошла ошибка";
        }
    }
}