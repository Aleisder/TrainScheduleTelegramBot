package ru.tsarenko.service;

import lombok.AllArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import ru.tsarenko.model.Route;
import ru.tsarenko.model.mongo.User;

@Service
@AllArgsConstructor
public class RouteService {

    private final MongoTemplate mongoTemplate;

    public Route[] getRoutes(Long userId) {
        var query = Query.query(Criteria.where("userId").is(userId));
        return mongoTemplate
                .findOne(query, User.class)
                .getRoutes();
    }

}
