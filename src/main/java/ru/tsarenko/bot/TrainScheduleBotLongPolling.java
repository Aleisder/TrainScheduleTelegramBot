package ru.tsarenko.bot;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import ru.tsarenko.config.TelegramConfig;
import ru.tsarenko.handler.MessageHandler;

@Service
@AllArgsConstructor
public class TrainScheduleBotLongPolling extends TelegramLongPollingBot {

    private final TelegramConfig telegramConfig;
    private final MessageHandler messageHandler;

    @Override
    public String getBotUsername() {
        return telegramConfig.getBotName();
    }

    @Override
    public String getBotToken() {
        return telegramConfig.getToken();
    }

    @Override
    public void onUpdateReceived(Update update) {
        System.out.println("GOT IT");
        try {
            execute(messageHandler.handle(update.getMessage()));
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }
}
