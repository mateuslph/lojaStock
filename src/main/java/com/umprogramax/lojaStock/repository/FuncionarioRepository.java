package com.umprogramax.lojaStock.repository;

import com.umprogramax.lojaStock.Model.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface FuncionarioRepository extends JpaRepository<Funcionario, UUID> {
}
