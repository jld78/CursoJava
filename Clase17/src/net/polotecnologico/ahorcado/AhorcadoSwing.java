package net.polotecnologico.ahorcado;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import java.awt.GridLayout;

import javax.swing.JPanel;

import java.awt.FlowLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;

public class AhorcadoSwing {

	private JFrame frame;
	private JPanel panelPalabra;
	JPanel panelTeclado;
	
	String palabra;
	 

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AhorcadoSwing window = new AhorcadoSwing();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AhorcadoSwing() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 630, 390);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panelPalabra = new JPanel();
		panelPalabra.setBackground(Color.WHITE);
		panelPalabra.setBounds(216, 45, 394, 47);
		frame.getContentPane().add(panelPalabra);
		panelPalabra.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Jugar");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNuevoJuego = new JMenuItem("Nuevo juego");
		mntmNuevoJuego.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				palabra = "prueba";
				palabra = palabra.toUpperCase();
				generarPalabraAhorcado();
				panelPalabra.validate();
			}
		});
		mnNewMenu.add(mntmNuevoJuego);
		
		JMenuItem mntmAyuda = new JMenuItem("Ayuda");
		menuBar.add(mntmAyuda);
		frame.getContentPane().setLayout(null);
		
		panelTeclado = new JPanel();
		panelTeclado.setBounds(256, 163, 342, 169);
		frame.getContentPane().add(panelTeclado);
		panelTeclado.setLayout(new GridLayout(5, 6, 0, 0));
		
		generarTeclado();
		
		JLabel lblNewLabel = new JLabel("Image");
		lblNewLabel.setBackground(Color.CYAN);
		lblNewLabel.setBounds(28, 47, 170, 203);
		frame.getContentPane().add(lblNewLabel);
		
	}
	
	public class PressTeclado implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			JButton jb = (JButton) e.getSource();
			if(jb.isEnabled()){
				String letra = jb.getText();
				jb.setEnabled(false);
				updateAhorcado(letra, panelPalabra);
			}
		}

	}
	
	private void generarPalabraAhorcado(){
		panelTeclado.removeAll();
		generarTeclado();
		panelTeclado.validate();
		panelPalabra.removeAll();
		if(palabra != null && !palabra.equals("")){
			for(int i=0; i<palabra.length(); i++){
				JLabel jl = new JLabel("_");
				jl.setBounds(0, 0, 500, 100);
				panelPalabra.add(jl);
			}
		}
	}
	
	private void generarTeclado(){
		PressTeclado pt = new PressTeclado();
		for(int i=0; i<26; i++){
			JButton jb = new JButton(String.valueOf((char)(i+65)));
			jb.addActionListener(pt);
			panelTeclado.add(jb);
		}
	}
	
	private void updateAhorcado(String letra, JPanel jp){
		int posicion = 0;
		JLabel jl;
		letra = letra.toUpperCase();
		while(palabra.indexOf(letra, posicion) != (-1)){
			posicion = palabra.indexOf(letra, posicion);
			jl = (JLabel) jp.getComponent(posicion);
			jl.setText(letra);
			posicion++;
		}
		panelPalabra.validate();
	}
}
