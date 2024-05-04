package br.infnet.diegorezende.jpajpql.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@Entity
@Table(name="Exposicao")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Exposicao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "nome", nullable = false)
    private String nome;
    @ManyToMany(fetch = FetchType.EAGER,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    @JoinTable(name = "Museu_Exposicao",
            joinColumns = { @JoinColumn(name = "exposicao_id") },
            inverseJoinColumns = { @JoinColumn(name = "museu_id") })
    private List<Museu> museus;

    public Exposicao(String nome) {
        this.nome = nome;
    }
}
