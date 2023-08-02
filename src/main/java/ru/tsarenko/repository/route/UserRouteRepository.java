package ru.tsarenko.repository.route;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import ru.tsarenko.model.Route;
import ru.tsarenko.repository.schedule.ScheduleRepository;

import java.util.ArrayList;
import java.util.List;

@Component
@AllArgsConstructor
public class UserRouteRepository implements UserRouteDao {

    private final ScheduleRepository scheduleRepository;

    @Override
    public void addRoute(Long userId, String routeCodes) {
        var from = routeCodes.substring(0, 6);
        var to = routeCodes.substring(9);

        var schedule = scheduleRepository.getSchedule(from, to);

        var route = new Route(
                schedule.getSearch().getFrom().getTitle(),
                Long.valueOf(from),
                schedule.getSearch().getTo().getTitle(),
                Long.valueOf(to)
        );

        if (userRoutes.containsKey(userId)) {
            userRoutes.get(userId).add(route);
        } else {
            userRoutes.put(userId, new ArrayList<>(List.of(route)));
        }
    }

    @Override
    public ArrayList<Route> getUserRoutes(Long userId) {
        return userRoutes.get(userId);
    }

}
