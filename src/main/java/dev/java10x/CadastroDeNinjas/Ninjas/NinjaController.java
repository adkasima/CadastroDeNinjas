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
    public NinjaDTO createNinja(@RequestBody NinjaDTO ninjaDTO) {
        return ninjaService.createNinja(ninjaDTO);
    }

    //Mostrar todos os ninjas
    @GetMapping("/listar")
    public List<NinjaDTO> listNinjas() {
        return ninjaService.listNinjas();
    }

    //Monstrar Ninja por ID
    @GetMapping("/listar/{id}")
    public NinjaDTO listNinjaByID(@PathVariable Long id) {
        return ninjaService.listNinjaById(id);
    }

    //Alterar dados do ninja
    @PutMapping("/alterar/{id}")
    public NinjaDTO updateNinja(@PathVariable Long id, @RequestBody NinjaDTO ninjaDTO) {
        return ninjaService.updateNinja(id, ninjaDTO);

    }

    //Deletar Ninja
    @DeleteMapping("/deletar/{id}")
    public void deleteNinjaById(@PathVariable Long id) {
        ninjaService.deleteNinjaById(id);
    }

}
