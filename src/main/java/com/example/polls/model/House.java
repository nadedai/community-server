package com.example.polls.model;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * @author hhtt
 * @date 2020/8/3 15:03
 * description:
 */
@Getter
@Setter
@Entity
@Table(name = "houses")
public class House {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @NotNull
    private Const street;
    @OneToOne
    @NotNull
    private Const community;
    @OneToOne
    @NotNull
    private Const court;
    @OneToOne
    @NotNull
    private Const household;
}
