package com.backend.repository;

import java.util.ArrayList;
import java.util.List;

import com.backend.entity.Casa;

public class CasaDAO extends DAO{

    public void registrarCasas(Casa c) throws Exception{

        String sql = "INSERT INTO casas (calle, numero, codigo_postal, ciudad, pais, fecha_desde, fecha hasta, tiempo_minimo, tiempo_maximo, precio_habitacion, tipo_vivienda) VALUES " +
        "(" +
        "'" + c.getCalle() + "'," +
        "'" + c.getNumero() + "'," +
        "'" + c.getCodigoPostal() + "'," +
        "'" + c.getCiudad() + "'," +
        "'" + c.getPais() + "'," +
        "'" + c.getFechaDesde() + "'," +
        "'" + c.getFechaHasta() + "'," +
        "'" + c.getTiempoMinimo() + "'," +
        "'" + c.getTiempoMaximo() + "'," +
        "'" + c.getTipoVivienda() + "'," +
        ")";
        insertarModificarEliminarDataBase(sql);
     }
    



    
    public List<Casa> listarCasa() throws Exception{
     
        String sql = "SELECT id, calle, numero, codigo_postal, ciudad, pais, fecha_desde, fecha hasta, tiempo_minimo, tiempo_maximo, precio_habitacion, tipo_vivienda FROM casas";
        consultarDataBase(sql);

        List<Casa> casas = new ArrayList<>();
        while (resultSet.next()) {
        Casa casa = new Casa();
        casa.setIdCasa(resultSet.getInt("id_casa"));
        casa.setCalle(resultSet.getString("nombre_calle"));
        casa.setNumero(resultSet.getInt("numero"));
        casa.setCodigoPostal(resultSet.getString("codigo_postal"));
        casa.setCiudad(resultSet.getString("ciudad"));
        casa.setFechaDesde(resultSet.getDate("fecha_desde"));
        casa.setFechaHasta(resultSet.getDate("fecha_hasta"));
        casa.setTiempoMinimo(resultSet.getInt("tiempo_minimo"));
        casa.setTiempoMaximo(resultSet.getInt("tiempo_maximo"));
        casa.setPrecioHabitacion(resultSet.getFloat("precio_habitacion"));
        casa.setTipoVivienda(resultSet.getString("tipo_vivienda"));

        casas.add(casa);
        System.out.println(casa.toString());
        System.out.println(" ");
        }
        
        return casas;



    }


}
