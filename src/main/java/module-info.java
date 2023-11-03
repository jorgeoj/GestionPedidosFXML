module com.example.gestiondepedidos {
    requires javafx.controls;
    requires javafx.fxml;
    requires lombok;
    requires java.sql;


    opens com.example.gestiondepedidos to javafx.fxml;
    exports com.example.gestiondepedidos;
    exports com.example.gestiondepedidos.controllers;
    opens com.example.gestiondepedidos.controllers to javafx.fxml;
    exports com.example.gestiondepedidos.orders;
    opens com.example.gestiondepedidos.orders to javafx.fxml;
}