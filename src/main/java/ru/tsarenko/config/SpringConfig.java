package ru.tsarenko.config;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.updates.SetWebhook;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;
import ru.tsarenko.bot.TrainScheduleBotLongPolling;

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

    @Bean
    public TelegramBotsApi getTelegramBotApi(TrainScheduleBotLongPolling bot) throws TelegramApiException {
        var api = new TelegramBotsApi(DefaultBotSession.class);
        api.registerBot(bot);
        return api;
    }
}