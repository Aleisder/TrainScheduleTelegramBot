package ru.tsarenko.handler;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import ru.tsarenko.service.BotService;

import java.util.regex.Pattern;

import static ru.tsarenko.service.BotMessage.UNKNOWN_COMMAND_MESSAGE;
import static ru.tsarenko.handler.UserMessage.*;

@Component
@AllArgsConstructor
public class MessageHandler {

    private final BotService service;
    private final Pattern pattern = Pattern.compile("\\d{6} - \\d{6}");

    public BotApiMethod<?> handle(Message message) {

        var id = message.getChatId().toString();
        var text = message.getText();

        return switch (text) {
            case START -> service.sendStart(id);
            case MY_ROUTES -> service.sendRoutes(Long.valueOf(id));
            case ADD_ROUTE -> service.sendAddRoute(id);
            default -> {
                if (pattern.matcher(text).matches())
                    yield service.sendRoutedIsAdded(id, text);
                yield new SendMessage(id, UNKNOWN_COMMAND_MESSAGE);
            }
        };
    }

}
