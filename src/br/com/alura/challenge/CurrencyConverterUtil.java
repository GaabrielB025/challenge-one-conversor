package br.com.alura.challenge;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

import javax.swing.JOptionPane;

public class CurrencyConverterUtil {
	private static final BigDecimal EXCHANGE_RATE_DOLAR = new BigDecimal("0.2");
	private static final BigDecimal EXCHANGE_RATE_EURO = new BigDecimal("0.19");
	private static final BigDecimal EXCHANGE_RATE_LIBRA_ESTERLINA = new BigDecimal("0.16");
	private static final BigDecimal EXCHANGE_RATE_PESO_ARGENTINO = new BigDecimal("52.84");
	private static final BigDecimal EXCHANGE_RATE_PESO_CHILENO = new BigDecimal("163.15");
	
	private static CurrencyConverter currencyConverter = new CurrencyConverter();
	
	public static void realToDollar(String input, String output) {
		if (input.equals("Real brasileiro") && output.equals("Dólar americano")) {
			BigDecimal valueInput = new BigDecimal(currencyConverter.getInputField().getText());
			
			BigDecimal result = valueInput.multiply(EXCHANGE_RATE_DOLAR);
			JOptionPane.showMessageDialog(null, "Resultado: ");
		}
	}
	
	private static BigDecimal madeConversion(BigDecimal value, BigDecimal currency) {
		return value.multiply(currency);
	}
	
	private static BigDecimal getCurrencyFromInputField() {
		BigDecimal currency = new BigDecimal(currencyConverter.getInputField().getText()); 
		return currency;
	}
	
	private static void setOutputText(BigDecimal value) {
		currencyConverter.getOutputField().setText(String.format("%.3f", value));
	}
}
