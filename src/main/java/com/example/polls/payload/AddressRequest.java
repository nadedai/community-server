package com.example.polls.payload;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author hhtt
 * @date 2020/8/4 18:53
 * description:
 */

@Getter
@Setter
@ToString
public class AddressRequest {
//    @NotBlank
//    private String street;
//    @NotBlank
//    private String community;
//    @NotBlank
//    private String court;
    @NotBlank
    private String name;
    @NotNull
    private Long parentId;
    @NotNull
    private  int level;

}
