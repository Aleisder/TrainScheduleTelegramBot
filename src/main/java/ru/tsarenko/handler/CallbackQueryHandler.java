package ru.tsarenko.handler;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import ru.tsarenko.repository.schedule.ScheduleDao;

@Service
@AllArgsConstructor
public class CallbackQueryHandler {

    private final ScheduleDao scheduleDao;

    public BotApiMethod<?> handle(Message message, String callbackData) {

        var fromStationCode = callbackData.substring(0, 6);
        var toStationCode = callbackData.substring(6);

        String schedule = scheduleDao.getSchedule(fromStationCode, toStationCode).formatted();

        return SendMessage.builder()
                .chatId(message.getChatId().toString())
                .text(schedule)
                .build();
    }
}
