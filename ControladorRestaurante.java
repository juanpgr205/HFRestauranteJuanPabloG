package controlador;

import modelo.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Controlador principal para gestionar las operaciones del restaurante, como la asignación de mesas,
 * generación de combinaciones saludables de menú, y la inicialización de datos.
 */
public class ControladorRestaurante {
    private List<Mesa> mesas;
    private List<Mesero> meseros;
    private List<Bebida> bebidas;
    private List<Proteina> proteinas;
    private List<Acompanamiento> acompanamientos;
    private List<Postre> postres;

    /**
     * Constructor que inicializa los datos del restaurante, incluyendo mesas, meseros y elementos del menú.
     */
    public ControladorRestaurante() {
        inicializarDatos();
    }

    /**
     * Inicializa los datos del restaurante, incluyendo las mesas con sus meseros asignados y los elementos del menú.
     */
    private void inicializarDatos() {
        mesas = new ArrayList<>();
        meseros = new ArrayList<>();

        // Inicializar lista de meseros con nombres y IDs
        meseros.add(new Mesero("Carlos", 1));
        meseros.add(new Mesero("Ana", 2));
        meseros.add(new Mesero("Fernando", 3));
        meseros.add(new Mesero("José", 4));
        meseros.add(new Mesero("Juan", 5));
        meseros.add(new Mesero("Pablo", 6));
        meseros.add(new Mesero("Jonathan", 7));
        meseros.add(new Mesero("Nuria", 8));
        meseros.add(new Mesero("Karen", 9));
        meseros.add(new Mesero("María", 10));

        // Crear y asignar mesas, cada una con un mesero por defecto de forma cíclica
        for (int i = 0; i < 10; i++) {
            Mesa mesa = new Mesa(i + 1);
            mesa.setMeseroAsignado(meseros.get(i % meseros.size())); // Asignación cíclica de meseros
            mesa.setDisponible(true); // Inicialmente, todas las mesas están disponibles
            mesas.add(mesa);
        }

        // Inicializar listas de bebidas, proteínas, acompañamientos y postres
        bebidas = new ArrayList<>();
        proteinas = new ArrayList<>();
        acompanamientos = new ArrayList<>();
        postres = new ArrayList<>();

        // Menú de 500 calorías
        bebidas.add(new Bebida("Jugo de naranja", 50, 1.5, true));
        proteinas.add(new Proteina("Pechuga de pollo", 200, 5.0));
        acompanamientos.add(new Acompanamiento("Arroz integral", 150, 2.5));
        postres.add(new Postre("Fruta fresca", 1.0, 80));

        // Añadir más elementos al menú según calorías (1000, 1500, 2000)
        // Menú de 1000 calorías
        bebidas.add(new Bebida("Té verde helado", 30, 1.0, true));
        proteinas.add(new Proteina("Salmón al vapor", 400, 7.5));
        acompanamientos.add(new Acompanamiento("Puré de papa", 200, 3.0));
        postres.add(new Postre("Yogurt griego con frutos", 2.5, 100));

        // ... Continuar con los demás menús y combinaciones
    }

    /**
     * Genera una combinación saludable de menú que no exceda el límite de calorías especificado.
     *
     * @param maxCalorias El máximo de calorías permitido para la combinación de menú.
     * @return Una combinación de menú que cumple con el límite de calorías, o null si no es posible generar una.
     */
    public CombinacionMenu generarCombinacionSaludable(int maxCalorias) {
        CombinacionMenu combinacion = CombinacionMenu.generarCombinacion(bebidas, proteinas, acompanamientos, postres, maxCalorias);
        if (combinacion != null) {
            System.out.println("Se ha generado la combinación saludable:");
            System.out.println(combinacion);
        }
        return combinacion;
    }

    /**
     * Asigna una mesa específica si está disponible.
     *
     * @param numeroMesa El número de la mesa a asignar.
     * @return La mesa asignada si estaba disponible, o null si no estaba disponible o no existe.
     */
    public Mesa asignarMesa(int numeroMesa) {
        for (Mesa mesa : mesas) {
            if (mesa.getNumeroMesa() == numeroMesa && mesa.isDisponible()) {
                mesa.setDisponible(false); // Cambia el estado a no disponible
                return mesa; // Devuelve la mesa asignada
            }
        }
        return null; // No se encontró una mesa disponible con el número especificado
    }

    /**
     * Asigna la primera mesa disponible en la lista.
     *
     * @return La mesa asignada si hay alguna disponible, o null si no hay mesas libres.
     */
    public Mesa asignarMesaDisponible() {
        for (Mesa mesa : mesas) {
            if (mesa.isDisponible()) {
                mesa.setDisponible(false); // Cambia el estado a no disponible
                return mesa;
            }
        }
        return null; // No hay mesas disponibles
    }
}
