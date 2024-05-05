package br.infnet.diegorezende.springdata.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "pintura")
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
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "inventario_id")
    private Inventario inventario;

    public Pintura(String nome, Pintor pintor, Museu museu) {
        this.nome = nome;
        this.pintor = pintor;
        this.museu = museu;
    }
    public Pintura(String nome) {
        this.nome = nome;
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
