package br.infnet.diegorezende.hibernate.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Pintor")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Pintor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "nascimento", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date nascimento;

    @OneToMany(mappedBy = "pintor",fetch = FetchType.EAGER,cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Pintura> pinturas;

    public Pintor(String nome, Date nascimento, List<Pintura> pinturas) {
        this.nome = nome;
        this.nascimento = nascimento;
        this.pinturas = pinturas;
    }

    public Pintor(String nome, Date nascimento) {
        this.nome = nome;
        this.nascimento = nascimento;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Pintor{id=").append(id);
        sb.append(", nome='").append(nome).append('\'');
        sb.append(", nascimento=").append(nascimento);
        sb.append(", pinturas=[");

        if (!pinturas.isEmpty()) {
            for (Pintura pintura : pinturas) {
                sb.append(pintura.getNome()).append(", "); // Assuming there's a getNome() method in Pintura
            }
            sb.delete(sb.length() - 2, sb.length()); // Remove the trailing comma and space
        } else {
            sb.append("empty");
        }

        sb.append("]}");

        return sb.toString();
    }

}

