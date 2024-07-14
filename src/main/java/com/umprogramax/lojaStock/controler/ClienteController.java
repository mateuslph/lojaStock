package com.umprogramax.lojaStock.controler;

import com.umprogramax.lojaStock.model.Cliente;
import com.umprogramax.lojaStock.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
public class ClienteController {

    @Autowired
    private ClienteService service;

    @GetMapping(value="/cliente")
    public String index(Model model) {
        model.addAttribute("clientes", service.list());
        model.addAttribute("cliente", new Cliente());
        return "/cliente/index";
    }

    @PostMapping(value="/salva-cliente")
    public String save(@ModelAttribute("cliente") Cliente cliente) {
        service.create(cliente);
        return "redirect:/cliente";
    }

    @PutMapping(value="/cliente/{id}")
    public String update(@PathVariable UUID id, @ModelAttribute("cliente") Cliente cliente, Model model) {
        Cliente obj = service.charge(id);
        obj.setId(id);
        obj.setNome(cliente.getNome());
        obj.setCpf(cliente.getCpf());
        obj.setDataInscricao(cliente.getDataInscricao());
        obj.setGenero(cliente.getGenero());
        obj.setEndereco(cliente.getEndereco());
        service.update(obj);
        return "redirect:/cliente";
    }

    @DeleteMapping(value="/cliente/{id}")
    public String delete(@PathVariable UUID id) {
        service.delete(id);
        return "redirect:/cliente";
    }
}
