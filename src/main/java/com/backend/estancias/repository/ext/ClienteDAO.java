package main.java.com.backend.estancias.repository.ext;

import main.java.com.backend.estancias.entity.Cliente;
import main.java.com.backend.estancias.entity.ClienteDtoOutput;
import main.java.com.backend.estancias.repository.DAO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO extends DAO {

    public Cliente registrarCliente(Cliente cliente) throws Exception {

        String sql = "INSERT INTO clientes (nombre, calle, numero, codigo_postal, ciudad, pais, email)" +
                " VALUES(" +
                "'" + cliente.getNombre() + "'," +
                "'" + cliente.getCalle() + "'," +
                "'" + cliente.getNumero() + "'," +
                "'" + cliente.getCodigoPostal() + "'," +
                "'" + cliente.getCiudad() + "'," +
                "'" + cliente.getPais() + "'," +
                "'" + cliente.getEmail() + "'" +
                ")";

        insertarModificarEliminarDataBase(sql);
        List<Cliente> clientesRegistradas = listarClientes();
        return buscarCliente(clientesRegistradas.get(clientesRegistradas.size() - 1).getIdCliente());
    }


    public List<Cliente> listarClientes() throws Exception {

        String sql = "SELECT id_cliente, nombre, calle, numero, codigo_postal, ciudad, pais, email FROM clientes";
        consultarDataBase(sql);

        List<Cliente> clientes = new ArrayList<>();
        while (resultSet.next()) {
            Cliente cliente = new Cliente();
            setUpCliente(cliente);

            clientes.add(cliente);
        }

        desconectarDataBase();
        return clientes;
    }


    public Cliente buscarCliente(int idCliente) throws Exception {
        String sql = "SELECT id_cliente, nombre, calle, numero, codigo_postal, ciudad, pais, email FROM clientes WHERE id_cliente=" + idCliente;
        consultarDataBase(sql);

        Cliente cliente = new Cliente();
        while (resultSet.next()) {
            setUpCliente(cliente);
        }

        desconectarDataBase();
        return cliente;
    }


    public boolean buscarClienteByName(String nameCliente) throws Exception {
        String sql = " SELECT id_cliente, nombre, calle, numero, codigo_postal, ciudad, pais, email FROM clientes WHERE nombre = " + "'" + nameCliente + "'";
        consultarDataBase(sql);

        Cliente cliente = new Cliente();
        while (resultSet.next()) {
            setUpCliente(cliente);
        }

        desconectarDataBase();
        if (cliente.getNombre() != null) {
            return cliente.getNombre().equals(nameCliente);
        }
        return false;

    }


    public Cliente actualizarCliente(Cliente cliente, int idCliente) throws Exception {

        String sql = "UPDATE clientes SET nombre=?, calle=?, numero=?, codigo_postal=?, ciudad=?, pais=?, email=? WHERE id_cliente=?";
        prepareStatementInsertarModificarEliminarDataBase(sql);
        System.out.println("ClienteAActualizar = " + cliente);
        preparedStatement.setString(1, cliente.getNombre());
        preparedStatement.setString(2, cliente.getCalle());
        preparedStatement.setInt(3, cliente.getNumero());
        preparedStatement.setString(4, cliente.getCodigoPostal());
        preparedStatement.setString(5, cliente.getCiudad());
        preparedStatement.setString(6, cliente.getPais());
        preparedStatement.setString(7, cliente.getEmail());
        preparedStatement.setInt(8, idCliente);

        preparedStatement.executeUpdate();
        //List<Cliente> clientesRistradas = listarClientes();
        return buscarCliente(idCliente);
    }


    public void eliminarCliente(int idCliente) throws Exception {
        String sql = "DELETE from clientes WHERE id_cliente=" + idCliente;
        insertarModificarEliminarDataBase(sql);
        desconectarDataBase();
    }

    public List<ClienteDtoOutput> buscarClienteByReserva() throws Exception {
        String sql = "SELECT c.id_cliente, c.nombre, c.email, " +
                "e.id_estancia, e.nombre_huesped, " +
                "ca.id_casa, ca.calle, ca.numero, ca.codigo_postal, ca.ciudad, ca.pais, " +
                "com.id_comentario, com.comentario " +
                "FROM clientes c " +
                "JOIN estancias e ON c.id_cliente = e.id_cliente " +
                "JOIN casas ca ON e.id_casa = ca.id_casa " +
                "JOIN comentarios com ON ca.id_casa = com.id_casa;";

        consultarDataBase(sql);

        System.out.println("!!!!!!!!!!!!!buscarClienteByReserva!!!!!!!!!!!!!");
        List<ClienteDtoOutput> clientes = new ArrayList<>();
        while (resultSet.next()) {
            ClienteDtoOutput cliente = new ClienteDtoOutput();
            cliente.setIdCliente(resultSet.getInt("id_cliente"));
            cliente.setNombre(resultSet.getString("nombre"));
            cliente.setEmail(resultSet.getString("email"));
            cliente.setIdEstancia(resultSet.getInt("id_estancia"));
            cliente.setNombreHuesped(resultSet.getString("nombre_huesped"));
            cliente.setIdCasa(resultSet.getInt("id_casa"));
            cliente.setCalle(resultSet.getString("calle"));
            cliente.setNumero(resultSet.getInt("numero"));
            cliente.setCodigoPostal(resultSet.getString("codigo_postal"));
            cliente.setCiudad(resultSet.getString("ciudad"));
            cliente.setPais(resultSet.getString("pais"));
            cliente.setIdComentario(resultSet.getInt("id_comentario"));
            cliente.setComentario(resultSet.getString("comentario"));
            clientes.add(cliente);
        }

        System.out.println("casas = " + clientes);

        desconectarDataBase();
        return clientes;
    }

    private void setUpCliente(Cliente cliente) throws SQLException {
        cliente.setIdCliente(resultSet.getInt("id_cliente"));
        cliente.setNombre(resultSet.getString("nombre"));
        cliente.setCalle(resultSet.getString("calle"));
        cliente.setNumero(resultSet.getInt("numero"));
        cliente.setCodigoPostal(resultSet.getString("codigo_postal"));
        cliente.setCiudad(resultSet.getString("ciudad"));
        cliente.setPais(resultSet.getString("pais"));
        cliente.setEmail(resultSet.getString("email"));
    }


}
