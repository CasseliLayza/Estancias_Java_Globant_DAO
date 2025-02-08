package main.java.com.backend.estancias.entity;

public class Familia {
    private int idFamilia;
    private String nombre;
    private int edadMinina;
    private int edadMaxima;
    private int numHijos;
    private String email;
    private int idCasaFamilia;

    public Familia() {
    }

    public Familia(String nombre, int edadMinina, int edadMaxima, int numHijos, String email, int idCasaFamilia) {
        this.nombre = nombre;
        this.edadMinina = edadMinina;
        this.edadMaxima = edadMaxima;
        this.numHijos = numHijos;
        this.email = email;
        this.idCasaFamilia = idCasaFamilia;
    }

    public Familia(int idFamilia, String nombre, int edadMinina, int edadMaxima, int numHijos, String email, int idCasaFamilia) {
        this.idFamilia = idFamilia;
        this.nombre = nombre;
        this.edadMinina = edadMinina;
        this.edadMaxima = edadMaxima;
        this.numHijos = numHijos;
        this.email = email;
        this.idCasaFamilia = idCasaFamilia;
    }

    public int getIdFamilia() {
        return idFamilia;
    }

    public void setIdFamilia(int idFamilia) {
        this.idFamilia = idFamilia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdadMinina() {
        return edadMinina;
    }

    public void setEdadMinina(int edadMinina) {
        this.edadMinina = edadMinina;
    }

    public int getEdadMaxima() {
        return edadMaxima;
    }

    public void setEdadMaxima(int edadMaxima) {
        this.edadMaxima = edadMaxima;
    }

    public int getNumHijos() {
        return numHijos;
    }

    public void setNumHijos(int numHijos) {
        this.numHijos = numHijos;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getIdCasaFamilia() {
        return idCasaFamilia;
    }

    public void setIdCasaFamilia(int idCasaFamilia) {
        this.idCasaFamilia = idCasaFamilia;
    }

    @Override
    public String toString() {
        return "Familia{" +
                "idFamilia=" + idFamilia +
                ", nombre='" + nombre + '\'' +
                ", edadMinina=" + edadMinina +
                ", edadMaxima=" + edadMaxima +
                ", numHijos=" + numHijos +
                ", email='" + email + '\'' +
                ", idCasaFamilia=" + idCasaFamilia +
                '}';
    }
}