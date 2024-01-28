package com.umprogramax.lojaStock.controler;

import com.umprogramax.lojaStock.model.Cliente;
import com.umprogramax.lojaStock.model.Endereco;
import com.umprogramax.lojaStock.service.ClienteService;
import com.umprogramax.lojaStock.service.EnderecoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
public class EnderecoController {

    private EnderecoService service;

    @PostMapping(value = "/salvar-endereco")
    public String save(@ModelAttribute("endereco") Endereco endereco) {
        service.create(endereco);
        return "redirect:/listar-enderecos/index";
    }

    @GetMapping(value="/listar-enderecos")
    public String index(Model model) {
        model.addAttribute("enderecos", service.list());
        return "/listar-enderecos/index";
    }

    @PutMapping(value="/atualizar-endereco/{id}")
    public String update(@PathVariable UUID id, @ModelAttribute("endereco") Endereco endereco, Model model) {
        Endereco obj = service.charge(id);
        obj.setId(String.valueOf(id));
        obj.setPais(endereco.getPais());
        obj.setUf(endereco.getUf());
        obj.setMunicipio(endereco.getMunicipio());
        obj.setLogradouro(endereco.getLogradouro());
        obj.setComplemento(endereco.getComplemento());
        obj.setCep(endereco.getCep());
        service.update(obj);
        return "redirect:/listar-enderecos/index";
    }

    public String delete(@PathVariable UUID id) {
        service.delete(id);
        return "redirect:/listar-enderecos/index";
    }

}
