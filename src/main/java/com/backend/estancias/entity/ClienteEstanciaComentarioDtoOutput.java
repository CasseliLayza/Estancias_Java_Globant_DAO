package main.java.com.backend.estancias.entity;

public class ClienteEstanciaComentarioDtoOutput {
    private int idCliente;
    private String nombreCliente;
    private String email;
    private int idEstancia;
    private int idCasa;
    private String comentario;

    public ClienteEstanciaComentarioDtoOutput() {
    }

    public ClienteEstanciaComentarioDtoOutput(int idCliente, String nombreCliente, String email, int idEstancia, int idCasa, String comentario) {
        this.idCliente = idCliente;
        this.nombreCliente = nombreCliente;
        this.email = email;
        this.idEstancia = idEstancia;
        this.idCasa = idCasa;
        this.comentario = comentario;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setIdEstancia(int idEstancia) {
        this.idEstancia = idEstancia;
    }

    public void setIdCasa(int idCasa) {
        this.idCasa = idCasa;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    @Override
    public String toString() {
        return "ClienteEstanciaComentarioDtoOutput{" +
                "idCliente=" + idCliente +
                ", nombreCliente='" + nombreCliente + '\'' +
                ", email='" + email + '\'' +
                ", idEstancia=" + idEstancia +
                ", idCasa=" + idCasa +
                ", comentario='" + comentario + '\'' +
                '}';
    }
}
