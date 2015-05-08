package net.polotecnologico.sqlmanager;

import java.awt.EventQueue;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;

import java.awt.FlowLayout;

import javax.swing.JTabbedPane;

import java.awt.BorderLayout;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.security.Timestamp;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JCheckBox;

import java.awt.Font;

import javax.swing.JPasswordField;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

public class SQLManager {

	private JFrame frmSqlmaster;
	private JTabbedPane tabbedPanel;
	private JTextField textHost;
	private JTextField textUsuario;
	private JTextField textPuerto;
	private JTextField textSQLSentencia;
	private JTextField textBD;
	private JPasswordField passwClave;
	private JTextArea textLog;
	private JTextArea textResultado;
	
	Connection conn = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SQLManager window = new SQLManager();
					window.frmSqlmaster.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SQLManager() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmSqlmaster = new JFrame();
		frmSqlmaster.setTitle("SQLMaster");
		frmSqlmaster.setBounds(100, 100, 613, 313);
		frmSqlmaster.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSqlmaster.getContentPane().setLayout(new BorderLayout(0, 0));
		
		tabbedPanel = new JTabbedPane(JTabbedPane.TOP);
		frmSqlmaster.getContentPane().add(tabbedPanel);
		
		JPanel panelLog = new JPanel();
		
		textLog = new JTextArea();
		textLog.setEditable(false);
		textLog.setLineWrap(true);
		
		JPanel panelConn = new JPanel();
		tabbedPanel.addTab("Conexi\u00F3n", null, panelConn, null);
		panelConn.setLayout(null);
		
		final JButton buttonConectar = new JButton("Conectar");
		final JButton buttonDesconectar = new JButton("Desconectar");
		final JCheckBox chckbxCrearSiNo = new JCheckBox("Crear si no existe");
		
		buttonDesconectar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					conn.close();
					
