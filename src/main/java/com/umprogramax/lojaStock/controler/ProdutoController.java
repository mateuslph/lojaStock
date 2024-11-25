package com.umprogramax.lojaStock.controler;

import com.umprogramax.lojaStock.model.Produto;
import com.umprogramax.lojaStock.service.EnderecoService;
import com.umprogramax.lojaStock.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
public class ProdutoController {

    @Autowired
    private ProdutoService service;

    @Autowired
    private EnderecoService enderecoService;

    @GetMapping(value = "/produto")
    public String index(Model model) {
        model.addAttribute("produtos", service.list());
        model.addAttribute("produto", new Produto());
        model.addAttribute("enderecos", enderecoService.list());
        return "/produto/index";
    }

    @PostMapping(value = "/salva-produto")
    public String save(@ModelAttribute("produto") Produto produto) {
        service.create(produto);
        return "redirect:/produto";
    }

    @PutMapping(value = "/produto/{id}")
    public String update(@PathVariable UUID id, @ModelAttribute("produto") Produto produto, Model model) {
        Produto obj = service.charge(id);
        obj.setId(id);
        obj.setDescricao(produto.getDescricao());
        obj.setPreco(produto.getPreco());
        obj.setObservacao(produto.getObservacao());
        service.update(obj);
        return "redirect:/produto";
    }

    @DeleteMapping(value = "/produto/{id}")
    public String delete(@PathVariable UUID id) {
        service.delete(id);
        return "redirect:/produto";
    }

}
