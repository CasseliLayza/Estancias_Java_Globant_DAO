package com.backend.service;

public class EstanciaService {


    EstanciaDAO estanciaDAO = new EstanciaDAO();

    public EstanciaService(EstanciaDAO estanciaDAO) {
        this.estanciaDAO = estanciaDAO;
    }

    public Lis<Estancia> listar (){
        List<Familia> familiaList = estanciaDAO.listarFamilias();
        System.out.println("familiaList = " + familiaList);

        return familiaList;

    }

    public Familia registarFamilia(Familia familia){

        if(buscarFamilia(familia.getIdFamilia)!=){
            throw new RuntimeException("No se pudo registrar la Familia pq existe en el sistema");
        }

        Familia familiaARegistrada = estanciaDAO.registrarFamilia();
        return familiaARegistrada;
    }

    public Familia buscarFamilia(int idFamilia){
        Familia familiabuscada = estanciaDAO.buscarFamilia();
        return familiabuscada;
    }

    public Familia actualizarFamilia(Familia familia, int idFamilia){

        if(buscarFamilia(familia.getIdFamilia)!=){
            throw new RuntimeException("No se pudo actualizar la Familia pq existe en el sistema");
        }

        Familia familiaActualizada = estanciaDAO.actualizarFamilia();
        return familiaActualizada;

    }

    public void eliminarFamilia(int idFamilia){
        if (buscarFamilia(idFamilia)==null) {
            throw new RuntimeException("No se pudo elimiar la Familia pq no existe en el sistema");
        }

        estanciaDAO.eliminarFamilia(idFamilia);

    }


}
