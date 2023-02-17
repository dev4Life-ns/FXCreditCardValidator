package com.validate.creditcardvalidator;

public class ValidateCard {

	/*  Validate credit card number
	 * implementing Lunh algorithm. Method using IntStream
	 *   and checks card length to determine its type
	 * */
	public boolean lunhCreditCardValidator(String creditCardNumber) {
		var cardLength = creditCardNumber.length() - 1;
		var isSecondDigit = false;
		var sumOfDigits = 0;
		var tempDigit = 0;

		for (int iterate = cardLength; iterate >= 0; iterate--) {
			tempDigit = creditCardNumber.charAt(iterate) - '0';
			if (isSecondDigit)
				tempDigit *= 2;
				sumOfDigits += tempDigit / 10;
				sumOfDigits += tempDigit % 10;
				isSecondDigit = !isSecondDigit;
		}

		return sumOfDigits % 10 == 0;
	}

 }
















