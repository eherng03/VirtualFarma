package interfazUsuario;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import images.ImagenVF;
import logicaPrograma.Administrador;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.SystemColor;

public class WindowAdministrador extends JFrame {

	/**
	 * Ventana que se muestra al administrador del programa.
	 * Contendra los metodos para registrar, dar de baja y editar los datos de los medicos y las farmacias, 
	 * y hacer una copia de seguridad
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel logoPanel;
	private Administrador admin;
	private WindowAdministrador windowAdministrador;
	

	/**
	 * Create the frame.
	 * @param iniciarSesion 
	 */
	public WindowAdministrador(IniciarSesion iniciarSesion) {
		iniciarSesion.setVisible(false);
		admin = Administrador.getAdmin();
		windowAdministrador = this;
		initializeWindow();

	}


	private void initializeWindow() {
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 584, 671);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(Color.WHITE);
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
		
		
		initializeLabels();
		
		initializeButtons();
		
	}
	


	private void initializeButtons() {
		JButton btnRegistrarFarmacia = new JButton("Registrar farmacia");
		btnRegistrarFarmacia.setBackground(SystemColor.activeCaption);
		btnRegistrarFarmacia.setFont(new Font("Arial", Font.PLAIN, 12));
		btnRegistrarFarmacia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame passwordFrame = new JFrame("Contraseña");
				passwordFrame.setBounds(100, 100, 584, 671);
				JLabel jlbPassword = new JLabel("Introduzca la contraseña:  ");
				JPasswordField jpwName = new JPasswordField(10);
				jpwName.setEchoChar('*');
				jpwName.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						JPasswordField input = (JPasswordField) e.getSource();
						if (admin.checkPassword(String.valueOf(input.getPassword()))) {
							passwordFrame.setVisible(false);
							windowAdministrador.setVisible(false);
							FormFarmacia formFarmacia = new FormFarmacia(null, windowAdministrador);
							formFarmacia.setVisible(true);
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
		btnRegistrarFarmacia.setBounds(22, 415, 233, 34);
		contentPane.add(btnRegistrarFarmacia);
		
		JButton btnRegistrarMdico = new JButton("Registrar medico");
		btnRegistrarMdico.setBackground(SystemColor.activeCaption);
		btnRegistrarMdico.setFont(new Font("Arial", Font.PLAIN, 12));
		btnRegistrarMdico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame passwordFrame = new JFrame("Contraseña");
				passwordFrame.setBounds(100, 100, 584, 671);
				JLabel jlbPassword = new JLabel("Introduzca la contraseña:  ");
				JPasswordField jpwName = new JPasswordField(10);
				jpwName.setEchoChar('*');
				jpwName.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						JPasswordField input = (JPasswordField) e.getSource();
						if (admin.checkPassword(String.valueOf(input.getPassword()))) {
							passwordFrame.setVisible(false);
							windowAdministrador.setVisible(false);
							FormMedico formMedico = new FormMedico(null, windowAdministrador);
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
		btnRegistrarMdico.setBounds(324, 415, 233, 34);
		contentPane.add(btnRegistrarMdico);
		
		JButton btnEditarFarmacia = new JButton("Editar farmacia");
		btnEditarFarmacia.setBackground(SystemColor.activeCaption);
		btnEditarFarmacia.setFont(new Font("Arial", Font.PLAIN, 12));
		btnEditarFarmacia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFrame passwordFrame = new JFrame("Contraseña");
				passwordFrame.setBounds(100, 100, 584, 671);
				JLabel jlbPassword = new JLabel("Introduzca la contraseña:  ");
				JPasswordField jpwName = new JPasswordField(10);
				jpwName.setEchoChar('*');
				jpwName.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						JPasswordField input = (JPasswordField) e.getSource();
						if (admin.checkPassword(String.valueOf(input.getPassword()))) {
							passwordFrame.setVisible(false);
							windowAdministrador.setVisible(false);
							String cif = JOptionPane.showInputDialog("Introduzca el CIF de la farmacia a editar");
							//TODO llamar a la BBDD para ver si existe el cif y devolverlo sino dar error 
							FormFarmacia formFarmacia = new FormFarmacia(cif, windowAdministrador);
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
		btnEditarFarmacia.setBounds(22, 460, 233, 34);
		contentPane.add(btnEditarFarmacia);
		
		JButton btnEditarMdico = new JButton("Editar medico");
		btnEditarMdico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame passwordFrame = new JFrame("Contraseña");
				passwordFrame.setBounds(100, 100, 584, 671);
				JLabel jlbPassword = new JLabel("Introduzca la contraseña:  ");
				JPasswordField jpwName = new JPasswordField(10);
				jpwName.setEchoChar('*');
				jpwName.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						JPasswordField input = (JPasswordField) e.getSource();
						if (admin.checkPassword(String.valueOf(input.getPassword()))) {
							passwordFrame.setVisible(false);
							windowAdministrador.setVisible(false);
							String dni = JOptionPane.showInputDialog("Introduzca el dni del médico a editar");
							//TODO llamar a la BBDD para ver si existe el dni y devolverlo sino dar error 
							FormMedico formMedico = new FormMedico(dni, windowAdministrador);
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
		btnEditarMdico.setBackground(SystemColor.activeCaption);
		btnEditarMdico.setFont(new Font("Arial", Font.PLAIN, 12));
		btnEditarMdico.setBounds(324, 460, 233, 34);
		contentPane.add(btnEditarMdico);
		
		JButton btnEliminarFarmacia = new JButton("Eliminar farmacia");
		btnEliminarFarmacia.setBackground(SystemColor.activeCaption);
		btnEliminarFarmacia.setFont(new Font("Arial", Font.PLAIN, 12));
		btnEliminarFarmacia.setBounds(22, 505, 233, 34);
		contentPane.add(btnEliminarFarmacia);
		
		JButton btnEliminarMdico = new JButton("Eliminar medico");
		btnEliminarMdico.setBackground(SystemColor.activeCaption);
		btnEliminarMdico.setFont(new Font("Arial", Font.PLAIN, 12));
		btnEliminarMdico.setBounds(324, 505, 233, 34);
		contentPane.add(btnEliminarMdico);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(22, 550, 535, 2);
		contentPane.add(separator);
		
		JButton btnCrearCopiaDe = new JButton("Crear copia de seguridad del sistema");
		btnCrearCopiaDe.setBackground(SystemColor.activeCaption);
		btnCrearCopiaDe.setFont(new Font("Arial", Font.PLAIN, 12));
		btnCrearCopiaDe.setBounds(22, 563, 535, 34);
		contentPane.add(btnCrearCopiaDe);
		
		JButton btnAyuda = new JButton("Ayuda");
		btnAyuda.setBackground(SystemColor.activeCaption);
		btnAyuda.setFont(new Font("Arial", Font.PLAIN, 12));
		btnAyuda.setBounds(238, 608, 89, 23);
		contentPane.add(btnAyuda);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setOrientation(SwingConstants.VERTICAL);
		separator_1.setBounds(290, 415, 2, 137);
		contentPane.add(separator_1);
		
		
	}


	private void initializeLabels() {
		
		
		JLabel lblFarmacias = new JLabel("Farmacias");
		lblFarmacias.setFont(new Font("Arial", Font.PLAIN, 12));
		lblFarmacias.setBounds(115, 393, 69, 14);
		contentPane.add(lblFarmacias);
		
		
		JLabel lblMedicos = new JLabel("Medicos");
		lblMedicos.setFont(new Font("Arial", Font.PLAIN, 12));
		lblMedicos.setBounds(415, 393, 69, 14);
		contentPane.add(lblMedicos);
		
		
	}
}