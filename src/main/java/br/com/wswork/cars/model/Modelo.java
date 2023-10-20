package br.com.wswork.cars.model;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "tb_modelo")
public class Modelo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long modeloId;
    private String nome;
    private Double valorFipe;
    @ManyToOne
    @JoinColumn(name = "marca_id")
    private Marca marcaId;

    public Modelo() {
    }

    public Modelo(String nome, Double valorFipe, Marca marcaId) {
        this.nome = nome;
        this.valorFipe = valorFipe;
        this.marcaId = marcaId;
    }

    public Long getModeloId() {
        return modeloId;
    }

    public void setModeloId(Long modeloId) {
        this.modeloId = modeloId;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getValorFipe() {
        return valorFipe;
    }

    public void setValorFipe(Double valorFipe) {
        this.valorFipe = valorFipe;
    }

    public Marca getMarcaId() {
        return marcaId;
    }

    public void setMarcaId(Marca marcaId) {
        this.marcaId = marcaId;
    }
}
