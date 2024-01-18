package com.umprogramax.lojaStock.repository;

import com.umprogramax.lojaStock.model.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EnderecoRepository extends JpaRepository<Endereco, UUID> {
}
