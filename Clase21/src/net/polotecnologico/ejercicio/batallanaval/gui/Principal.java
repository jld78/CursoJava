package net.polotecnologico.ejercicio.batallanaval.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;

import net.polotecnologico.ejercicio.batallanaval.Juego;
import javax.swing.JPanel;
import javax.swing.JLabel;

public class Principal {

	private JFrame frmBatallaNaval;
	private static Juego juego = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		juego = Juego.getInstance();
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal window = new Principal();
					window.frmBatallaNaval.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Principal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmBatallaNaval = new JFrame();
		frmBatallaNaval.setTitle("Batalla Naval");
		frmBatallaNaval.setBounds(100, 100, 735, 435);
		frmBatallaNaval.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmBatallaNaval.getContentPane().setLayout(null);
		
		JLabel lblJuego = new JLabel("Juego");
		lblJuego.setBounds(160, 30, 52, 15);
		frmBatallaNaval.getContentPane().add(lblJuego);
		
		JLabel lblControl = new JLabel("Control");
		lblControl.setBounds(521, 30, 70, 15);
		frmBatallaNaval.getContentPane().add(lblControl);
		
		JPanel panelJuego = new JPanel();
		panelJuego.setBounds(43, 57, 300, 300);
		frmBatallaNaval.getContentPane().add(panelJuego);
		
		JPanel panelControl = new JPanel();
		panelControl.setBounds(392, 57, 300, 300);
		frmBatallaNaval.getContentPane().add(panelControl);
		
	}
}
