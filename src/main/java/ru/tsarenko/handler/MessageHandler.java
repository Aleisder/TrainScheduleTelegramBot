package ru.tsarenko.handler;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import ru.tsarenko.repository.ScheduleRepository;

@Component
@AllArgsConstructor
public class MessageHandler {

    private final ScheduleRepository scheduleRepository;

    public BotApiMethod<?> handle(Message message) {
        var id = message.getChatId().toString();
        var text = message.getText();
        if (text.equals("Привет")) {
            return new SendMessage(id, "Ну привет");
        } else if (text.equals("Расписание")) {
            return sendSchedule(id) ;
        }
        return new SendMessage(id, "Я не знаю такой команды");
    }

    private SendMessage sendSchedule(String id) {
        return new SendMessage(id, scheduleRepository.getSchedule().getFormatted());
    }

}
