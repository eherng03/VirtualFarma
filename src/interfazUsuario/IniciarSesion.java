package interfazUsuario;


import java.awt.EventQueue;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import excepciones.AlreadyExistException;
import excepciones.EmptyFieldException;
import excepciones.InvalidCIFException;
import excepciones.InvalidCuentaException;
import excepciones.InvalidDNIException;
import excepciones.InvalidNameException;
import excepciones.InvalidPasswordException;
import excepciones.InvalidSSNumberException;
import excepciones.InvalidTelefoneException;
import excepciones.InvalidUserOrPasswordException;
import logicaPrograma.Administrador;
import logicaPrograma.Farmacia;
import logicaPrograma.Medico;
import logicaPrograma.Paciente;
import persistencia.BBDDFarmacias;
import persistencia.BBDDMedicos;
import persistencia.BBDDPacientes;

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
	
	private String user;
	private String password;


	/**
	 * Create the frame.
	 */
	public IniciarSesion(String rol) {
		setResizable(false);
		
		setTitle("Iniciar sesión como " + rol);
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
				try {
					accionIniciarSesion(rol);
				} catch (SQLException e) {
					javax.swing.JOptionPane.showMessageDialog(null, "Ha habido un error en la conexión con la\nbase de datos, disculpe las molestias", "ERROR", javax.swing.JOptionPane.ERROR_MESSAGE);
				}catch(EmptyFieldException | InvalidUserOrPasswordException | InvalidPasswordException | InvalidSSNumberException | InvalidDNIException | InvalidNameException | InvalidCIFException | InvalidCuentaException | InvalidTelefoneException e){
					javax.swing.JOptionPane.showMessageDialog(null, e.getMessage(), "ERROR", javax.swing.JOptionPane.ERROR_MESSAGE);
				}
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
	 * @throws EmptyFieldException 
	 * @throws InvalidUserOrPasswordException 
	 * @throws InvalidNameException 
	 * @throws InvalidDNIException 
	 * @throws InvalidSSNumberException 
	 * @throws InvalidPasswordException 
	 * @throws SQLException 
	 * @throws InvalidTelefoneException 
	 * @throws InvalidCuentaException 
	 * @throws InvalidCIFException 
	 */
	private void accionIniciarSesion(String rol) throws EmptyFieldException, InvalidUserOrPasswordException, SQLException, InvalidPasswordException, InvalidSSNumberException, InvalidDNIException, InvalidNameException, InvalidCIFException, InvalidCuentaException, InvalidTelefoneException {
		user = userField.getText();
		password = String.valueOf(passwordField.getPassword());
		
		switch(rol){
			case "Administrador":
				if(user.equals("") || password.equals("")){
					throw new EmptyFieldException();
				}
				if(Administrador.getAdmin().checkUser(user) && Administrador.getAdmin().checkPassword(password)){
					WindowAdministrador ventanaAdmin = new WindowAdministrador(this);
					ventanaAdmin.setVisible(true);
					this.setVisible(false);
				}else{
					throw new InvalidUserOrPasswordException();
				}
				break;
			case "Paciente":
			Paciente pac;
			try {
				pac = BBDDPacientes.getInstance().getPaciente(user, password);
				WindowPaciente ventanaPac = new WindowPaciente(pac, this);
				ventanaPac.setVisible(true);
				this.setVisible(false);
				break;
			} catch (AlreadyExistException e) {
				javax.swing.JOptionPane.showMessageDialog(null, e.getMessage(), "ERROR", javax.swing.JOptionPane.ERROR_MESSAGE);
			}
			case "Farmacia":
			try {
				Farmacia f1 = BBDDFarmacias.getInstance().getFarmacia(user, password);
				//TODO Abrir la ventana de farmacia
				break;
			} catch (AlreadyExistException e) {
				javax.swing.JOptionPane.showMessageDialog(null, e.getMessage(), "ERROR", javax.swing.JOptionPane.ERROR_MESSAGE);
			}
			case "Medico":
			try {
				Medico m1 = BBDDMedicos.getInstance().getMedico(user, password);
				//TODO abrir la ventana de medico
				break;
			} catch (AlreadyExistException e) {
				javax.swing.JOptionPane.showMessageDialog(null, e.getMessage(), "ERROR", javax.swing.JOptionPane.ERROR_MESSAGE);
			}
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