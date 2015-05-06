package net.polotecnologico.sqlmanager;

import java.awt.EventQueue;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.FlowLayout;

import javax.swing.JTabbedPane;

import java.awt.BorderLayout;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;

public class SQLManager {

	private JFrame frmSqlmaster;
	private JTextField textHost;
	private JTextField textClave;
	private JTextField textUsuario;
	private JTextField textPuerto;
	private JTextField textSQLSentencia;

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
		
		JTabbedPane tabbedPanel = new JTabbedPane(JTabbedPane.TOP);
		frmSqlmaster.getContentPane().add(tabbedPanel);
		
		JPanel panelConn = new JPanel();
		tabbedPanel.addTab("Conexi\u00F3n", null, panelConn, null);
		panelConn.setLayout(null);
		
		textHost = new JTextField();
		textHost.setBounds(142, 11, 178, 20);
		textHost.setColumns(10);
		panelConn.add(textHost);
		
		textClave = new JTextField();
		textClave.setBounds(142, 73, 178, 20);
		textClave.setColumns(10);
		panelConn.add(textClave);
		
		textUsuario = new JTextField();
		textUsuario.setBounds(142, 42, 178, 20);
		textUsuario.setColumns(10);
		panelConn.add(textUsuario);
		
		textPuerto = new JTextField();
		textPuerto.setBounds(142, 104, 178, 20);
		textPuerto.setColumns(10);
		panelConn.add(textPuerto);
		
		JLabel labelHost = new JLabel("Host");
		labelHost.setBounds(45, 14, 22, 14);
		panelConn.add(labelHost);
		
		JLabel labelUsuario = new JLabel("Usuario");
		labelUsuario.setBounds(45, 45, 36, 14);
		panelConn.add(labelUsuario);
		
		JLabel labelClave = new JLabel("Contrase\u00F1a");
		labelClave.setBounds(45, 76, 56, 14);
		panelConn.add(labelClave);
		
		JLabel labelPuerto = new JLabel("Puerto");
		labelPuerto.setBounds(45, 107, 32, 14);
		panelConn.add(labelPuerto);
		
		JButton buttonConectar = new JButton("Conectar");
		buttonConectar.setBounds(46, 181, 77, 23);
		panelConn.add(buttonConectar);
		
		JButton buttonDesconectar = new JButton("Desconectar");
		buttonDesconectar.setEnabled(false);
		buttonDesconectar.setBounds(294, 181, 93, 23);
		panelConn.add(buttonDesconectar);
		
		JPanel panelSQL = new JPanel();
		tabbedPanel.addTab("SQL", null, panelSQL, null);
		panelSQL.setLayout(null);
		
		JTextArea textResultado = new JTextArea();
		textResultado.setBounds(22, 57, 546, 166);
		panelSQL.add(textResultado);
		
		textSQLSentencia = new JTextField();
		textSQLSentencia.setBounds(81, 11, 266, 20);
		panelSQL.add(textSQLSentencia);
		textSQLSentencia.setColumns(10);
		
		JLabel lblSql = new JLabel("SQL");
		lblSql.setBounds(25, 14, 46, 14);
		panelSQL.add(lblSql);
		
		JButton btnEjecutarSql = new JButton("Ejecutar SQL");
		btnEjecutarSql.setBounds(454, 10, 128, 23);
		panelSQL.add(btnEjecutarSql);
		
		JPanel panelLog = new JPanel();
		tabbedPanel.addTab("Log", null, panelLog, null);
		panelLog.setLayout(null);
		
		JTextArea textLog = new JTextArea();
		textLog.setBounds(10, 11, 572, 225);
		panelLog.add(textLog);
	}
}
