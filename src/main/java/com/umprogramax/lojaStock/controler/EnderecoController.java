package com.umprogramax.lojaStock.controler;

import com.umprogramax.lojaStock.model.Cliente;
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

    @GetMapping(value="/endereco")
    public String index(Model model) {
        model.addAttribute("enderecos", service.list());
        model.addAttribute("endereco", new Endereco());
        return "/endereco/index";
    }

    @PostMapping("/salva-endereco")
    public String save(@ModelAttribute("endereco") Endereco endereco) {
        service.create(endereco);
        return "redirect:/endereco";
    }

    @PutMapping("/endereco/{id}")
    public String update(@PathVariable UUID id, @ModelAttribute("endereco") Endereco endereco, Model model) {
        Endereco obj = service.charge(id);
        obj.setId(id);
        obj.setPais(endereco.getPais());
        obj.setUf(endereco.getUf());
        obj.setMunicipio(endereco.getMunicipio());
        obj.setLogradouro(endereco.getLogradouro());
        obj.setNumero(endereco.getNumero());
        obj.setComplemento(endereco.getComplemento());
        obj.setCep(endereco.getCep());
        service.update(obj);
        return "redirect:/endereco";
    }

    @DeleteMapping(value="/endereco/{id}")
    public String delete(@PathVariable UUID id) {
        service.delete(id);
        return "redirect:/endereco";
    }
}
