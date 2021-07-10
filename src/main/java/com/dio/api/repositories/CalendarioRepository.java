package com.dio.api.repositories;

import com.dio.api.model.AccessLevel;
import com.dio.api.model.Calendario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CalendarioRepository extends JpaRepository<Calendario, Long> {
}
