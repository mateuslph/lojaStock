package com.umprogramax.lojaStock.repository;

import com.umprogramax.lojaStock.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProdutoRepository extends JpaRepository<Produto, UUID> {
}
