package com.umprogramax.lojaStock.service;

import com.umprogramax.lojaStock.model.Fornecedor;
import com.umprogramax.lojaStock.model.Funcionario;
import com.umprogramax.lojaStock.repository.FornecedorRepository;
import com.umprogramax.lojaStock.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class FuncionarioService {

    @Autowired
    FuncionarioRepository repository;

    public Funcionario create(Funcionario obj) { return repository.save(obj); }

    public List<Funcionario> list() {
        return repository.findAll();
    }

    public Funcionario update(Funcionario funcionario) {
        return repository.save(funcionario);
    }

    public void delete(UUID id) {
        repository.deleteById(id);
    }

    public Funcionario charge(UUID id) {
        return repository.findById(id).orElseThrow();
    }
}
