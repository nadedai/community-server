package com.example.polls.payload;

import lombok.ToString;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
@ToString
public class PollLength {
    @NotNull
    @Max(31)
    private Integer days;

    @NotNull
    @Max(23)
    private Integer hours;

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }
}
