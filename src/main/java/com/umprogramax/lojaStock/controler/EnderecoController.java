package com.umprogramax.lojaStock.controler;

import com.umprogramax.lojaStock.model.Endereco;
import com.umprogramax.lojaStock.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
public class EnderecoController {

    @Autowired
    private EnderecoService service;

    @PostMapping("/salvar-endereco")
    public String save(@ModelAttribute("endereco") Endereco endereco) {
        service.create(endereco);
        return "redirect:/listar-enderecos";
    }

    @GetMapping("/listar-enderecos")
    public String index(Model model) {
        model.addAttribute("enderecos", service.list());
        return "listar-enderecos/index";
    }

    @PutMapping("/atualizar-endereco/{id}")
    public String update(@PathVariable("id") UUID id, @ModelAttribute("endereco") Endereco endereco) {
        Endereco obj = service.charge(id);
        obj.setPais(endereco.getPais());
        obj.setUf(endereco.getUf());
        obj.setMunicipio(endereco.getMunicipio());
        obj.setLogradouro(endereco.getLogradouro());
        obj.setComplemento(endereco.getComplemento());
        obj.setCep(endereco.getCep());
        service.update(obj);
        return "redirect:/listar-enderecos";
    }

    @DeleteMapping("/deletar-endereco/{id}")
    public String delete(@PathVariable("id") UUID id) {
        service.delete(id);
        return "redirect:/listar-enderecos";
    }
}
