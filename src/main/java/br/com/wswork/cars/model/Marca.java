package br.com.wswork.cars.model;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "tb_marca")
public class Marca {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long marcaId;
    private String nomeMarca;

    public Marca() {
    }

    public Marca(String nomeMarca) {
        this.nomeMarca = nomeMarca;
    }

    public Long getMarcaId() {
        return marcaId;
    }

    public void setMarcaId(Long marcaId) {
        this.marcaId = marcaId;
    }

    public String getNomeMarca() {
        return nomeMarca;
    }

    public void setNomeMarca(String nomeMarca) {
        this.nomeMarca = nomeMarca;
    }
}
