
package com.First.Jobs.models;

import jakarta.persistence.*;


@Entity
public class ItemMenu {
    
      @Id
      @GeneratedValue(strategy = GenerationType.IDENTITY)
      private Long id;
      
      private String titulo;
      private String icono;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getIcono() {
        return icono;
    }

    public void setIcono(String icono) {
        this.icono = icono;
    }

    public ItemMenu(Long id, String titulo, String icono) {
        this.id = id;
        this.titulo = titulo;
        this.icono = icono;
    }

    public ItemMenu(String titulo, String icono) {
        this.titulo = titulo;
        this.icono = icono;
    }

    public ItemMenu() {
    }
      
      
}
