package ru.tsarenko.repository;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;
import ru.tsarenko.model.Schedule;
import ru.tsarenko.util.UrlBuilder;

@Repository
@AllArgsConstructor
public class ScheduleRepository {

    private final RestTemplate restTemplate;
    private final UrlBuilder urlBuilder;

    public Schedule getSchedule() {
        var responce = restTemplate.exchange(
                urlBuilder.getSearchScheduleUrl("182603", "181615"),
                HttpMethod.GET,
                HttpEntity.EMPTY,
                Schedule.class
        );
        return responce.getBody();
    }
}