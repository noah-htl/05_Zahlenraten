package at.htlsaalfelden.zahlenraten;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

import java.net.URL;
import java.util.Objects;
import java.util.Random;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    @FXML
    public TextField numberInput;

    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText(numberInput.getText());
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

    }
}