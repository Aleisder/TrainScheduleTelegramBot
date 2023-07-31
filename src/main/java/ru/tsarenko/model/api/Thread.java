package ru.tsarenko.model.api;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;

@Getter
public class Thread {
    @SerializedName("title")
    private String title;

    @SerializedName("transport_subtype")
    private TransportSubtype transportSubtype;
}