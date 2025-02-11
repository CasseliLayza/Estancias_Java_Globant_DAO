package main.java.com.backend.estancias.service;

import main.java.com.backend.estancias.entity.Casa;
import main.java.com.backend.estancias.entity.Comentario;
import main.java.com.backend.estancias.repository.ext.CasaDAO;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CasaService {
    private final CasaDAO casaDAO;

    public CasaService() {
        this.casaDAO = new CasaDAO();
    }

    public List<Casa> listarCasas() throws Exception {
        List<Casa> casas = casaDAO.listarCasas();
        System.out.println("casas registradas: ");
        for (Casa casa : casas) {
            System.out.println("casa = " + casa);
        }

        return casas;

    }

    public Casa registrarCasa(Casa casa) throws Exception {

        Casa casaBuscada = casaDAO.buscarCasaByAddress(casa);
        System.out.println("casaBuscada = " + casaBuscada);
        if (casaBuscada.getIdCasa() != 0) {
            if (casaBuscada.getPais().equals(casa.getPais())
                    && casaBuscada.getCiudad().equals(casa.getCiudad())
                    && casaBuscada.getCalle().equals(casa.getCalle())
                    && casaBuscada.getNumero() == casa.getNumero()
            ) {
                throw new RuntimeException("No se pudo registrar la casa pq ya existe en el sistema");
            }
        }

        Casa casaRegistrada = casaDAO.registrarCasa(casa);
        System.out.println("casaRegistrada = " + casaRegistrada);
        return casaRegistrada;
    }

    public Casa buscarCasa(int idCasa) throws Exception {
        Casa casaBuscada = casaDAO.buscarCasa(idCasa);
        System.out.println("casaBuscada = " + casaBuscada);

        return casaBuscada;
    }

    public Casa actualizarCasa(Casa casa, int idCasa) throws Exception {

        if (buscarCasa(idCasa).getIdCasa() == 0) {
            throw new RuntimeException("No se pudo actualiza la casa pq no existe en el sistema");
        }

        Casa casaActualizada = casaDAO.actualizarCasa(casa, idCasa);
        System.out.println("casaActualizada = " + casaActualizada);
        return casaActualizada;

    }

    public void eliminarCasa(int idCasa) throws Exception {
        if (buscarCasa(idCasa).getIdCasa() == 0) {
            throw new RuntimeException("No se pudo eliminar la casa pq no existe en el sistema");
        }

        casaDAO.eliminarCasa(idCasa);
        System.out.println("Casa eliminada con id = " + idCasa);

    }

    public List<Casa> buscarCasasPorPeriodoServ() throws Exception {
        String pais = "Reino Unido";
        String fecha_desde = "2020-08-01";
        String fecha_hasta = "2020-08-31";

        List<Casa> casas = casaDAO.listarCasasPorPeriodo(pais, fecha_desde, fecha_hasta);
        for (Casa casa : casas) {
            System.out.println("casa = " + casa);
        }

        if (casas.isEmpty()) {
            throw new Exception("No se encontraron casas en " + pais +
                    " en el perido del " + fecha_desde + " y " + fecha_hasta);
        }

        return casas;
    }

    public List<Casa> casasApartirDeUnaFechaHastaNumeroDeDiasEspecifico(int diasEspecificos) throws Exception {
        String fecha_desde = "2020-08-01";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        List<Casa> casas;

        try {
            Date fecha = simpleDateFormat.parse(fecha_desde);
            System.out.println("fecha = " + fecha);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(fecha);
            calendar.add(Calendar.DAY_OF_MONTH, diasEspecificos);
            Date fechaMasDiasEspecificos = calendar.getTime();
            System.out.println("fechaMas = " + fechaMasDiasEspecificos);
            casas = listarCasas().stream()
                    .filter(c -> fecha.after(c.getFechaDesde()) && fechaMasDiasEspecificos.before(c.getFechaHasta()))
                    .toList();

            System.out.println("Casa disponibles entre " + fecha + " y " + fechaMasDiasEspecificos);
            for (Casa casa : casas) {
                System.out.println("casa = " + casa);
            }
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        return casas;
    }


    public void incrementarPrecioByDiaCasas(double porcentajeIncremento) throws Exception {

        List<Casa> casas = listarCasas().stream()
                .filter(c -> "Reino Unido".equals(c.getPais()))
                .peek(c -> c.setPrecioHabitacion(c.getPrecioHabitacion() * (1 + (porcentajeIncremento / 100)))).toList();

        System.out.println("Casa incremento precio dia:  " + porcentajeIncremento + "%");
        for (
                Casa casa : casas) {
            System.out.println("casa = " + casa);
        }
    }


    public void obtenerNumeroCasasByPais() throws Exception {

        Map<String, Long> casasPorPais = listarCasas().stream()
                .collect(Collectors.groupingBy(Casa::getPais, Collectors.counting()));

        casasPorPais.forEach((pais, cantidad) ->
                System.out.println("País: " + pais + " - Número de casas: " + cantidad));
    }


    public void obtnerCasasReinoUnioComentadasComoLimpias() throws Exception {

        List<Casa> casas = listarCasas().stream()
                .filter(c -> "Reino Unido".equals(c.getPais())).collect(Collectors.toList());

        ComentarioService comentarioService = new ComentarioService();

        List<Casa> casasLimpias = casas.stream()
                .filter(casa -> {
                    try {
                        Comentario comentario = comentarioService.buscarComentario(casa.getIdCasa());
                        return comentario != null && comentario.getComentario().contains("limpia");
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                })
                .collect(Collectors.toList());

        System.out.println("obtnerCasasReinoUnioComentadasComoLimpias!!!!!!!!!!!!!!!!!!!!!");
        for (Casa casasLimpia : casasLimpias) {
            System.out.println("casasLimpia = " + casasLimpia);
        }


    }
}