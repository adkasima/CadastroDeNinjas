package dev.java10x.CadastroDeNinjas.Missoes;

import dev.java10x.CadastroDeNinjas.Ninjas.NinjaModel;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/missoes")
public class MissionController {

    private MissionService missionService;

    public MissionController(MissionService missionService) {
        this.missionService = missionService;
    }

    //Cadastrar Missão
    @PostMapping("/criar")
    public MissionsModel createMission(@RequestBody MissionsModel mission) {
        return missionService.createMission(mission);
    }

    //Listar todas as missões
    @GetMapping("/listar")
    public List<MissionsModel> listMissions() {
        return missionService.listMission();
    }

    //Listar missão por ID
    @GetMapping("/listar/{id}")
    public MissionsModel listMissionById(@PathVariable Long id) {
        return missionService.listMissionById(id);
    }

    //Deletar missão por ID
    @DeleteMapping("/deletar/{id}")
    public void deleteMissionById(@PathVariable Long id) {
        missionService.deleteMissionById(id);
    }

    @PutMapping("/alterar/{id}")
    public MissionsModel updateMission(@PathVariable Long id, @RequestBody MissionsModel upatedMission) {
        return missionService.updateMission(id, upatedMission);
    }

}
