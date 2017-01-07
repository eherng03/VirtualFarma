import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FormPaciente extends JFrame {

	private JPanel contentPane;
	private JFrame padre;
	private JTextField textNombre;
	private JTextField textApellido1;
	private JTextField textApellido2;
	private JTextField textDNI;
	private JTextField textNumeroSS;
	private JPasswordField passwordField;
	
	/**
	 * Create the frame.
	 */
	public FormPaciente() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 370, 274);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblIntroduzcaLosDatos = new JLabel("Introduzca los datos del nuevo paciente o editelos si este ya existe");
		lblIntroduzcaLosDatos.setBounds(10, 11, 414, 14);
		contentPane.add(lblIntroduzcaLosDatos);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(10, 36, 46, 14);
		contentPane.add(lblNombre);
		
		JLabel lblPrimerApellido = new JLabel("Primer apellido");
		lblPrimerApellido.setBounds(10, 61, 77, 14);
		contentPane.add(lblPrimerApellido);
		
		JLabel lblSegundoApellido = new JLabel("Segundo apellido");
		lblSegundoApellido.setBounds(10, 86, 93, 14);
		contentPane.add(lblSegundoApellido);
		
		JLabel lblNumeroDeLa = new JLabel("Numero de la seguridad social");
		lblNumeroDeLa.setBounds(10, 136, 160, 14);
		contentPane.add(lblNumeroDeLa);
		
		JLabel lblDni = new JLabel("DNI");
		lblDni.setBounds(10, 111, 46, 14);
		contentPane.add(lblDni);
		
		JLabel lblContrasea = new JLabel("Contraseña");
		lblContrasea.setBounds(10, 161, 77, 14);
		contentPane.add(lblContrasea);
		
		textNombre = new JTextField();
		textNombre.setBounds(66, 33, 264, 20);
		contentPane.add(textNombre);
		textNombre.setColumns(10);
		
		textApellido1 = new JTextField();
		textApellido1.setBounds(97, 58, 233, 20);
		contentPane.add(textApellido1);
		textApellido1.setColumns(10);
		
		textApellido2 = new JTextField();
		textApellido2.setBounds(107, 83, 223, 20);
		contentPane.add(textApellido2);
		textApellido2.setColumns(10);
		
		textDNI = new JTextField();
		textDNI.setBounds(45, 108, 285, 20);
		contentPane.add(textDNI);
		textDNI.setColumns(10);
		
		textNumeroSS = new JTextField();
		textNumeroSS.setBounds(174, 133, 156, 20);
		contentPane.add(textNumeroSS);
		textNumeroSS.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(82, 158, 248, 20);
		contentPane.add(passwordField);
		
		JButton btnAtrs = new JButton("Atrás");
		btnAtrs.setBounds(10, 189, 89, 23);
		contentPane.add(btnAtrs);
		
		JButton btnAyuda = new JButton("Ayuda");
		btnAyuda.setBounds(126, 189, 89, 23);
		contentPane.add(btnAyuda);
		
		JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				registrarPaciente();
			}
		});
		btnConfirmar.setBounds(241, 189, 89, 23);
		contentPane.add(btnConfirmar);
	}

	protected void registrarPaciente() {
		// Crear el objeto paciente con los datos de los text
		
	}

	//para poder volver atras
	public void setPadre(JFrame startWindow) {
		this.padre = startWindow;
	}
}
