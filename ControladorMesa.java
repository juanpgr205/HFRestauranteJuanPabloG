package controlador;

import modelo.Mesa;
import modelo.Mesero;
import java.util.ArrayList;
import java.util.List;

/**
 * Controlador para la gestión de mesas y meseros en el restaurante.
 *
 * ControladorMesa utiliza el patrón Singleton para garantizar una única instancia
 * que centralice la gestión de mesas y meseros en el restaurante.
 */
public class ControladorMesa {
    private static ControladorMesa instancia;
    private List<Mesa> mesas;
    private List<Mesero> meseros;

    private ControladorMesa() {
        this.mesas = new ArrayList<>();
        this.meseros = new ArrayList<>();
        inicializarMesasYMeseros();
    }

    /**
     * Obtiene la única instancia de ControladorMesa.
     *
     * @return La instancia única de ControladorMesa.
     */
    public static ControladorMesa getInstancia() {
        if (instancia == null) {
            instancia = new ControladorMesa();
        }
        return instancia;
    }

    /**
     * Inicializa la lista de mesas y meseros con datos ficticios para pruebas.
     */
    private void inicializarMesasYMeseros() {
        for (int i = 1; i <= 5; i++) {
            mesas.add(new Mesa(i)); // Asignar número de mesa
            meseros.add(new Mesero("Mesero " + i, i)); // Crear meseros con nombre y número de mesero
        }
    }

    /**
     * Asigna una mesa disponible y un mesero disponible a un cliente.
     *
     * @return La mesa asignada, o null si no hay mesas disponibles.
     */
    public Mesa asignarMesaDisponible() {
        for (Mesa mesa : mesas) {
            if (mesa.isDisponible()) {
                Mesero meseroAsignado = asignarMeseroDisponible();
                if (meseroAsignado != null) {
                    mesa.asignarMesero(meseroAsignado);
                    return mesa;
                }
            }
        }
        return null; // No hay mesas disponibles
    }

    /**
     * Asigna un mesero disponible a una mesa.
     *
     * @return El mesero asignado, o null si no hay meseros disponibles.
     */
    private Mesero asignarMeseroDisponible() {
        for (Mesero mesero : meseros) {
            if (mesero.isDisponible()) {
                mesero.asignarMesa(); // Marcar mesero como asignado
                return mesero;
            }
        }
        return null; // No hay meseros disponibles
    }

    /**
     * Libera una mesa específica y el mesero asignado a ella.
     *
     * @param numeroMesa Número de la mesa a liberar.
     */
    public void liberarMesa(int numeroMesa) {
        for (Mesa mesa : mesas) {
            if (mesa.getNumeroMesa() == numeroMesa && !mesa.isDisponible()) {
                mesa.liberarMesa();
                break;
            }
        }
    }

    /**
     * Obtiene el estado actual de todas las mesas.
     *
     * @return Lista de todas las mesas y sus estados.
     */
    public List<Mesa> obtenerEstadoMesas() {
        return mesas;
    }
}
