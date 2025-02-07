package com.backend.repository;

import java.util.ArrayList;
import java.util.List;

import com.backend.entity.Estancia;

public class EstanciaDAO extends DAO{

    public void registrarEstancia(Estancia e) throws Exception{

        String sql = "INSERT INTO estanciass (nombre_huesped, fecha_desde, fecha_hasta ) VALUES " +
        "(" +
        "'" + e.getNombreHuesped() + "'," +
        "'" + e.getFechaDesde() + "'," +
        "'" + e.getFechaHasta() + "'," +
        ")";
        insertarModificarEliminarDataBase(sql);
     }
    



    
    public List<Estancia> listarEstancia() throws Exception{
     
        String sql = "SELECT id_estancia, id_cliente, id_casa, nombre_huesped, fecha_desde, fecha hasta FROM estancias";
        consultarDataBase(sql);

        List<Estancia> estancias = new ArrayList<>();
        while (resultSet.next()) {
        Estancia estancia = new Estancia();
        estancia.setIdEstancia(resultSet.getInt("id_estancia"));
        estancia.setIdCliente(resultSet.getInt("id_cliente"));
        estancia.setNombreHuesped(resultSet.getString("nombre_huespedl"));;
        estancia.setFechaDesde(resultSet.getDate("fecha_desde"));
        estancia.setFechaHasta(resultSet.getDate("fecha_hasta"));

        estancias.add(estancia);
        System.out.println(estancia.toString());
        System.out.println(" ");
        }
        
        return estancias;


}
