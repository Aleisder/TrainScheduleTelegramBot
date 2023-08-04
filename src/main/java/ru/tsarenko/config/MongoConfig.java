package ru.tsarenko.config;

import com.mongodb.ConnectionString;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

@Configuration
public class MongoConfig {

    @Value("${mongo.url}")
    private String mongoUrl;

    @Bean
    public MongoClient getMongoClient() {
        return MongoClients.create(mongoUrl);
    }

    @Bean
    public MongoTemplate getMongoTemplate(MongoClient client) {
        return new MongoTemplate(client, "trainschedule");
    }
}
