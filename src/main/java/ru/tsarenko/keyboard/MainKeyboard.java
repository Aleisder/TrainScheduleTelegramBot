package ru.tsarenko.keyboard;

import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.List;

import static ru.tsarenko.handler.UserMessage.ADD_ROUTE;
import static ru.tsarenko.handler.UserMessage.MY_ROUTES;

public class MainKeyboard {

    private static KeyboardRow getRow() {
        return new KeyboardRow(
                List.of(
                        new KeyboardButton(MY_ROUTES),
                        new KeyboardButton(ADD_ROUTE)
                )
        );
    }

    public static ReplyKeyboardMarkup getMainKeyboard() {
        return ReplyKeyboardMarkup.builder()
                .keyboardRow(getRow())
                .oneTimeKeyboard(false)
                .build();
    }
}
