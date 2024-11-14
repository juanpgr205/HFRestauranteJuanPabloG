package controlador;

import modelo.Bebida;
import modelo.Proteina;
import modelo.Acompanamiento;
import modelo.Postre;

import java.util.ArrayList;
import java.util.List;

/**
 * Controlador para manejar la carga de ingredientes disponibles para los menús.
 */
public class ControladorMenu {

    // Listas de opciones de proteínas, postres, acompañamientos y bebidas disponibles
    private List<Proteina> proteinasDisponibles;
    private List<Postre> postresDisponibles;
    private List<Bebida> bebidasDisponibles;
    private List<Acompanamiento> acompanamientosDisponibles;

    /**
     * Constructor del ControladorMenu, inicializa las listas de opciones.
     */
    public ControladorMenu() {
        proteinasDisponibles = cargarProteinas();
        postresDisponibles = cargarPostres();
        bebidasDisponibles = cargarBebidas();
        acompanamientosDisponibles = cargarAcompanamientos();
    }

    /**
     * Carga las opciones de proteínas.
     *
     * @return Lista de proteínas disponibles.
     */
    private List<Proteina> cargarProteinas() {
        List<Proteina> proteinas = new ArrayList<>();
        proteinas.add(new Proteina("Pollo", 150, 3000));
        proteinas.add(new Proteina("Pescado", 120, 3500));
        // Agregar más opciones de proteínas si es necesario
        return proteinas;
    }

    /**
     * Carga las opciones de postres.
     *
     * @return Lista de postres disponibles.
     */
    private List<Postre> cargarPostres() {
        List<Postre> postres = new ArrayList<>();
        postres.add(new Postre("Fruta fresca", 1.0, 80));
        // Agregar más opciones de postres si es necesario
        return postres;
    }

    /**
     * Carga las opciones de bebidas.
     *
     * @return Lista de bebidas disponibles.
     */
    private List<Bebida> cargarBebidas() {
        List<Bebida> bebidas = new ArrayList<>();
        bebidas.add(new Bebida("Jugo de naranja", 50, 1.5, true));
        // Agregar más opciones de bebidas si es necesario
        return bebidas;
    }

    /**
     * Carga las opciones de acompañamientos.
     *
     * @return Lista de acompañamientos disponibles.
     */
    private List<Acompanamiento> cargarAcompanamientos() {
        List<Acompanamiento> acompanamientos = new ArrayList<>();
        acompanamientos.add(new Acompanamiento("Arroz integral", 150, 2.5));
        // Agregar más opciones de acompañamientos si es necesario
        return acompanamientos;
    }
}
