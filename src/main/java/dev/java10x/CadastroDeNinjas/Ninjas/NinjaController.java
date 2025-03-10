package dev.java10x.CadastroDeNinjas.Ninjas;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<String> createNinja(@RequestBody NinjaDTO ninjaDTO) {
        NinjaDTO novoNinja = ninjaService.createNinja(ninjaDTO);
        return ResponseEntity.status(HttpStatus.CREATED)
            .body("Ninja criado com sucesso: " + novoNinja.getNome() + " (ID) " + novoNinja.getId());
    }

    //Mostrar todos os ninjas
    @GetMapping("/listar")
    public ResponseEntity<List<NinjaDTO>> listNinjas() {
        List<NinjaDTO> ninjas = ninjaService.listNinjas();
        return ResponseEntity.ok(ninjas);
    }

    //Monstrar Ninja por ID
    @GetMapping("/listar/{id}")
    public ResponseEntity<?> listNinjaByID(@PathVariable Long id) {
        NinjaDTO ninja = ninjaService.listNinjaById(id);
        if (ninja != null) {
            ninjaService.listNinjaById(id);
            return ResponseEntity.ok(ninja);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Ninja com o ID: " + id + " Não foi encontrado!");
        }
    }

    //Alterar dados do ninja
    @PutMapping("/alterar/{id}")
    public ResponseEntity<?> updateNinja(@PathVariable Long id, @RequestBody NinjaDTO ninjaDTO) {
        NinjaDTO ninja = ninjaService.listNinjaById(id);
        if (ninja != null) {
            ninjaService.updateNinja(id, ninjaDTO);
            return ResponseEntity.ok(ninja);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Ninja com o ID: " + id + " Não foi encontrado!");
        }

    }

    //Deletar Ninja
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deleteNinjaById(@PathVariable Long id) {
        NinjaDTO ninja = ninjaService.listNinjaById(id);
        if(ninja != null) {
            ninjaService.deleteNinjaById(id);
            return ResponseEntity.ok("Ninja com o ID: " + id + " Foi deletado com sucesso!");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Ninja com o ID: " + id + " Não foi encontrado!");
        }
    }

}
