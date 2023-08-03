package ru.tsarenko.repository.schedule;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;
import ru.tsarenko.model.api.Schedule;
import ru.tsarenko.util.UrlBuilder;

@Repository
@AllArgsConstructor
public class ScheduleRepository implements ScheduleDao {

    private final RestTemplate restTemplate;
    private final UrlBuilder urlBuilder;

    @Override
    public Schedule getSchedule(String fromStationCode, String toStationCode) {
        return restTemplate.exchange(
                urlBuilder.getSearchScheduleUrl(fromStationCode, toStationCode),
                HttpMethod.GET,
                HttpEntity.EMPTY,
                Schedule.class
        ).getBody();
    }
}