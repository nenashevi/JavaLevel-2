package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Font;

import java.awt.*;

public class Controller {
    @FXML
    public TextArea msgList;
    @FXML
    public Button sendMsgBtn;
    @FXML
    public TextField msgField;


    @FXML
    public void sendMsgBtnClick(ActionEvent actionEvent) {
        String msg = msgField.getText();
        msgList.appendText(msg + "\n");
        msgField.clear();
        msgField.requestFocus();
    }
    @FXML
    public void msgFieldClick(ActionEvent actionEvent) {
        String msg = msgField.getText();
        msgList.appendText(msg + "\n");
        msgField.clear();
    }
    @FXML
    public void sendMsgBtnEntered(MouseEvent mouseEvent) {
        sendMsgBtn.setFont(Font.font(13));
    }
    @FXML
    public void sendMsgBtnExited(MouseEvent mouseEvent) {
        sendMsgBtn.setFont(Font.font(12));
    }
}
