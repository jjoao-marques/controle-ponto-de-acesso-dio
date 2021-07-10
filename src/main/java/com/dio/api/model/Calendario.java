package com.dio.api.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Entity
public class Calendario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private TypeDate typeDate;

    private String description;
    private LocalDateTime specialDate;
}
