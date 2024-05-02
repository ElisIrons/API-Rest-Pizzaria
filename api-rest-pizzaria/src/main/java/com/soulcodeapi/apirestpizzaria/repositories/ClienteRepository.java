package com.soulcodeapi.apirestpizzaria.repositories;

import com.soulcodeapi.apirestpizzaria.models.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
