package com.umprogramax.lojaStock.repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import com.umprogramax.lojaStock.model.Cliente;
import com.umprogramax.lojaStock.model.Produto;
import com.umprogramax.lojaStock.model.Venda;
import com.umprogramax.lojaStock.model.Vendedor;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface  VendaRepository extends JpaRepository<Venda, UUID> {

    List<Venda> findByProduto(Produto produto);

    List<Venda> findByVendedor(Vendedor vendedor);

    List<Venda> findByCliente(Cliente cliente);

    List<Venda> findByDataDaVendaBetween(LocalDateTime startDate, LocalDateTime endDate);

}
