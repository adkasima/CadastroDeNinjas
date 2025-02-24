package dev.java10x.CadastroDeNinjas.Ninjas;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class NinjaController {

    @GetMapping("/hello")
    public String hello() {
        return "Olá mundo!";

    }

    //Cadastrar Ninjas
    @PostMapping("/cadastrar")
    public String registerNinja() {
        return "Cadastrar ninja";
    }

    //Mostrar todos os ninjas
    @GetMapping("/listar")
    public String showNinjas() {
        return "listar ninjas";
    }

    //Monstrar Ninja por ID
    @GetMapping("/listarID")
    public String showNinjaByID() {
        return "listar ninjas por ID";
    }

    //Alterar dados do ninja
    @PutMapping("/alterarID")
    public String updateNinjaByID() {
        return "alterar dados por ID";
    }
    //Deletar Ninja
    @DeleteMapping("/deletarID")
    public String deleteNinjaByID() {
        return "deletar ninja por ID";
    }
}
