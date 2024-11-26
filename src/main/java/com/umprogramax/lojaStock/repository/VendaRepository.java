package com.umprogramax.lojaStock.repository;

import java.util.Optional;
import java.util.UUID;
import com.umprogramax.lojaStock.model.Venda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface  VendaRepository extends JpaRepository<Venda, UUID> {
}
