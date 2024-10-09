module at.htlsaalfelden.zahlenraten {
    requires javafx.controls;
    requires javafx.fxml;


    opens at.htlsaalfelden.zahlenraten to javafx.fxml;
    exports at.htlsaalfelden.zahlenraten;
}