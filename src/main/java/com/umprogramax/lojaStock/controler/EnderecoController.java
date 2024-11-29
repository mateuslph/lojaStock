package com.umprogramax.lojaStock.controler;

import com.umprogramax.lojaStock.model.Endereco;
import com.umprogramax.lojaStock.service.EnderecoService;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping(value = "/endereco")
public class EnderecoController {

    @Autowired
    private EnderecoService enderecoService;

    // inserir e listar os enderecos

    @GetMapping
    public String index(Model model) {
        List<Endereco> enderecos = enderecoService.list();
        model.addAttribute("enderecos", enderecos);
        model.addAttribute("endereco", new Endereco());
        return "/endereco/index";
    }

    @PostMapping("/salva-endereco")
    public String save(@Valid @ModelAttribute("endereco") Endereco endereco, BindingResult bindingResult) {

        Endereco objFromApi = enderecoService.buscarEnderecoPorCep(endereco.getCep());

        if (bindingResult.hasErrors()) { return "endereco"; }

        if (objFromApi == null) {
            // Handle API call failure (log error, return appropriate response)
            throw new RuntimeException("Error retrieving address from external API");
        }

        endereco.setCep(objFromApi.getCep());
        endereco.setLogradouro(objFromApi.getLogradouro());
        endereco.setComplemento(objFromApi.getComplemento());
        endereco.setBairro(objFromApi.getBairro());
        endereco.setLocalidade(objFromApi.getLocalidade());
        endereco.setUf(objFromApi.getUf());
        endereco.setUnidade(objFromApi.getUnidade());
        endereco.setIbge(objFromApi.getIbge());
        endereco.setGia(objFromApi.getGia());
        enderecoService.create(endereco);
        return "redirect:/endereco";

    }

    // editar os enderecos

    @GetMapping(value = "/edita-endereco")
    public String index() { return "/endereco/edita-endereco"; }

    @PutMapping("/{id}")
    public String update(@PathVariable UUID id, @ModelAttribute("editaEndereco") Endereco endereco, Model model) {
        Endereco obj = enderecoService.charge(id);
        obj.setId(id);
        obj.setLogradouro(endereco.getLogradouro());
        obj.setComplemento(endereco.getComplemento());
        obj.setBairro(endereco.getBairro());
        enderecoService.update(obj);
        return "redirect:/endereco";
    }

    @DeleteMapping(value="/{id}")
    public String delete(@PathVariable UUID id) {
        enderecoService.delete(id);
        return "redirect:/endereco";
    }

}
