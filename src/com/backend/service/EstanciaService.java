package com.backend.service;

import com.backend.entity.Estancia;

import java.util.List;

public class EstanciaService {


    EstanciaDAO estanciaDAO = new EstanciaDAO();

    public EstanciaService(EstanciaDAO estanciaDAO) {
        this.estanciaDAO = estanciaDAO;
    }

    public List<Estancia> listarEstancias (){
        List<Estancia> estancias = estanciaDAO.listarEstancias();
        System.out.println("estancias = " + estancias);

        return estancias;

    }

    public Estancia registarEstancia(Estancia familia){

        if(buscarEstancia(familia.getIdEstancia())!=null){
            throw new RuntimeException("No se pudo registrar la Estancia pq existe en el sistema");
        }

        Estancia estanciaARegistrada = estanciaDAO.registrarEstancia();
        return estanciaARegistrada;
    }

    public Estancia buscarEstancia(int idEstancia){
        Estancia estanciaBuscada = estanciaDAO.buscarEstancia();
        return estanciaBuscada;
    }

    public Estancia actualizarEstancia(Estancia estancia, int idEstancia){

        if(buscarEstancia(estancia.getIdEstancia())!=null){
            throw new RuntimeException("No se pudo actualizar la Estancia pq existe en el sistema");
        }

        Estancia estanciaActualizada = estanciaDAO.actualizarEstancia();
        return estanciaActualizada;

    }

    public void eliminarEstancia(int idEstancia){
        if (buscarEstancia(idEstancia)==null) {
            throw new RuntimeException("No se pudo Estancia la Familia pq no existe en el sistema");
        }

        estanciaDAO.eliminarEstancia(idEstancia);

    }


}
