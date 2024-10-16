module at.htlsaalfelden.zahlenraten {
    requires javafx.fxml;
    requires org.controlsfx.controls;


    opens at.htlsaalfelden.zahlenraten to javafx.fxml;
    exports at.htlsaalfelden.zahlenraten;
}