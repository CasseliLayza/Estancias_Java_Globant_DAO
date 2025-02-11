package main.java.com.backend.estancias.service;

import main.java.com.backend.estancias.entity.Cliente;
import main.java.com.backend.estancias.entity.Comentario;
import main.java.com.backend.estancias.entity.Estancia;
import main.java.com.backend.estancias.repository.ext.EstanciaDAO;

import java.util.List;
import java.util.stream.Collectors;

public class EstanciaService {

    private final EstanciaDAO estanciaDAO;

    public EstanciaService() {
        this.estanciaDAO = new EstanciaDAO();
    }

    public List<Estancia> listarEstancias() throws Exception {
        List<Estancia> estancias = estanciaDAO.listarEstancias();
        for (Estancia estancia : estancias) {
            System.out.println("estancia = " + estancia);
        }

        return estancias;
    }

    public Estancia registrarEstancia(Estancia estancia) throws Exception {

        System.out.println("estanciaARegistrar = " + estancia);
        if (!estanciaDAO.verificarDisponibilidadEstancia(estancia)) {
            throw new RuntimeException("No se pudo registrar la estancia pq no existe disponibilidad");
        }

        Estancia estanciaRegistrada = estanciaDAO.registrarEstancia(estancia);
        System.out.println("estanciaARegistrada = " + estanciaRegistrada);
        return estanciaRegistrada;
    }

    public Estancia buscarEstancia(int idEstancia) throws Exception {
        Estancia estanciaBuscada = estanciaDAO.buscarEstancia(idEstancia);
        System.out.println("estanciaBuscada = " + estanciaBuscada);
        return estanciaBuscada;
    }

    public Estancia actualizarEstancia(Estancia estancia, int idEstancia) throws Exception {

        if (buscarEstancia(idEstancia).getIdEstancia() == 0) {
            throw new RuntimeException("No se pudo actualiza la estancia pq no existe en el sistema");
        }

        Estancia estanciaActualizada = estanciaDAO.actualizarEstancia(estancia, idEstancia);
        System.out.println("estanciaActualizada = " + estanciaActualizada);

        return estanciaActualizada;
    }

    public void eliminarEstancia(int idEstancia) throws Exception {
        if (buscarEstancia(idEstancia).getIdEstancia() == 0) {
            throw new RuntimeException("No se pudo eliminar la estancia pq no existe en el sistema");
        }

        estanciaDAO.eliminarEstancia(idEstancia);
        System.out.println("Estancia eliminada con id = " + idEstancia);

    }

    public void buscarEstanciaByCliente(int idCliente) throws Exception {
        List<Estancia> estanciasById = listarEstancias().stream()
                .filter(e -> e.getIdCliente() == idCliente).collect(Collectors.toList());

        ClienteService clienteService = new ClienteService();
        Cliente clienteBuscado = clienteService.buscarCliente(estanciasById.get(0).getIdCliente());
        ComentarioService comentarioService = new ComentarioService();
        List<Comentario> comentariosByCliente = comentarioService.listarComentarios()
                .stream().filter(c -> c.getIdCasa() == estanciasById.get(0).getIdCasa())
                .collect(Collectors.toList());

        System.out.println("buscarEstanciaByCliente: " + idCliente);
        System.out.println(
                "nombreCliente: " + clienteBuscado.getNombre()
                        + ", pais: " + clienteBuscado.getPais() + ", ciudad: " + clienteBuscado.getCiudad()
                        + ", comentarioCasa: " + comentariosByCliente.get(0).getComentario());


    }

}
