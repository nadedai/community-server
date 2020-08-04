package com.example.polls.payload;

import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
@ToString
public class ChoiceRequest {
    @NotBlank
    @Size(max = 40)
    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
