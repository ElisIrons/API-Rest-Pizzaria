package com.soulcodeapi.apirestpizzaria.repositories;


import com.soulcodeapi.apirestpizzaria.models.Ingrediente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IngredienteRepository extends JpaRepository<Ingrediente, Long> {
}
