package com.umprogramax.lojaStock.controler;

import com.umprogramax.lojaStock.model.Fornecedor;
import com.umprogramax.lojaStock.model.Funcionario;
import com.umprogramax.lojaStock.service.FornecedorService;
import com.umprogramax.lojaStock.service.EnderecoService;
import com.umprogramax.lojaStock.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
public class FuncionarioController {

    @Autowired
    private FuncionarioService funcionarioService;

    @Autowired
    private EnderecoService enderecoService;

    @GetMapping(value = "/funcionario")
    public String index(Model model) {
        model.addAttribute("funcionarios", funcionarioService.list());
        model.addAttribute("funcionario", new Funcionario());
        model.addAttribute("enderecos", enderecoService.list());
        return "/funcionario/index";
    }

    @PostMapping(value = "/salva-funcionario")
    public String save(@ModelAttribute("funcionario") Funcionario funcionario) {
        funcionarioService.create(funcionario);
        return "redirect:/funcionario";
    }

    @PutMapping(value = "/funcionario/{id}")
    public String update(@PathVariable UUID id, @ModelAttribute("funcionario") Funcionario funcionario, Model model) {
        Funcionario obj = funcionarioService.charge(id);
        obj.setId(id);
        obj.setNome(funcionario.getNome());
        obj.setCpf(funcionario.getCpf());
        obj.setRegistro(funcionario.getRegistro());
        obj.setTipo(funcionario.getTipo());
        obj.setEndereco(funcionario.getEndereco());
        funcionarioService.update(obj);
        return "redirect:/funcionario";
    }

    @DeleteMapping(value = "/funcionario/{id}")
    public String delete(@PathVariable UUID id) {
        funcionarioService.delete(id);
        return "redirect:/funcionario";
    }
}
