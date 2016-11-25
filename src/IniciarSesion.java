

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

public class IniciarSesion extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private StartWindow padre;
	private JPanel contentPane;
	private JTextField userText;
	private JPasswordField passwordField;
	private JButton btnAyuda;
	private JButton btnIniciarSes;
	private boolean admin;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IniciarSesion frame = new IniciarSesion(true);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public IniciarSesion(boolean adminX) {
		
		this.admin = adminX;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 393, 266);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		userText = new JTextField();
		userText.setBounds(136, 64, 189, 20);
		contentPane.add(userText);
		userText.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(136, 95, 189, 20);
		contentPane.add(passwordField);
		
		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setBounds(50, 67, 46, 14);
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
				botonIniciar();
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

	private void botonIniciar() {
		//Comprobar si es user o admin
		//Mirar en dicha tabla a ver si esta bien
		//Si esta bien pasar a la siguinte pantalla
		//Si no que salga un mensaje de error
		
	}

	private void botonVolver() {
		this.padre.setVisible(true);
		this.setVisible(false);
		
	}

	public void setPadre(StartWindow startWindow) {
		this.padre = startWindow;
	}
}