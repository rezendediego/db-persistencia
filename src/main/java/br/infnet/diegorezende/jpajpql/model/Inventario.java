package br.infnet.diegorezende.jpajpql.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="Inventario")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Inventario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "codigo", nullable = false)
    private Integer codigo;

    @OneToOne(mappedBy = "inventario", cascade = CascadeType.ALL)
    private Pintura pintura;

    public Inventario(Integer codigo) {
        this.codigo = codigo;
    }
}
