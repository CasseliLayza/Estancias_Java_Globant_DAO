package main.java.com.backend.estancias;

import main.java.com.backend.estancias.entity.*;
import main.java.com.backend.estancias.service.*;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

public class EstanciasApplication {
    public static void main(String[] args) {

        //casas
        CasaService casaService = new CasaService();
        Date fechaDesde = Date.from(LocalDate.of(2025, 04, 7).atStartOfDay(ZoneId.systemDefault()).toInstant());
        Date fechaHasta = Date.from(LocalDate.of(2025, 04, 9).atStartOfDay(ZoneId.systemDefault()).toInstant());
        Casa casaARegistar = new Casa("Keneddy", 201, "051", "Lima", "Peru",
                fechaDesde, fechaHasta, 8, 48, 100.00, "Departamento");

        //estancias
        EstanciaService estanciaService = new EstanciaService();
        Estancia estanciaARegistrar = new Estancia(1,1,"casse",fechaDesde,fechaHasta);

        //Familias
        FamiliaService familiaService = new FamiliaService();
        Familia familiaARegistrar = new Familia("Lara",4,10,7,"Jhones@gmail.com",1);

        //Clientes
        ClienteService clienteService = new ClienteService();
        Cliente clienteARegistrar = new Cliente("casse mckinley","keneddy",787,"051","new york","United States","cc@gmail.com");

        //Comentarios
        ComentarioService comentarioService = new ComentarioService();
        Comentario comentarioARegistrar = new Comentario(1,"Buen casa limpia y ordenada");

        try {
            /*//CRUD Casas
            //register
            System.out.println("||||||||||||||||||||||||register||||||||||||||||||||||||||");
            Casa CasaRegistrada = casaService.registrarCasa(casaARegistar);

            //List
            System.out.println("||||||||||||||||||||||||List||||||||||||||||||||||||||");
            List<Casa> casas = casaService.listarCasas();

            //find
            System.out.println("||||||||||||||||||||||||Find||||||||||||||||||||||||||");
            Casa CasaBuscada = casaService.buscarCasa(1);

            //Update
            System.out.println("||||||||||||||||||||||||Upadate||||||||||||||||||||||||||");
            Casa CasaActualizada = casaService.actualizarCasa(CasaRegistrada, CasaRegistrada.getIdCasa());

            //Delete
            System.out.println("||||||||||||||||||||||||Delete||||||||||||||||||||||||||");
            casaService.eliminarCasa(CasaRegistrada.getIdCasa()-1);
            Casa CasaBuscadaEliminada = casaService.buscarCasa(CasaRegistrada.getIdCasa()-1);
            */

            /*//CRUD Estancias
            //register
            System.out.println("||||||||||||||||||||||||register||||||||||||||||||||||||||");
            Estancia estanciaRegistrada = estanciaService.registrarEstancia(estanciaARegistrar);

            //List
            System.out.println("||||||||||||||||||||||||List||||||||||||||||||||||||||");
            List<Estancia> estancias = estanciaService.listarEstancias();

            //find
            System.out.println("||||||||||||||||||||||||Find||||||||||||||||||||||||||");
            Estancia estanciaBuscada = estanciaService.buscarEstancia(1);

            //Update
            System.out.println("||||||||||||||||||||||||Upadate||||||||||||||||||||||||||");
            Estancia estanciaActualizada = estanciaService.actualizarEstancia(estanciaRegistrada, estanciaRegistrada.getIdEstancia());

            //Delete
            System.out.println("||||||||||||||||||||||||Delete||||||||||||||||||||||||||");
            estanciaService.eliminarEstancia(estanciaRegistrada.getIdEstancia()-1);
            Estancia estanciaBuscadaEliminada = estanciaService.buscarEstancia(estanciaRegistrada.getIdEstancia()-1);*/

            /*//CRUD Familias
            //register
            System.out.println("||||||||||||||||||||||||register||||||||||||||||||||||||||");
            Familia familiaRegistrada = familiaService.registrarFamilia(familiaARegistrar);

            //List
            System.out.println("||||||||||||||||||||||||List||||||||||||||||||||||||||");
            List<Familia> familias = familiaService.listarFamilias();

            //find
            System.out.println("||||||||||||||||||||||||Find||||||||||||||||||||||||||");
            Familia estanciaBuscada = familiaService.buscarFamilia(1);

            //Update
            System.out.println("||||||||||||||||||||||||Upadate||||||||||||||||||||||||||");
            Familia estanciaActualizada = familiaService.actualizarFamilia(familiaRegistrada, familiaRegistrada.getIdFamilia());

            //Delete
            System.out.println("||||||||||||||||||||||||Delete||||||||||||||||||||||||||");
            familiaService.eliminarFamilia(familiaRegistrada.getIdFamilia()-1);
            Familia familiaBuscadaEliminada = familiaService.buscarFamilia(familiaRegistrada.getIdFamilia()-1);*/

            /*//CRUD Clientes
            //register
            System.out.println("||||||||||||||||||||||||register||||||||||||||||||||||||||");
            Cliente clienteRegistrado = clienteService.registrarCliente(clienteARegistrar);

            //List
            System.out.println("||||||||||||||||||||||||List||||||||||||||||||||||||||");
            List<Cliente> familias = clienteService.listarClientes();

            //find
            System.out.println("||||||||||||||||||||||||Find||||||||||||||||||||||||||");
            Cliente estanciaBuscada = clienteService.buscarCliente(1);

            //Update
            System.out.println("||||||||||||||||||||||||Upadate||||||||||||||||||||||||||");
            Cliente estanciaActualizada = clienteService.actualizarCliente(clienteRegistrado, clienteRegistrado.getIdCliente());

            //Delete
            System.out.println("||||||||||||||||||||||||Delete||||||||||||||||||||||||||");
            clienteService.eliminarCliente(clienteRegistrado.getIdCliente()-1);
            Cliente clienteBuscadoEliminado = clienteService.buscarCliente(clienteRegistrado.getIdCliente()-1);*/

            /*//CRUD Comentarios
            //register
            System.out.println("||||||||||||||||||||||||register||||||||||||||||||||||||||");
            Comentario comentarioRegistrado = comentarioService.registrarComentario(comentarioARegistrar);

            //List
            System.out.println("||||||||||||||||||||||||List||||||||||||||||||||||||||");
            List<Comentario> familias = comentarioService.listarComentarios();

            //find
            System.out.println("||||||||||||||||||||||||Find||||||||||||||||||||||||||");
            Comentario estanciaBuscada = comentarioService.buscarComentario(1);

            //Update
            System.out.println("||||||||||||||||||||||||Upadate||||||||||||||||||||||||||");
            Comentario estanciaActualizada = comentarioService.actualizarComentario(comentarioRegistrado, comentarioRegistrado.getIdComentario());

            //Delete
            System.out.println("||||||||||||||||||||||||Delete||||||||||||||||||||||||||");
            comentarioService.eliminarComentario(comentarioRegistrado.getIdComentario()-1);
            Comentario comentarioBuscadoEliminado = comentarioService.buscarComentario(comentarioRegistrado.getIdComentario()-1);
*/

            //Buscar y listar aquellas familias que tienen al menos 3 hijos, y con edad máxima inferior a 10 años.
            List<Familia> familiasMas2HijosMaximoEadIferiorMax10 =familiaService.listarFamilias()
                    .stream().filter(f->f.getNumHijos()>=3&& f.getEdadMinina()<=10)
                    .toList();

            System.out.println("||||||||||||||||||||familiasMas2HijosMaximoEadIferiorMax10|||||||||||||||||||||||");
            for (Familia familia:familiasMas2HijosMaximoEadIferiorMax10) {
                System.out.println("familia = " + familia);
            }

            // Buscar y listar las casas disponibles para el periodo comprendido entre el 1 de agosto de 2025 y el 31 de agosto de 2025 en Reino Unido.
            System.out.println("||||||||||||||||||||buscarCasasPorPeriodoServ|||||||||||||||||||||||");
            casaService.buscarCasasPorPeriodoServ();

            //Buscar y listar  todas aquellas familias cuya dirección de email sea Hotmail.
            List<Familia> familiasHotmail =familiaService.listarFamilias()
                    .stream().filter(f-> f.getEmail().contains("hotmail"))
                    .toList();

            System.out.println("||||||||||||||||||||familiasHotmail|||||||||||||||||||||||");
            for (Familia familia:familiasHotmail) {
                System.out.println("familia = " + familia);
            }

            //Consulta la BD para que te devuelva aquellas casas disponibles a partir de una fecha dada y un número de días específico.
            System.out.println("||||||||||||||||||||casasApartirDeUnaFechaHastaNumeroDeDiasEspecifico|||||||||||||||||||||||");
            casaService.casasApartirDeUnaFechaHastaNumeroDeDiasEspecifico(30);

            //Buscar y listar los datos de todos los clientes que en algún momento realizaron una estancia y la descripción de la casa donde la realizaron.
            System.out.println("||||||||||||||||||||buscarClienteByEstancia|||||||||||||||||||||||");
            clienteService.buscarClientesByEstancia();

            //Op2 Buscar y listar los datos de todos los clientes que en algún momento realizaron una estancia y la descripción de la casa donde la realizaron.
            System.out.println("||||||||||||||||||||listarClienteAndComentariosByEstancia|||||||||||||||||||||||");
            clienteService.listarClienteAndComentariosByEstancia();

            //Buscar y listar todas las estancias que han sido reservadas por un cliente, mostrar el nombre, país y ciudad del cliente y además la información de la casa que reservó. La que reemplazaría a la anterior
            System.out.println("||||||||||||||||||||buscarEstanciaByCliente|||||||||||||||||||||||");
            estanciaService.buscarEstanciaByCliente(1);

            //Crear un método para incrementar el precio por día. El mismo debe recibir como parámetro el % de aumento. En esta ocasión, debido a la devaluación de la libra esterlina con respecto al euro se desea incrementar el precio por día en un 5% de todas las casas del Reino Unido. Mostrar los precios actualizados.
            System.out.println("||||||||||||||||||||incrementarPrecioByDia|||||||||||||||||||||||");
            casaService.incrementarPrecioByDiaCasas(5.0);

            //Obtener el número de casas que existen para cada uno de los países diferentes.
            System.out.println("||||||||||||||||||||obtenerNumeroCasasByPais|||||||||||||||||||||||");
            casaService.obtenerNumeroCasasByPais();

            //Buscar y listar aquellas casas del Reino Unido de las que se ha dicho de ellas (comentarios) que están ‘limpias’.
            System.out.println("||||||||||||||||||||obtnercasasReinoUnioComentadasComoLimpias|||||||||||||||||||||||");
            casaService.obtnerCasasReinoUnioComentadasComoLimpias();

        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }

    }

}
