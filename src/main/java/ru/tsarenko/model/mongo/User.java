package ru.tsarenko.model.mongo;

import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import ru.tsarenko.model.Route;

@Document("routes")
public class User {
    @Id
    private String id;

    @Field("userId")
    private Long userId;

    @Field("routes")
    @Getter
    private Route[] routes;
}
