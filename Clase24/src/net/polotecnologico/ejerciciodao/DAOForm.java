package net.polotecnologico.ejerciciodao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTabbedPane;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JTextPane;

public class DAOForm {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DAOForm window = new DAOForm();
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
	public DAOForm() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 659, 428);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		frame.getContentPane().add(tabbedPane);
		
		JPanel panelUsuario = new JPanel();
		tabbedPane.addTab("CRUD", null, panelUsuario, null);
		panelUsuario.setLayout(null);
		
		JLabel lblId = new JLabel("Id:");
		lblId.setBounds(10, 11, 46, 14);
		panelUsuario.add(lblId);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(10, 36, 46, 14);
		panelUsuario.add(lblNombre);
		
		JLabel lblClave = new JLabel("Clave:");
		lblClave.setBounds(10, 61, 46, 14);
		panelUsuario.add(lblClave);
		
		textField = new JTextField();
		textField.setBounds(86, 8, 188, 20);
		panelUsuario.add(textField);
		textField.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setBounds(10, 86, 46, 14);
		panelUsuario.add(lblEmail);
		
		textField_1 = new JTextField();
		textField_1.setBounds(86, 33, 188, 20);
		panelUsuario.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(86, 58, 188, 20);
		panelUsuario.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(86, 83, 188, 20);
		panelUsuario.add(textField_3);
		textField_3.setColumns(10);
		
		JButton btnNuevo = new JButton("Nuevo");
		btnNuevo.setBounds(26, 133, 89, 23);
		panelUsuario.add(btnNuevo);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(140, 133, 89, 23);
		panelUsuario.add(btnBuscar);
		
		JButton btnBorrar = new JButton("Borrar");
		btnBorrar.setBounds(377, 133, 89, 23);
		panelUsuario.add(btnBorrar);
		
		JButton btnActualizar = new JButton("Actualizar");
		btnActualizar.setBounds(265, 133, 89, 23);
		panelUsuario.add(btnActualizar);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(26, 167, 590, 184);
		panelUsuario.add(textPane);
		
		JPanel panelBusqueda = new JPanel();
		tabbedPane.addTab("B\u00FAsqueda", null, panelBusqueda, null);
	}
}
