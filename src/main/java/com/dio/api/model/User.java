package com.dio.api.model;

import lombok.*;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Audited
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private UserCategory userCategory;

    private String name;

    @ManyToOne
    private Company company;

    @ManyToOne
    private AccessLevel accessLevel;

    @ManyToOne
    private Workday workday;

    private BigDecimal delayTolerance;
    private LocalDateTime startWorkingDay;
    private LocalDateTime endWorkingDay;


}
