package br.com.alura.challenge;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class TemperatureConverter {
	JFrame frame = new JFrame();
	private JTextField inputField = new JTextField();
	private JTextField outputField = new JTextField(); 
	
	public TemperatureConverter() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Conversor de Temperatura");
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBackground(new Color(238, 238, 236));
		frame.getContentPane().add(desktopPane, BorderLayout.CENTER);
		
		JLabel lblConversor = new JLabel("Conversor de Temperaturas");
		lblConversor.setFont(new Font("Inter Semi Bold", Font.PLAIN, 20));
		lblConversor.setBounds(83, 12, 288, 43);
		desktopPane.add(lblConversor);
		
		inputField.setHorizontalAlignment(SwingConstants.CENTER);
		inputField.setFont(new Font("Dialog", Font.PLAIN, 19));
		inputField.setText("0");
		inputField.setBounds(22, 112, 132, 43);
		inputField.setForeground(Color.BLACK);
		desktopPane.add(inputField);
		
		JTextArea textArea = new JTextArea();
		textArea.setBackground(new Color(238, 238, 236));
		textArea.setEditable(false);
		textArea.setFont(new Font("Dialog", Font.PLAIN, 30));
		textArea.setText("=");
		textArea.setBounds(212, 125, 19, 37);
		desktopPane.add(textArea);
		
		outputField.setEditable(false);
		outputField.setText("0");
		outputField.setHorizontalAlignment(SwingConstants.CENTER);
		outputField.setFont(new Font("Dialog", Font.PLAIN, 19));
		outputField.setBounds(285, 112, 132, 43);
		outputField.setForeground(Color.BLACK);
		desktopPane.add(outputField);
		
		JComboBox<String> comboBoxInput = new JComboBox<>();
		comboBoxInput.setModel(new DefaultComboBoxModel<>(new String[] {"Celsius", "Fahrenheit", "Kelvin"}));
		comboBoxInput.setFont(new Font("Dialog", Font.BOLD, 18));
		comboBoxInput.setBackground(Color.WHITE);
		comboBoxInput.setForeground(Color.BLACK);
		comboBoxInput.setBounds(22, 152, 132, 31);
		desktopPane.add(comboBoxInput);
		
		JComboBox<String> comboBoxOut = new JComboBox<>();
		comboBoxOut.setModel(new DefaultComboBoxModel<>(new String[] {"Fahrenheit", "Celsius", "Kelvin"}));
		comboBoxOut.setFont(new Font("Dialog", Font.BOLD, 18));
		comboBoxOut.setBackground(Color.WHITE);
		comboBoxOut.setForeground(Color.BLACK);
		comboBoxOut.setBounds(285, 152, 132, 31);
		desktopPane.add(comboBoxOut);
		
		JButton btnConverter = new JButton("Converter");
		btnConverter.setFont(new Font("Dialog", Font.BOLD, 15));
		btnConverter.setFocusPainted(false);
		btnConverter.setBorderPainted(false);
		btnConverter.setOpaque(true);
		btnConverter.setBackground(new Color(59, 89, 152));
		btnConverter.setForeground(Color.WHITE);
		btnConverter.setBounds(157, 227, 132, 31);
		btnConverter.addMouseListener(new java.awt.event.MouseAdapter() {
			 public void mouseEntered(java.awt.event.MouseEvent evt) {
			        btnConverter.setBackground(new Color(89, 119, 182));
			        btnConverter.setCursor(new Cursor(Cursor.HAND_CURSOR));
			    }
			    public void mouseExited(java.awt.event.MouseEvent evt) {
			    	btnConverter.setBackground(new Color(59, 89, 152));
			    	btnConverter.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			    }
		});
		btnConverter.addActionListener(e -> {
			String input = (String) comboBoxInput.getSelectedItem();
			String output = (String) comboBoxOut.getSelectedItem();
			
			sameTemperature(input, output);
			celsiusToFahrenheit(input, output);
			celsiusToKelvin(input, output);
			fahrenheitToCelsius(input, output);
			fahrenheitToKelvin(input, output);
			kelvinToCelsius(input, output);
			KelvinToFahrenheit(input, output);
		});
		desktopPane.add(btnConverter);
	}
	
	private void sameTemperature(String input, String output) {
		try {			
			if (input.equals(output)) {
				double temperature = getTemperatureFromInputField();
				setOutputText(temperature);
			}
		} catch (NumberFormatException e) {
			messageError();
			clearFields();
		}
	}
	
	private void celsiusToFahrenheit(String input, String output) {
		try {
			if (input.equals("Celsius") && output.equals("Fahrenheit")) {
				double temperatura = getTemperatureFromInputField();
				double fahrenheit = temperatura * 1.8 + 32;
				setOutputText(fahrenheit);
			}
		} catch (NumberFormatException e) {
			messageError();
			clearFields();
		}
	}
	
	private void celsiusToKelvin(String input, String output) {
		try {
			if (input.equals("Celsius") && output.equals("Kelvin")) {
				double temperatura = getTemperatureFromInputField();
				double kelvin = temperatura + 273.15;				
				setOutputText(kelvin);
			}	
		} catch (NumberFormatException e) {
			messageError();
			clearFields();
		}
	}
	
	private void fahrenheitToCelsius(String input, String output) {
		try {
			if (input.equals("Fahrenheit") && output.equals("Celsius")) {
				double temperatura = getTemperatureFromInputField();
				double celsius = (temperatura - 32) * 5/9;
				setOutputText(celsius);
			}
		} catch (NumberFormatException e) {
			messageError();
			clearFields();
		}
	}
	
	private void fahrenheitToKelvin(String input, String output) {
		try {
			if (input.equals("Fahrenheit") && output.equals("Kelvin")) {
				double temperatura = getTemperatureFromInputField();
				double kelvin = (temperatura - 32)* 5/9 + 273.15;
				setOutputText(kelvin);
			}
		} catch (NumberFormatException e) {
			messageError();
			clearFields();
		}
	}
	
	private void kelvinToCelsius(String input, String output) {
		try {
			if (input.equals("Kelvin") && output.equals("Celsius")) {
				double temperatura = getTemperatureFromInputField();
				double celsius = temperatura - 273.15;
				setOutputText(celsius);	
			}
		} catch (NumberFormatException e) {
			messageError();
			clearFields();
		}
	}
	
	private void KelvinToFahrenheit(String input, String output) {
		try {
			if (input.equals("Kelvin") && output.equals("Fahrenheit")) {
				double temperatura = getTemperatureFromInputField();
				double fahrenheit = (temperatura - 273.15) * 1.8 + 32;
				
				setOutputText(fahrenheit);
			}
		} catch (NumberFormatException e) {
			messageError();
			clearFields();
		}
	}
	
	private void messageError() {
		JOptionPane.showMessageDialog(JOptionPane.getRootFrame(), "Digite apenas números!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
	}
	
	private double getTemperatureFromInputField() {
		return Double.parseDouble(inputField.getText());
	}
	
	private void setOutputText(double value) {
		outputField.setText(String.format("%.2f °", value));
	}
	
	private void clearFields() {
		inputField.setText("0");
		outputField.setText("0");
	}
}
