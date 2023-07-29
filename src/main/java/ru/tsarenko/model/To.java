package ru.tsarenko.model;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;

@Getter
public class To {
    @SerializedName("title")
    private String title;

    @SerializedName("code")
    private String code;
}
