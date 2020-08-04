package com.example.polls.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

/**
 * @author hhtt
 * @date 2020/8/3 23:17
 * description:
 */

@Getter
@Setter
@Entity
@Table(name = "consts" ,uniqueConstraints = {
        @UniqueConstraint(columnNames = {
                "text"
        })})
public class Const {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String text;

    public Const() {
    }
    public Const(String text) {
        this.text = text;
    }
}
