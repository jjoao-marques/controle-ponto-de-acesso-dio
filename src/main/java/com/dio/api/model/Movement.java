package com.dio.api.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
@Entity
public class Movement {

    @AllArgsConstructor
    @NoArgsConstructor
    @EqualsAndHashCode
    @Embeddable
    public class MovementId implements Serializable {
        private Long idMovement;
        private Long idUser;

    }


    @Id
    @EmbeddedId
    private MovementId id;

    private LocalDateTime entryDate;
    private LocalDateTime departureDate;
    private BigDecimal time;

    @ManyToOne
    private Occurrence occurrence;

    @ManyToOne
    private Calendario calendario;


}
