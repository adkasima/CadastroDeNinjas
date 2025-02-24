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
    @GetMapping("/mostrar")
    public String showNinjas() {
        return "mostrar ninjas";
    }

    //Monstrar Ninja por ID
    @GetMapping("/mostrarID")
    public String showNinjaByID() {
        return "mostrar ninjas por ID";
    }

    //Alterar dados do ninja
    @PutMapping("/alterar")
    public String updateNinjaByID() {
        return "alterar dados por ID";
    }
    //Deletar Ninja
    @DeleteMapping("/deletar")
    public String deleteNinjaByID() {
        return "deletar ninja por ID";
    }
}
