
package model;

import jakarta.persistence.*;

@Entity
@Table(name="Usuarios")
public class Usuario {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;
    
    private String tipo;
    private String numero;
    
    private String password;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Usuario(String tipo, String numero, String password) {
        this.tipo = tipo;
        this.numero = numero;
        this.password = password;
    }

    public Usuario(Long id, String tipo, String numero, String password) {
        this.id = id;
        this.tipo = tipo;
        this.numero = numero;
        this.password = password;
    }

    public Usuario() {
    }
    
    
}
