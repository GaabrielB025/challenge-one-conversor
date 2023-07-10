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
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import br.com.alura.challenge.util.TemperatureConverterUtil;

public class TemperatureConverter {
	JFrame frame = new JFrame();
	protected static JTextField inputField = new JTextField();
	protected static JTextField outputField = new JTextField();
	
	public TemperatureConverter() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Conversor de Temperatura");
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setBounds(100, 100, 450, 300);
		frame.setSize(650, 320);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBackground(new Color(238, 238, 236));
		frame.getContentPane().add(desktopPane, BorderLayout.CENTER);
		
		JLabel lblConversor = new JLabel("Conversor de Temperaturas");
		lblConversor.setFont(new Font("Dialog", Font.BOLD, 25));
		lblConversor.setBounds(153, 12, 354, 43);
		desktopPane.add(lblConversor);
		
		inputField.setHorizontalAlignment(SwingConstants.CENTER);
		inputField.setFont(new Font("Dialog", Font.PLAIN, 19));
		inputField.setText("0");
		inputField.setBounds(33, 112, 185, 43);
		inputField.setForeground(Color.BLACK);
		desktopPane.add(inputField);
		
		JTextArea textArea = new JTextArea();
		textArea.setBackground(new Color(238, 238, 236));
		textArea.setEditable(false);
		textArea.setFont(new Font("Dialog", Font.PLAIN, 30));
		textArea.setText("=");
		textArea.setBounds(306, 131, 19, 37);
		desktopPane.add(textArea);
		
		outputField.setEditable(false);
		outputField.setText("0");
		outputField.setHorizontalAlignment(SwingConstants.CENTER);
		outputField.setFont(new Font("Dialog", Font.PLAIN, 19));
		outputField.setBounds(417, 112, 185, 43);
		outputField.setForeground(Color.BLACK);
		desktopPane.add(outputField);
		
		JComboBox<String> comboBoxInput = new JComboBox<>();
		comboBoxInput.setModel(new DefaultComboBoxModel<>(new String[] {"Celsius", "Fahrenheit", "Kelvin"}));
		comboBoxInput.setFont(new Font("Dialog", Font.BOLD, 18));
		comboBoxInput.setBackground(Color.WHITE);
		comboBoxInput.setForeground(Color.BLACK);
		comboBoxInput.setBounds(33, 152, 185, 43);
		desktopPane.add(comboBoxInput);
		
		JComboBox<String> comboBoxOut = new JComboBox<>();
		comboBoxOut.setModel(new DefaultComboBoxModel<>(new String[] {"Fahrenheit", "Celsius", "Kelvin"}));
		comboBoxOut.setFont(new Font("Dialog", Font.BOLD, 18));
		comboBoxOut.setBackground(Color.WHITE);
		comboBoxOut.setForeground(Color.BLACK);
		comboBoxOut.setBounds(417, 152, 185, 43);
		desktopPane.add(comboBoxOut);
		
		JButton btnConverter = new JButton("Converter");
		btnConverter.setFont(new Font("Dialog", Font.BOLD, 15));
		btnConverter.setFocusPainted(false);
		btnConverter.setBorderPainted(false);
		btnConverter.setOpaque(true);
		btnConverter.setBackground(new Color(59, 89, 152));
		btnConverter.setForeground(Color.WHITE);
		btnConverter.setBounds(253, 229, 132, 31);
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
			
			TemperatureConverterUtil.convertTemperature(input, output);
		});
		desktopPane.add(btnConverter);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.setBounds(60, 229, 112, 31);
		btnLimpar.setFont(new Font("Dialog", Font.BOLD, 15));
		btnLimpar.setFocusPainted(false);
		btnLimpar.setBorderPainted(false);
		btnLimpar.setOpaque(true);
		btnLimpar.setBackground(new Color(59, 89, 152));
		btnLimpar.setForeground(Color.WHITE);
		btnLimpar.addMouseListener(new java.awt.event.MouseAdapter() {
			 public void mouseEntered(java.awt.event.MouseEvent evt) {
				 	btnLimpar.setBackground(new Color(89, 119, 182));
				 	btnLimpar.setCursor(new Cursor(Cursor.HAND_CURSOR));
			    }
			    public void mouseExited(java.awt.event.MouseEvent evt) {
			    	btnLimpar.setBackground(new Color(59, 89, 152));
			    	btnLimpar.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			    }
		});
		btnLimpar.addActionListener(e -> {
			clearFields();
		});
		desktopPane.add(btnLimpar);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setBounds(471, 229, 112, 28);
		btnVoltar.setFont(new Font("Dialog", Font.BOLD, 15));
		btnVoltar.setFocusPainted(false);
		btnVoltar.setBorderPainted(false);
		btnVoltar.setOpaque(true);
		btnVoltar.setBackground(new Color(59, 89, 152));
		btnVoltar.setForeground(Color.WHITE);
		btnVoltar.addMouseListener(new java.awt.event.MouseAdapter() {
			 public void mouseEntered(java.awt.event.MouseEvent evt) {
				 	btnVoltar.setBackground(new Color(89, 119, 182));
				 	btnVoltar.setCursor(new Cursor(Cursor.HAND_CURSOR));
			    }
			    public void mouseExited(java.awt.event.MouseEvent evt) {
			    	btnVoltar.setBackground(new Color(59, 89, 152));
			    	btnVoltar.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			    }
		});
		btnVoltar.addActionListener(e -> {
			frame.dispose();
			MainPage launch = new MainPage();
			launch.frame.setVisible(true);
		});
		desktopPane.add(btnVoltar);
	}

	
	protected static double getTemperatureFromInputField() {
		return Double.parseDouble(inputField.getText());
	}
	
	private void clearFields() {
		inputField.setText("");
		outputField.setText("");
	}
}
