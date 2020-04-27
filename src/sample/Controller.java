package sample;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.geometry.NodeOrientation;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    public TextField messageTextField = new TextField();
    public HBox lowerHBox = new HBox();
    public Button sendButton = new Button();
    public TextArea chatTextArea = new TextArea();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        lowerHBox.setHgrow(messageTextField, Priority.ALWAYS);
        lowerHBox.prefHeightProperty().bind(messageTextField.heightProperty());
        chatTextArea.setFocusTraversable(false);
    }

    public void sendMessage() {
        if (messageTextField.getText().equals("")) return;
        if (!chatTextArea.getText().equals("")) chatTextArea.appendText("\n");
        chatTextArea.appendText("[" + new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date()) + "]\n" + messageTextField.getText());
        messageTextField.setText("");
        messageTextField.requestFocus();
    }

    public void messageTextFieldKeyListener(KeyEvent keyEvent) {
        if (keyEvent.getCode() == KeyCode.ENTER) {
            sendMessage();
        }
    }
}
