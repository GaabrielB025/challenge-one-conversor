package br.com.alura.challenge;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.print.attribute.AttributeSet;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import javax.swing.JButton;

public class CurrencyConverter {
	
	private JFrame frame;
	JTextField inputField;
	JTextField outputField;

	public CurrencyConverter() {
		initialize();
	}

	
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Conversor de Moeda");
		frame.setVisible(true);
		frame.setBounds(100, 100, 450, 300);
		frame.setSize(650, 320);
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
				"Libras Esterlinas", "Peso argentino", "Peso chileno"}));
		boxInput.setFont(new Font("Dialog", Font.BOLD, 18));
		boxInput.setBackground(Color.WHITE);
		boxInput.setForeground(Color.BLACK);
		boxInput.setBounds(36, 82, 207, 35);
		panel.add(boxInput);
		
		JComboBox<String> boxOutput = new JComboBox<>();
		boxOutput.setModel(new DefaultComboBoxModel<>(new String[] {"Dólar americano", "Real brasileiro", "Euro",
				"Libras Esterlinas", "Peso argentino", "Peso chileno"}));
		boxOutput.setFont(new Font("Dialog", Font.BOLD, 18));
		boxOutput.setBackground(Color.WHITE);
		boxOutput.setForeground(Color.BLACK);
		boxOutput.setBounds(393, 82, 207, 35);
		panel.add(boxOutput);
		
		JLabel label = new JLabel("⇄");
		label.setFont(new Font("Dialog", Font.PLAIN, 30));
		label.setBounds(299, 115, 35, 24);
		panel.add(label);
		
		inputField = new JTextField();
		inputField.setFont(new Font("Dialog", Font.PLAIN, 19));
		inputField.setForeground(Color.BLACK);
		inputField.setBounds(36, 144, 211, 36);
		inputField.setColumns(10);
		panel.add(inputField);
		
		JLabel lblNewLabel = new JLabel("De:");
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 15));
		lblNewLabel.setBounds(36, 46, 26, 24);
		panel.add(lblNewLabel);
		
		outputField = new JTextField();
		outputField.setEditable(false);
		outputField.setBounds(393, 144, 211, 36);
		panel.add(outputField);
		outputField.setColumns(10);
		
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
		btnConverter.setBounds(252, 230, 132, 31);
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
			CurrencyUtilTest currencyUtil = new CurrencyUtilTest();
			String input = (String) boxInput.getSelectedItem();
			String output = (String) boxOutput.getSelectedItem();
			frame.dispose();
			
			currencyUtil.show();
		});
		panel.add(btnConverter);
	}

	public JTextField getInputField() {
		return inputField;
	}
	
	public JTextField getOutputField() {
		return outputField;
	}
}
