package interfazUsuario;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import excepciones.InvalidCIFException;
import excepciones.InvalidCuentaException;
import excepciones.InvalidNameException;
import excepciones.InvalidPasswordException;
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
import java.awt.event.ActionEvent;

public class FormFarmacia extends JFrame {

	private JPanel contentPane;
	private JPanel logoPanel;
	private JPasswordField passwordField;
	private JTextField textEmail;
	private JTextField textTelefono;
	private JTextField textDueno;
	private JTextField textCuentaBancaria;
	private JTextField textDireccion;
	private JTextField textHorario;
	private JTextField textCIF;
	private JTextField textNombre;
	private Administrador admin;



	/**
	 * Create the frame.
	 */
	public FormFarmacia(String cif) {
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
		
		JLabel lblCif = new JLabel("CIF");
		lblCif.setFont(new Font("Arial", Font.PLAIN, 12));
		lblCif.setBounds(10, 418, 46, 14);
		contentPane.add(lblCif);
		
		JLabel lblHorarioDeApertura = new JLabel("Horario de apertura");
		lblHorarioDeApertura.setFont(new Font("Arial", Font.PLAIN, 12));
		lblHorarioDeApertura.setBounds(9, 443, 108, 14);
		contentPane.add(lblHorarioDeApertura);
		
		JLabel lblDireccion = new JLabel("Direccion");
		lblDireccion.setFont(new Font("Arial", Font.PLAIN, 12));
		lblDireccion.setBounds(10, 468, 57, 14);
		contentPane.add(lblDireccion);
		
		JLabel lblNumeroDeCuenta = new JLabel("Numero de cuenta bancaria");
		lblNumeroDeCuenta.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNumeroDeCuenta.setBounds(10, 493, 153, 14);
		contentPane.add(lblNumeroDeCuenta);
		
		JLabel lblNombreDelDueo = new JLabel("Nombre del dueño");
		lblNombreDelDueo.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNombreDelDueo.setBounds(10, 518, 107, 14);
		contentPane.add(lblNombreDelDueo);
		
		JLabel lblTelfonoDeContacto = new JLabel("Teléfono de contacto");
		lblTelfonoDeContacto.setFont(new Font("Arial", Font.PLAIN, 12));
		lblTelfonoDeContacto.setBounds(10, 543, 121, 14);
		contentPane.add(lblTelfonoDeContacto);
		
		JLabel lblEmail = new JLabel("e-mail");
		lblEmail.setFont(new Font("Arial", Font.PLAIN, 12));
		lblEmail.setBounds(10, 568, 46, 14);
		contentPane.add(lblEmail);
		
		JLabel lblPassword = new JLabel("Contraseña");
		lblPassword.setFont(new Font("Arial", Font.PLAIN, 12));
		lblPassword.setBounds(10, 593, 89, 14);
		contentPane.add(lblPassword);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(90, 590, 329, 20);
		contentPane.add(passwordField);
		
		textEmail = new JTextField();
		textEmail.setBounds(66, 565, 353, 20);
		contentPane.add(textEmail);
		textEmail.setColumns(10);
		
		textTelefono = new JTextField();
		textTelefono.setBounds(141, 540, 278, 20);
		contentPane.add(textTelefono);
		textTelefono.setColumns(10);
		
		textDueno = new JTextField();
		textDueno.setBounds(119, 515, 300, 20);
		contentPane.add(textDueno);
		textDueno.setColumns(10);
		
		textCuentaBancaria = new JTextField();
		textCuentaBancaria.setBounds(172, 490, 247, 20);
		contentPane.add(textCuentaBancaria);
		textCuentaBancaria.setColumns(10);
		
		textDireccion = new JTextField();
		textDireccion.setBounds(66, 465, 353, 20);
		contentPane.add(textDireccion);
		textDireccion.setColumns(10);
		
		textHorario = new JTextField();
		textHorario.setBounds(119, 440, 300, 20);
		contentPane.add(textHorario);
		textHorario.setColumns(10);
		
		textCIF = new JTextField();
		textCIF.setBounds(44, 415, 375, 20);
		contentPane.add(textCIF);
		textCIF.setColumns(10);
		
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
			public void actionPerformed(ActionEvent e) {
				if(cif != null){
				
				}
			}
		});
		btnAceptar.setBackground(SystemColor.activeCaption);
		btnAceptar.setFont(new Font("Arial", Font.PLAIN, 12));
		btnAceptar.setBounds(446, 418, 89, 23);
		contentPane.add(btnAceptar);
		
		JButton button = new JButton("Atras");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(cif != null){
					admin.editarFarmacia(null);
				}else{
					try {
						admin.crearFarmacia(textNombre.getText(), textCIF.getText(), textHorario.getText(), textDireccion.getText(), textCuentaBancaria.getText(),
								textNombre.getText(), textTelefono.getText(), textEmail.getText(), String.valueOf(passwordField));
					} catch (InvalidNameException e) {
						javax.swing.JOptionPane.showMessageDialog(null, e.getMessage(), "ERROR", javax.swing.JOptionPane.ERROR_MESSAGE);
					} catch (InvalidCIFException e) {
						javax.swing.JOptionPane.showMessageDialog(null, e.getMessage(), "ERROR", javax.swing.JOptionPane.ERROR_MESSAGE);
					} catch (InvalidCuentaException e) {
						javax.swing.JOptionPane.showMessageDialog(null, e.getMessage(), "ERROR", javax.swing.JOptionPane.ERROR_MESSAGE);
					} catch (InvalidTelefoneException e) {
						javax.swing.JOptionPane.showMessageDialog(null, e.getMessage(), "ERROR", javax.swing.JOptionPane.ERROR_MESSAGE);
					} catch (InvalidPasswordException e) {
						javax.swing.JOptionPane.showMessageDialog(null, e.getMessage(), "ERROR", javax.swing.JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
		button.setFont(new Font("Arial", Font.PLAIN, 12));
		button.setBackground(SystemColor.activeCaption);
		button.setBounds(446, 515, 89, 23);
		contentPane.add(button);
	}
}
