package com.example.polls.model;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Objects;

/**
 * @author hhtt
 * @date 2020/8/3 15:03
 * description:
 */
@Getter
@Setter
@Entity
@Table(name = "houses" ,uniqueConstraints = {
        @UniqueConstraint(columnNames = {
                "household","address_id"
        })})
public class House {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String household;

    @ManyToOne
    @NotNull
    private Address address;

}
