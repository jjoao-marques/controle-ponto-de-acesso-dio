package com.dio.api.model;


import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Entity
public class BancoDeHoras {

    @EqualsAndHashCode
    @AllArgsConstructor
    @NoArgsConstructor
    @Embeddable
    public static class BancoDeHorasId implements Serializable {
        private Long IdBancoDeHoras;
        private Long idMovement;
        private Long idUser;
    }

    @Id
    @EmbeddedId
    private BancoDeHorasId bancoDeHorasId;

    private LocalDateTime dataTrabalhada;
    private BigDecimal quantityHours;
    private BigDecimal hoursBalance;

}
