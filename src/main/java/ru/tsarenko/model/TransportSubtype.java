package ru.tsarenko.model;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;

@Getter
public class TransportSubtype {
    @SerializedName("title")
    private String title;
}
