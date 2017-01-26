

import java.awt.EventQueue;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;

/**
 * Ventana que pide usuario y contraseña
 * @author Eva
 * @author Alba
 *
 */
public class IniciarSesion extends JFrame {

	private static final long serialVersionUID = 1L;
	private StartWindow padre;
	private JPanel contentPane;
	private JTextField userField;
	private JPasswordField passwordField;
	private JButton btnAyuda;
	private JButton btnIniciarSes;
	
	private String rol;
	private String user;
	private String password;


	/**
	 * Create the frame.
	 */
	public IniciarSesion(String flag) {
		
		this.rol = flag;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 393, 266);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		userField = new JTextField();
		userField.setBounds(136, 64, 189, 20);
		contentPane.add(userField);
		userField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(136, 95, 189, 20);
		contentPane.add(passwordField);
		
		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setBounds(50, 67, 76, 14);
		contentPane.add(lblUsuario);
		
		JLabel lblContrasea = new JLabel("Contraseña:");
		lblContrasea.setBounds(50, 98, 76, 14);
		contentPane.add(lblContrasea);
		
		JLabel lblIntroduzcaSuNombre = new JLabel("Introduzca su nombre de usuario y contraseña");
		lblIntroduzcaSuNombre.setBounds(51, 33, 275, 20);
		contentPane.add(lblIntroduzcaSuNombre);
		
	/*
	 * AYUDA
	 */
		btnAyuda = new JButton("Ayuda");
		btnAyuda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				/*
				 * ABRIR LA AYUDA DESDE ESTA PAGINA
				 */
				
			}
		});
		btnAyuda.setBounds(147, 160, 84, 23);
		contentPane.add(btnAyuda);
		
	/*
	 * INICIAR SESION
	 */
		btnIniciarSes = new JButton("Iniciar sesión");
		btnIniciarSes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				accionIniciarSesion();
			}
		});
		btnIniciarSes.setBounds(196, 126, 129, 23);
		contentPane.add(btnIniciarSes);
		
		JButton btnVolverAtrs = new JButton("Volver atrás");
		btnVolverAtrs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				botonVolver();
				
			}
		});
		btnVolverAtrs.setBounds(50, 126, 129, 23);
		contentPane.add(btnVolverAtrs);
	}

	//*************************************METODOS**********************************
	
	/**
	 * Dependiendo del rol seleccionado se buscará el usuario y contraseña en una BBDD determinada
	 */
	private void accionIniciarSesion() {
		user = userField.getText();
		password = passwordField.getPassword().toString();
		
		switch(rol){
			case "admin":
				//Comprobar que usuario y contraseña sean los de admin
				WindowAdministrador ventanaAdmin = new WindowAdministrador(this);
				ventanaAdmin.setVisible(true);
				this.setVisible(false);
				break;
			case "paciente":
				Paciente pac = BBDDPacientes.getPaciente(user, password);
				WindowPaciente ventanaPac = new WindowPaciente(pac, this);
				ventanaPac.setVisible(true);
				this.setVisible(false);
				break;
			case "farmacia":
				Farmacia f1 = BBDDFarmacias.getFarmacia(user, password);
				//Abrir la ventana de farmacia
				break;
			case "medico":
				Medico m1 = BBDDMedicos.getMedico(user, password);
				//abrir la ventana de medico
				break;
		}
		
	}

	private void botonVolver() {
		this.padre.setVisible(true);
		this.setVisible(false);
		
	}

	public void setPadre(StartWindow startWindow) {
		this.padre = startWindow;
	}
}