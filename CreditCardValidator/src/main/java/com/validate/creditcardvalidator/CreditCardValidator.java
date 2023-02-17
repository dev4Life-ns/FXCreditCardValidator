package com.validate.creditcardvalidator;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class CreditCardValidator extends Application {
	public void start(Stage stage) throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(CreditCardValidator.class.getResource("validation-view.fxml"));
		Scene scene = new Scene(fxmlLoader.load(), 607, 482);
		stage.setTitle("Credit Card Validator!");
		stage.setScene(scene);
		stage.show();
	}

	public static void main(String[] args) {
		launch();
	}
}