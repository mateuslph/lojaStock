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
        return "redirect:/salvar-fornecedor/index";
    }

    @GetMapping(value="/listar-fornecedor")
    public String index(Model model) {
        model.addAttribute("fornecedores", service.list());
        return "/listar-fornecedores/index";
    }

    @PutMapping(value="/atualizar-fornecedores/{id}")
    public String update(@PathVariable UUID id, @ModelAttribute("fornecedor") Fornecedor fornecedor, Model model) {
        Fornecedor obj = service.charge(id);
        obj.setId(String.valueOf(id));
        obj.setNomeFantazia(fornecedor.getNomeFantazia());
        obj.setCnpj(fornecedor.getCnpj());
        obj.setDataInscricao(fornecedor.getDataInscricao());
        obj.setEndereco(fornecedor.getEndereco());
        service.update(obj);
        return "redirect:/atualizar-fornecedor/index";
    }

    public String delete(@PathVariable UUID id) {
        service.delete(id);
        return "redirect:/listar-fornecedores/index";
    }

}
