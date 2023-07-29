package ru.tsarenko.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
@Getter
public class TelegramConfig {
    @Value("${telegram.bot-name}")
    private String botName;

    @Value("${telegram.token}")
    private String token;

    @Value("${telegram.url}")
    private String url;

    @Value("${telegram.webhook}")
    private String webhook;
}