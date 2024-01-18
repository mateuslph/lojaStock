package com.umprogramax.lojaStock.service;

import com.umprogramax.lojaStock.model.Cliente;
import com.umprogramax.lojaStock.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ClienteService {

    @Autowired
    ClienteRepository repository;

    public Cliente create(Cliente obj) {
        obj.getNome();
        obj.getCpf();
        obj.getDataInscricao();
        obj.getGenero();
        obj.getEndereco();
        return repository.save(obj);
    }

    public List<Cliente> list() {
        return (List<Cliente>) repository.findAll();
    }

    public Cliente update(Cliente cliente) {
        return repository.save(cliente);
    }

    public void delete(UUID id) {
        repository.deleteById(id);
    }

}
