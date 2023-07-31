package ru.tsarenko.repository.route;

import ru.tsarenko.model.Route;

import java.util.ArrayList;
import java.util.HashMap;

public interface UserRouteDao {

    HashMap<Integer, ArrayList<Route>> userRoutes = new HashMap<>();

    void addRoute(Integer userId, Route route);
    String[] getUserRoutes(Integer userId);
}
