package ru.tsarenko.repository.route;

import org.springframework.stereotype.Component;
import ru.tsarenko.model.Route;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Component
public class UserRouteRepository implements UserRouteDao {

    private final HashMap<Integer, ArrayList<Route>> userRoutes = new HashMap<>();

    @Override
    public void addRoute(Integer userId, Route route) {
        if (userRoutes.containsKey(userId)) {
            userRoutes.get(userId).add(route);
        } else {
            userRoutes.put(userId, new ArrayList<>(List.of(route)));
        }
    }

    @Override
    public String[] getUserRoutes(Integer userId) {
        /*
        ArrayList<String> routes = new ArrayList<>();
        userRoutes
                .get(userId)
                .forEach(route -> routes.add(String.format("%s - %s", route.getFromTitle(), route.getToTitle())));
        return routes.toArray(new String[] {});
         */
        return new String[] {
                "Одинцово - Беговая",
                "Голицино - Фили"
        };
    }

}
