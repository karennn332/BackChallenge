
package model;

import java.math.BigDecimal;


public class Tarjeta {
    
    private Long id;
    
    
    private String numeroTarjeta;
    private BigDecimal balance;
    private String nombreTarjeta;
    private String validUntil;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumeroTarjeta() {
        return numeroTarjeta;
    }

    public void setNumeroTarjeta(String numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public String getNombreTarjeta() {
        return nombreTarjeta;
    }

    public void setNombreTarjeta(String nombreTarjeta) {
        this.nombreTarjeta = nombreTarjeta;
    }

    public String getValidUntil() {
        return validUntil;
    }

    public void setValidUntil(String validUntil) {
        this.validUntil = validUntil;
    }

    public Tarjeta(String numeroTarjeta, BigDecimal balance, String nombreTarjeta, String validUntil) {
        this.numeroTarjeta = numeroTarjeta;
        this.balance = balance;
        this.nombreTarjeta = nombreTarjeta;
        this.validUntil = validUntil;
    }

    public Tarjeta(Long id, String numeroTarjeta, BigDecimal balance, String nombreTarjeta, String validUntil) {
        this.id = id;
        this.numeroTarjeta = numeroTarjeta;
        this.balance = balance;
        this.nombreTarjeta = nombreTarjeta;
        this.validUntil = validUntil;
    }

    public Tarjeta() {
    }
    
    
}
