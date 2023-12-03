
package model;


public class ApiResponse {
    
    
    private String mensaje;
    
    private int estado;

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public ApiResponse(String mensaje, int estado) {
        this.mensaje = mensaje;
        this.estado = estado;
    }

    public ApiResponse() {
    }
    
    
}
