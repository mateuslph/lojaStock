package com.umprogramax.lojaStock.controler;

import com.umprogramax.lojaStock.model.Endereco;
import com.umprogramax.lojaStock.model.Fornecedor;
import com.umprogramax.lojaStock.service.EnderecoService;
import com.umprogramax.lojaStock.service.FornecedorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.UUID;

@Controller
public class FornecedorController {

    private FornecedorService service;

    @PostMapping(value = "/salvar-fornecedor")
    public String save(@ModelAttribute("fornecedor")Fornecedor fornecedor) {
        service.create(fornecedor);
        return "redirect:/listar-fornecedores/index";
    }

    @GetMapping(value="/listar-fornecedores")
    public String index(Model model) {
        model.addAttribute("fornecedores", service.list());
        return "/listar-fornecedores/index";
    }

    @PutMapping(value="/atualizar-fornecedor/{id}")
    public String update(@PathVariable UUID id, @ModelAttribute("fornecedor") Fornecedor fornecedor, Model model) {
        Fornecedor obj = service.charge(id);
        obj.setId(String.valueOf(id));
        obj.setNomeFantazia(fornecedor.getNomeFantazia());
        obj.setCnpj(fornecedor.getCnpj());
        obj.setDataInscricao(fornecedor.getDataInscricao());
        obj.setEndereco(fornecedor.getEndereco());
        service.update(obj);
        return "redirect:/listar-fornecedores/index";
    }

    public String delete(@PathVariable UUID id) {
        service.delete(id);
        return "redirect:/listar-fornecedores/index";
    }

}
