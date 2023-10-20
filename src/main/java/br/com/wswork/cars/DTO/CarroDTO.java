package br.com.wswork.cars.DTO;

public class CarroDTO {
    private Long id;
    private Long timestampCadastro;
    private Long modelo_id;
    private int ano;
    private String combustivel;
    private int numPortas;
    private String cor;
    private String nomeModelo;
    private double valor;

    public CarroDTO() {
    }

    public CarroDTO(Long id, Long timestampCadastro, Long modelo_id, int ano, String combustivel, int numPortas, String cor, String nomeModelo, double valor) {
        this.id = id;
        this.timestampCadastro = timestampCadastro;
        this.modelo_id = modelo_id;
        this.ano = ano;
        this.combustivel = combustivel;
        this.numPortas = numPortas;
        this.cor = cor;
        this.nomeModelo = nomeModelo;
        this.valor = valor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTimestampCadastro() {
        return timestampCadastro;
    }

    public void setTimestampCadastro(Long timestampCadastro) {
        this.timestampCadastro = timestampCadastro;
    }

    public Long getModelo_id() {
        return modelo_id;
    }

    public void setModelo_id(Long modelo_id) {
        this.modelo_id = modelo_id;
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

    public String getNomeModelo() {
        return nomeModelo;
    }

    public void setNomeModelo(String nomeModelo) {
        this.nomeModelo = nomeModelo;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
}
