package com.soulcodeapi.apirestpizzaria.repositories;

import com.soulcodeapi.apirestpizzaria.models.Pizza;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PizzaRepository extends JpaRepository<Pizza, Long> {
}