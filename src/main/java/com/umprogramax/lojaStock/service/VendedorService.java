package com.umprogramax.lojaStock.service;

import com.umprogramax.lojaStock.model.Vendedor;
import com.umprogramax.lojaStock.repository.VendedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class VendedorService {

    @Autowired
    VendedorRepository repository;

    public Vendedor create(Vendedor obj) { return repository.save(obj); }

    public List<Vendedor> list() { return repository.findAll(); }

    public Vendedor update(Vendedor vendedor) { return repository.save(vendedor); }

    public void delete(UUID id) { repository.deleteById(id); }

    public Vendedor charge(UUID id) { return repository.findById(id).orElseThrow(); }

}
