package com.umprogramax.lojaStock.controler;

import com.umprogramax.lojaStock.model.Produto;
import com.umprogramax.lojaStock.model.Vendedor;
import com.umprogramax.lojaStock.service.EnderecoService;
import com.umprogramax.lojaStock.service.VendedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Controller
public class VendedorController {

    @Autowired
    private VendedorService vendedorService;

    @Autowired
    private EnderecoService enderecoService;

    @GetMapping(value = "/vendedor")
    public String index(Model model) {
        List<Vendedor> vendedores = vendedorService.list();
        model.addAttribute("vendedores", vendedorService.list());
        model.addAttribute("vendedor", new Vendedor());
        model.addAttribute("enderecos", enderecoService.list());
        return "/vendedor/index";
    }

    @PostMapping(value = "/salva-vendedor")
    public String save(@ModelAttribute("vendedor") Vendedor vendedor) {
        vendedorService.create(vendedor);
        return "redirect:/vendedor";
    }

    @PutMapping(value = "/vendedor/{id}")
    public String update(@PathVariable UUID id, @ModelAttribute("vendedor") Vendedor vendedor, Model model) {
        Vendedor obj = vendedorService.charge(id);
        obj.setId(id);
        obj.setNome(vendedor.getNome());
        obj.setCpf(vendedor.getCpf());
        obj.setRegistro(vendedor.getRegistro());
        obj.setTipo(vendedor.getTipo());
        obj.setEndereco(vendedor.getEndereco());
        vendedorService.update(obj);
        return "redirect:/vendedor";
    }

    @DeleteMapping(value = "/vendedor/{id}")
    public String delete(@PathVariable UUID id) {
        vendedorService.delete(id);
        return "redirect:/vendedor";
    }

}
