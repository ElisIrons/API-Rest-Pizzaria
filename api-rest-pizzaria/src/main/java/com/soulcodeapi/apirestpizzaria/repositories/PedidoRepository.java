package com.soulcodeapi.apirestpizzaria.repositories;

import com.soulcodeapi.apirestpizzaria.models.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}