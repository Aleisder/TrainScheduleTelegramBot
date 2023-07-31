package ru.tsarenko.model;

import lombok.Getter;

@Getter
public class Route {
    private Integer fromCode;
    private String fromTitle;
    private Integer toCode;
    private String toTitle;
}
