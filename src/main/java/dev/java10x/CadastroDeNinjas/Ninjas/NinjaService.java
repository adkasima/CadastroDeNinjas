package dev.java10x.CadastroDeNinjas.Ninjas;

import jakarta.persistence.Id;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
public class NinjaService {

    private final NinjaRepository ninjaRepository;

    public NinjaService(NinjaRepository ninjaRepository) {
        this.ninjaRepository = ninjaRepository;
    }

    //Criar Ninja
    public NinjaModel createNinja(NinjaModel ninja) {
        return ninjaRepository.save(ninja);

    }

    //Deletar Ninja
    public void deleteNinjaById(Long id) {
        ninjaRepository.deleteById(id);
    }

    //Listar todos os ninjas
    public List<NinjaModel> listNinjas() {
        return ninjaRepository.findAll();
    }

    //Listar ninja por ID
    public NinjaModel listNinjaById(Long id) {
        Optional<NinjaModel> ninjaByID = ninjaRepository.findById(id);
        return ninjaByID.orElse(null);
    }

    //Atualizar Ninja
    public NinjaModel updateNinja(Long id, NinjaModel updatedNinja) {
        if(ninjaRepository.existsById(id)) {
            updatedNinja.setId(id);
            return ninjaRepository.save(updatedNinja);
        }
        return null;
    }

}
