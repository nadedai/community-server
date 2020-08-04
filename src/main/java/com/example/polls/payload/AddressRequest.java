package com.example.polls.payload;

import lombok.Getter;

import javax.validation.constraints.NotBlank;

/**
 * @author hhtt
 * @date 2020/8/3 18:23
 * description:
 */
@Getter
public class AddressRequest {
    @NotBlank
    private String street;
    @NotBlank
    private String community;
    @NotBlank
    private String court;
    @NotBlank
    private String household;
}
