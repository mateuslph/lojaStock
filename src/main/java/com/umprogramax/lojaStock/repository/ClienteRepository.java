package com.umprogramax.lojaStock.repository;

import com.umprogramax.lojaStock.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ClienteRepository extends JpaRepository<Cliente, UUID> {
}
