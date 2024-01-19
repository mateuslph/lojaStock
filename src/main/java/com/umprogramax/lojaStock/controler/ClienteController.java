package com.umprogramax.lojaStock.controler;


import com.umprogramax.lojaStock.model.Cliente;
import com.umprogramax.lojaStock.service.ClienteService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
public class ClienteController {

    private ClienteService service;

    @PostMapping(value = "/salvar-cliente")
    public String save(@ModelAttribute("emprestimo") Cliente cliente) {
        service.create(cliente);
        return "redirect:/salvar-cliente/index";
    }

    @GetMapping(value="/listar-clientes")
    public String index(Model model) {
        model.addAttribute("clientes", service.list());
        return "/listar-clientes/index";
    }

    @PutMapping(value="/atualizar-clientes/{id}")
    public String update(@PathVariable UUID id, @ModelAttribute("cliente") Cliente cliente, Model model) {
        Cliente obj = service.charge(id);
        obj.setId(String.valueOf(id));
        obj.setNome(cliente.getNome());
        obj.setCpf(cliente.getCpf());
        obj.setDataInscricao(cliente.getDataInscricao());
        obj.setGenero(cliente.getGenero());
        obj.setEndereco(cliente.getEndereco());
        service.update(obj);
        return "redirect:/atualizar-clientes/index";
    }

    public String delete(@PathVariable UUID id) {
        service.delete(id);
        return "redirect:/listar-clientes/index";
    }

}
