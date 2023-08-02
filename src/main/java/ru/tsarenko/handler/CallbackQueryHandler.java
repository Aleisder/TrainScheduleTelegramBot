package ru.tsarenko.handler;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import ru.tsarenko.repository.schedule.ScheduleRepository;

@Service
@AllArgsConstructor
public class CallbackQueryHandler {

    private final ScheduleRepository scheduleRepository;

    public BotApiMethod<?> handle(Message message, String callbackData) {

        var fromStationCode = callbackData.substring(0, 6);
        var toStationCode = callbackData.substring(6);

        return SendMessage.builder()
                .chatId(message.getChatId().toString())
                .text(
                        scheduleRepository.getSchedule(fromStationCode, toStationCode).formatted()
                )
                .build();
    }
}
