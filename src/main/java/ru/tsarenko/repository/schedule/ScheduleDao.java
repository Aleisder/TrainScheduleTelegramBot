package ru.tsarenko.repository.schedule;

import ru.tsarenko.model.api.Schedule;

public interface ScheduleDao {
    Schedule getSchedule(String fromStationCode, String toStationCode);
}
