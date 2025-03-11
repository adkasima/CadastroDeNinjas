package dev.java10x.CadastroDeNinjas.Missoes;

import dev.java10x.CadastroDeNinjas.Missoes.dtos.MissionDTO;
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
    public ResponseEntity<String> createMission(@RequestBody MissionDTO missionDTO) {
        MissionDTO novaMissao = missionService.createMission(missionDTO);
        return ResponseEntity.status(HttpStatus.CREATED)
            .body("Missão criada com sucesso: " + novaMissao.getNome() + " (ID) " + novaMissao.getId());
    }

    //Listar todas as missões
    @GetMapping("/listar")
    public ResponseEntity<List<MissionDTO>> lwistMissions() {
        List<MissionDTO> missions = missionService.listMission();
        return ResponseEntity.ok(missions);

    }

    //Listar missão por ID
    @GetMapping("/listar/{id}")
    public ResponseEntity<?> listMissionById(@PathVariable Long id) {
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
    public ResponseEntity<String> deleteMissionById(@PathVariable Long id) {
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
    public ResponseEntity<?> updateMission(@PathVariable Long id, @RequestBody MissionDTO missionDTO) {
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
