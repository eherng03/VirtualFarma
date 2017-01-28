package interfazUsuario;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.MalformedURLException;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import javax.help.HelpSetException;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

import excepciones.AlreadyExistException;
import excepciones.InvalidCIFException;
import excepciones.InvalidCuentaException;
import excepciones.InvalidDNIException;
import excepciones.InvalidNameException;
import excepciones.InvalidPasswordException;
import excepciones.InvalidSSNumberException;
import excepciones.InvalidTelefoneException;

import images.ImagenVF;
import logicaPrograma.Administrador;
import logicaPrograma.Farmacia;
import logicaPrograma.Helper;
import logicaPrograma.Medico;
import persistencia.BBDDFarmacias;
import persistencia.BBDDMedicos;



/**
 * Ventana con las acciones que puede realizar el administrador al iniciar sesion
 * Contendra los metodos para registrar, dar de baja y editar los datos de los medicos y las farmacias, 
 * y hacer una copia de seguridad
 * @author Eva y Alba
 *
 */
public class WindowAdministrador extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel logoPanel;
	private Administrador admin;
	private WindowAdministrador windowAdministrador;
	private IniciarSesion iniciarSesion;
	

	/**
	 * Crea la ventana
	 * @param iniciarSesion 
	 */
	public WindowAdministrador(IniciarSesion iniciarSesion) {
		
		iniciarSesion.setVisible(false);
		this.iniciarSesion = iniciarSesion;
		admin = Administrador.getAdmin();
		windowAdministrador = this;
		
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
	

	/**
	 * Inicializa todos los botones
	 */
	private void initializeButtons() {
		
		/*
		 * -----------------------REGISTRAR FARMACIA-----------------------------------
		 */
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
		
		
		/*
		 * -----------------------EDITAR FARMACIA-----------------------------------
		 */
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
							try {
								Farmacia farmacia = BBDDFarmacias.getInstance().getFarmacia(cif);
								FormFarmacia formFarmacia = new FormFarmacia(farmacia, windowAdministrador);
								formFarmacia.setVisible(true);
							}catch (InvalidNameException | InvalidCIFException | InvalidCuentaException | InvalidTelefoneException | InvalidPasswordException | AlreadyExistException e1){
								javax.swing.JOptionPane.showMessageDialog(null, e1.getMessage(), "ERROR", javax.swing.JOptionPane.ERROR_MESSAGE);
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
		btnEditarFarmacia.setBounds(22, 460, 233, 34);
		contentPane.add(btnEditarFarmacia);
		

		/*
		 * -----------------------ELIMINAR FARMACIA-----------------------------------
		 */
		JButton btnEliminarFarmacia = new JButton("Eliminar farmacia");
		btnEliminarFarmacia.setBackground(SystemColor.activeCaption);
		btnEliminarFarmacia.setFont(new Font("Arial", Font.PLAIN, 12));
		btnEliminarFarmacia.setBounds(22, 505, 233, 34);
		btnEliminarFarmacia.addActionListener(new ActionListener() {
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
								String cif = JOptionPane.showInputDialog("Introduzca el CIF de la farmacia a eliminar");
								try {
									BBDDFarmacias.getInstance().eliminarFarmacia(cif);
									javax.swing.JOptionPane.showMessageDialog(windowAdministrador, "La farmacia se ha eliminado con éxito");
									windowAdministrador.setVisible(true);
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
		
		contentPane.add(btnEliminarFarmacia);
		
		
		
		/*
		 * -----------------------REGISTRAR MEDICO-----------------------------------
		 */
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
							formMedico.setVisible(true);
						} else {
							JOptionPane.showMessageDialog(passwordFrame, "Contraseña incorrecta", "Error", JOptionPane.ERROR_MESSAGE);
						}
					}
				});
				JPanel jplContentPane = new JPanel(new BorderLayout());
				jplContentPane.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
				jplContentPane.add(jlbPassword, BorderLayout.WEST);
				jplContentPane.add(jpwName, BorderLayout.CENTER);
				passwordFrame.setContentPane(jplContentPane);
				passwordFrame.pack();
				passwordFrame.setVisible(true);
			}
		});
		btnRegistrarMdico.setBounds(324, 415, 233, 34);
		contentPane.add(btnRegistrarMdico);
		
		
		
		
		/*
		 * -----------------------EDITAR MEDICO-----------------------------------
		 */
		JButton btnEditarMdico = new JButton("Editar medico");
		btnEditarMdico.setBackground(SystemColor.activeCaption);
		btnEditarMdico.setFont(new Font("Arial", Font.PLAIN, 12));
		btnEditarMdico.setBounds(324, 460, 233, 34);
		btnEditarMdico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame passwordFrame = new JFrame("Contraseña");
				passwordFrame.setBounds(100, 100, 584, 671);
				passwordFrame.setVisible(true);
				JLabel jlbPassword = new JLabel("Introduzca la contraseña:  ");
				JPasswordField jpwName = new JPasswordField(10);
				jpwName.setEchoChar('*');
				jpwName.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						JPasswordField input = (JPasswordField) e.getSource();
						if (admin.checkPassword(String.valueOf(input.getPassword()))) {
							passwordFrame.setVisible(false);
							windowAdministrador.setVisible(false);
							String  dni = JOptionPane.showInputDialog("Introduzca el dni del médico a editar");
							try {
								Medico medico = BBDDMedicos.getInstance().getMedico(dni);
								FormMedico formMedico = new FormMedico(medico, windowAdministrador);
								formMedico.setVisible(true);
							}catch (InvalidNameException | InvalidDNIException | InvalidSSNumberException | InvalidPasswordException | AlreadyExistException e1){
								javax.swing.JOptionPane.showMessageDialog(null, e1.getMessage(), "ERROR", javax.swing.JOptionPane.ERROR_MESSAGE);
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
		
		contentPane.add(btnEditarMdico);
		
		
		
		/*
		 * -----------------------ELIMINAR MEDICO-----------------------------------
		 */
		JButton btnEliminarMdico = new JButton("Eliminar medico");
		btnEliminarMdico.addActionListener(new ActionListener() {
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
							String dni = JOptionPane.showInputDialog("Introduzca el DNI del médico a eliminar");
							try {
								BBDDMedicos.getInstance().eliminarMedico(dni);
								javax.swing.JOptionPane.showMessageDialog(windowAdministrador, "El médico se ha eliminado con éxito");
								windowAdministrador.setVisible(true);
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
		btnEliminarMdico.setBackground(SystemColor.activeCaption);
		btnEliminarMdico.setFont(new Font("Arial", Font.PLAIN, 12));
		btnEliminarMdico.setBounds(324, 505, 233, 34);
		contentPane.add(btnEliminarMdico);
		
		
		
		
		/*
		 * -----------------------COPIA DE SEGURIDAD-----------------------------------
		 */
		JButton btnCrearCopiaDe = new JButton("Crear copia de seguridad del sistema");
		btnCrearCopiaDe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					admin.crearCopiaDeSeguridad();
				} catch (IOException e1) {
					javax.swing.JOptionPane.showMessageDialog(null, "Ha habido un error en la conexión con la\nbase de datos, disculpe las molestias", "ERROR", javax.swing.JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnCrearCopiaDe.setBackground(SystemColor.activeCaption);
		btnCrearCopiaDe.setFont(new Font("Arial", Font.PLAIN, 12));
		btnCrearCopiaDe.setBounds(22, 563, 535, 34);
		contentPane.add(btnCrearCopiaDe);
		
		
		/*
		 * ------------------------------AYUDA-----------------------------------------
		 */
		JButton btnAyuda = new JButton("Ayuda");
		btnAyuda.setBackground(SystemColor.activeCaption);
		btnAyuda.setFont(new Font("Arial", Font.PLAIN, 12));
		btnAyuda.setBounds(303, 608, 254, 23);
		contentPane.add(btnAyuda);
		try {
			Helper.getInstance().openHelp(btnAyuda, "ventana_admin");
		} catch (MalformedURLException | HelpSetException e1) {
			javax.swing.JOptionPane.showMessageDialog(null, "Ha habido un error con el acceso a la\nayuda, disculpe las molestias.", "ERROR", javax.swing.JOptionPane.ERROR_MESSAGE);
		}
		
		JButton btnAtras = new JButton("Atrás");
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				iniciarSesion.setVisible(true);
				windowAdministrador.setVisible(false);
			}
		});
		btnAtras.setBackground(SystemColor.activeCaption);
		btnAtras.setBounds(22, 608, 254, 24);
		contentPane.add(btnAtras);
		
		
		
	}

	/**
	 * Inicializa todas las etiquetas
	 */
	private void initializeLabels() {
		
		//-----------------------LABELS-----------------------------
		JLabel lblFarmacias = new JLabel("Farmacias");
		lblFarmacias.setFont(new Font("Arial", Font.PLAIN, 12));
		lblFarmacias.setBounds(115, 393, 69, 14);
		contentPane.add(lblFarmacias);
		
		
		JLabel lblMedicos = new JLabel("Medicos");
		lblMedicos.setFont(new Font("Arial", Font.PLAIN, 12));
		lblMedicos.setBounds(415, 393, 69, 14);
		contentPane.add(lblMedicos);
		
		
		//-------------------------SEPARADORES------------------------
		JSeparator separator_1 = new JSeparator();
		separator_1.setOrientation(SwingConstants.VERTICAL);
		separator_1.setBounds(290, 415, 2, 137);
		contentPane.add(separator_1);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(22, 550, 535, 2);
		contentPane.add(separator);
	}
}