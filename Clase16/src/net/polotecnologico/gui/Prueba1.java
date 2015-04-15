package net.polotecnologico.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;

public class Prueba1 {

	private JFrame frame;
	private JButton btnBotonazo;
	private JMenuBar menuBar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Prueba1 window = new Prueba1();
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
	public Prueba1() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		btnBotonazo = new JButton("Botonazo!");
		btnBotonazo.setBounds(61, 53, 140, 38);
		frame.getContentPane().add(btnBotonazo);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(95, 120, 64, 38);
		frame.getContentPane().add(lblNewLabel);
		
		menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("New menu item");
		menuBar.add(mntmNewMenuItem);
		
		JMenu mnNewMenu = new JMenu("New menu");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("New menu item");
		mnNewMenu.add(mntmNewMenuItem_4);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("New menu item");
		mnNewMenu.add(mntmNewMenuItem_3);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("New menu item");
		menuBar.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("New menu item");
		menuBar.add(mntmNewMenuItem_2);
	}
}
