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
    @PostMapping("/criar")
    public NinjaModel createNinja(@RequestBody NinjaModel ninja) {
        return ninjaService.createNinja(ninja);
    }

    //Mostrar todos os ninjas
    @GetMapping("/listar")
    public List<NinjaModel> listNinjas() {
        return ninjaService.listNinjas();
    }

    //Monstrar Ninja por ID
    @GetMapping("/listar/{id}")
    public NinjaModel listNinjaByID(@PathVariable Long id) {
        return ninjaService.listNinjaById(id);
    }

    //Alterar dados do ninja
    @PutMapping("/alterar/{id}")
    public NinjaModel updateNinja(@PathVariable Long id, @RequestBody NinjaModel updatedNinja) {
        return ninjaService.updateNinja(id, updatedNinja);

    }

    //Deletar Ninja
    @DeleteMapping("/deletar/{id}")
    public void deleteNinjaById(@PathVariable Long id) {
        ninjaService.deleteNinjaById(id);
    }

}
