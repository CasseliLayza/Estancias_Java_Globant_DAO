package com.backend.service;

import com.backend.entity.Casa;
import com.backend.repository.CasaDAO;

import java.util.List;

public class CasasService {


    CasaDAO casaDAO = new CasaDAO();

    public CasasService(CasaDAO casaDAO) {
        this.casaDAO = casaDAO;
    }

    public List<Casa> listarCasas() throws Exception {
        List<Casa> casas = casaDAO.listarCasa();
        System.out.println("casas = " + casas);

        return casas;

    }

    public Casa registarCasa(Casa casa){

        if(buscarCasa(casa.getIdCasa())!=null){
            throw new RuntimeException("No se pudo casa la Familia pq existe en el sistema");
        }

        Casa casaARegistrada = casaDAO.registrarCasas();
        return casaARegistrada;
    }

    public Casa buscarCasa(int idFamilia){
        Familia familiabuscada = casaDAO.buscarFamilia();
        return familiabuscada;
    }

    public Familia actualizarFamilia(Familia familia, int idFamilia){

        if(buscarCasa(familia.getIdFamilia)!=){
            throw new RuntimeException("No se pudo actualizar la Familia pq existe en el sistema");
        }

        Familia familiaActualizada = casaDAO.actualizarFamilia();
        return familiaActualizada;

    }

    public void eliminarFamilia(int idFamilia){
        if (buscarCasa(idFamilia)==null) {
            throw new RuntimeException("No se pudo elimiar la Familia pq no existe en el sistema");
        }

        casaDAO.eliminarFamilia(idFamilia);

    }


}
