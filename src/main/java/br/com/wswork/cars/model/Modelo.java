package br.com.wswork.cars.model;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "tb_modelo")
public class Modelo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long modeloId;
    private String nome;
    private Double valorFipe;
    @ManyToOne
    @JoinColumn(name = "marca_id")
    private Marca marca;

    public Modelo() {
    }

    public Modelo(String nome, Double valorFipe, Marca marca) {
        this.nome = nome;
        this.valorFipe = valorFipe;
        this.marca = marca;
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

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }
}
