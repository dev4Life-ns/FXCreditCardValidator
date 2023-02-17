package com.validate.creditcardvalidator;

import com.validate.creditcardvalidator.animation.CardAnimation;
import com.validate.creditcardvalidator.format.FormatFields;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;


/*
 * Demo application that validates a credit card number using
 * the Luhn algorithm. Luhn algorithm is a simple checksum formula
 * used to validate a variety of identification numbers, such as credit,
 * capable of detecting most single-digit transcription errors. More over
 * this algorithm does not detect certain digit permutations.
 *
 *  */

public class CreditCardValidatorController {
	@FXML Label cardNameLabel;
	@FXML private Label resultLabel;
	@FXML private StackPane creditCardStackPane;
	@FXML TextField cardNumber_tf;
	@FXML ImageView visa;
	@FXML ImageView mastercard;
	@FXML ImageView discover;
	@FXML ImageView american_express;
	@FXML VBox creditCard_Vbox;

	//instantiates classes
	CardAnimation card_animation = new CardAnimation();
	ValidateCard validateCard = new ValidateCard();
	FormatFields formatFields = new FormatFields();



	// method validates credit card against lunhCreditCard Method
	@FXML
	private void validateCardInput() {
		var cardNumber = String.valueOf(cardNumber_tf.getText());
		//method only allows digits to be entered in the text field
		linkToTextField();
		validateCard.lunhCreditCardValidator(cardNumber);
		var results = validateCard.lunhCreditCardValidator(cardNumber) ? "Valid Card Number" : "Invalid Card Number";
		resultLabel.setText(results);
		// check if card number is valid before displaying card type
		if(results.equals("Valid Card Number")){
			displayCardType();
		}
		card_animation.turnCardToRight(creditCard_Vbox);
	}

   @FXML public void linkToTextField(){
	   formatFields.onlyAllowDigits(cardNumber_tf);
   }

    //Substring gets the first digit of the card number and
	//card type is feed through java's new switch expression  returning
	//the corresponding card data followed by the card icon.
	 public void displayCardType(){
		switch (cardNumber_tf.getText().substring(0, 1)) {
			case "5","2" -> {
				cardNameLabel.setText("Mastercard");
				mastercard.setVisible(true);
			}
			case "3" -> {
				cardNameLabel.setText("American Express");
				american_express.setVisible(true);
			}
			case "4" -> {
				cardNameLabel.setText("Visa");
				visa.setVisible(true);
			}
			case "6" -> {
				cardNameLabel.setText("Discover");
				discover.setVisible(true);
			}
		}
	}


	  //resets card fields
     @FXML public void clearInput(ActionEvent ae){
		 cardNumber_tf.setText(" ");
		 cardNumber_tf.setPromptText("0000 0000 0000 0000");
		 cardNameLabel.setText("Card Name");
		 resultLabel.setText(" ");
		 hideCardIcons();
	 }

	@FXML  public void hideCardIcons(){
		creditCardStackPane.getChildren().forEach(node -> node.setVisible(false));
	}

}