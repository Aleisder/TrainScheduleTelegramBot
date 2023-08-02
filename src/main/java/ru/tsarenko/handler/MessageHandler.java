package ru.tsarenko.handler;

import com.sun.jdi.LongValue;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.ParseMode;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import ru.tsarenko.repository.route.UserRouteDao;

import java.util.regex.Pattern;

import static ru.tsarenko.handler.BotMessage.*;
import static ru.tsarenko.handler.UserMessage.*;
import static ru.tsarenko.keyboard.InlineKeyboardMaker.buildInlineKeyboardOfRows;
import static ru.tsarenko.keyboard.MainKeyboard.getMainKeyboard;

@Component
@AllArgsConstructor
public class MessageHandler {

    private final UserRouteDao userRouteRepository;
    private final Pattern pattern = Pattern.compile("\\d{6} - \\d{6}");

    public BotApiMethod<?> handle(Message message) {
        var id = message.getChatId().toString();
        var text = message.getText();
        return switch (text) {
            case START -> sendStartMessage(id);
            case MY_ROUTES -> sendRoutes(id);
            case ADD_ROUTE -> sendAddRoute(id);
            default -> {
                if (pattern.matcher(text).matches())
                    yield sendRoutedIsAdded(id, text);

                yield new SendMessage(id, UNKNOWN_COMMAND_MESSAGE);
            }
        };
    }

    private SendMessage sendStartMessage(String id) {
        return SendMessage.builder()
                .chatId(id)
                .text(START_MESSAGE)
                .replyMarkup(getMainKeyboard())
                .build();
    }

    private SendMessage sendRoutes(String id) {

        if (userRouteRepository.getUserRoutes(Long.valueOf(id)) == null) {
            return SendMessage.builder()
                    .chatId(id)
                    .text("У вас нет добавленных маршрутов")
                    .build();
        }

        return SendMessage.builder()
                .chatId(id)
                .text("Добавленные маршруты:")
                .replyMarkup(buildInlineKeyboardOfRows(userRouteRepository.getUserRoutes(Long.valueOf(id))))
                .build();
    }

    private SendMessage sendAddRoute(String id) {
        return SendMessage.builder()
                .chatId(id)
                .text(ADD_ROUTE_MESSAGE)
                .parseMode(ParseMode.MARKDOWN)
                .build();
    }

    private SendMessage sendRoutedIsAdded(String id, String routeCodes) {
        userRouteRepository.addRoute(
                Long.valueOf(id),
                routeCodes
        );

        return SendMessage.builder().chatId(id).text("Вы только что добавили маршрут").build();
    }

}
