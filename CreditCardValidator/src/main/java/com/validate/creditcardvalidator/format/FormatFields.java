package com.validate.creditcardvalidator.format;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class FormatFields {


    // method only allows digits to be entered in the text field
    //method works after inputting the wrong contents first time around.
   @FXML
   public void onlyAllowDigits(TextField tempField){
           tempField.textProperty().addListener((observable, oldValue, newValue) -> {
                if (!newValue.matches("^(\\d*){15,16}$")) {
                    tempField.setText(" ");
                }
            });
        /*tempField.setTextFormatter(new TextFormatter<Integer>(change ->
        change.getControlNewText().matches("^(\\d+){15,16}$") ? change : null));*/
    }


}
