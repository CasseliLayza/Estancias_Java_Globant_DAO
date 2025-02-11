package main.java.com.backend.estancias.service;

import main.java.com.backend.estancias.entity.Cliente;
import main.java.com.backend.estancias.entity.ClienteDtoOutput;
import main.java.com.backend.estancias.entity.ClienteEstanciaComentarioDtoOutput;
import main.java.com.backend.estancias.entity.Estancia;
import main.java.com.backend.estancias.repository.ext.ClienteDAO;

import java.util.ArrayList;
import java.util.List;

public class ClienteService {

    private final ClienteDAO clienteDAO;

    public ClienteService() {
        this.clienteDAO = new ClienteDAO();
        ;
    }

    public List<Cliente> listarClientes() throws Exception {
        List<Cliente> clientes = clienteDAO.listarClientes();
        for (Cliente cliente : clientes) {
            System.out.println("cliente = " + cliente);
        }


        return clientes;

    }

    public Cliente registrarCliente(Cliente cliente) throws Exception {

        System.out.println("clienteARegistrar = " + cliente);
        if (clienteDAO.buscarClienteByName(cliente.getNombre())) {
            throw new RuntimeException("No se pudo registrar el cliente pq ya existe el sistema");
        }
        Cliente clienteRegistrado = clienteDAO.registrarCliente(cliente);
        System.out.println("clienteRegistrado = " + clienteRegistrado);
        return clienteRegistrado;
    }

    public Cliente buscarCliente(int idCliente) throws Exception {

        Cliente clienteBuscado = clienteDAO.buscarCliente(idCliente);
        System.out.println("clienteBuscado = " + clienteBuscado);
        return clienteBuscado;
    }

    public Cliente actualizarCliente(Cliente cliente, int idCliente) throws Exception {

        if (buscarCliente(idCliente).getIdCliente() == 0) {
            throw new RuntimeException("No se pudo actualizar el Cliente pq no existe en el sistema");
        }

        Cliente clienteActualizado = clienteDAO.actualizarCliente(cliente, idCliente);
        System.out.println("clienteActualizado = " + clienteActualizado);
        return clienteActualizado;

    }

    public void eliminarCliente(int idCliente) throws Exception {
        if (buscarCliente(idCliente).getIdCliente() == 0) {
            throw new RuntimeException("No se pudo eliminar el Cliente pq no existe en el sistema");
        }

        clienteDAO.eliminarCliente(idCliente);
        System.out.println("Cliente eliminado con id = " + idCliente);

    }


    public List<ClienteDtoOutput> buscarClientesByEstancia() throws Exception {
        List<ClienteDtoOutput> clientes = clienteDAO.buscarClienteByReserva();

        for (ClienteDtoOutput cliente : clientes) {
            System.out.println("cliente = " + cliente);
        }

        return clientes;
    }


    public List<ClienteEstanciaComentarioDtoOutput> listarClienteAndComentariosByEstancia() throws Exception {

        EstanciaService estanciaService = new EstanciaService();
        ComentarioService comentarioService = new ComentarioService();
        List<Estancia> estancias = estanciaService.listarEstancias();

        List<ClienteEstanciaComentarioDtoOutput>clienteEstanciaComentarioDtoOutputs = new ArrayList<>();

        for (Estancia estancia : estancias) {
            ClienteEstanciaComentarioDtoOutput clienteEstanciaComentarioDtoOutput = new ClienteEstanciaComentarioDtoOutput();
            Cliente cliente = buscarCliente(estancia.getIdCliente());
            clienteEstanciaComentarioDtoOutput.setIdCliente(cliente.getIdCliente());
            clienteEstanciaComentarioDtoOutput.setNombreCliente(cliente.getNombre());
            clienteEstanciaComentarioDtoOutput.setEmail(cliente.getEmail());
            clienteEstanciaComentarioDtoOutput.setIdEstancia(estancia.getIdEstancia());
            clienteEstanciaComentarioDtoOutput.setIdCasa(estancia.getIdCasa());
            clienteEstanciaComentarioDtoOutput.setComentario(comentarioService.buscarComentario(estancia.getIdCasa()).getComentario());
            clienteEstanciaComentarioDtoOutputs.add(clienteEstanciaComentarioDtoOutput);
        }

        System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||clienteEstanciaComentarioDtoOutputs|||||||||||||||||||||||||||||||||||||||||||||||||");
        for (ClienteEstanciaComentarioDtoOutput cliente : clienteEstanciaComentarioDtoOutputs) {
            System.out.println("cliente = " + cliente);
        }

        return clienteEstanciaComentarioDtoOutputs;
    }


}