package br.infnet.diegorezende.springdata.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name="museu")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Museu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "nome", nullable = false)
    private String nome;
    @Column(name = "pais", nullable = false)
    private String pais;
    @OneToMany(mappedBy = "museu",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private List<Pintura> pinturas;

    @ManyToMany(mappedBy = "museus",
            fetch = FetchType.EAGER,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    List<Exposicao> exposicoes;

    public Museu(Integer id, String nome, String pais) {
        this.id = id;
        this.nome = nome;
        this.pais = pais;
    }

    public Museu(String nome, String pais) {
        this.nome = nome;
        this.pais = pais;
    }

    @Override
    public String toString() {
        return "Museu{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", pais='" + pais + '\'' +
                '}';
    }
}
