package controlador;

import modelo.Mesero;
import modelo.Orden;
import modelo.Mesa;
import modelo.MenuSaludable;

import java.util.ArrayList;

/**
 * Controlador para gestionar las órdenes en el restaurante.
 */
public class ControladorOrden {
    private ArrayList<Orden> ordenes;

    /**
     * Constructor para inicializar el controlador de órdenes.
     */
    public ControladorOrden() {
        this.ordenes = new ArrayList<>();
    }

    /**
     * Crea una nueva orden y marca la mesa como ocupada.
     *
     * @param mesa          La mesa en la que se realiza la orden.
     * @param mesero        El mesero asignado a la orden.
     * @param menuSaludable El menú saludable seleccionado.
     */
    public void crearOrden(Mesa mesa, Mesero mesero, MenuSaludable menuSaludable) {
        Orden orden = new Orden(mesa, mesero, menuSaludable);
        ordenes.add(orden);

        // Marcamos la mesa como ocupada
        mesa.setDisponible(false);
    }

    /**
     * Finaliza la orden, liberando la mesa y el mesero asignado.
     *
     * @param orden La orden a finalizar.
     */
    public void finalizarOrden(Orden orden) {
        Mesa mesa = orden.getMesa();
        if (mesa != null) {
            mesa.liberarMesa(); // Aquí liberamos la mesa correctamente
        }
        ordenes.remove(orden);
    }

    /**
     * Obtiene la lista de órdenes activas.
     *
     * @return La lista de órdenes activas.
     */
    public ArrayList<Orden> getOrdenes() {
        return ordenes;
    }
}
