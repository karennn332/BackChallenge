
package com.First.Jobs.models;

import jakarta.persistence.*;
import java.util.Date;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;


@Entity
@Table(name="transaccion")
public class Transaccion {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Long id;

    private String icon;
    private String name;
  
    @NotNull
    @Digits(integer = Integer.MAX_VALUE, fraction = 0, message = "Solo se aceptan numeros")
    private Number value;
    private Date symbol;
    private String estado;
    private String iconClass;
    private String stateClass;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Number getValue() {
        return value;
    }

    public void setValue(Number value) {
        this.value = value;
    }

    public Date getSymbol() {
        return symbol;
    }

    public void setSymbol(Date symbol) {
        this.symbol = symbol;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getIconClass() {
        return iconClass;
    }

    public void setIconClass(String iconClass) {
        this.iconClass = iconClass;
    }

    public String getStateClass() {
        return stateClass;
    }

    public void setStateClass(String stateClass) {
        this.stateClass = stateClass;
    }

    public Transaccion(Long id, String icon, String name, Number value, Date symbol, String estado, String iconClass, String stateClass) {
        this.id = id;
        this.icon = icon;
        this.name = name;
        this.value = value;
        this.symbol = symbol;
        this.estado = estado;
        this.iconClass = iconClass;
        this.stateClass = stateClass;
    }

    public Transaccion(String icon, String name, Number value, Date symbol, String estado, String iconClass, String stateClass) {
        this.icon = icon;
        this.name = name;
        this.value = value;
        this.symbol = symbol;
        this.estado = estado;
        this.iconClass = iconClass;
        this.stateClass = stateClass;
    }

    public Transaccion() {
    }
    
    
}
