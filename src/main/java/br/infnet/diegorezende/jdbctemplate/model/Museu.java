package br.infnet.diegorezende.jdbctemplate.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Objects;
@Component
@Scope("prototype")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Museu {
    private Long id;
    private String nome;
    private String pais;

    public Museu(String nome, String pais) {
        this.nome = nome;
        this.pais = pais;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Museu museu)) return false;
        return getId().equals(museu.getId()) && getNome().equals(museu.getNome()) && getPais().equals(museu.getPais());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getNome(), getPais());
    }
}