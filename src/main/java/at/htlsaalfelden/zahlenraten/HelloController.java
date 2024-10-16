package at.htlsaalfelden.zahlenraten;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import org.controlsfx.control.RangeSlider;

import java.net.URL;
import java.util.Objects;
import java.util.Random;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    @FXML
    public TextField numberInput;
    @FXML
    public Label response;
    @FXML
    public Label versuche;
    @FXML
    public RangeSlider slider;


    private ZahlenRaten zahlenRaten;


    @FXML
    protected void onHelloButtonClick() {
        if(!zahlenRaten.canRun()) {
            return;
        }

        int response = zahlenRaten.checkZahl(Integer.parseInt(numberInput.getText()));
        if(response == 0) {
            this.response.setText(String.format("Korrekt, in %s Versuchen gelöst", zahlenRaten.getUsedVersuche()));
        }

        if(response == 1) {
            this.response.setText("Zu groß");
        }

        if(response == -1) {
            this.response.setText("Zu klein");
        }

        versuche.setText(String.format("%s Versuche verbleibend", zahlenRaten.getVersuche()));

        if(!zahlenRaten.canRun()) {
            numberInput.setEditable(false);
            numberInput.setText("");

            versuche.setText(String.format("Die Zahl war: %d", zahlenRaten.getZahl()));
        } else {
            numberInput.requestFocus();
        }
    }

    public void onKeyTyped(KeyEvent keyEvent) { // Keine Buchstaben erlauben
        if(!Utils.isInt(keyEvent.getCharacter()) &&
           Utils.isPrintable(keyEvent.getCharacter())) {

            keyEvent.consume();
            int l = keyEvent.getCharacter().length();
            numberInput.setText(numberInput.getText().substring(0, numberInput.getText().length() - l));
            numberInput.positionCaret(numberInput.getText().length());
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        zahlenRaten = new ZahlenRaten();
        versuche.setText(String.format("Versuche: %s", zahlenRaten.getVersuche()));

        slider.lowValueProperty().setValue(0);
        slider.highValueProperty().setValue(100);
    }

    public void onGenerate(ActionEvent actionEvent) {
        zahlenRaten.generate((int) slider.lowValueProperty().get(), (int) slider.highValueProperty().get());
        numberInput.setPromptText(String.format("%d-%d", (int) slider.lowValueProperty().get(), (int) slider.highValueProperty().get()));
    }
}