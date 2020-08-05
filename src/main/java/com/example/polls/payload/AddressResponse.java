package com.example.polls.payload;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hhtt
 * @date 2020/8/4 19:18
 * description:
 */
@ToString
@Setter
@Getter
public class AddressResponse {
    private Long id;
    private String title;
    private String key;
    private List<AddressResponse> children = new ArrayList<>();
    public AddressResponse(){

    }
    public AddressResponse(Long id, String title, String key) {
        this.id = id;
        this.title = title;
        this.key = key;
    }


}
