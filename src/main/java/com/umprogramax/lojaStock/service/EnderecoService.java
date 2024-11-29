package com.umprogramax.lojaStock.service;

import com.umprogramax.lojaStock.model.Endereco;
import com.umprogramax.lojaStock.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.UUID;

@Service
public class EnderecoService {

    @Autowired
    EnderecoRepository repository;

    @Autowired
    private RestTemplate restTemplate;

    public Endereco buscarEnderecoPorCep(String cep) {

        String url = "https://viacep.com.br/ws/" + cep + "/json/";
        ResponseEntity<Endereco> response = restTemplate.getForEntity(url, Endereco.class);
        return response.getBody();

    }

    public Endereco create(Endereco obj) { return repository.save(obj); }

    public List<Endereco> list() { return repository.findAll(); }

    public Endereco update(Endereco endereco) { return repository.save(endereco); }

    public void delete(UUID id) { repository.deleteById(id); }

    public Endereco charge(UUID id) { return repository.findById(id).orElseThrow(); }

}
