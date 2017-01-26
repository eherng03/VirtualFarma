package interfazUsuario;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import excepciones.InvalidCIFException;
import excepciones.InvalidCuentaException;
import excepciones.InvalidDNIException;
import excepciones.InvalidNameException;
import excepciones.InvalidPasswordException;
import excepciones.InvalidSSNumberException;
import excepciones.InvalidTelefoneException;
import images.ImagenVF;
import logicaPrograma.Administrador;

import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class FormMedico extends JFrame {

	private JPanel contentPane;
	private JPanel logoPanel;
	private JTextField textDNI;
	private JTextField textNombre;
	private Administrador admin;
	private JTextField textCPF;
	private JTextField textNumeroSS;
	private JPasswordField passwordField;
	private JTextField textCentroMedico;
	private JTextField textDireccion;
	private JTextField textEmail;



	/**
	 * Create the frame.
	 */
	public FormMedico(String cif) {
		admin = Administrador.getAdmin();
		
		setResizable(false);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 584, 671);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(SystemColor.textHighlightText);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		/*
		 * LOGO
		 */
		logoPanel = new ImagenVF(547, 382);
		logoPanel.setBackground(Color.WHITE);
		logoPanel.setBounds(10, 0, 547, 382);
		contentPane.add(logoPanel);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNombre.setBounds(10, 393, 45, 14);
		contentPane.add(lblNombre);
		
		JLabel lblDNI = new JLabel("DNI");
		lblDNI.setFont(new Font("Arial", Font.PLAIN, 12));
		lblDNI.setBounds(10, 418, 46, 14);
		contentPane.add(lblDNI);
		
		textDNI = new JTextField();
		textDNI.setBounds(44, 415, 375, 20);
		contentPane.add(textDNI);
		textDNI.setColumns(10);
		
		textNombre = new JTextField();
		textNombre.setBounds(62, 390, 357, 20);
		contentPane.add(textNombre);
		textNombre.setColumns(10);
		
		JButton btnAyuda = new JButton("Ayuda");
		btnAyuda.setBackground(SystemColor.activeCaption);
		btnAyuda.setFont(new Font("Arial", Font.PLAIN, 12));
		btnAyuda.setBounds(446, 564, 89, 23);
		contentPane.add(btnAyuda);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBackground(SystemColor.activeCaption);
		btnCancelar.setFont(new Font("Arial", Font.PLAIN, 12));
		btnCancelar.setBounds(446, 468, 89, 23);
		contentPane.add(btnCancelar);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				
			}
		});
		btnAceptar.setBackground(SystemColor.activeCaption);
		btnAceptar.setFont(new Font("Arial", Font.PLAIN, 12));
		btnAceptar.setBounds(446, 418, 89, 23);
		contentPane.add(btnAceptar);
		
		JButton button = new JButton("Atras");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				registrarMedico();
			}
		});
		button.setFont(new Font("Arial", Font.PLAIN, 12));
		button.setBackground(SystemColor.activeCaption);
		button.setBounds(446, 515, 89, 23);
		contentPane.add(button);
		
		JLabel lblCpf = new JLabel("CPF");
		lblCpf.setBounds(10, 446, 46, 14);
		contentPane.add(lblCpf);
		
		textCPF = new JTextField();
		textCPF.setBounds(44, 443, 375, 20);
		contentPane.add(textCPF);
		textCPF.setColumns(10);
		
		JLabel lblNumeross = new JLabel("NumeroSS");
		lblNumeross.setBounds(10, 473, 64, 14);
		contentPane.add(lblNumeross);
		
		textNumeroSS = new JTextField();
		textNumeroSS.setBounds(73, 470, 346, 20);
		contentPane.add(textNumeroSS);
		textNumeroSS.setColumns(10);
		
		JLabel lblDireccion = new JLabel("Direccion");
		lblDireccion.setBounds(10, 500, 64, 14);
		contentPane.add(lblDireccion);
		
		JLabel lblEmail = new JLabel("e-mail");
		lblEmail.setBounds(10, 529, 46, 14);
		contentPane.add(lblEmail);
		
		JLabel lblCentroMdico = new JLabel("Centro médico");
		lblCentroMdico.setBounds(10, 560, 76, 14);
		contentPane.add(lblCentroMdico);
		
		JLabel lblContrasea = new JLabel("Contraseña");
		lblContrasea.setBounds(10, 588, 64, 14);
		contentPane.add(lblContrasea);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(80, 585, 339, 20);
		contentPane.add(passwordField);
		
		textCentroMedico = new JTextField();
		textCentroMedico.setBounds(96, 557, 323, 20);
		contentPane.add(textCentroMedico);
		textCentroMedico.setColumns(10);
		
		textDireccion = new JTextField();
		textDireccion.setBounds(68, 498, 351, 20);
		contentPane.add(textDireccion);
		textDireccion.setColumns(10);
		
		textEmail = new JTextField();
		textEmail.setBounds(62, 526, 357, 20);
		contentPane.add(textEmail);
		textEmail.setColumns(10);
	}
	private void registrarMedico() {
		try {
			admin.crearMedico(textNombre.getText(), textDNI.getText(), textNumeroSS.getText(), textDireccion.getText(), textEmail.getText(), textCentroMedico.getText(), String.valueOf(passwordField));
			javax.swing.JOptionPane.showMessageDialog(this, "La cuenta ha sido creada con éxito");
		} catch (InvalidNameException | InvalidDNIException | InvalidSSNumberException | InvalidPasswordException e) {
			javax.swing.JOptionPane.showMessageDialog(this, e.getMessage(), "ERROR", javax.swing.JOptionPane.ERROR_MESSAGE);
		} /*catch (SQLException e) {
			javax.swing.JOptionPane.showMessageDialog(null, "Ha habido un error en la conexión con la\nbase de datos, disculpe las molestias", "ERROR", javax.swing.JOptionPane.ERROR_MESSAGE);
		}*/
	}
}