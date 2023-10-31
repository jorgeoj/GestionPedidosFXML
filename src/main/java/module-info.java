module com.example.gestiondepedidos {
    requires javafx.controls;
    requires javafx.fxml;
    requires lombok;
    requires java.sql;


    opens com.example.gestiondepedidos to javafx.fxml;
    exports com.example.gestiondepedidos;
}