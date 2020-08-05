package com.example.polls.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

/**
 * @author hhtt
 * @date 2020/8/4 17:19
 * description:
 */
@Getter
@Setter
@ToString
@Entity
@Table(name = "address" )
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String name;

    @Column(columnDefinition="BIGINT default 0")
    Long parentId;

    @NotNull
    int level;

    @Transient
    private List<Address> children = new ArrayList<>();
}
