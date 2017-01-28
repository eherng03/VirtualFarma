package interfazUsuario;


import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;

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
import images.ImagenVF;
import logicaPrograma.Administrador;
import logicaPrograma.Farmacia;
import logicaPrograma.Medico;
import logicaPrograma.Paciente;
import persistencia.BBDDFarmacias;
import persistencia.BBDDMedicos;
import persistencia.BBDDPacientes;
import java.awt.Font;
import java.awt.SystemColor;



/**
 * Ventana que pide usuario y contraseña
 * @author Eva y alba
 *
 */
public class IniciarSesion extends JFrame {

	private static final long serialVersionUID = 1L;
	private StartWindow padre;
	private JPanel contentPane;
	private JPanel logoPanel;
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
		setBounds(100, 100, 584, 671);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(Color.WHITE);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		/*
		 * LOGO
		 */
		logoPanel = new ImagenVF(547, 382);
		logoPanel.setBackground(Color.WHITE);
		logoPanel.setBounds(10, 0, 547, 382);
		contentPane.add(logoPanel);
		
		/*
		 * INICIAR SESION
		 */
	
		
		userField = new JTextField();
		userField.setFont(new Font("Arial", Font.PLAIN, 12));
		userField.setBounds(242, 427, 189, 20);
		contentPane.add(userField);
		userField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(242, 458, 189, 20);
		contentPane.add(passwordField);
		
		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setFont(new Font("Arial", Font.PLAIN, 12));
		lblUsuario.setBounds(156, 430, 76, 14);
		contentPane.add(lblUsuario);
		
		JLabel lblContrasea = new JLabel("Contraseña:");
		lblContrasea.setFont(new Font("Arial", Font.PLAIN, 12));
		lblContrasea.setBounds(156, 461, 76, 14);
		contentPane.add(lblContrasea);
		
		JLabel lblIntroduzcaSuNombre = new JLabel("Introduzca su nombre de usuario y contraseña");
		lblIntroduzcaSuNombre.setFont(new Font("Arial", Font.PLAIN, 12));
		lblIntroduzcaSuNombre.setBounds(10, 396, 275, 20);
		contentPane.add(lblIntroduzcaSuNombre);
		
	/*
	 * AYUDA
	 */
		btnAyuda = new JButton("Ayuda");
		btnAyuda.setBackground(SystemColor.activeCaption);
		btnAyuda.setFont(new Font("Arial", Font.PLAIN, 12));
		btnAyuda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//TODO ayuda
				
			}
		});
		btnAyuda.setBounds(346, 585, 198, 34);
		contentPane.add(btnAyuda);
		
	/*
	 * INICIAR SESION
	 */
		btnIniciarSes = new JButton("Iniciar sesión");
		btnIniciarSes.setBackground(SystemColor.activeCaption);
		btnIniciarSes.setFont(new Font("Arial", Font.PLAIN, 12));
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
		btnIniciarSes.setBounds(156, 501, 275, 34);
		contentPane.add(btnIniciarSes);
		
		JButton btnVolverAtrs = new JButton("Atrás");
		btnVolverAtrs.setBackground(SystemColor.activeCaption);
		btnVolverAtrs.setFont(new Font("Arial", Font.PLAIN, 12));
		btnVolverAtrs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				botonVolver();
			}
		});
		btnVolverAtrs.setBounds(34, 585, 198, 34);
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
				WindowFarmacia ventanaFarmacia = new WindowFarmacia(f1.getCIF(), this);
				ventanaFarmacia.setVisible(true);
				this.setVisible(false);
				break;
			} catch (AlreadyExistException e) {
				javax.swing.JOptionPane.showMessageDialog(null, e.getMessage(), "ERROR", javax.swing.JOptionPane.ERROR_MESSAGE);
			}
			case "Medico":
			try {
				Medico m1 = BBDDMedicos.getInstance().getMedico(user, password);
				WindowMedico ventanaMedico = new WindowMedico(m1.getDNI(), this);
				ventanaMedico.setVisible(true);
				this.setVisible(false);
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