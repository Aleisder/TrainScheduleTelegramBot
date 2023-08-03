package ru.tsarenko.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.ParseMode;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import ru.tsarenko.repository.route.UserRouteDao;
import ru.tsarenko.repository.schedule.ScheduleDao;

import static ru.tsarenko.service.BotMessage.ADD_ROUTE_MESSAGE;
import static ru.tsarenko.service.BotMessage.START_MESSAGE;
import static ru.tsarenko.keyboard.InlineKeyboardMaker.buildInlineKeyboardOfRows;
import static ru.tsarenko.keyboard.MainKeyboard.getMainKeyboard;

@Service
@AllArgsConstructor
public class BotService {

    private final UserRouteDao userRouteDao;
    private final ScheduleDao scheduleDao;

    public SendMessage sendStart(String id) {
        return SendMessage.builder()
                .chatId(id)
                .text(START_MESSAGE)
                .replyMarkup(getMainKeyboard())
                .build();
    }

    public SendMessage sendAddRoute(String id) {
        return SendMessage.builder()
                .chatId(id)
                .text(ADD_ROUTE_MESSAGE)
                .parseMode(ParseMode.MARKDOWN)
                .build();
    }

    public SendMessage sendRoutedIsAdded(String id, String routeCodes) {
        userRouteDao.addRoute(
                Long.valueOf(id),
                routeCodes
        );

        return SendMessage.builder()
                .chatId(id)
                .text("Вы только что добавили маршрут")
                .build();
    }


    public SendMessage sendRoutes(Long userId) {
        var routes = userRouteDao.getUserRoutes(userId);

        if (routes == null) {
            return SendMessage.builder()
                    .chatId(userId.toString())
                    .text("У вас нет добавленных маршрутов")
                    .build();
        }
        return SendMessage.builder()
                .chatId(userId.toString())
                .text("Добавленные маршруты")
                .replyMarkup(buildInlineKeyboardOfRows(userRouteDao.getUserRoutes(userId)))
                .build();
    }
}
