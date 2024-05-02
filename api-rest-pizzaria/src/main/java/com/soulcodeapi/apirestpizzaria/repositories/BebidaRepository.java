package com.soulcodeapi.apirestpizzaria.repositories;

import com.soulcodeapi.apirestpizzaria.models.Bebida;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BebidaRepository extends JpaRepository<Bebida, Long> {
}