package com.umprogramax.lojaStock.service;

import com.umprogramax.lojaStock.model.Fornecedor;
import com.umprogramax.lojaStock.repository.FornecedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class FornecedorService {

    @Autowired
    FornecedorRepository repository;

    public Fornecedor create(Fornecedor obj) { return repository.save(obj); }

    public List<Fornecedor> list() {
        return repository.findAll();
    }

    public Fornecedor update(Fornecedor fornecedor) {
        return repository.save(fornecedor);
    }

    public void delete(UUID id) {
        repository.deleteById(id);
    }

    public Fornecedor charge(UUID id) {
        return repository.findById(id).orElseThrow();
    }
}
