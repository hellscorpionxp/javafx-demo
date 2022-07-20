/**
 * @year 2022年
 */
package com.tony;

import java.net.URL;
import java.util.ResourceBundle;

import org.apache.commons.lang3.RandomStringUtils;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;

/**
 * @author tony
 * @createDate 2022年7月20日
 * @version 1.0.0
 *
 */
public class MainController implements Initializable {

  @FXML
  private CheckBox cbNum;
  @FXML
  private CheckBox cbLower;
  @FXML
  private CheckBox cbUpper;
  @FXML
  private CheckBox cbChar;
  @FXML
  private TextField tfLen;
  @FXML
  private Button btnPw;
  @FXML
  private Label lPw;

  @Override
  public void initialize(URL location, ResourceBundle resources) {
  }

  public void generatePassword(ActionEvent event) {
    int len = Integer.parseInt(tfLen.getText());
    boolean lletters = cbLower.isSelected();
    boolean uletters = cbUpper.isSelected();
    boolean numbers = cbNum.isSelected();
    boolean specials = cbChar.isSelected();
    StringBuilder sb = new StringBuilder();
    String str = "abcdefghijklmnopqrstuvwxyz";
    if (lletters) {
      sb.append(str);
    }
    if (uletters) {
      sb.append(str.toUpperCase());
    }
    if (numbers) {
      sb.append("1234567890");
    }
    String pw = "";
    if (specials) {
      pw = RandomStringUtils.randomAscii(len);
    } else {
      pw = RandomStringUtils.random(len, 0, 0, lletters || uletters, numbers, sb.toString().toCharArray());
    }
    lPw.setText(pw);
  }

  public void copyPassword() {
    Clipboard clipboard = Clipboard.getSystemClipboard();
    ClipboardContent content = new ClipboardContent();
    content.putString(lPw.getText());
    clipboard.setContent(content);
    Alert alert = new Alert(AlertType.INFORMATION);
    alert.setContentText("Copied!");
    alert.show();
  }

}
