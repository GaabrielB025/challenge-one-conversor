package br.com.alura.challenge;

import java.awt.EventQueue;

public class Main {

	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {		
			try {
				MainPage launch = new MainPage();				
				launch.frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});

	}

}
