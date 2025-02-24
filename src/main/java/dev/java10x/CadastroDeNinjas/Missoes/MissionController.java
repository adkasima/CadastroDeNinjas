package dev.java10x.CadastroDeNinjas.Missoes;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("missoes")
public class MissionController {

    @PostMapping("/cadastrar")
    public String createMission() {
        return "Missão criada";
    }

    @GetMapping("/listar")
    public String listMissions() {
        return "Missões listadas";
    }

    @PutMapping("/alterar")
    public String updateMission() {
        return "Missão alterada";
    }

    @DeleteMapping("/deletar")
    public String deleteMission() {
        return "Missão deletada";
    }
}
