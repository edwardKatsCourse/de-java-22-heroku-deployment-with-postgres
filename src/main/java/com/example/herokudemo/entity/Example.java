package com.example.herokudemo.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "example")

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Example {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
}
