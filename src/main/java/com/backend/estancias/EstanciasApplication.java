package main.java.com.backend.estancias;

import main.java.com.backend.estancias.entity.Casa;
import main.java.com.backend.estancias.entity.Estancia;
import main.java.com.backend.estancias.entity.Familia;
import main.java.com.backend.estancias.service.CasaService;
import main.java.com.backend.estancias.service.EstanciaService;
import main.java.com.backend.estancias.service.FamiliaService;

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

        FamiliaService familiaService = new FamiliaService();
        Familia familiaARegistrar = new Familia("Johns",4,10,7,"Jhones@gmail.com",1);


        try {
            /*//CRUD Casas
            //register
            System.out.println("||||||||||||||||||||||||register||||||||||||||||||||||||||");
            Casa CasaRegistrada = casaService.registrarCasa(casaARegistar);
            System.out.println("CasaRegistrada = " + CasaRegistrada);

            //List
            System.out.println("||||||||||||||||||||||||List||||||||||||||||||||||||||");
            List<Casa> casas = casaService.listarCasas();
            for (Casa casa : casas) {
                System.out.println("casa = " + casa);
            }

            //find
            System.out.println("||||||||||||||||||||||||Find||||||||||||||||||||||||||");
            Casa CasaBuscada = casaService.buscarCasa(1);
            System.out.println("CasaBuscada = " + CasaBuscada);

            //Update
            System.out.println("||||||||||||||||||||||||Upadate||||||||||||||||||||||||||");
            Casa CasaActualizada = casaService.actualizarCasa(CasaRegistrada, CasaRegistrada.getIdCasa());
            System.out.println("CasaActualizada = " + CasaActualizada);

            //Delete
            System.out.println("||||||||||||||||||||||||Delete||||||||||||||||||||||||||");
            casaService.eliminarCasa(CasaRegistrada.getIdCasa()-1);
            Casa CasaBuscadaEliminada = casaService.buscarCasa(CasaRegistrada.getIdCasa()-1);
            System.out.println("CasaBuscadaEliminada = " + CasaBuscadaEliminada);
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

            //CRUD Familias
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
            Familia familiaBuscadaEliminada = familiaService.buscarFamilia(familiaRegistrada.getIdFamilia()-1);


        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }

    }
}
