package com.backend.entity;

public class Familias {
    private int idFamlia;
    private String nombre;
    private int edadMinina;
    private int edadMaxima;
    private int numHijos;
    private String email;
    private int idCasaFamilia;

    public Familias() {
    }

    public Familias(String nombre, int edadMinina, int edadMaxima, int numHijos, String email, int idCasaFamilia) {
        this.nombre = nombre;
        this.edadMinina = edadMinina;
        this.edadMaxima = edadMaxima;
        this.numHijos = numHijos;
        this.email = email;
        this.idCasaFamilia = idCasaFamilia;
    }

    public Familias(int idFamlia, String nombre, int edadMinina, int edadMaxima, int numHijos, String email, int idCasaFamilia) {
        this.idFamlia = idFamlia;
        this.nombre = nombre;
        this.edadMinina = edadMinina;
        this.edadMaxima = edadMaxima;
        this.numHijos = numHijos;
        this.email = email;
        this.idCasaFamilia = idCasaFamilia;
    }

    @Override
    public String toString() {
        return "Familias{" +
                "idFamlia=" + idFamlia +
                ", nombre='" + nombre + '\'' +
                ", edadMinina=" + edadMinina +
                ", edadMaxima=" + edadMaxima +
                ", numHijos=" + numHijos +
                ", email='" + email + '\'' +
                ", idCasaFamilia=" + idCasaFamilia +
                '}';
    }
}
