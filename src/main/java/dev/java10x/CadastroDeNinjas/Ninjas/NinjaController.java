package dev.java10x.CadastroDeNinjas.Ninjas;

import dev.java10x.CadastroDeNinjas.Ninjas.dtos.NinjaDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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
    @Operation(summary = "Boas vindas", description = "Essa rota retorna uma mensagem de boas vindas")
    public String hello() {
        return "Olá mundo!";

    }

    //Cadastrar Ninjas
    @PostMapping("/criar")
    @Operation(summary = "Cria um novo ninja", description = "Essa rota cria um novo ninja e salva no banco")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Ninja criado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Erro na criação do ninja")
    })
    public ResponseEntity<String> createNinja(@RequestBody NinjaDTO ninjaDTO) {
        NinjaDTO novoNinja = ninjaService.createNinja(ninjaDTO);
        return ResponseEntity.status(HttpStatus.CREATED)
            .body("Ninja criado com sucesso: " + novoNinja.getNome() + " (ID) " + novoNinja.getId());
    }

    //Mostrar todos os ninjas
    @GetMapping("/listar")
    @Operation(summary = "Lista todos os ninjas", description = "Essa rota lista todos os ninjas cadastrados no banco")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Ninja listado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Ninja não encontrado")
    })
    public ResponseEntity<List<NinjaDTO>> listNinjas() {
        List<NinjaDTO> ninjas = ninjaService.listNinjas();
        return ResponseEntity.ok(ninjas);
    }

    //Monstrar Ninja por ID
    @GetMapping("/listar/{id}")
    @Operation(summary = "Lista um ninja por ID", description = "Essa rota procura e lista um ninja com o ID específico")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Ninja listado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Ninja não encontrado")
    })
    public ResponseEntity<?> listNinjaByID(
            @Parameter(description = "Usuario envia o ID pelo path da requisição")
            @PathVariable Long id) {
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
    @Operation(summary = "Altera um ninja por ID", description = "Essa rota procura e altera um ninja com o ID " +
            "específico")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Ninja alterado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Ninja não encontrado")
    })
    public ResponseEntity<?> updateNinja(
            @Parameter(description = "Usuario envia o ID pelo path da requisição")
            @PathVariable Long id,
            @RequestBody NinjaDTO ninjaDTO) {
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
    @Operation(summary = "Deleta um ninja por ID", description = "Essa rota procura e deleta um ninja com o ID " +
            "específico")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Ninja deletado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Ninja não encontrado")
    })
    public ResponseEntity<String> deleteNinjaById(
            @Parameter(description = "Usuario envia o ID pelo path da requisição")
            @PathVariable Long id) {
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
