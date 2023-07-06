package br.com.alura.challenge;

import javax.swing.JOptionPane;

public class CurrencyUtilTest {
	private static final double EXCHANGE_RATE_DOLAR = 0.2;
	
	CurrencyConverter currency1 = new CurrencyConverter();
	
	public void realToDollar(String input, String output) {
		if (input.equals("Real brasileiro") && output.equals("Dólar americano")) {
			double inputValue = getCurrencyFromInputField();
//			double result = madeConversion(inputValue, EXCHANGE_RATE_DOLAR);
			int value = 19;
			JOptionPane.showMessageDialog(null, "Resultado: ");
//			setOutputText(result);
		}
	}
	
	public void show() {
		JOptionPane.showMessageDialog(null, "Teste");
	}
	
	private double madeConversion(double value, double currency) {
		return value * currency;
	}
	
	private double getCurrencyFromInputField() {
		return Double.parseDouble(currency1.inputField.getText());
	}
	
//	private void setOutputText(double value) {
//		getOutputField().setText(String.format("%.3f", value));
//	}
}
