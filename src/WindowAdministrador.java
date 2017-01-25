
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;

public class WindowAdministrador extends JFrame {

	/**
	 * Ventana que se muestra al administrador del programa.
	 * Contendra los métodos para registrar, dar de baja y editar los datos de los médicos y las farmacias, 
	 * y hacer una copia de seguridad
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel logoPanel;
	private Administrador admin;
	

	/**
	 * Create the frame.
	 * @param iniciarSesion 
	 */
	public WindowAdministrador(IniciarSesion iniciarSesion) {
		
		
		admin = new Administrador();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 412, 548);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		/*
		 * LOGO
		 */
		logoPanel = new ImagenVF(394, 257);
		logoPanel.setBackground(Color.WHITE);
		logoPanel.setBounds(0, 0, 394, 257);
		contentPane.add(logoPanel);
		
		JLabel lblFarmacias = new JLabel("Farmacias");
		lblFarmacias.setBounds(81, 268, 69, 14);
		contentPane.add(lblFarmacias);
		
		JLabel lblMdicos = new JLabel("Médicos");
		lblMdicos.setBounds(277, 268, 46, 14);
		contentPane.add(lblMdicos);
		
		JButton btnRegistrarFarmacia = new JButton("Registrar farmacia");
		btnRegistrarFarmacia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				admin.crearFarmacia();
			}
		});
		btnRegistrarFarmacia.setBounds(10, 293, 180, 34);
		contentPane.add(btnRegistrarFarmacia);
		
		JButton btnRegistrarMdico = new JButton("Registrar médico");
		btnRegistrarMdico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				admin.crearMedico();
			}
		});
		btnRegistrarMdico.setBounds(206, 293, 180, 34);
		contentPane.add(btnRegistrarMdico);
		
		JButton btnEditarFarmacia = new JButton("Editar farmacia.");
		btnEditarFarmacia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				admin.editarFarmacia();
			}
		});
		btnEditarFarmacia.setBounds(10, 338, 180, 34);
		contentPane.add(btnEditarFarmacia);
		
		JButton btnEditarMdico = new JButton("Editar médico");
		btnEditarMdico.setBounds(206, 338, 180, 34);
		contentPane.add(btnEditarMdico);
		
		JButton btnEliminarFarmacia = new JButton("Eliminar farmacia");
		btnEliminarFarmacia.setBounds(10, 383, 180, 34);
		contentPane.add(btnEliminarFarmacia);
		
		JButton btnEliminarMdico = new JButton("Eliminar médico");
		btnEliminarMdico.setBounds(206, 383, 180, 34);
		contentPane.add(btnEliminarMdico);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 428, 376, 2);
		contentPane.add(separator);
		
		JButton btnCrearCopiaDe = new JButton("Crear copia de seguridad del sistema");
		btnCrearCopiaDe.setBounds(10, 441, 376, 23);
		contentPane.add(btnCrearCopiaDe);
		
		JButton btnAyuda = new JButton("Ayuda");
		btnAyuda.setBounds(155, 475, 89, 23);
		contentPane.add(btnAyuda);
	}
}