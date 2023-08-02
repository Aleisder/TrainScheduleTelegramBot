package ru.tsarenko.keyboard;

import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import ru.tsarenko.model.Route;

import java.util.ArrayList;
import java.util.List;

public class InlineKeyboardMaker {

    public static InlineKeyboardMarkup buildInlineKeyboardOfRows(ArrayList<Route> routes) {

        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
        for (var route : routes) {

            var title = String.format("%s - %s", route.getFromTitle(), route.getToTitle());
            var callback = String.format("%d%d", route.getFromCode(), route.getToCode());

            var button = InlineKeyboardButton.builder()
                    .text(title)
                    .callbackData(callback)
                    .build();
            keyboard.add(List.of(button));
        }
        return new InlineKeyboardMarkup(keyboard);
    }
}
