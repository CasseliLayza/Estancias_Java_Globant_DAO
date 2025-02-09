package com.backend.repository;
import java.util.ArrayList;
import java.util.List;

import com.backend.entity.Comentario;

public class ComentarioDAO extends DAO{

    public void registrarComentario(Comentario c) throws Exception{
        String sql = "INSERT INTO comentarios VALUES " +
        "(" +
        "'" + c.getComentario() + "'," +
        ")";
        insertarModificarEliminarDataBase(sql);
    }

    public List<Comentario> listarComentarios() throws Exception{
        String sql = "SELECT id_comentario, id_casa, comentario FROM comentarios";
        consultarDataBase(sql);
        List<Comentario> comentarios = new ArrayList<>();
        while (resultSet.next()) {
            Comentario comentario = new Comentario();
            comentario.setIdComentario(resultSet.getInt("id_comentario"));
            comentario.setIdCasa(resultSet.getInt("id_casa"));
            comentario.setComentario(resultSet.getString("comentario"));
            comentarios.add(comentario);
            System.out.println(comentario.toString());
            System.out.println(" ");
        }

        return comentarios;
    }
}


