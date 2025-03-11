package dev.java10x.CadastroDeNinjas.Missoes.mapper;

import dev.java10x.CadastroDeNinjas.Missoes.MissionModel;
import dev.java10x.CadastroDeNinjas.Missoes.dtos.MissionDTO;
import org.springframework.stereotype.Component;

@Component
public class MissionMapper {

    public MissionModel map(MissionDTO missionDTO) {

        MissionModel missionsModel = new MissionModel();
        missionsModel.setId(missionDTO.getId());
        missionsModel.setNome(missionDTO.getNome());
        missionsModel.setDificuldade(missionDTO.getDificuldade());
        missionsModel.setNinjas(missionDTO.getNinjas());

        return missionsModel;
    }

    public MissionDTO map(MissionModel missionModel) {

        MissionDTO missionDTO = new MissionDTO();
        missionDTO.setId(missionModel.getId());
        missionDTO.setNome(missionModel.getNome());
        missionDTO.setDificuldade(missionModel.getDificuldade());
        missionDTO.setNinjas(missionModel.getNinjas());

        return missionDTO;
    }
}
