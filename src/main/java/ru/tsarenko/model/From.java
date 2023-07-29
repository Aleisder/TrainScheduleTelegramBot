package ru.tsarenko.model;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;

@Getter
public class From {
    @SerializedName("title")
    private String title;

    @SerializedName("code")
    private String code;
}
