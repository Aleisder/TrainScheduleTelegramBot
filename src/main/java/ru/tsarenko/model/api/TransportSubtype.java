package ru.tsarenko.model.api;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;

@Getter
public class TransportSubtype {
    @SerializedName("title")
    private String title;
}
