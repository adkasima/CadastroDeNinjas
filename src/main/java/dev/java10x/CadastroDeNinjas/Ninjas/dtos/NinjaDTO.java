package dev.java10x.CadastroDeNinjas.Ninjas.dtos;

import dev.java10x.CadastroDeNinjas.Missoes.MissionModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NinjaDTO {

    private Long id;
    private String nome;
    private String email;
    private String imgUrl;
    private int idade;
    private String rank;
    private MissionModel missao;
}
