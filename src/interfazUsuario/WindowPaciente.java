package interfazUsuario;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import excepciones.InvalidCIFException;
import excepciones.InvalidCuentaException;
import excepciones.InvalidNameException;
import excepciones.InvalidPasswordException;
import excepciones.InvalidTelefoneException;
import images.ImagenVF;
import logicaPrograma.Farmacia;
import logicaPrograma.Paciente;
import persistencia.BBDDFarmacias;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class WindowPaciente extends JFrame {

	private JPanel contentPane;
	private JPanel logoPanel;
	private JButton btnConsultarRecetas;
	private Paciente paciente;
	private IniciarSesion iniciarSesion;
	private WindowPaciente windowPaciente;
	private JButton btnAtrs;


	/**
	 * Create the frame.
	 * @param iniciarSesion 
	 */
	public WindowPaciente(Paciente paciente, IniciarSesion iniciarSesion) {
		
		this.iniciarSesion = iniciarSesion;
		this.paciente = paciente;
		windowPaciente = this;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 584, 671);
		contentPane = new JPanel();		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new Color(255, 255, 255));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		setResizable(false);
		
		/*
		 * LOGO
		 */
		logoPanel = new ImagenVF(547, 382);
		logoPanel.setBackground(Color.WHITE);
		logoPanel.setBounds(10, 0, 547, 382);
		contentPane.add(logoPanel);
		
		JButton btnShowChemistry = new JButton("Ver lista de farmacias y/o \r\ndisponibilidad de un medicamento");
		btnShowChemistry.setFont(new Font("Arial", Font.PLAIN, 12));
		btnShowChemistry.setBackground(SystemColor.activeCaption);
		btnShowChemistry.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ListadoFarmacias lista = new ListadoFarmacias(windowPaciente);
				lista.setVisible(true);
				windowPaciente.setVisible(false);
			}
		});
		btnShowChemistry.setBounds(10, 475, 547, 48);
		contentPane.add(btnShowChemistry);
		
		btnConsultarRecetas = new JButton("Consultar recetas");
		btnConsultarRecetas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListadoRecetas lista = new ListadoRecetas(paciente.getDni(), windowPaciente);
				lista.setVisible(true);
				windowPaciente.setVisible(false);
			}
		});
		btnConsultarRecetas.setFont(new Font("Arial", Font.PLAIN, 12));
		btnConsultarRecetas.setBackground(SystemColor.activeCaption);
		btnConsultarRecetas.setBounds(10, 416, 547, 48);
		contentPane.add(btnConsultarRecetas);
		
		JButton btnDarseDeBaja = new JButton("Darse de baja");
		btnDarseDeBaja.setFont(new Font("Arial", Font.PLAIN, 12));
		btnDarseDeBaja.setBackground(SystemColor.activeCaption);
		btnDarseDeBaja.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFrame passwordFrame = new JFrame("Contraseña");
				passwordFrame.setBounds(100, 100, 584, 671);
				JLabel jlbPassword = new JLabel("Introduzca la contraseña:  ");
				JPasswordField jpwName = new JPasswordField(10);
				jpwName.setEchoChar('*');
				jpwName.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						JPasswordField input = (JPasswordField) e.getSource();
						if (paciente.checkPassword(String.valueOf(input.getPassword()))) {
							try {
								paciente.eliminar();
							} catch (SQLException e1) {
								javax.swing.JOptionPane.showMessageDialog(null, "Ha habido un error en la conexión con la\nbase de datos, disculpe las molestias", "ERROR", javax.swing.JOptionPane.ERROR_MESSAGE);
							}
						} else {
							JOptionPane.showMessageDialog(passwordFrame,
									"Contraseña incorrecta", "Error",
									JOptionPane.ERROR_MESSAGE);
						}
					}
				});
				JPanel jplContentPane = new JPanel(new BorderLayout());
				jplContentPane.setBorder(BorderFactory.createEmptyBorder(20, 20,
						20, 20));
				jplContentPane.add(jlbPassword, BorderLayout.WEST);
				jplContentPane.add(jpwName, BorderLayout.CENTER);
				passwordFrame.setContentPane(jplContentPane);
				passwordFrame.pack();
				passwordFrame.setVisible(true);
			}
		});
		btnDarseDeBaja.setBounds(10, 534, 547, 48);
		contentPane.add(btnDarseDeBaja);
		
		
		JButton btnAyuda = new JButton("Ayuda");
		btnAyuda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//TODO ayuda
			}
		});
		btnAyuda.setBackground(SystemColor.activeCaption);
		btnAyuda.setFont(new Font("Arial", Font.PLAIN, 12));
		btnAyuda.setBounds(308, 593, 249, 38);
		contentPane.add(btnAyuda);
		
		btnAtrs = new JButton("Atrás");
		btnAtrs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				iniciarSesion.setVisible(true);
				windowPaciente.setVisible(false);
			}
		});
		btnAtrs.setBounds(10, 593, 249, 38);
		contentPane.add(btnAtrs);
		
		
	}
	

}
