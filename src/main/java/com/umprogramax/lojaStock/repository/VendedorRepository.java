package com.umprogramax.lojaStock.repository;

import com.umprogramax.lojaStock.model.Vendedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface VendedorRepository extends JpaRepository<Vendedor, UUID> {
}
