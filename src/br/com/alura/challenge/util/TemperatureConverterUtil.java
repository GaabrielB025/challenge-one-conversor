package br.com.alura.challenge.util;

import java.math.BigDecimal;

import br.com.alura.challenge.MessageBox;
import br.com.alura.challenge.TemperatureConverter;

public class TemperatureConverterUtil extends TemperatureConverter {
	
	public static void convertTemperature(String input, String output) {
		boolean inputIsEmpty = TemperatureConverter.inputField.getText().isEmpty();
        try {
            BigDecimal temperatura = new BigDecimal(getTemperatureFromInputField());

            if (input.equals(output)) {
                setOutputText(temperatura);
            } else {
                BigDecimal converterTemperature = convert(input, output);
                setOutputText(converterTemperature);
            }
        } catch (NumberFormatException e) {
        	if (inputIsEmpty) {
        		warningMessage();
        	} else {
        		errorMessage();
        	}
        }
    }
	
	private static BigDecimal convert(String input, String output) {
		double temperature = getTemperatureFromInputField();
		switch (input) {
			case "Celsius":
				return convertFromCelsius(output, temperature);
			case "Fahrenheit":
				return convertFromFahrenheit(output, temperature);
			case "Kelvin":
				return convertFromKelvin(output, temperature);
		}
		
		return BigDecimal.ONE;
	}
	
	private static BigDecimal convertFromCelsius(String output, double value) {
		BigDecimal temperature = new BigDecimal(value);
		switch (output) {
			case "Fahrenheit":
				return temperature.multiply(BigDecimal.valueOf(1.8)).add(BigDecimal.valueOf(32));
			case "Kelvin":
				return temperature.add(BigDecimal.valueOf(273.15));
		}
		
		return BigDecimal.ZERO;
	}
	
	private static BigDecimal convertFromFahrenheit(String output, double value) {
		switch (output) {
			case "Celsius":
				return BigDecimal.valueOf((value - 32) * 5/9);
			case "Kelvin":
				return BigDecimal.valueOf((value - 32) * 5/9 + 273.15);
		}
		
		return BigDecimal.ZERO;
	}
	
	private static BigDecimal convertFromKelvin(String output, double value) {
		BigDecimal temperature = new BigDecimal(value);
		switch (output) {
			case "Celsius":
				return temperature.subtract(BigDecimal.valueOf(273.15));
			case "Fahrenheit":
				return BigDecimal.valueOf((value - 273.15) * 9/5 + 32);
		}
		
		return BigDecimal.ZERO;
	}
	
	private static void setOutputText(BigDecimal value) {
	        TemperatureConverter.outputField.setText(String.format("%.2f °", value));
	}
	
	private static void errorMessage() {
		MessageBox.showErrorMessage("Digite apenas números", "Erro de Conversão");
		clearFields();
	}
	
	private static void warningMessage() {
		MessageBox.showMessage("Informe um valor", "Valor não informado");
	}
	
	private static void clearFields() {
		TemperatureConverter.inputField.setText("");
		TemperatureConverter.outputField.setText("");
	}
	
}
