package dev.java10x.CadastroDeNinjas.Ninjas;

import dev.java10x.CadastroDeNinjas.Missoes.MissionModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

//Entity transforma uma classe em uma Entidade no banco de dados
@Entity
@Table(name = "tb_ninjas")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "missao")
public class NinjaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @Column(unique = true)
    private String email;

    @Column(name = "img_url")
    private String imgUrl;

    @Column (name = "idade")
    private int idade;

    @Column (name = "rank")
    private String rank;

    //@ManyToOne: Ninjas podem ter apenas uma única missão.
    @ManyToOne
    @JoinColumn(name = "missoes_id") //Foreign Key ou Chave estrangeira
    private MissionModel missao;

}
