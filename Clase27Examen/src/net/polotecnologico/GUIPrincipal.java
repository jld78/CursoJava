package net.polotecnologico;

import java.awt.EventQueue;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JButton;

import net.polotecnologico.dao.DAORegistro;
import net.polotecnologico.dao.DAORegistroException;
import net.polotecnologico.dao.DAORegistroJDBC;
import net.polotecnologico.dao.Registro;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class GUIPrincipal {

	private JFrame frmExportacin;
	private JTextField textArchivoCVS;
	private JTextField textUsuario;
	private JPasswordField passClave;
	private JTextField textServidor;
	File file;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUIPrincipal window = new GUIPrincipal();
					window.frmExportacin.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GUIPrincipal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmExportacin = new JFrame();
		frmExportacin.setTitle("Exportaci\u00F3n");
		frmExportacin.setBounds(100, 100, 450, 202);
		frmExportacin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmExportacin.getContentPane().setLayout(null);
		
		JLabel lblArchivoCVS = new JLabel("Archivo CVS");
		lblArchivoCVS.setBounds(24, 11, 80, 14);
		frmExportacin.getContentPane().add(lblArchivoCVS);
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setBounds(24, 36, 46, 14);
		frmExportacin.getContentPane().add(lblUsuario);
		
		JLabel lblClave = new JLabel("Clave");
		lblClave.setBounds(24, 61, 46, 14);
		frmExportacin.getContentPane().add(lblClave);
		
		JLabel lblServidor = new JLabel("Servidor");
		lblServidor.setBounds(24, 86, 46, 14);
		frmExportacin.getContentPane().add(lblServidor);
		
		textArchivoCVS = new JTextField();
		textArchivoCVS.setBounds(134, 8, 166, 20);
		frmExportacin.getContentPane().add(textArchivoCVS);
		textArchivoCVS.setColumns(10);
		
		textUsuario = new JTextField();
		textUsuario.setBounds(134, 33, 166, 20);
		frmExportacin.getContentPane().add(textUsuario);
		textUsuario.setColumns(10);
		
		passClave = new JPasswordField();
		passClave.setBounds(134, 58, 166, 20);
		frmExportacin.getContentPane().add(passClave);
		passClave.setColumns(10);
		
		textServidor = new JTextField();
		textServidor.setBounds(134, 83, 166, 20);
		frmExportacin.getContentPane().add(textServidor);
		textServidor.setColumns(10);
		
		final JFileChooser fc = new JFileChooser();
		
		JButton btnExaminar = new JButton("Examinar");
		btnExaminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int returnValor = fc.showOpenDialog(null);
				
				if(returnValor == JFileChooser.APPROVE_OPTION){
					file = fc.getSelectedFile();
					textArchivoCVS.setText(file.getAbsolutePath());
				}
			}
		});
		btnExaminar.setBounds(312, 7, 89, 23);
		frmExportacin.getContentPane().add(btnExaminar);
		
		JButton btnMigrar = new JButton("Migrar");
		btnMigrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textArchivoCVS != null && !textArchivoCVS.getText().equals("")){
					if(textUsuario != null && !textUsuario.getText().equals("")){
						if(passClave != null && !passClave.getPassword().toString().equals("")){
							if(textServidor != null && !textServidor.getText().equals("")){
							
								try {
									BufferedReader br = new BufferedReader(new FileReader(file));
									
									String linea;
									while((linea = br.readLine())!=null){
										
										String[] datos = linea.split(",");
										
										int id = Integer.valueOf(datos[0]);
										String nombre = datos[1];
										String apellido = datos[2];
										boolean habilitado = false;
										if(datos.length == 4){
											habilitado = datos[3].equals("true")? true: false;
										}else{
											habilitado = false;
										}
										
										if(habilitado){
											Registro nuevoRegistro = new Registro(id, nombre, apellido, habilitado);
											DAORegistro daoRegistro = new DAORegistroJDBC();
											try {
												daoRegistro.insertarRegistro(nuevoRegistro,textServidor.getText(), textUsuario.getText(), passClave.getPassword());
											} catch (DAORegistroException e1) {
												// TODO Auto-generated catch block
												e1.printStackTrace();
												mostrarError("Error", e1.getMessage());
											}
										}
									}
								} catch (IOException e1) {
									mostrarError("Error", "Error al intentar leer el archivo");
									e1.printStackTrace();
								}
							
							}else{
								mostrarError("Error", "Debe ingresar el servidor");
							}
						}else{
							mostrarError("Error", "Se requiere una clave de acceso");
						}
					}else{
						mostrarError("Error", "Debe ingresar el usuario");
					}
				} else {
					mostrarError("Error", "Debe seleccionar un archivo");
				}
			}
		});
		btnMigrar.setBounds(134, 127, 89, 23);
		frmExportacin.getContentPane().add(btnMigrar);
	}
	
	private void mostrarError(String titulo, String mensaje){
		JOptionPane.showMessageDialog(frmExportacin, mensaje, titulo, JOptionPane.ERROR_MESSAGE);
	}
}
