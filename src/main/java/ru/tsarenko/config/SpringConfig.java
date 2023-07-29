package ru.tsarenko.config;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.telegram.telegrambots.meta.api.methods.updates.SetWebhook;

@Configuration
@AllArgsConstructor
public class SpringConfig {

    private final TelegramConfig telegramConfig;

    @Bean
    public SetWebhook getWebhook() {
        return SetWebhook.builder()
                .url(telegramConfig.getUrl())
                .build();
    }
}