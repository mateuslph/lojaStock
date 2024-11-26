package com.umprogramax.lojaStock.controler;

import com.umprogramax.lojaStock.model.Fornecedor;
import com.umprogramax.lojaStock.model.Produto;
import com.umprogramax.lojaStock.service.FornecedorService;
import com.umprogramax.lojaStock.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Controller
public class FornecedorController {

    @Autowired
    private FornecedorService fornecedorService;

    @GetMapping(value="/fornecedor")
    public String index(Model model) {
        List<Fornecedor> fornecedores = fornecedorService.list();
        model.addAttribute("fornecedor", new Fornecedor());
        model.addAttribute("fornecedores", fornecedores);
        return "/fornecedor/index";
    }

    @PostMapping(value = "/salva-fornecedor")
    public String save(@ModelAttribute("fornecedor") Fornecedor fornecedor) {
        fornecedorService.create(fornecedor);
        return "redirect:/fornecedor";
    }

    @PutMapping(value = "/fornecedor/{id}")
    public String update(@PathVariable UUID id, @ModelAttribute("fornecedor") Fornecedor fornecedor, Model model) {
        Fornecedor obj = fornecedorService.charge(id);
        obj.setId(id);
        obj.setNomeFantazia(fornecedor.getNomeFantazia());
        obj.setCnpj(fornecedor.getCnpj());
        obj.setDataInscricao(fornecedor.getDataInscricao());
        obj.setEndereco(fornecedor.getEndereco());
        fornecedorService.update(obj);
        return "redirect:/fornecedor";
    }

    @DeleteMapping(value = "/fornecedor/{id}")
    public String delete(@PathVariable UUID id) {
        fornecedorService.delete(id);
        return "redirect:/fornecedor";
    }

}
