package com.umprogramax.lojaStock.service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.umprogramax.lojaStock.model.Venda;
import com.umprogramax.lojaStock.repository.VendaRepository;

@Service
public class VendaService {

    @Autowired
    VendaRepository repository;


    public LocalDateTime criaDataDaVenda() {

        LocalDateTime agora = LocalDateTime.now();
        return agora;

    }

    public Venda create(Venda obj) { return repository.save(obj); }

    public List<Venda> list() { return repository.findAll(); }

    public Venda update(Venda venda) { return repository.save(venda); }

    public void delete(UUID id) { repository.deleteById(id); }

    public Venda charge(UUID id) { return repository.findById(id).orElseThrow(); }

}
