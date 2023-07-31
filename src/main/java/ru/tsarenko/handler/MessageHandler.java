package ru.tsarenko.handler;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import ru.tsarenko.keyboard.MainKeyboard;
import ru.tsarenko.repository.route.UserRouteDao;
import ru.tsarenko.repository.schedule.ScheduleRepository;
import ru.tsarenko.util.InlineKeyboardMaker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static ru.tsarenko.handler.UserMessage.*;

@Component
@AllArgsConstructor
public class MessageHandler {

    private final ScheduleRepository scheduleRepository;
    private final UserRouteDao userRouteRepository;
    private final MainKeyboard mainKeyboard;
    private final InlineKeyboardMaker inlineKeyboardMaker;

    public BotApiMethod<?> handle(Message message) {
        var id = message.getChatId().toString();
        var text = message.getText();
        return switch (text) {
            case START -> sendStartMessage(id);
            case KUBINKA_SVALANSKIY_BULVAR -> new SendMessage(id, scheduleRepository.getSchedule().getFormatted());
            case MY_ROUTES -> sendRoutes(id);
            case ADD_ROUTE -> new SendMessage(id, "Coming soon...");
            default -> new SendMessage(id, "Я не знаю такой команды");
        };
    }

    private SendMessage sendStartMessage(String id) {
        return SendMessage.builder()
                .chatId(id)
                .text("Привет!")
                .replyMarkup(mainKeyboard.get())
                .build();
    }

    private SendMessage sendRoutes(String id) {
        return SendMessage.builder()
                .chatId(id)
                .text("Добавленные маршруты:")
                .build();
    }

}
