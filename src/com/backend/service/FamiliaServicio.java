package com.backend.service;

public class FamiliaServicio {

    FamiliaDAO familiaDAO = new FamiliaDAO();

    public FamiliaServicio(FamiliaDAO familiaDAO) {
        this.familiaDAO = familiaDAO;
    }

    public Lis<Familia> listarFamilias (){
        List<Familia> familiaList = familiaDAO.listarFamilias();
        System.out.println("familiaList = " + familiaList);

        return familiaList;

    }

    public Familia registarFamilia(Familia familia){

        if(buscarFamilia(familia.getIdFamilia)!=){
            throw new RuntimeException("No se pudo registrar la Familia pq existe en el sistema");
        }

        Familia familiaARegistrada = familiaDAO.registrarFamilia();
        return familiaARegistrada;
    }

    public Familia buscarFamilia(int idFamilia){
        Familia familiabuscada = familiaDAO.buscarFamilia();
        return familiabuscada;
    }
    
    public Familia actualizarFamilia(Familia familia, int idFamilia){

        if(buscarFamilia(familia.getIdFamilia)!=){
            throw new RuntimeException("No se pudo actualizar la Familia pq existe en el sistema");
        }

        Familia familiaActualizada = familiaDAO.actualizarFamilia();
        return familiaActualizada;
        
    }

    public void eliminarFamilia(int idFamilia){
        if (buscarFamilia(idFamilia)==null) {
            throw new RuntimeException("No se pudo elimiar la Familia pq no existe en el sistema");
        }

        familiaDAO.eliminarFamilia(idFamilia);

    }

}
