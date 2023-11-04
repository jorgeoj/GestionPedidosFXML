package com.example.gestiondepedidos.controllers;

import com.example.gestiondepedidos.Main;
import com.example.gestiondepedidos.Sesion;
import com.example.gestiondepedidos.domain.DBConnection;
import com.example.gestiondepedidos.item.Item;
import com.example.gestiondepedidos.item.ItemDAOImp;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.net.URL;
import java.util.ResourceBundle;

public class VentanaPedidoController implements Initializable {
    @javafx.fxml.FXML
    private Button btnCerrarSesion;
    @javafx.fxml.FXML
    private TableView tvPedido;
    @javafx.fxml.FXML
    private TableColumn<Item, String> colId;
    @javafx.fxml.FXML
    private TableColumn<Item, String> colCodPedido;
    @javafx.fxml.FXML
    private TableColumn<Item, String> colCantidad;
    @javafx.fxml.FXML
    private TableColumn<Item, String> colProducto;
    @javafx.fxml.FXML
    private Button btnVolver;

    private ObservableList<Item> observableListItem;

    private VentanaPedidoController(){}

    public void initialize(URL url, ResourceBundle resourceBundle){
        this.colId.setCellValueFactory((fila) ->{
            String id = String.valueOf(fila.getValue().getId());
            return new SimpleStringProperty(id);
        });
        this.colCodPedido.setCellValueFactory((fila) -> {
            String cPedido = fila.getValue().getCodigo_pedido();
            return new SimpleStringProperty(cPedido);
        });
        this.colCantidad.setCellValueFactory((fila) -> {
            String cCantidad = String.valueOf(fila.getValue().getCantidad());
            return new SimpleStringProperty(cCantidad);
        });
        this.colProducto.setCellValueFactory((fila) -> {
            String cProducto = String.valueOf(fila.getValue().getProducto_id());
            return new SimpleStringProperty(cProducto);
        });

        this.observableListItem = FXCollections.observableArrayList();
        ItemDAOImp itemDAOImp = new ItemDAOImp(DBConnection.getConnection());
        Sesion.setItems(itemDAOImp.loadAll(Sesion.getPedido().getCodigo()));
        this.observableListItem.addAll(Sesion.getItems());
        this.tvPedido.setItems(this.observableListItem);
    }

    @javafx.fxml.FXML
    public void logout(ActionEvent actionEvent) {
        Sesion.setUsuario(null);
        Main.loadFXMLLogin("ventana-login.fxml");
    }

    @javafx.fxml.FXML
    public void volver(ActionEvent actionEvent) {
        Main.loadFXMLUsuario("ventana-usuario.fxml");
    }
}
