package net.polotecnologico.ejerciciodao;

import java.awt.EventQueue;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;
import net.polotecnologico.ejerciciodao.dao.DAOUsuarioException;
import net.polotecnologico.ejerciciodao.dao.UsuarioDAO;
import net.polotecnologico.ejerciciodao.dao.UsuarioDAOJDBC;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.JRadioButton;

public class DAOForm {

	private JFrame frmDaocrud;
	private JTextArea textResultado;
	private JTextField textId;
	private JTextField textNombre;
	private JPasswordField passClave;
	private JTextField textEmail;
	private JButton btnBuscar;
	private JButton btnActualizar;
	private JButton btnBorrar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DAOForm window = new DAOForm();
					window.frmDaocrud.setVisible(true);
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
		
		final UsuarioDAO uDAO = new UsuarioDAOJDBC();
//		try {
//			uDAO.crearTabla();
//		} catch (SQLException e2) {
//			// TODO Auto-generated catch block
//			e2.printStackTrace();
//		}
		
		frmDaocrud = new JFrame();
		frmDaocrud.setTitle("DAOCrud");
		frmDaocrud.setBounds(100, 100, 659, 428);
		frmDaocrud.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmDaocrud.getContentPane().setLayout(null);
		
		JPanel panelUsuario = new JPanel();
		panelUsuario.setBounds(0, 0, 643, 390);
		frmDaocrud.getContentPane().add(panelUsuario);
		panelUsuario.setLayout(null);
		
		JLabel lblId = new JLabel("Id:");
		lblId.setBounds(10, 11, 46, 14);
		panelUsuario.add(lblId);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(10, 36, 76, 14);
		panelUsuario.add(lblNombre);
		
		JLabel lblClave = new JLabel("Clave:");
		lblClave.setBounds(10, 61, 46, 14);
		panelUsuario.add(lblClave);
		
		textId = new JTextField();
		textId.setBounds(96, 8, 62, 20);
		panelUsuario.add(textId);
		textId.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setBounds(10, 86, 46, 14);
		panelUsuario.add(lblEmail);
		
		textNombre = new JTextField();
		textNombre.setBounds(96, 33, 188, 20);
		panelUsuario.add(textNombre);
		textNombre.setColumns(10);
				
		passClave = new JPasswordField();
		passClave.setBounds(96, 58, 188, 20);
		panelUsuario.add(passClave);
		passClave.setColumns(10);
		
		textEmail = new JTextField();
		textEmail.setBounds(96, 83, 188, 20);
		panelUsuario.add(textEmail);
		textEmail.setColumns(10);
		
