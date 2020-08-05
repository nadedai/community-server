package com.example.polls.model;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

/**
 * @author hhtt
 * @date 2020/8/4 17:19
 * description:
 */
@Getter
@Setter
@ToString
@Entity
@Table(name = "address" ,uniqueConstraints = {
        @UniqueConstraint(columnNames = {
                "street","community","court"
        })})
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String street;
    @NotBlank
    private String community;
    @NotBlank
    private String court;
}
