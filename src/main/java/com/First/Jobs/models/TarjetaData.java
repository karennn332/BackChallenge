
package com.First.Jobs.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="tarjetaData")
public class TarjetaData {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(unique = true, nullable = false)
    private String label;
    
    
    @ElementCollection
    private List<Integer> data;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public List<Integer> getData() {
        return data;
    }

    public void setData(List<Integer> data) {
        this.data = data;
    }

    public TarjetaData(Long id, String label, List<Integer> data) {
        this.id = id;
        this.label = label;
        this.data = data;
    }

    public TarjetaData(String label, List<Integer> data) {
        this.label = label;
        this.data = data;
    }

    public TarjetaData() {
    }
    
    
}
