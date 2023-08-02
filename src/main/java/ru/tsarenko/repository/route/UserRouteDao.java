package ru.tsarenko.repository.route;

import ru.tsarenko.model.Route;

import java.util.ArrayList;
import java.util.HashMap;

public interface UserRouteDao {

    HashMap<Long, ArrayList<Route>> userRoutes = new HashMap<>();

    void addRoute(Long userId, String routeCodes);
    ArrayList<Route> getUserRoutes(Long userId);
}
