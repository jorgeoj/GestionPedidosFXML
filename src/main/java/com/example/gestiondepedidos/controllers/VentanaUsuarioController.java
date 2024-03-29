package com.example.gestiondepedidos.controllers;

import com.example.gestiondepedidos.Main;
import com.example.gestiondepedidos.Sesion;
import com.example.gestiondepedidos.domain.DBConnection;
import com.example.gestiondepedidos.orders.Pedido;
import com.example.gestiondepedidos.orders.PedidoDAOImp;
import javafx.beans.Observable;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Controlador de la ventana de usuario en la aplicación de gestión de pedidos.
 * Esta clase gestiona la interfaz de usuario para mostrar los pedidos del usuario y permite al usuario cerrar sesión.
 */
public class VentanaUsuarioController implements Initializable {
    @javafx.fxml.FXML
    private Button btnCerrarSesion;
    @javafx.fxml.FXML
    private Label labelTitulo;
    @javafx.fxml.FXML
    private TableView<Pedido> tvPedidos;
    @javafx.fxml.FXML
    private TableColumn<Pedido, String> colIdPedido;
    @javafx.fxml.FXML
    private TableColumn<Pedido, String> colCodPedido;
    @javafx.fxml.FXML
    private TableColumn<Pedido, String> colFecha;
    @javafx.fxml.FXML
    private TableColumn<Pedido, String> colUsuario;
    @javafx.fxml.FXML
    private TableColumn<Pedido, String> colTotal;

    private ObservableList<Pedido> pedidosObservable;

    /**
     * Constructor de la clase VentanaUsuarioController.
     */
    public VentanaUsuarioController(){}

    /**
     * Inicializa la interfaz de usuario y carga los pedidos del usuario actual.
     *
     * @param url             Ubicación relativa del archivo FXML.
     * @param resourceBundle  Recursos utilizados para la inicialización.
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.colIdPedido.setCellValueFactory((fila)->{
            String id = String.valueOf((fila.getValue().getId()));
            return new SimpleStringProperty(id);
        });
        this.colFecha.setCellValueFactory((fila)->{
            String fecha = String.valueOf((fila.getValue().getFecha()));
            return new SimpleStringProperty(fecha);
        });
        this.colCodPedido.setCellValueFactory((fila) -> {
            String codigoPedido = fila.getValue().getCodigo();
            return new SimpleStringProperty(codigoPedido);
        });
        this.colUsuario.setCellValueFactory((fila) -> {
            String usuarioId = String.valueOf(fila.getValue().getUsuarioId());
            return new SimpleStringProperty(usuarioId);
        });
        this.colTotal.setCellValueFactory((fila) -> {
            String total = String.valueOf(fila.getValue().getTotal());
            return new SimpleStringProperty(total);
        });

        this.labelTitulo.setText("Bienvenido, " + Sesion.getUsuario().getNombre());
        this.pedidosObservable = FXCollections.observableArrayList();
        PedidoDAOImp pedidoDAOImp = new PedidoDAOImp(DBConnection.getConnection());
        Sesion.setPedidos(pedidoDAOImp.loadAll(Sesion.getUsuario().getId()));
        this.pedidosObservable.addAll(Sesion.getPedidos());
        this.tvPedidos.setItems(this.pedidosObservable);
        this.tvPedidos.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) ->{
           this.seleccionarPedido(this.tvPedidos.getSelectionModel().getSelectedItem());
        });
    }

    /**
     * Maneja la selección de un pedido en la tabla y carga los detalles del pedido seleccionado.
     *
     * @param pedido Pedido seleccionado.
     */
    private void seleccionarPedido(Pedido pedido) {
        Sesion.setPedido(pedido);
        Sesion.setPos(this.tvPedidos.getSelectionModel().getSelectedIndex());
        Main.loadFXMLDetalles("ventana-pedido.fxml");
    }

    @javafx.fxml.FXML
    public void logout(ActionEvent actionEvent) {
        Sesion.setUsuario(null);
        Main.loadFXMLLogin("ventana-login.fxml");
    }
}
