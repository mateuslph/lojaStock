package com.umprogramax.lojaStock.controler;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.umprogramax.lojaStock.model.Venda;
import com.umprogramax.lojaStock.service.EnderecoService;
import com.umprogramax.lojaStock.service.VendaService;

@Controller
public class VendaController {

    @Autowired
    private VendaService vendaService;

    @Autowired
    private EnderecoService enderecoService;

    @GetMapping(value = "/venda")
    public String index(Model model) {
        model.addAttribute("vendas", vendaService.list());
        model.addAttribute("venda", new Venda());
        model.addAttribute("enderecos", enderecoService.list());
        return "/venda/index";
    }

    @PostMapping(value = "/salva-venda")
    public String save(@ModelAttribute("venda") Venda venda) {
        vendaService.create(venda);
        return "redirect:/venda";
    }

    @PutMapping(value = "/venda/{id}")
    public String update(@PathVariable UUID id, @ModelAttribute("venda") Venda venda, Model model) {
        Venda obj = vendaService.charge(id);
        obj.setId(id);
        obj.setDataDaVenda(venda.getDataDaVenda());
        obj.setProduto(venda.getProduto());
        obj.setVendedor(venda.getVendedor());
        obj.setCliente(venda.getCliente());
        vendaService.update(obj);
        return "redirect:/venda";
    }

    @DeleteMapping(value = "/venda/{id}")
    public String delete(@PathVariable UUID id) {
        vendaService.delete(id);
        return "redirect:/venda";
    }

}
