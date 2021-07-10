package com.dio.api.repositories;

import com.dio.api.model.BancoDeHoras;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BancoDeHorasRepository extends JpaRepository<BancoDeHoras, Long> {
}