		final JButton btnNuevo = new JButton("Nuevo");
		btnNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnNuevo.setEnabled(false);
				btnBuscar.setEnabled(false);
				resetFormulario();
				textId.setEnabled(false);
				textNombre.requestFocusInWindow();
				btnActualizar.setText("Guardar");
				btnActualizar.setEnabled(true);
				btnBorrar.setText("Cancelar");
				btnBorrar.setEnabled(true);
				textNombre.requestFocusInWindow();
			}
		});
		btnNuevo.setBounds(26, 133, 89, 23);
		panelUsuario.add(btnNuevo);
		
		
		final JRadioButton rdbtnPorNombre = new JRadioButton("Por Nombre");
		rdbtnPorNombre.setBounds(485, 28, 109, 23);
		panelUsuario.add(rdbtnPorNombre);
		
		final JRadioButton rdbtnPorId = new JRadioButton("Por Id");
		rdbtnPorId.setBounds(485, 52, 109, 23);
		panelUsuario.add(rdbtnPorId);
		
		ButtonGroup groupBuscar = new ButtonGroup();
		groupBuscar.add(rdbtnPorNombre);
		groupBuscar.add(rdbtnPorId);
		
		rdbtnPorNombre.setSelected(true);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Integer id = null;
				String nombre = null;
				
				textResultado.setText("");	
				
				if(textId.getText() != null && !textId.getText().equals("") && rdbtnPorId.isSelected()){
					id = new Integer(textId.getText());
					Usuario usuario = null;
					try {
						usuario = uDAO.getUsuarioById(id);
					} catch (DAOUsuarioException e1) {
						mostrarError("Error", e1.getMessage());
						e1.printStackTrace();
					}
					if(usuario != null){
						llenarFormulario(usuario);
					}else{
						mostrarError("Bucar", "No se encontró ningún usuario con ese Id");
					}
				}else if(rdbtnPorNombre.isSelected() || textId.getText() != null || !textId.getText().equals("")){
					if(textNombre.getText() == null || textNombre.getText().equals("")){
						nombre = "%";
					}else{
						nombre = textNombre.getText();
					}
					
					ArrayList<Usuario> usuarios = null;
					try {
						usuarios = uDAO.getUsuarioByName(nombre);
					} catch (DAOUsuarioException e1) {
						mostrarError("Error", e1.getMessage());
						e1.printStackTrace();
					}
					if(usuarios.size() > 0){
						if(usuarios.size() == 1){
							llenarFormulario(usuarios.get(0));
							btnActualizar.setText("Actualizar");
							btnBorrar.setEnabled(true);
						}else{
							resetFormulario();
							for (Usuario usuario : usuarios) {
								textResultado.append(
										usuario.getId() +"\t"+
										usuario.getNombre() +"\t"+
										usuario.getEmail() + "\n"
										);
							}
						}
					}else{
						mostrarError("Buscar", "No se encontró ningún usuario con ese Nombre");
					}
				}else{
					mostrarError("Error", "Debe ingresar el Id");
				}
			}
		});
		btnBuscar.setBounds(390, 41, 89, 23);
		panelUsuario.add(btnBuscar);
		
		btnBorrar = new JButton("Borrar");
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int afectados = 0;
				if (btnBorrar.getText().equals("Borrar")) {
					if (Integer.valueOf(textId.getText()) != null) {
						try {
							afectados = uDAO.deleteByID(Integer.valueOf(textId
									.getText()));
						} catch (NumberFormatException e1) {
							e1.printStackTrace();
						} catch (DAOUsuarioException e1) {
							mostrarError("Error", e1.getMessage());
							e1.printStackTrace();
						}
					}
					if (afectados == 0) {
						mostrarError("Error", "No se pudo eliminar");
					}
				}
				resetFormulario();
				btnBorrar.setEnabled(false);
				btnActualizar.setEnabled(false);
				btnNuevo.setEnabled(true);
				btnBuscar.setEnabled(true);
				textId.setEnabled(true);
				textId.requestFocusInWindow();
			}
		});
		btnBorrar.setBounds(257, 133, 89, 23);
		btnBorrar.setEnabled(false);
		panelUsuario.add(btnBorrar);
		
		btnActualizar = new JButton("Actualizar");
		btnActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int afectados = 0;
				String errorMensaje = "Error";
				if ((textNombre == null || textNombre.getText().equals(""))
						|| (passClave == null || passClave.getPassword().toString().equals(""))) {
					mostrarError("Error", errorMensaje);
					return;
				} else {
					if (btnActualizar.getText().equals("Guardar")) {
						errorMensaje = "No se pudo guardar";
						try {
							afectados = uDAO.create(new Usuario(null,
									textNombre.getText(), passClave.getPassword().toString(),
									textEmail.getText()));
						} catch (DAOUsuarioException e1) {
							mostrarError("Error", e1.getMessage());
							e1.printStackTrace();
						}

					}else if(btnActualizar.getText().equals("Actualizar")){
						errorMensaje = "No se pudo actualizar";
						try {
							afectados = uDAO.update(new Usuario(Integer.valueOf(textId.getText()), textNombre.getText(), passClave.getPassword().toString(), textEmail.getText()));
						} catch (DAOUsuarioException e1) {
							mostrarError("Error", e1.getMessage());
							e1.printStackTrace();
						}
					} else {
						errorMensaje = "No se pudo actualizar";
						try {
							afectados = uDAO.update(new Usuario(null,
									textNombre.getText(), passClave.getPassword().toString(),
									textEmail.getText()));
						} catch (DAOUsuarioException e1) {
							mostrarError("Error", e1.getMessage());
							e1.printStackTrace();
						}
					}
				}
				if (afectados == 0) {
					JOptionPane.showMessageDialog(frmDaocrud, errorMensaje, "Error",
							JOptionPane.ERROR_MESSAGE);
				}else{
					JOptionPane.showMessageDialog(frmDaocrud, "Operación exitosa", "Ok",
							JOptionPane.INFORMATION_MESSAGE);
//					btnBorrar.doClick();
					resetFormulario();
					btnBorrar.setEnabled(false);
					btnActualizar.setEnabled(false);
					btnNuevo.setEnabled(true);
					btnBuscar.setEnabled(true);
					textId.setEnabled(true);
					textId.requestFocusInWindow();
				}
			}
		});
		btnActualizar.setBounds(143, 133, 89, 23);
		btnActualizar.setEnabled(false);
		panelUsuario.add(btnActualizar);
		
		textResultado = new JTextArea();
		textResultado.setBounds(26, 167, 590, 212);
		panelUsuario.add(textResultado);

	}
	
	private void resetFormulario(){
		textId.setText("");
		textNombre.setText("");
		passClave.setText("");
		textEmail.setText("");
	}
	
	private void llenarFormulario(Usuario usuario){
		textId.setText(usuario.getId().toString());
		textNombre.setText(usuario.getNombre());
		passClave.setText(usuario.getClave());
		textEmail.setText(usuario.getEmail());
		btnActualizar.setEnabled(true);
		btnBorrar.setEnabled(true);
	}
	
	private void mostrarError(String titulo, String mensaje){
		JOptionPane.showMessageDialog(frmDaocrud, mensaje, titulo, JOptionPane.ERROR_MESSAGE);
	}
}
