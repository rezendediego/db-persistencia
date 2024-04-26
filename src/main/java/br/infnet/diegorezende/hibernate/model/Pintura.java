package br.infnet.diegorezende.hibernate.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Pintura")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Pintura {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "nome", nullable = false)
    private String nome;
    @ManyToOne
    @JoinColumn(name="pintor_id")
    private Pintor pintor;

    @ManyToOne
    @JoinColumn(name="museu_id")
    private Museu museu;

    public Pintura(String nome, Pintor pintor, Museu museu) {
        this.nome = nome;
        this.pintor = pintor;
        this.museu = museu;
    }

    @Override
    public String toString() {
        return "Pintura{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", pintor=" + pintor +
                ", museu=" + museu +
                '}';
    }
}
