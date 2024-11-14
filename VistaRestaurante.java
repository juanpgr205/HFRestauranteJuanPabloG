package GUI;

import controlador.ControladorMenu;
import controlador.ControladorRestaurante;
import modelo.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

/**
 * Interfaz gráfica de usuario principal para la gestión de un restaurante,
 * permitiendo seleccionar mesas, crear órdenes y ver pedidos activos.
 */
public class VistaRestaurante extends JFrame {
    private ControladorRestaurante controladorRestaurante;
    private ControladorMenu controladorMenu;
    private Mesa mesaSeleccionada;   // Mesa actualmente seleccionada por el cliente
    private Orden ordenActual;       // Orden actualmente activa
    private List<String> orderList;  // Lista de órdenes realizadas

    private JTextArea displayArea;   // Área de visualización de las órdenes actuales

    /**
     * Constructor de la vista para el restaurante.
     *
     * @param controladorRestaurante Controlador para la gestión de operaciones de mesas.
     * @param controladorMenu Controlador para la gestión de operaciones de menú.
     */
    public VistaRestaurante(ControladorRestaurante controladorRestaurante, ControladorMenu controladorMenu) {
        this.controladorRestaurante = controladorRestaurante;
        this.controladorMenu = controladorMenu;
        this.orderList = new ArrayList<>();

        // Configuración de la interfaz gráfica
        setLayout(new FlowLayout());
        configurarComponentesUI();
        setSize(450, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /**
     * Configura los componentes de la interfaz gráfica, incluyendo botones para la
     * selección de mesas, creación de órdenes, procesamiento de pagos y visualización de órdenes.
     */
    private void configurarComponentesUI() {
        JButton botonSeleccionarMesa = new JButton("Seleccionar Mesa Disponible");
        botonSeleccionarMesa.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                seleccionarMesa();
            }
        });

        JButton botonProcesarOrden = new JButton("Procesar Orden y Pagar");
        botonProcesarOrden.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                procesarOrdenYPagar();
            }
        });

        JButton createOrderButton = new JButton("Crear Orden");
        createOrderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createOrder();
            }
        });

        JButton viewOrdersButton = new JButton("Ver Órdenes");
        viewOrdersButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showOrders();
            }
        });

        displayArea = new JTextArea(10, 30);
        displayArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(displayArea);

        add(botonSeleccionarMesa);
        add(botonProcesarOrden);
        add(createOrderButton);
        add(viewOrdersButton);
        add(scrollPane);
    }

    /**
     * Selecciona una mesa disponible y asigna un mesero a la mesa seleccionada.
     * Genera un menú basado en el límite de calorías proporcionado por el cliente.
     */
    private void seleccionarMesa() {
        Mesa mesa = controladorRestaurante.asignarMesaDisponible();
        if (mesa != null) {
            mesaSeleccionada = mesa;
            displayArea.append("Mesa " + mesa.getNumeroMesa() + " seleccionada.\n");
        } else {
            displayArea.append("No hay mesas disponibles.\n");
        }
    }

    /**
     * Procesa la orden actual y la marca como pagada,
     * registrando el total de la orden en la lista de órdenes completadas.
     */
    private void procesarOrdenYPagar() {
        if (ordenActual != null) {
            orderList.add("Orden pagada: " + ordenActual.toString());
            displayArea.append("Orden procesada y pagada.\n");
            ordenActual = null;  // Restablece la orden actual después de pagar
        } else {
            displayArea.append("No hay orden activa para procesar.\n");
        }
    }

    /**
     * Crea una nueva orden para la mesa seleccionada,
     * permitiendo al cliente seleccionar elementos de menú.
     */
    private void createOrder() {
        if (mesaSeleccionada != null) {
            ordenActual = new Orden(mesaSeleccionada);
            displayArea.append("Nueva orden creada para la mesa " + mesaSeleccionada.getNumeroMesa() + ".\n");
        } else {
            displayArea.append("Debe seleccionar una mesa antes de crear una orden.\n");
        }
    }

    /**
     * Muestra todas las órdenes actuales y pasadas en el área de visualización.
     */
    private void showOrders() {
        displayArea.setText("");
        for (String order : orderList) {
            displayArea.append(order + "\n");
        }
    }
}
