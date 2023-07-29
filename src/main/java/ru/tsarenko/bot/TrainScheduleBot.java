package ru.tsarenko.bot;

import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.updates.SetWebhook;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.starter.SpringWebhookBot;
import ru.tsarenko.config.TelegramConfig;
import ru.tsarenko.handler.MessageHandler;

@Service
public class TrainScheduleBot extends SpringWebhookBot {

    private final TelegramConfig telegramConfig;
    private final MessageHandler messageHandler;

    public TrainScheduleBot(SetWebhook setWebhook,
                            TelegramConfig telegramConfig,
                            MessageHandler messageHandler) {
        super(setWebhook);
        this.telegramConfig = telegramConfig;
        this.messageHandler = messageHandler;
    }

    @Override
    public String getBotUsername() {
        return telegramConfig.getBotName();
    }

    @Override
    public String getBotToken() {
        return telegramConfig.getToken();
    }

    @Override
    public BotApiMethod<?> onWebhookUpdateReceived(Update update) {
        return messageHandler.handle(update.getMessage());
    }

    @Override
    public String getBotPath() {
        return telegramConfig.getWebhook();
    }
}