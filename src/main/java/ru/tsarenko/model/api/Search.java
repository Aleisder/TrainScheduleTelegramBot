package ru.tsarenko.model.api;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;

@Getter
public class Search {
    @SerializedName("from")
    private From from;

    @SerializedName("to")
    private To to;
}
