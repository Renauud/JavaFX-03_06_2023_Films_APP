module com.example.tpguidejavafilms {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.tpguidejavafilms to javafx.fxml;
    exports com.example.tpguidejavafilms;
}