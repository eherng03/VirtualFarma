package interfazUsuario;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import excepciones.EmptyFieldException;
import excepciones.IncorrectDNIException;
import excepciones.IncorrectPasswordException;
import excepciones.IncorrectSSNumberException;
import excepciones.InvalidNameException;
import logicaPrograma.Paciente;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.Font;

public class FormPaciente extends JFrame {

	private JPanel contentPane;
	private StartWindow startWindow;
	private JTextField textNombre;
	private JTextField textApellido1;
	private JTextField textApellido2;
	private JTextField textDNI;
	private JTextField textNumeroSS;
	private JPasswordField passwordField;
	
	/**
	 * Create the frame.
	 */
	public FormPaciente(StartWindow startWindow) {
		
		this.startWindow = startWindow;
		
		setResizable(false);
		
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 386, 274);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.window);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblIntroduzcaLosDatos = new JLabel("Introduzca los datos del nuevo paciente o editelos si este ya existe");
		lblIntroduzcaLosDatos.setFont(new Font("Arial", Font.PLAIN, 11));
		lblIntroduzcaLosDatos.setBounds(10, 11, 414, 14);
		contentPane.add(lblIntroduzcaLosDatos);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNombre.setBounds(10, 36, 46, 14);
		contentPane.add(lblNombre);
		
		JLabel lblPrimerApellido = new JLabel("Primer apellido");
		lblPrimerApellido.setFont(new Font("Arial", Font.PLAIN, 12));
		lblPrimerApellido.setBounds(10, 61, 93, 14);
		contentPane.add(lblPrimerApellido);
		
		JLabel lblSegundoApellido = new JLabel("Segundo apellido");
		lblSegundoApellido.setFont(new Font("Arial", Font.PLAIN, 11));
		lblSegundoApellido.setBounds(10, 86, 93, 14);
		contentPane.add(lblSegundoApellido);
		
		JLabel lblNumeroDeLa = new JLabel("Numero de la seguridad social");
		lblNumeroDeLa.setFont(new Font("Arial", Font.PLAIN, 11));
		lblNumeroDeLa.setBounds(10, 136, 160, 14);
		contentPane.add(lblNumeroDeLa);
		
		JLabel lblDni = new JLabel("DNI");
		lblDni.setFont(new Font("Arial", Font.PLAIN, 11));
		lblDni.setBounds(10, 111, 46, 14);
		contentPane.add(lblDni);
		
		JLabel lblContrasea = new JLabel("Contraseña");
		lblContrasea.setFont(new Font("Arial", Font.PLAIN, 11));
		lblContrasea.setBounds(10, 161, 77, 14);
		contentPane.add(lblContrasea);
		
		textNombre = new JTextField();
		textNombre.setFont(new Font("Arial", Font.PLAIN, 11));
		textNombre.setBounds(66, 33, 264, 20);
		contentPane.add(textNombre);
		textNombre.setColumns(10);
		
		textApellido1 = new JTextField();
		textApellido1.setFont(new Font("Arial", Font.PLAIN, 11));
		textApellido1.setBounds(113, 58, 217, 20);
		contentPane.add(textApellido1);
		textApellido1.setColumns(10);
		
		textApellido2 = new JTextField();
		textApellido2.setFont(new Font("Arial", Font.PLAIN, 11));
		textApellido2.setBounds(113, 83, 217, 20);
		contentPane.add(textApellido2);
		textApellido2.setColumns(10);
		
		textDNI = new JTextField();
		textDNI.setFont(new Font("Arial", Font.PLAIN, 11));
		textDNI.setBounds(45, 108, 285, 20);
		contentPane.add(textDNI);
		textDNI.setColumns(10);
		
		textNumeroSS = new JTextField();
		textNumeroSS.setFont(new Font("Arial", Font.PLAIN, 11));
		textNumeroSS.setBounds(174, 133, 156, 20);
		contentPane.add(textNumeroSS);
		textNumeroSS.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(82, 158, 248, 20);
		contentPane.add(passwordField);
		
		JButton btnAtrs = new JButton("Atrás");
		btnAtrs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				volverAtras();
			}
		});
		btnAtrs.setFont(new Font("Arial", Font.PLAIN, 11));
		btnAtrs.setBounds(10, 189, 89, 23);
		contentPane.add(btnAtrs);
		
		JButton btnAyuda = new JButton("Ayuda");
		btnAyuda.setFont(new Font("Arial", Font.PLAIN, 11));
		btnAyuda.setBounds(126, 189, 89, 23);
		contentPane.add(btnAyuda);
		
		JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.setFont(new Font("Arial", Font.PLAIN, 11));
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				registrarPaciente();
			}
		});
		btnConfirmar.setBounds(241, 189, 89, 23);
		contentPane.add(btnConfirmar);
	}

	protected void registrarPaciente() {
		try {
			Paciente paciente = new Paciente(textNombre.getText() + " " + textApellido1.getText() + " " + textApellido2.getText(), textDNI.getText(), textNumeroSS.getText(), String.valueOf(passwordField.getPassword()));
			javax.swing.JOptionPane.showMessageDialog(this, "Su cuenta ha sido creada con éxito");
		} catch (SQLException e) {
			javax.swing.JOptionPane.showMessageDialog(this, "Ha habido un error en la conexión con la\nbase de datos, disculpe las molestias.", "ERROR", javax.swing.JOptionPane.ERROR_MESSAGE);
		} catch (IncorrectPasswordException e) {
			javax.swing.JOptionPane.showMessageDialog(this, e.getMessage(), "ERROR", javax.swing.JOptionPane.ERROR_MESSAGE);
		}catch (EmptyFieldException e) {
			javax.swing.JOptionPane.showMessageDialog(this, e.getMessage(), "ERROR", javax.swing.JOptionPane.ERROR_MESSAGE);
		}catch (InvalidNameException e) {
			javax.swing.JOptionPane.showMessageDialog(this, e.getMessage(), "ERROR", javax.swing.JOptionPane.ERROR_MESSAGE);
		} catch (IncorrectDNIException e) {
			javax.swing.JOptionPane.showMessageDialog(this, e.getMessage(), "ERROR", javax.swing.JOptionPane.ERROR_MESSAGE);
		} catch (IncorrectSSNumberException e){
			javax.swing.JOptionPane.showMessageDialog(this, e.getMessage(), "ERROR", javax.swing.JOptionPane.ERROR_MESSAGE);
		}
	}

	private void volverAtras() {
		startWindow.setVisible(true);
		this.setVisible(false);
	}
}
