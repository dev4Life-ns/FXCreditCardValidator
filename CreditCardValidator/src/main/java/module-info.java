module com.validate.creditcardvalidator {
	requires javafx.controls;
	requires javafx.fxml;
	requires org.apache.commons.lang3;



	opens com.validate.creditcardvalidator to javafx.fxml;
	exports com.validate.creditcardvalidator;
}