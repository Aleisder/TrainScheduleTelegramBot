package ru.tsarenko.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Route {
    private String fromTitle;
    private Long fromCode;
    private String toTitle;
    private Long toCode;
}