					buttonDesconectar.setEnabled(false);
					buttonConectar.setEnabled(true);
					textHost.setEnabled(true);
					textUsuario.setEnabled(true);
					passwClave.setEnabled(true);
					textPuerto.setEnabled(true);
					textBD.setEnabled(true);
					chckbxCrearSiNo.setEnabled(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		textHost = new JTextField();
		textHost.setBounds(214, 14, 257, 20);
		textHost.setColumns(10);
		panelConn.add(textHost);
		
		textUsuario = new JTextField();
		textUsuario.setBounds(214, 45, 257, 20);
		textUsuario.setColumns(10);
		panelConn.add(textUsuario);
		
		textPuerto = new JTextField();
		textPuerto.setBounds(214, 107, 76, 20);
		textPuerto.setColumns(10);
		panelConn.add(textPuerto);
		
		JLabel labelHost = new JLabel("Host");
		labelHost.setBounds(45, 14, 56, 14);
		panelConn.add(labelHost);
		
		JLabel labelUsuario = new JLabel("Usuario");
		labelUsuario.setBounds(45, 45, 56, 14);
		panelConn.add(labelUsuario);
		
		JLabel labelClave = new JLabel("Contrase\u00F1a");
		labelClave.setBounds(45, 76, 93, 14);
		panelConn.add(labelClave);
		
		JLabel labelPuerto = new JLabel("Puerto");
		labelPuerto.setBounds(45, 107, 56, 14);
		panelConn.add(labelPuerto);
		
		
		buttonConectar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					Class.forName("org.apache.derby.jdbc.ClientDriver");
					String conexionUrl = "jdbc:derby://" + textHost.getText()
							+ ":" + textPuerto.getText() + "/" + textBD.getText();
					if(chckbxCrearSiNo.isSelected()){
						conexionUrl = conexionUrl + ";create=true";
					}
					conn = DriverManager.getConnection(
							conexionUrl, textUsuario.getText(), passwClave.getPassword().toString());
					buttonConectar.setEnabled(false);
					buttonDesconectar.setEnabled(true);
					textHost.setEnabled(false);
					textUsuario.setEnabled(false);
					passwClave.setEnabled(false);
					textPuerto.setEnabled(false);
					textBD.setEnabled(false);
					chckbxCrearSiNo.setEnabled(false);
					
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					textLog.setText("");
					tabbedPanel.setSelectedIndex(2);
					textLog.setText("No se encontró la libreria de acceso al motor de base de datos");
					e1.printStackTrace();
				} catch (SQLException e1) {
					updateLogPanel(e1.getCause().toString());
				}
			}
		});
		buttonConectar.setBounds(46, 181, 131, 23);
		panelConn.add(buttonConectar);
		
		JLabel lblBaseDeDatos = new JLabel("Base de datos");
		lblBaseDeDatos.setBounds(45, 139, 119, 15);
		panelConn.add(lblBaseDeDatos);
		
		textBD = new JTextField();
		textBD.setBounds(214, 139, 257, 19);
		panelConn.add(textBD);
		textBD.setColumns(10);
		
		
		chckbxCrearSiNo.setFont(new Font("Dialog", Font.PLAIN, 10));
		chckbxCrearSiNo.setBounds(478, 136, 114, 23);
		panelConn.add(chckbxCrearSiNo);
		
		passwClave = new JPasswordField();
		passwClave.setBounds(214, 77, 257, 19);
		panelConn.add(passwClave);
		buttonDesconectar.setEnabled(false);
		buttonDesconectar.setBounds(293, 181, 131, 23);
		panelConn.add(buttonDesconectar);
		
		JPanel panelSQL = new JPanel();
		tabbedPanel.addTab("SQL", null, panelSQL, null);
		panelSQL.setLayout(null);
		
		textResultado = new JTextArea();
		textResultado.setBounds(22, 57, 546, 166);
		panelSQL.add(textResultado);
		
		textSQLSentencia = new JTextField();
		textSQLSentencia.setBounds(81, 11, 340, 20);
		panelSQL.add(textSQLSentencia);
		textSQLSentencia.setColumns(10);
		
		JLabel lblSql = new JLabel("SQL");
		lblSql.setBounds(25, 14, 46, 14);
		panelSQL.add(lblSql);
		
		JButton btnEjecutarSql = new JButton("Ejecutar SQL");
		btnEjecutarSql.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sentencia =textSQLSentencia.getText().toLowerCase();
				if(sentencia.contains("select")){
					try {
						ArrayList<String[]> arrayList = new ArrayList<>(); 
						arrayList = DBHelper.selectConsulta(conn, sentencia);
						updateResultadoPanel(arrayList, "Registros obtenidos/n");
						updateLogPanel("");
					} catch (SQLException e1) {
						e1.printStackTrace();
						updateLogPanel(e1.getCause().toString());
					}
				}else{
					try {
						int i = DBHelper.updateConsulta(conn, sentencia);
						if(sentencia.contains("update")){
							updateResultadoPanel(null, "Se actualizaron " + i + " registros");
						}else if(sentencia.contains("insert")){
							updateResultadoPanel(null, "Se insertaron " + i + " registros");
						}else if(sentencia.contains("delete")){
							updateResultadoPanel(null, "Se eliminaron " + i + " elementos");
						}else if(sentencia.contains("create")){
							updateResultadoPanel(null, "Se crearon " + i + " elementos");
						}
						updateLogPanel("");
					} catch (SQLException e1) {
						e1.printStackTrace();
						updateLogPanel(e1.getCause().toString());
					}
				}
				
			}
		});
		btnEjecutarSql.setBounds(454, 10, 128, 23);
		panelSQL.add(btnEjecutarSql);
		
		tabbedPanel.addTab("Log", null, panelLog, null);
		panelLog.setLayout(null);
		
		textLog.setBounds(10, 11, 572, 225);
		panelLog.add(textLog);
	}
	
	private void updateLogPanel(String mensaje){
		textLog.setText("");
		if(!mensaje.equals("") && mensaje != null){
			tabbedPanel.setSelectedIndex(2);
		}
		try{
			mensaje = mensaje.substring(0, mensaje.indexOf("'")) + mensaje.substring(mensaje.indexOf("'", mensaje.indexOf("'")+1)+1, mensaje.length());
		}catch(Exception ex){
			ex.getStackTrace();
		}
		textLog.setText(mensaje);
	}
	
	private void updateResultadoPanel(ArrayList<String[]> arrayList, String mensaje){
		textResultado.setText("");
		boolean bandera = true;
		if(arrayList == null){
			textResultado.setText(mensaje);
		}else{
			for (String[] fila : arrayList) {
				for (String columna : fila) {
					textResultado.append(columna + "\t");
				}
				textResultado.append("\n");
				
				if(bandera){
					for (String columna : fila) {
						textResultado.append("--------------------" + "\t");
					}
					textResultado.append("\n");
					bandera = false;
				}
			}
		}
	}
}
