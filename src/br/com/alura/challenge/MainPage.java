package br.com.alura.challenge;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainPage {
	protected JFrame frame = new JFrame();
	
	public MainPage() {
		inicialize();
	}
	
	public void inicialize() {
		frame = new JFrame();
		frame.setTitle("Conversor");
		frame.setBounds(100, 100, 450, 300);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel mainPanel = new JPanel();
		frame.getContentPane().add(mainPanel, BorderLayout.CENTER);
		mainPanel.setLayout(null);
		
		JLabel lblEscolhaUmaOpo = new JLabel("Escolha uma opção");
		lblEscolhaUmaOpo.setFont(new Font("Poppins Light", Font.BOLD, 16));
		lblEscolhaUmaOpo.setBounds(90, 118, 177, 31);
		mainPanel.add(lblEscolhaUmaOpo);
		
		JComboBox<String> comboBox = new JComboBox<>();
		comboBox.setModel(new DefaultComboBoxModel<>(new String[] {"Conversor de Moeda", "Conversor de Temperatura"}));
		comboBox.setFont(new Font("Poppins Light", Font.BOLD, 15));
		comboBox.setBackground(Color.WHITE);
		comboBox.setForeground(Color.BLACK);
		comboBox.setBounds(90, 158, 261, 31);
		mainPanel.add(comboBox);
		
		JLabel lblConversor = new JLabel("CONVERSOR");
		lblConversor.setFont(new Font("SansSerif", Font.BOLD, 21));
		lblConversor.setBounds(150, 47, 158, 31);
		mainPanel.add(lblConversor);
		
		JButton button = new JButton("Converter");
		button.setFont(new Font("Dialog", Font.BOLD, 13));
		button.setBackground(new Color(59, 89, 152));
		button.setForeground(Color.WHITE);
		button.setFocusPainted(false);
		button.setBorderPainted(false);
		button.setOpaque(true);
		button.addMouseListener(new java.awt.event.MouseAdapter() {
			 public void mouseEntered(java.awt.event.MouseEvent evt) {
			        button.setBackground(new Color(89, 119, 182));
			        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
			    }
			    public void mouseExited(java.awt.event.MouseEvent evt) {
			        button.setBackground(new Color(59, 89, 152));
			        button.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			    }
		});
		button.addActionListener(e -> {	
				String choice = (String) comboBox.getSelectedItem();
					
				if (choice.equals("Conversor de Temperatura")) {
					frame.dispose();
					new TemperatureConverter();
				} else {
					frame.dispose();
					new CurrencyConverter();
				}
		});
		button.setBounds(157, 227, 132, 30);
		mainPanel.add(button);
	}
}
