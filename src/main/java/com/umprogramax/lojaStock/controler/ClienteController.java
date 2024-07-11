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

    @GetMapping("/area-do-cliente")
    public String mostraFormulario(Model model) {
        model.addAttribute("clientes", clienteService.list());
        return "cliente/index";
    }

    @PostMapping(value = "/salva-cliente")
    public String salvaCliente(@ModelAttribute("cliente") Cliente cliente) {
        clienteService.create(cliente);
        return "area-do-cliente";
    }

    @PutMapping("/atualizar-cliente/{id}")
    public String update(@PathVariable("id") UUID id, @ModelAttribute("cliente") Cliente cliente) {
        Cliente obj = clienteService.charge(id);
        obj.setNome(cliente.getNome());
        obj.setCpf(cliente.getCpf());
        obj.setDataInscricao(cliente.getDataInscricao());
        obj.setGenero(cliente.getGenero());
        obj.setEndereco(cliente.getEndereco());
        clienteService.update(obj);
        return "redirect:/cliente";
    }

    @DeleteMapping("/deletar-cliente/{id}")
    public String delete(@PathVariable("id") UUID id) {
        clienteService.delete(id);
        return "redirect:/cliente";
    }
}
