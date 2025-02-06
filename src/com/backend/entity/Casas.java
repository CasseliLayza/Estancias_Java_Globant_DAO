package com.backend.entity;

import java.util.Date;

public class Casas {
    private int idCasa;
    private String calle;
    private int numero;
    private String codigoPostal;;
    private String ciudad;
    private Date fechaDesde;
    private Date fechaHasta;
    private int tiempoMinimo;
    private double precioHabitacion;
    private String tipoVivienda;

    public Casas() {
    }

    public Casas(String calle, int numero, String codigoPostal, String ciudad, Date fechaDesde, Date fechaHasta, int tiempoMinimo, double precioHabitacion, String tipoVivienda) {
        this.calle = calle;
        this.numero = numero;
        this.codigoPostal = codigoPostal;
        this.ciudad = ciudad;
        this.fechaDesde = fechaDesde;
        this.fechaHasta = fechaHasta;
        this.tiempoMinimo = tiempoMinimo;
        this.precioHabitacion = precioHabitacion;
        this.tipoVivienda = tipoVivienda;
    }

    public Casas(int idCasa, String calle, int numero, String codigoPostal, String ciudad, Date fechaDesde, Date fechaHasta, int tiempoMinimo, double precioHabitacion, String tipoVivienda) {
        this.idCasa = idCasa;
        this.calle = calle;
        this.numero = numero;
        this.codigoPostal = codigoPostal;
        this.ciudad = ciudad;
        this.fechaDesde = fechaDesde;
        this.fechaHasta = fechaHasta;
        this.tiempoMinimo = tiempoMinimo;
        this.precioHabitacion = precioHabitacion;
        this.tipoVivienda = tipoVivienda;
    }

    public int getIdCasa() {
        return idCasa;
    }

    public void setIdCasa(int idCasa) {
        this.idCasa = idCasa;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public Date getFechaDesde() {
        return fechaDesde;
    }

    public void setFechaDesde(Date fechaDesde) {
        this.fechaDesde = fechaDesde;
    }

    public Date getFechaHasta() {
        return fechaHasta;
    }

    public void setFechaHasta(Date fechaHasta) {
        this.fechaHasta = fechaHasta;
    }

    public int getTiempoMinimo() {
        return tiempoMinimo;
    }

    public void setTiempoMinimo(int tiempoMinimo) {
        this.tiempoMinimo = tiempoMinimo;
    }

    public double getPrecioHabitacion() {
        return precioHabitacion;
    }

    public void setPrecioHabitacion(double precioHabitacion) {
        this.precioHabitacion = precioHabitacion;
    }

    public String getTipoVivienda() {
        return tipoVivienda;
    }

    public void setTipoVivienda(String tipoVivienda) {
        this.tipoVivienda = tipoVivienda;
    }

    @Override
    public String toString() {
        return "Casas{" +
                "idCasa=" + idCasa +
                ", calle='" + calle + '\'' +
                ", numero=" + numero +
                ", codigoPostal='" + codigoPostal + '\'' +
                ", ciudad='" + ciudad + '\'' +
                ", fechaDesde=" + fechaDesde +
                ", fechaHasta=" + fechaHasta +
                ", tiempoMinimo=" + tiempoMinimo +
                ", precioHabitacion=" + precioHabitacion +
                ", tipoVivienda='" + tipoVivienda + '\'' +
                '}';
    }
}
