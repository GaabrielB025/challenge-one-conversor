package br.com.alura.challenge;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;

import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;

import br.com.alura.challenge.util.CurrencyConverterUtil;

import javax.swing.JButton;

public class CurrencyConverter {
	
	private JFrame frame;
	protected static JTextField inputField = new JTextField();
	protected static JTextField outputField = new JTextField();

	public CurrencyConverter() {
		initialize();
	}
	
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Conversor de Moeda");
		frame.setVisible(true);
		frame.setBounds(100, 100, 450, 300);
		frame.setSize(650, 320);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblConversorDeMoeda = new JLabel("Conversor de Moeda");
		lblConversorDeMoeda.setFont(new Font("Dialog", Font.BOLD, 25));
		lblConversorDeMoeda.setForeground(Color.BLACK);
		lblConversorDeMoeda.setBounds(194, 12, 264, 35);
		panel.add(lblConversorDeMoeda);
		
		JComboBox<String> boxInput = new JComboBox<>();
		boxInput.setModel(new DefaultComboBoxModel<>(new String[] {"Real brasileiro", "Dólar americano", "Euro",
				"Libra esterlina", "Peso argentino", "Peso chileno"}));
		boxInput.setFont(new Font("Dialog", Font.BOLD, 18));
		boxInput.setBackground(Color.WHITE);
		boxInput.setForeground(Color.BLACK);
		boxInput.setBounds(36, 82, 207, 35);
		panel.add(boxInput);
		
		JComboBox<String> boxOutput = new JComboBox<>();
		boxOutput.setModel(new DefaultComboBoxModel<>(new String[] {"Dólar americano", "Real brasileiro", "Euro",
				"Libra esterlina", "Peso argentino", "Peso chileno"}));
		boxOutput.setFont(new Font("Dialog", Font.BOLD, 18));
		boxOutput.setBackground(Color.WHITE);
		boxOutput.setForeground(Color.BLACK);
		boxOutput.setBounds(393, 82, 207, 35);
		panel.add(boxOutput);
		
		JLabel label = new JLabel("⇄");
		label.setFont(new Font("Dialog", Font.PLAIN, 30));
		label.setBounds(299, 115, 35, 24);
		panel.add(label);
		
		inputField.setFont(new Font("Dialog", Font.PLAIN, 19));
		inputField.setForeground(Color.BLACK);
		inputField.setBounds(36, 144, 211, 36);
		inputField.setColumns(10);
		panel.add(inputField);
		
		JLabel lblNewLabel = new JLabel("De:");
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 15));
		lblNewLabel.setBounds(36, 46, 26, 24);
		panel.add(lblNewLabel);
		
		outputField.setEditable(false);
		outputField.setBounds(393, 144, 211, 36);
		outputField.setForeground(Color.BLACK);
		outputField.setFont(new Font("Dialog", Font.PLAIN, 19));
		panel.add(outputField);
		
		JLabel lblPara = new JLabel("Para:");
		lblPara.setFont(new Font("Dialog", Font.BOLD, 15));
		lblPara.setBounds(558, 49, 42, 18);
		panel.add(lblPara);
		
		JButton btnConverter = new JButton("Converter");
		btnConverter.setFont(new Font("Dialog", Font.BOLD, 15));
		btnConverter.setFocusPainted(false);
		btnConverter.setBorderPainted(false);
		btnConverter.setOpaque(true);
		btnConverter.setBackground(new Color(59, 89, 152));
		btnConverter.setForeground(Color.WHITE);
		btnConverter.setBounds(261, 230, 132, 31);
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
			String input = (String) boxInput.getSelectedItem();
			String output = (String) boxOutput.getSelectedItem();
			
			CurrencyConverterUtil.convertCurrency(input, output);
		});
		panel.add(btnConverter);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.setBounds(75, 230, 106, 31);
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
		panel.add(btnLimpar);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setBounds(468, 230, 106, 31);
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
		panel.add(btnVoltar);
	}
	
	protected static double getCurrencyFromInputField() {
		return Double.parseDouble(inputField.getText());
	}
	
	private void clearFields() {
		inputField.setText("");
		outputField.setText("");
	}
}
