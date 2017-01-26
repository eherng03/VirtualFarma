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
	

	/**
	 * Create the frame.
	 * @param iniciarSesion 
	 */
	public WindowAdministrador(IniciarSesion iniciarSesion) {
		iniciarSesion.setEnabled(false);
		admin = Administrador.getAdmin();
		
		initializeWindow();

	}


	private void initializeWindow() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 412, 548);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//logo
		logoPanel = new ImagenVF(394, 257);
		logoPanel.setBackground(Color.WHITE);
		logoPanel.setBounds(0, 0, 394, 257);
		contentPane.add(logoPanel);
		
		initializeLabel("Farmacias", 81, 268, 69, 14);
		initializeLabel("Medicos", 277, 268, 46, 14);
		
		initializeButtons();
		
	}

	private void initializeButtons() {
		JButton btnRegistrarFarmacia = new JButton("Registrar farmacia");
		btnRegistrarFarmacia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				admin.crearFarmacia();
			}
		});
		btnRegistrarFarmacia.setBounds(10, 293, 180, 34);
		contentPane.add(btnRegistrarFarmacia);
		
		JButton btnRegistrarMdico = new JButton("Registrar medico");
		btnRegistrarMdico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				admin.crearMedico();
			}
		});
		btnRegistrarMdico.setBounds(206, 293, 180, 34);
		contentPane.add(btnRegistrarMdico);
		
		JButton btnEditarFarmacia = new JButton("Editar farmacia.");
		btnEditarFarmacia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				final JFrame passwordFrame = new JFrame("Contraseña");
				JLabel jlbPassword = new JLabel("Introduzca la contraseña:  ");
				JPasswordField jpwName = new JPasswordField(10);
				jpwName.setEchoChar('*');
				jpwName.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						JPasswordField input = (JPasswordField) e.getSource();
						if (admin.checkPassword(input.getPassword().toString())) {
							JOptionPane.showMessageDialog(passwordFrame,
									"Contraseña correcta");
							String cif = JOptionPane.showInputDialog("Introduzca el CIF de la farmacia a editar");
							FormFarmacia formFarmacia = new FormFarmacia(cif);
							
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
				passwordFrame.addWindowListener(new WindowAdapter() {

						public void windowClosing(WindowEvent e) {
							System.exit(0);
						}
					});
				passwordFrame.pack();
				passwordFrame.setVisible(true);
			}
		});
		btnEditarFarmacia.setBounds(10, 338, 180, 34);
		contentPane.add(btnEditarFarmacia);
		
		JButton btnEditarMdico = new JButton("Editar medico");
		btnEditarMdico.setBounds(206, 338, 180, 34);
		contentPane.add(btnEditarMdico);
		
		JButton btnEliminarFarmacia = new JButton("Eliminar farmacia");
		btnEliminarFarmacia.setBounds(10, 383, 180, 34);
		contentPane.add(btnEliminarFarmacia);
		
		JButton btnEliminarMdico = new JButton("Eliminar medico");
		btnEliminarMdico.setBounds(206, 383, 180, 34);
		contentPane.add(btnEliminarMdico);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 428, 376, 2);
		contentPane.add(separator);
		
		JButton btnCrearCopiaDe = new JButton("Crear copia de seguridad del sistema");
		btnCrearCopiaDe.setBounds(10, 441, 376, 23);
		contentPane.add(btnCrearCopiaDe);
		
		JButton btnAyuda = new JButton("Ayuda");
		btnAyuda.setBounds(155, 475, 89, 23);
		contentPane.add(btnAyuda);
	}


	private void initializeLabel(String string, int i, int j, int k, int l) {
		JLabel lblFarmacias = new JLabel(string);
		lblFarmacias.setBounds(i, j, k, l);
		contentPane.add(lblFarmacias);
	}
}