package br.com.alura.challenge;

import javax.swing.JOptionPane;

public class MessageBox {
	 public static void showMessage(String message, String title) {
	        JOptionPane.showMessageDialog(null, message, title, JOptionPane.INFORMATION_MESSAGE);
	 }

     public static void showErrorMessage(String message, String title) {
        JOptionPane.showMessageDialog(null, message, title, JOptionPane.ERROR_MESSAGE);
     }
}
