package com.example.polls.payload;

import lombok.Getter;
import javax.validation.constraints.NotBlank;


/**
 * @author hhtt
 * @date 2020/8/3 18:20
 * description:
 */
@Getter
public class HouseRequest {
    @NotBlank
    private String street;
    @NotBlank
    private String community;
    @NotBlank
    private String court;
    @NotBlank
    private String household;

}
