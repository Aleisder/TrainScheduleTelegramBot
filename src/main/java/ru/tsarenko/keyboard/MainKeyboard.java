package ru.tsarenko.keyboard;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.List;

import static ru.tsarenko.handler.UserMessage.ADD_ROUTE;
import static ru.tsarenko.handler.UserMessage.MY_ROUTES;

@Component
public class MainKeyboard {

    private KeyboardRow getRow() {
        return new KeyboardRow(
                List.of(
                        new KeyboardButton(MY_ROUTES),
                        new KeyboardButton(ADD_ROUTE)
                )
        );
    }

    public ReplyKeyboardMarkup get() {
        return ReplyKeyboardMarkup.builder()
                .keyboardRow(getRow())
                .oneTimeKeyboard(false)
                .build();
    }
}
