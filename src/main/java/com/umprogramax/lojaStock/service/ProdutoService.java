package com.umprogramax.lojaStock.service;

import com.umprogramax.lojaStock.model.Funcionario;
import com.umprogramax.lojaStock.model.Produto;
import com.umprogramax.lojaStock.repository.FuncionarioRepository;
import com.umprogramax.lojaStock.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ProdutoService {

    @Autowired
    ProdutoRepository repository;

    public Produto create(Produto obj) {
        obj.getDescricao();
        obj.getPreco();
        obj.getObservacao();
        return repository.save(obj);
    }

    public List<Produto> list() {
        return (List<Produto>) repository.findAll();
    }

    public Produto update(Produto produto) {
        return repository.save(produto);
    }

    public void delete(UUID id) {
        repository.deleteById(id);
    }

    public Produto charge(UUID id) {
        return (Produto) repository.findById(id).get();
    }

}
