package interfazUsuario;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.help.HelpSetException;
import javax.swing.JButton;

import excepciones.AlreadyExistException;
import excepciones.EmptyFieldException;
import excepciones.InvalidDNIException;
import excepciones.InvalidPasswordException;
import excepciones.InvalidSSNumberException;
import images.ImagenVF;
import excepciones.InvalidNameException;
import logicaPrograma.Helper;
import logicaPrograma.Paciente;

import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.Font;

public class FormPaciente extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private StartWindow startWindow;
	private JTextField textNombre;
	private JTextField textApellido1;
	private JTextField textApellido2;
	private JTextField textDNI;
	private JTextField textNumeroSS;
	private JPasswordField passwordField;
	private JPanel logoPanel;
	

	public FormPaciente(StartWindow startWindow) {
		
		this.startWindow = startWindow;
		
		setResizable(false);
		setTitle("Formulario de datos de paciente");
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
		
		JLabel lblIntroduzcaLosDatos = new JLabel("Introduzca los datos del nuevo paciente o editelos si este ya existe");
		lblIntroduzcaLosDatos.setFont(new Font("Arial", Font.PLAIN, 12));
		lblIntroduzcaLosDatos.setBounds(20, 413, 414, 14);
		contentPane.add(lblIntroduzcaLosDatos);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNombre.setBounds(20, 438, 46, 14);
		contentPane.add(lblNombre);
		
		JLabel lblPrimerApellido = new JLabel("Primer apellido");
		lblPrimerApellido.setFont(new Font("Arial", Font.PLAIN, 12));
		lblPrimerApellido.setBounds(20, 463, 93, 14);
		contentPane.add(lblPrimerApellido);
		
		JLabel lblSegundoApellido = new JLabel("Segundo apellido");
		lblSegundoApellido.setFont(new Font("Arial", Font.PLAIN, 12));
		lblSegundoApellido.setBounds(20, 488, 93, 14);
		contentPane.add(lblSegundoApellido);
		
		JLabel lblNumeroDeLa = new JLabel("Numero de la seguridad social");
		lblNumeroDeLa.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNumeroDeLa.setBounds(20, 538, 178, 14);
		contentPane.add(lblNumeroDeLa);
		
		JLabel lblDni = new JLabel("DNI");
		lblDni.setFont(new Font("Arial", Font.PLAIN, 12));
		lblDni.setBounds(20, 513, 46, 14);
		contentPane.add(lblDni);
		
		JLabel lblContrasea = new JLabel("Contraseña");
		lblContrasea.setFont(new Font("Arial", Font.PLAIN, 12));
		lblContrasea.setBounds(20, 563, 77, 14);
		contentPane.add(lblContrasea);
		
		textNombre = new JTextField();
		textNombre.setFont(new Font("Arial", Font.PLAIN, 11));
		textNombre.setBounds(76, 435, 481, 20);
		contentPane.add(textNombre);
		textNombre.setColumns(10);
		
		textApellido1 = new JTextField();
		textApellido1.setFont(new Font("Arial", Font.PLAIN, 11));
		textApellido1.setBounds(123, 460, 434, 20);
		contentPane.add(textApellido1);
		textApellido1.setColumns(10);
		
		textApellido2 = new JTextField();
		textApellido2.setFont(new Font("Arial", Font.PLAIN, 11));
		textApellido2.setBounds(123, 485, 434, 20);
		contentPane.add(textApellido2);
		textApellido2.setColumns(10);
		
		textDNI = new JTextField();
		textDNI.setFont(new Font("Arial", Font.PLAIN, 11));
		textDNI.setBounds(55, 510, 502, 20);
		contentPane.add(textDNI);
		textDNI.setColumns(10);
		
		textNumeroSS = new JTextField();
		textNumeroSS.setFont(new Font("Arial", Font.PLAIN, 11));
		textNumeroSS.setBounds(208, 535, 349, 20);
		contentPane.add(textNumeroSS);
		textNumeroSS.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(92, 560, 465, 20);
		contentPane.add(passwordField);
		
		/*
		 * ATRAS
		 */
		JButton btnAtrs = new JButton("Atrás");
		btnAtrs.setBackground(SystemColor.activeCaption);
		btnAtrs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				volverAtras();
			}
		});
		btnAtrs.setFont(new Font("Arial", Font.PLAIN, 13));
		btnAtrs.setBounds(20, 591, 160, 40);
		contentPane.add(btnAtrs);
		
		/*
		 * AYUDA
		 */
		JButton btnAyuda = new JButton("Ayuda");
		btnAyuda.setBackground(SystemColor.activeCaption);
		btnAyuda.setFont(new Font("Arial", Font.PLAIN, 13));
		btnAyuda.setBounds(211, 591, 160, 40);
		contentPane.add(btnAyuda);
		try {
			Helper.getInstance().openHelp(btnAyuda, "crear_paciente");
		} catch (MalformedURLException | HelpSetException e1) {
			javax.swing.JOptionPane.showMessageDialog(null, "Ha habido un error con el acceso a la\nayuda, disculpe las molestias.", "ERROR", javax.swing.JOptionPane.ERROR_MESSAGE);
		}
		
		/*
		 * CONFIRMAR
		 */
		JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.setBackground(SystemColor.activeCaption);
		btnConfirmar.setFont(new Font("Arial", Font.PLAIN, 13));
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				registrarPaciente();
			}
		});
		btnConfirmar.setBounds(397, 591, 160, 40);
		contentPane.add(btnConfirmar);
	}

	private void registrarPaciente() {
		try {
			new Paciente(textNombre.getText() + " " + textApellido1.getText() + " " + textApellido2.getText(), textDNI.getText(), textNumeroSS.getText(), String.valueOf(passwordField.getPassword()), true);
			javax.swing.JOptionPane.showMessageDialog(this, "Su cuenta ha sido creada con éxito");
			this.setVisible(false);
			startWindow.setVisible(true);
		} catch(InvalidPasswordException | EmptyFieldException | InvalidNameException | InvalidDNIException | InvalidSSNumberException | AlreadyExistException e){
			javax.swing.JOptionPane.showMessageDialog(null, e.getMessage(), "ERROR", javax.swing.JOptionPane.ERROR_MESSAGE);
		}catch (SQLException e) {
			javax.swing.JOptionPane.showMessageDialog(this, "Ha habido un error en la conexión con la\nbase de datos, disculpe las molestias.", "ERROR", javax.swing.JOptionPane.ERROR_MESSAGE);
		}
	}

	private void volverAtras() {
		startWindow.setVisible(true);
		this.setVisible(false);
	}
}
