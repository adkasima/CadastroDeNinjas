package dev.java10x.CadastroDeNinjas.Missoes;

import dev.java10x.CadastroDeNinjas.Missoes.dtos.MissionDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/missoes")
public class MissionController {

    private final MissionService missionService;

    public MissionController(MissionService missionService) {
        this.missionService = missionService;
    }

    //Cadastrar Missão
    @PostMapping("/criar")
    @Operation(summary = "Cria uma nova missão", description = "Essa rota cria uma nova missão e salva no banco")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Missão criada com sucesso"),
            @ApiResponse(responseCode = "404", description = "Erro na criação da missão")
    })
    public ResponseEntity<String> createMission(@RequestBody MissionDTO missionDTO) {
        MissionDTO novaMissao = missionService.createMission(missionDTO);
        return ResponseEntity.status(HttpStatus.CREATED)
            .body("Missão criada com sucesso: " + novaMissao.getNome() + " (ID) " + novaMissao.getId());
    }

    //Listar todas as missões
    @GetMapping("/listar")
    @Operation(summary = "Lista todas as missões", description = "Essa rota lista todos as missões cadastrados no banco")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Missão listada com sucesso"),
            @ApiResponse(responseCode = "404", description = "Missão não encontrada")
    })
    public ResponseEntity<List<MissionDTO>> lwistMissions() {
        List<MissionDTO> missions = missionService.listMission();
        return ResponseEntity.ok(missions);

    }

    //Listar missão por ID
    @GetMapping("/listar/{id}")
    @Operation(summary = "Lista uma missão por ID", description = "Essa rota procura e lista uma missão com o ID específico")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Missão listada com sucesso"),
            @ApiResponse(responseCode = "404", description = "Missão não encontrada")
    })
    public ResponseEntity<?> listMissionById(
            @Parameter(description = "Usuario envia o ID pelo path da requisição")
            @PathVariable Long id) {
        MissionDTO mission = missionService.listMissionById(id);

        if (mission != null) {
            missionService.listMissionById(id);
            return ResponseEntity.ok(mission);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Missão com o ID: " + id + " Não foi encontrada!");
        }

    }

    //Deletar missão por ID
    @DeleteMapping("/deletar/{id}")
    @Operation(summary = "Deleta uma missão por ID", description = "Essa rota procura e deleta uma missão com o ID específico")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Missão deletada com sucesso"),
            @ApiResponse(responseCode = "404", description = "Missão não encontrada")
    })
    public ResponseEntity<String> deleteMissionById(
            @Parameter(description = "Usuario envia o ID pelo path da requisição")
            @PathVariable Long id) {

        MissionDTO mission = missionService.listMissionById(id);

        if (mission != null) {
            missionService.deleteMissionById(id);
            return ResponseEntity.ok("Missão com o ID: " + id + " Foi deletada com sucesso!");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Missão com o ID: " + id + " Não foi encontrada!");
        }
    }

    @PutMapping("/alterar/{id}")
    public ResponseEntity<?> updateMission(
            @Parameter(description = "Usuario envia o ID pelo path da requisição")
            @PathVariable Long id,

            @Parameter(description = "Usuario envia a missão alterada pelo corpo da requisição")
            @RequestBody MissionDTO missionDTO) {
        MissionDTO mission = missionService.listMissionById(id);

        if (mission != null) {
            missionService.updateMission(id, missionDTO);
            return ResponseEntity.ok(mission);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Missão com o ID: " + id + " Não foi encontrada!");
        }
    }

}
