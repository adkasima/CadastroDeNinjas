package dev.java10x.CadastroDeNinjas.Ninjas;

import jakarta.persistence.Id;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class NinjaService {

    private final NinjaRepository ninjaRepository;
    private final NinjaMapper ninjaMapper;

    public NinjaService(NinjaRepository ninjaRepository, NinjaMapper ninjaMapper) {
        this.ninjaRepository = ninjaRepository;
        this.ninjaMapper = ninjaMapper;
    }

    //Criar Ninja
    public NinjaDTO createNinja(NinjaDTO ninjaDTO) {
        NinjaModel ninja = ninjaMapper.map(ninjaDTO);
        ninja = ninjaRepository.save(ninja);
        return  ninjaMapper.map(ninja);
    }

    public void deleteNinjaById(Long id) {
        ninjaRepository.deleteById(id);
    }

    public List<NinjaDTO> listNinjas() {
        List<NinjaModel> ninjas = ninjaRepository.findAll();
        return ninjas.stream()
                .map(ninjaMapper::map)
                .collect(Collectors.toList());
    }

    public NinjaDTO listNinjaById(Long id) {
        Optional<NinjaModel> ninjaByID = ninjaRepository.findById(id);
        return ninjaByID.map(ninjaMapper::map).orElse(null);
    }

    //Atualizar Ninja
    public NinjaDTO updateNinja(Long id, NinjaDTO ninjaDTO) {
        Optional<NinjaModel> ninjaToUpdate = ninjaRepository.findById(id);

        if (ninjaToUpdate.isPresent()) {
            NinjaModel updatedNinja = ninjaMapper.map(ninjaDTO);
            updatedNinja.setId(id);
            NinjaModel savedNinja = ninjaRepository.save(updatedNinja);
            return ninjaMapper.map(savedNinja);
        }
        return null;
    }

}
