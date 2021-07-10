package com.dio.api.model;

import lombok.*;

import javax.persistence.*;


@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Entity
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private AccessLevel accessLevel;

    private String description;
}
