package com.umprogramax.lojaStock.controler;

import com.umprogramax.lojaStock.model.Endereco;
import com.umprogramax.lojaStock.model.Fornecedor;
import com.umprogramax.lojaStock.model.Funcionario;
import com.umprogramax.lojaStock.service.FornecedorService;
import com.umprogramax.lojaStock.service.FuncionarioService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
public class FuncionarioController {

    private FuncionarioService service;

    @PostMapping(value = "/salvar-funcionario")
    public String save(@ModelAttribute("funcionario")Funcionario funcionario) {
        service.create(funcionario);
        return "redirect:/salvar-funcionario/index";
    }

    @GetMapping(value="/listar-funcionario")
    public String index(Model model) {
        model.addAttribute("funcionarios", service.list());
        return "/listar-funcionarios/index";
    }

    @PutMapping(value="/atualizar-funcionarios/{id}")
    public String update(@PathVariable UUID id, @ModelAttribute("funcionarios") Funcionario funcionario, Model model) {
        Funcionario obj = service.charge(id);
        obj.setId(String.valueOf(id));
        obj.setNome(funcionario.getNome());
        obj.setCpf(funcionario.getCpf());
        obj.setRegistro(funcionario.getRegistro());
        obj.setTipo(funcionario.getTipo());
        obj.setEndereco(funcionario.getEndereco());
        service.update(obj);
        return "redirect:/atualizar-funcionario/index";
    }

    public String delete(@PathVariable UUID id) {
        service.delete(id);
        return "redirect:/listar-funcionario/index";
    }

}
