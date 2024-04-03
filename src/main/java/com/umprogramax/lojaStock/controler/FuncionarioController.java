package com.umprogramax.lojaStock.controler;

import com.umprogramax.lojaStock.model.Funcionario;
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
        return "redirect:/listar-funcionarios/index";
    }

    @GetMapping(value="/listar-funcionarios")
    public String index(Model model) {
        model.addAttribute("funcionarios", service.list());
        return "/listar-funcionarios/index";
    }

    @PutMapping(value="/atualizar-funcionario/{id}")
    public String update(@PathVariable UUID id, @ModelAttribute("funcionario") Funcionario funcionario, Model model) {
        Funcionario obj = service.charge(id);
        obj.setId(String.valueOf(id));
        obj.setNome(funcionario.getNome());
        obj.setCpf(funcionario.getCpf());
        obj.setRegistro(funcionario.getRegistro());
        obj.setTipo(funcionario.getTipo());
        obj.setEndereco(funcionario.getEndereco());
        service.update(obj);
        return "redirect:/listar-funcionarios/index";
    }

    public String delete(@PathVariable UUID id) {
        service.delete(id);
        return "redirect:/listar-funcionarios/index";
    }

}
