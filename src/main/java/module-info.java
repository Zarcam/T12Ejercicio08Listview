module com.t12ejercicio08listview {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.t12ejercicio08listview to javafx.fxml;
    exports com.t12ejercicio08listview;
}