package br.infnet.diegorezende.hibernate.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name="Museu")
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
