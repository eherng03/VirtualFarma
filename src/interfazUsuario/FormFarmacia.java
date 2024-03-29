package interfazUsuario;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Window;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.help.HelpSetException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import excepciones.AlreadyExistException;
import excepciones.InvalidCIFException;
import excepciones.InvalidCuentaException;
import excepciones.InvalidNameException;
import excepciones.InvalidPasswordException;
import excepciones.InvalidTelefoneException;
import images.ImagenVF;
import logicaPrograma.Administrador;
import logicaPrograma.Farmacia;
import logicaPrograma.Helper;




public class FormFarmacia extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel logoPanel;
	private JPasswordField passwordField;
	private JTextField textEmail;
	private JTextField textTelefono;
	private JTextField textNombreDueno;
	private JTextField textCuentaBancaria;
	private JTextField textDireccion;
	private JTextField textHorario;
	private JTextField textCIF;
	private JTextField textNombre;
	private Administrador admin;
	private FormFarmacia formFarmacia;
	private Window windowAdministrador;



	/**
	 * Create the frame.
	 */
	public FormFarmacia(Farmacia farmacia, WindowAdministrador windowAdministrador) {
		formFarmacia = this;
		
		admin = Administrador.getAdmin();
		this.windowAdministrador = windowAdministrador;
		
		setResizable(false);
		setTitle("Formulario de datos de farmacia");
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
		if(farmacia == null){
			JLabel lblPassword = new JLabel("Contraseña");
			lblPassword.setFont(new Font("Arial", Font.PLAIN, 12));
			lblPassword.setBounds(10, 593, 89, 14);
			contentPane.add(lblPassword);
			
			passwordField = new JPasswordField();
			passwordField.setBounds(90, 590, 329, 20);
			contentPane.add(passwordField);
		}
		textEmail = new JTextField();
		textEmail.setBounds(66, 565, 353, 20);
		contentPane.add(textEmail);
		textEmail.setColumns(10);
		
		textTelefono = new JTextField();
		textTelefono.setBounds(141, 540, 278, 20);
		contentPane.add(textTelefono);
		textTelefono.setColumns(10);
		
		textNombreDueno = new JTextField();
		textNombreDueno.setBounds(119, 515, 300, 20);
		contentPane.add(textNombreDueno);
		textNombreDueno.setColumns(10);
		
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
		
		if(farmacia != null){
			textEmail.setText(farmacia.getEmail());
			textTelefono.setText(farmacia.getTelefono());
			textNombreDueno.setText(farmacia.getNombreDueno());
			textCuentaBancaria.setText(farmacia.getNumeroCuenta());
			textDireccion.setText(farmacia.getDireccion());
			textHorario.setText(farmacia.getHorario());
			textCIF.setText(farmacia.getCIF());
			textNombre.setText(farmacia.getNombre());
		}
		
		JButton btnAyuda = new JButton("Ayuda");
		btnAyuda.setBackground(SystemColor.activeCaption);
		btnAyuda.setFont(new Font("Arial", Font.PLAIN, 12));
		btnAyuda.setBounds(446, 564, 89, 23);
		contentPane.add(btnAyuda);
		try {
			if(farmacia == null){
					Helper.getInstance().openHelp(btnAyuda, "crear_farmacia");
			}else{
					Helper.getInstance().openHelp(btnAyuda, "editar_farmacia");
			}
		} catch (MalformedURLException | HelpSetException e1) {
			javax.swing.JOptionPane.showMessageDialog(null, "Ha habido un error con el acceso a la\nayuda, disculpe las molestias.", "ERROR", javax.swing.JOptionPane.ERROR_MESSAGE);
		}
		
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBackground(SystemColor.activeCaption);
		btnCancelar.setFont(new Font("Arial", Font.PLAIN, 12));
		btnCancelar.setBounds(446, 468, 89, 23);
		contentPane.add(btnCancelar);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				if(farmacia != null){
					try {
						admin.editarFarmacia(farmacia, textCIF.getText(), textNombre.getText(), textHorario.getText(),
								textDireccion.getText(), textCuentaBancaria.getText(), textNombreDueno.getText(), 
								textTelefono.getText(), textEmail.getText());
						javax.swing.JOptionPane.showMessageDialog(null, "La cuenta ha sido editada con éxito");
						//Vuelve a la ventana anterior
						formFarmacia.setVisible(false);
						windowAdministrador.setVisible(true);
					} catch (SQLException e) {
						javax.swing.JOptionPane.showMessageDialog(null, "Ha habido un error en la conexión con la\nbase de datos, disculpe las molestias", "ERROR", javax.swing.JOptionPane.ERROR_MESSAGE);
					} catch (InvalidPasswordException | AlreadyExistException e) {
						javax.swing.JOptionPane.showMessageDialog(null, e.getMessage(), "ERROR", javax.swing.JOptionPane.ERROR_MESSAGE);
					}
				}else{
					registrarFarmacia();
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
				formFarmacia.setVisible(false);
				windowAdministrador.setVisible(true);
			}
		});
		button.setFont(new Font("Arial", Font.PLAIN, 12));
		button.setBackground(SystemColor.activeCaption);
		button.setBounds(446, 515, 89, 23);
		contentPane.add(button);
	
	
	}
	
	private void registrarFarmacia() {
		try {
			admin.crearFarmacia(textNombre.getText(), textCIF.getText(), textHorario.getText(), textDireccion.getText(), textCuentaBancaria.getText(),
					textNombre.getText(), textTelefono.getText(), textEmail.getText(), String.valueOf(passwordField.getPassword()));
			javax.swing.JOptionPane.showMessageDialog(this, "La farmacia ha sido creada con éxito");
			//Vuelve a la ventana anterior
			formFarmacia.setVisible(false);
			windowAdministrador.setVisible(true);
		} catch (InvalidNameException | InvalidCIFException | InvalidCuentaException | InvalidTelefoneException | InvalidPasswordException | AlreadyExistException e) {
			javax.swing.JOptionPane.showMessageDialog(null, e.getMessage(), "ERROR", javax.swing.JOptionPane.ERROR_MESSAGE);
		} catch (SQLException e) {
			javax.swing.JOptionPane.showMessageDialog(null, "Ha habido un error en la conexión con la\nbase de datos, disculpe las molestias", "ERROR", javax.swing.JOptionPane.ERROR_MESSAGE);
		}
	}
}
