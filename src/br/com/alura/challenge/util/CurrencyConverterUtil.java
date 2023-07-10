package br.com.alura.challenge.util;

import java.math.BigDecimal;

import br.com.alura.challenge.CurrencyConverter;
import br.com.alura.challenge.MessageBox;

public class CurrencyConverterUtil extends CurrencyConverter {
	private static final BigDecimal SAME_VALUE = new BigDecimal("1");
	private static final BigDecimal DOLAR_TO_REAL_EXCHANGE_RATE = new BigDecimal("4.874292");
	private static final BigDecimal REAL_TO_DOLAR_EXCHANGE_RATE = new BigDecimal("0.205158");
	private static final BigDecimal EURO_TO_REAL_EXCHANGE_RATE = new BigDecimal("5.342340");
	private static final BigDecimal REAL_TO_EURO_EXCHANGE_RATE = new BigDecimal("0.187184");
	private static final BigDecimal LIBRA_TO_REAL_EXCHANGE_RATE = new BigDecimal("6.253250");
	private static final BigDecimal REAL_TO_LIBRA_EXCHANGE_RATE = new BigDecimal("0.159917");
	private static final BigDecimal PESO_ARGENTINO_TO_REAL_EXCHANGE_RATE = new BigDecimal("0.018678");
	private static final BigDecimal REAL_TO_PESO_ARGENTINO_EXCHANGE_RATE = new BigDecimal("53.54036");
	private static final BigDecimal PESO_CHILENO_TO_REAL_EXCHANGE_RATE = new BigDecimal("0.006033");
	private static final BigDecimal REAL_TO_PESO_CHILENO_EXCHANGE_RATE = new BigDecimal("165.7525");
	
	public static void convertCurrency(String input, String output) {
		boolean inputIsEmpty = CurrencyConverter.inputField.getText().isEmpty();
		BigDecimal exchangeRate = getExchangeRate(input, output);			
		try {
			BigDecimal valueInput = new BigDecimal(CurrencyConverter.getCurrencyFromInputField());
			BigDecimal result = madeConversion(valueInput, exchangeRate);
			setOutputText(result);
		} catch (NumberFormatException e) {
			if (inputIsEmpty) {
				warningMessage();
			} else {				
				errorMessage();
			}
		}
	}
	
	private static BigDecimal getExchangeRate(String input, String output) {
		if (input.equals(output)) {
			return SAME_VALUE;
		}
        switch (input) {
            case "Real brasileiro":
                switch (output) {
                    case "Dólar americano":
                        return REAL_TO_DOLAR_EXCHANGE_RATE;
                    case "Euro":
                        return REAL_TO_EURO_EXCHANGE_RATE;
                    case "Libra esterlina":
                        return REAL_TO_LIBRA_EXCHANGE_RATE;
                    case "Peso argentino":
                        return REAL_TO_PESO_ARGENTINO_EXCHANGE_RATE;
                    case "Peso chileno":
                        return REAL_TO_PESO_CHILENO_EXCHANGE_RATE;
                }
                break;
            case "Dólar americano":
                switch (output) {
                    case "Real brasileiro":
                        return DOLAR_TO_REAL_EXCHANGE_RATE;
                }
                break;
            case "Euro":
                switch (output) {
                    case "Real brasileiro":
                        return EURO_TO_REAL_EXCHANGE_RATE;
                }
                break;
            case "Libra esterlina":
                switch (output) {
                    case "Real brasileiro":
                        return LIBRA_TO_REAL_EXCHANGE_RATE;
                }
                break;
            case "Peso argentino":
                switch (output) {
                    case "Real brasileiro":
                        return PESO_ARGENTINO_TO_REAL_EXCHANGE_RATE;
                }
                break;
            case "Peso chileno":
                switch (output) {
                    case "Real brasileiro":
                        return PESO_CHILENO_TO_REAL_EXCHANGE_RATE;
                }
                break;
        }
        return null;
    }
	
	private static void errorMessage() {
		MessageBox.showErrorMessage("Digite apenas números", "Erro de Conversão");
		clearFields();
	}
	
	private static void warningMessage() {
		MessageBox.showMessage("Informe um valor", "Valor não informado");
	}
	
	private static void clearFields() {
		CurrencyConverter.inputField.setText("");
		CurrencyConverter.outputField.setText("");
	}
	
	private static BigDecimal madeConversion(BigDecimal value, BigDecimal currency) {
		return value.multiply(currency);
	}
	
	private static void setOutputText(BigDecimal value) {
		CurrencyConverter.outputField.setText(String.format("%.2f", value));
	}
}
