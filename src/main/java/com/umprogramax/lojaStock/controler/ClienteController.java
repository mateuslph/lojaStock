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
    private ClienteService clienteService;

    @GetMapping(value="/cliente")
    public String index(Model model) {
        model.addAttribute("clientes", clienteService.list());
        return "/cliente/index";
    }

    @PostMapping(value = "/salva-cliente")
    public String save(@ModelAttribute("cliente") Cliente cliente) {
        clienteService.create(cliente);
        return "redirect:/cliente";
    }

    @PutMapping(value="/atualizar-cliente/{id}")
    public String update(@PathVariable UUID id, @ModelAttribute("cliente") Cliente cliente, Model model) {
        Cliente obj = clienteService.charge(id);
        obj.setId(String.valueOf(id));
        obj.setNome(cliente.getNome());
        obj.setCpf(cliente.getCpf());
        obj.setDataInscricao(cliente.getDataInscricao());
        obj.setGenero(cliente.getGenero());
        obj.setEndereco(cliente.getEndereco());
        clienteService.update(obj);
        return "redirect:/cliente/index";
    }

    public String delete(@PathVariable UUID id) {
        clienteService.delete(id);
        return "redirect:/cliente/index";
    }

}
