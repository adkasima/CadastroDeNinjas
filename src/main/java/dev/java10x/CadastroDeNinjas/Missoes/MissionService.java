package dev.java10x.CadastroDeNinjas.Missoes;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MissionService {

    private MissionRepository missionRepository;

    public MissionService(MissionRepository missionRepository) {
        this.missionRepository = missionRepository;
    }

    //Criar Missão
    public MissionsModel createMission(MissionsModel mission) {
        return missionRepository.save(mission);
    }

    //Deletar Missão
    public void deleteMissionById(Long id) {
        missionRepository.deleteById(id);
    }

    //Listar missões
    public List<MissionsModel> listMission() {
        return missionRepository.findAll();
    }

    //Listar missão por iD
    public MissionsModel listMissionById(Long id) {
        Optional<MissionsModel> missionById = missionRepository.findById(id);
        return missionById.orElse(null);
    }

    //Atualizar Missão
    public MissionsModel updateMission(Long id, MissionsModel updatedMission) {
        if(missionRepository.existsById(id)) {
            updatedMission.setId(id);
            missionRepository.save(updatedMission);
        }
        return null;
    }
}
