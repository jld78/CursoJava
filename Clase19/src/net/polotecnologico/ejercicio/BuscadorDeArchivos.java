package net.polotecnologico.ejercicio;

import java.awt.EventQueue;

import javax.swing.JFrame;

import java.util.ArrayList;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollBar;

public class BuscadorDeArchivos {

	private JFrame frame;
	private JTextField txtBuscar;
	private JTextArea txtResultado;
	
	private String unidad;
	private final JTextArea textArea = new JTextArea();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BuscadorDeArchivos window = new BuscadorDeArchivos();
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
	public BuscadorDeArchivos() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 595, 309);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		final JComboBox<String> cmbUnidad = new JComboBox<>();
		cmbUnidad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				unidad = cmbUnidad.getSelectedItem().toString();
				System.out.println(unidad);
			}
		});
		cmbUnidad.setBounds(46, 31, 77, 20);
		frame.getContentPane().add(cmbUnidad);
		
		ArrayList<String> unidades = FileUtils.getUnidades();
		for (String string : unidades) {
			cmbUnidad.addItem(string);
		}
		
		unidad = cmbUnidad.getSelectedItem().toString();
		
		System.out.println(unidad);
		
		txtBuscar = new JTextField();
		txtBuscar.setBounds(192, 31, 249, 20);
		frame.getContentPane().add(txtBuscar);
		txtBuscar.setColumns(10);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtResultado.removeAll();
				txtResultado.validate();
//				ArrayList<String> resultado = FileUtils.buscarArchivos(unidad, txtBuscar.getText());
				ArrayList<String> resultado = FileUtils.buscarArchivos("/home/alien", txtBuscar.getText());
				for (String string : resultado) {
					txtResultado.append(string + "\n");
				}
			}
		});
		btnBuscar.setBounds(455, 30, 89, 23);
		frame.getContentPane().add(btnBuscar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(46, 75, 498, 186);
		frame.getContentPane().add(scrollPane);
		
		txtResultado = new JTextArea();
		scrollPane.setViewportView(txtResultado);
		
	}
}
