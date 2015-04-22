package net.polotecnologico.ahorcado;

import java.awt.EventQueue;

import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.GridLayout;

import javax.swing.JPanel;

import java.awt.FlowLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

public class AhorcadoSwing {

	private static final int MAX_INTENTOS_PERMITIDOS = 6;
	private JFrame frame;
	private JPanel panelPalabra;
	JPanel panelTeclado;
	JLabel lblAhorcado;
	
	int intentos_permitidos = MAX_INTENTOS_PERMITIDOS;
	int intentos = 0;
	static Diccionario diccionario;
	String palabra;
	private static ArrayList<Icon> imagenes;
	 

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		diccionario = new DiccionarioFileSingle();
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
				palabra = diccionario.getPalabra();
				intentos = 0;
				palabra = palabra.toUpperCase();
				generarPalabraAhorcado();
				panelPalabra.validate();
				panelTeclado.setVisible(true);
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
		panelTeclado.setVisible(false);
		
		generarTeclado();
		
		imagenes = new ArrayList<>();
		for (int i = 0; i < 7; i++) {
			imagenes.add(new ImageIcon(AhorcadoSwing.class.getResource("/img/a" + i + ".jpg")));
		}
		
		lblAhorcado = new JLabel("");
		lblAhorcado.setVerticalAlignment(SwingConstants.TOP);
		lblAhorcado.setIcon(imagenes.get(0));
		lblAhorcado.setBackground(Color.CYAN);
		lblAhorcado.setBounds(28, 47, 103, 103);
		frame.getContentPane().add(lblAhorcado);
		
	}
	
	public class PressTeclado implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			JButton jb = (JButton) e.getSource();
			if(jb.isEnabled()){
				String letra = jb.getText();
				jb.setEnabled(false);
				updateAhorcado(letra);
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
	
	private void updateAhorcado(String letra){
		int posicion = 0;
		JLabel jl;
		letra = letra.toUpperCase();
		if(palabra.contains(letra)){
		while(palabra.indexOf(letra, posicion) != (-1)){
			posicion = palabra.indexOf(letra, posicion);
			jl = (JLabel) panelPalabra.getComponent(posicion);
			jl.setText(letra);
			posicion++;
		}}else{
			intentos++;
			lblAhorcado.setIcon(imagenes.get(intentos));
		}
		String resultado = checkResultado();
		if(resultado.equals("GANADOR")){
			JOptionPane.showMessageDialog(frame, "Ganador");
		}else if(resultado.equals("JUEGO_TERMINADO")){
			JOptionPane.showMessageDialog(frame, "Termino el juego");
		};
		panelPalabra.validate();
	}
	
	private String checkResultado(){	
		JLabel jl = new JLabel();
		for (int i=0; i < panelPalabra.getComponentCount(); i++) {
			jl = (JLabel)panelPalabra.getComponent(i);
			if(jl.getText().equals("_")){
				if(intentos < MAX_INTENTOS_PERMITIDOS){
					return "CONTINUAR";
				}else{
					panelTeclado.setVisible(false);
					return "JUEGO_TERMINADO";
				}
			}
		}
		panelTeclado.setVisible(false);
		return "GANADOR";
	}
}
