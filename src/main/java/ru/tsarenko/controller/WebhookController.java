package ru.tsarenko.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.tsarenko.bot.TrainScheduleBot;

@RestController
@AllArgsConstructor
public class WebhookController {

    private final TrainScheduleBot trainScheduleBot;

    @PostMapping("/")
    public BotApiMethod<?> onUpdateReceived(@RequestBody Update update) {
        System.out.println("GOT IT");
        return trainScheduleBot.onWebhookUpdateReceived(update);
    }
}
