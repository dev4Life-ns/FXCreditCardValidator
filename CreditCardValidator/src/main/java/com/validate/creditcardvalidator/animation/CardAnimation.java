package com.validate.creditcardvalidator.animation;

import javafx.animation.RotateTransition;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;

public class CardAnimation {

    //  animation for credit card
    //  method to rotate card on Z axis -30 degrees
    @FXML
    public void turnCardToRight(VBox tempBox){
        Duration cardDuration = Duration.millis(2000);
        RotateTransition rotate = new RotateTransition(cardDuration);
        rotate.setToAngle(-25);
        rotate.setAxis(Rotate.Y_AXIS);
        rotate.setCycleCount(2);
        rotate.setAutoReverse(true);
        rotate.setNode(tempBox);
        rotate.play();

    }

    // uncomment and add to mouse exit event to rotate card when mouse enters card
 	@FXML public void cardMouseOverAnimation(MouseEvent mouseEvent, VBox tempBox) {
		    tempBox.setOnMouseEntered(event -> {
			Duration cardDuration = Duration.millis(1000);
			RotateTransition rotate = new RotateTransition(cardDuration);
			rotate.setToAngle(-30);
			rotate.setAxis(Rotate.Y_AXIS);
			rotate.setCycleCount(2);
			rotate.setAutoReverse(true);
			rotate.setNode(tempBox);
			rotate.play();
		});
	}
}
