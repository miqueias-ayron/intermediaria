package com.avaliacao.intermediaria.quarto;

import java.util.UUID;

public class Quarto {
    private final String id = UUID.randomUUID().toString();
    private String tipo;
    private Integer andar;
    private Double precoPorNoite;
    private boolean disponivel;
    private boolean deleted;

    public String getId() {
        return id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Integer getAndar() {
        return andar;
    }

    public void setAndar(int andar) {
        this.andar = andar;
    }

    public double getPrecoPorNoite() {
        return precoPorNoite;
    }

    public void setPrecoPorNoite(double precoPorNoite) {
        this.precoPorNoite = precoPorNoite;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }
}
