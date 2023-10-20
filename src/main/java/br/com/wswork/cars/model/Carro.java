package br.com.wswork.cars.model;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "tb_carro")
public class Carro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @CreationTimestamp
    private LocalDateTime timeStampCadastro;
    @ManyToOne
    @JoinColumn(name = "modelo_Id")
    private Modelo modelo;
    private int ano;
    private String combustivel;
    private int numPortas;
    private String cor;

    public Carro() {
    }

    public Carro(LocalDateTime timeStampCadastro, Modelo modelo, int ano, String combustivel, int numPortas, String cor) {
        this.timeStampCadastro = timeStampCadastro;
        this.modelo = modelo;
        this.ano = ano;
        this.combustivel = combustivel;
        this.numPortas = numPortas;
        this.cor = cor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getTimeStampCadastro() {
        return timeStampCadastro;
    }

    public void setTimeStampCadastro(LocalDateTime timeStampCadastro) {
        this.timeStampCadastro = timeStampCadastro;
    }

    public Modelo getModelo() {
        return modelo;
    }

    public void setModelo(Modelo modelo) {
        this.modelo = modelo;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getCombustivel() {
        return combustivel;
    }

    public void setCombustivel(String combustivel) {
        this.combustivel = combustivel;
    }

    public int getNumPortas() {
        return numPortas;
    }

    public void setNumPortas(int numPortas) {
        this.numPortas = numPortas;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }
}
