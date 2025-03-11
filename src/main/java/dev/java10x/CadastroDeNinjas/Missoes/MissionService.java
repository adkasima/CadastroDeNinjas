package dev.java10x.CadastroDeNinjas.Missoes;

import dev.java10x.CadastroDeNinjas.Missoes.dtos.MissionDTO;
import dev.java10x.CadastroDeNinjas.Missoes.mapper.MissionMapper;
import dev.java10x.CadastroDeNinjas.Ninjas.NinjaModel;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MissionService {

    private final MissionRepository missionRepository;
    private final MissionMapper missionMapper;

    public MissionService(MissionRepository missionRepository, MissionMapper missionMapper) {
        this.missionRepository = missionRepository;
        this.missionMapper = missionMapper;
    }

    //Criar Missão
    public MissionDTO createMission(MissionDTO missionDTO) {
        MissionModel mission = missionMapper.map(missionDTO);
        mission = missionRepository.save(mission);
        return  missionMapper.map(mission);

    }

    //Deletar Missão
    public void deleteMissionById(Long id) {
        missionRepository.deleteById(id);
    }

    //Listar missões
    public List<MissionDTO> listMission() {
        List<MissionModel> missions = missionRepository.findAll() ;
        return missions.stream()
                .map(missionMapper::map)
                .collect(Collectors.toList());
    }

    //Listar missão por iD
    public MissionDTO listMissionById(Long id) {
        Optional<MissionModel> missionById = missionRepository.findById(id);
        return missionById.map(missionMapper::map).orElse(null);
    }

    //Atualizar Missão
    public MissionDTO updateMission(Long id, MissionDTO missionDTO) {
        Optional<MissionModel> missionToUpdate = missionRepository.findById(id);

        if (missionToUpdate.isPresent()) {
            MissionModel updatedMission = missionMapper.map(missionDTO);
            updatedMission.setId(id);
            MissionModel savedMission = missionRepository.save(updatedMission);
            return missionMapper.map(savedMission);
        }
        return null;
    }
}
