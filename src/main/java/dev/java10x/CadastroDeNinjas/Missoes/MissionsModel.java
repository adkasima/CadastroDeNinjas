package dev.java10x.CadastroDeNinjas.Missoes;

import dev.java10x.CadastroDeNinjas.Ninjas.NinjaModel;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table (name = "tb_missoes")
public class MissionsModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private MissionRankEnum dificuldade;

    //@OneToMany: Uma missão pode ter vários Ninjas.
    @OneToMany (mappedBy = "missoes")
    private List<NinjaModel> ninjas;

}
