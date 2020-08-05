package com.example.polls.payload;

import lombok.Getter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


/**
 * @author hhtt
 * @date 2020/8/3 18:20
 * description:
 */
@Getter
@ToString
public class HouseRequest {
    @NotBlank
    private String username;
    @NotBlank
    private String phone;
    @NotBlank
    private String street;
    @NotBlank
    private String community;
    @NotBlank
    private String court;
    @NotBlank
    private String household;
}
