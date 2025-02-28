package dev.java10x.CadastroDeNinjas.Ninjas;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ninjas")
public class NinjaController {

    private final NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

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
    public List<NinjaModel> listNinjas() {
        return ninjaService.listNinjas();
    }

    //Monstrar Ninja por ID
    @GetMapping("/listar/{id}")
    public NinjaModel listNinjaByID(@PathVariable Long id) {
        return ninjaService.listNinjaByID(id);
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
