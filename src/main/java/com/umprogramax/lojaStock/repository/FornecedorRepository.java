package com.umprogramax.lojaStock.repository;

import com.umprogramax.lojaStock.Model.Fornecedor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface FornecedorRepository extends JpaRepository<Fornecedor, UUID> {
}
