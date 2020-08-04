package com.example.polls.payload;

import lombok.*;

import java.time.Instant;

/**
 * @author hhtt
 * @date 2020/7/30 16:40
 * description:
 */

@Getter
@Setter
public class UserResponse {
    private Long id;
    private String username;
    private String email;
    private Instant createdAt;
    private Instant updatedAt;
}
