package ru.tsarenko.util;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.Collections;
import java.util.List;

@Component
public class InlineKeyboardMaker {

    public InlineKeyboardMarkup buildOfRows(String[] routes) {
        // TODO: 31/07/2023
        return InlineKeyboardMarkup.builder()
                .keyboard(
                        Collections.singleton(List.of(
                                        new InlineKeyboardButton("Голицино - Одинцово"),
                                        new InlineKeyboardButton("Кубинка - Славянский бульвар")
                                )
                        )
                ).build();
    }

}
