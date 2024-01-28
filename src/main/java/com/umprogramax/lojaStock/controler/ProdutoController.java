package com.umprogramax.lojaStock.controler;

import com.umprogramax.lojaStock.model.Funcionario;
import com.umprogramax.lojaStock.model.Produto;
import com.umprogramax.lojaStock.service.FuncionarioService;
import com.umprogramax.lojaStock.service.ProdutoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
public class ProdutoController {

    private ProdutoService service;

    @PostMapping(value = "/salvar-produto")
    public String save(@ModelAttribute("produto")Produto produto) {
        service.create(produto);
        return "redirect:/listar-produtos/index";
    }

    @GetMapping(value="/listar-produtos")
    public String index(Model model) {
        model.addAttribute("produtos", service.list());
        return "/listar-produtos/index";
    }

    @PutMapping(value="/atualizar-produto/{id}")
    public String update(@PathVariable UUID id, @ModelAttribute("produto") Produto produto, Model model) {
        Produto obj = service.charge(id);
        obj.setId(String.valueOf(id));
        obj.setDescricao(produto.getDescricao());
        obj.setPreco(produto.getPreco());
        obj.setObservacao(produto.getObservacao());
        service.update(obj);
        return "redirect:/listar-produtos/index";
    }

    public String delete(@PathVariable UUID id) {
        service.delete(id);
        return "redirect:/listar-produto/index";
    }

}
