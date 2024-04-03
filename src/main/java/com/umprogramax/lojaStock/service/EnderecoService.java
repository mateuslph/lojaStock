package com.umprogramax.lojaStock.service;

import com.umprogramax.lojaStock.model.Endereco;
import com.umprogramax.lojaStock.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class EnderecoService {

    @Autowired
    EnderecoRepository repository;

    public Endereco create(Endereco obj) {
        obj.getPais();
        obj.getUf();
        obj.getMunicipio();
        obj.getLogradouro();
        obj.getComplemento();
        obj.getCep();
        return repository.save(obj);
    }

    public List<Endereco> list() {
        return (List<Endereco>) repository.findAll();
    }

    public Endereco update(Endereco endereco) {
        return repository.save(endereco);
    }

    public void delete(UUID id) {
        repository.deleteById(id);
    }

    public Endereco charge(UUID id) {
        return (Endereco) repository.findById(id).get();
    }

}
