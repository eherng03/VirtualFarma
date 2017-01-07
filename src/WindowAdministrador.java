
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class WindowAdministrador extends JFrame {

	/**
	 * Ventana que se muestra al administrador del programa.
	 * Contendra los métodos para registrar, dar de baja y editar los datos de los médicos y las farmacias, 
	 * y hacer una copia de seguridad
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	

	/**
	 * Create the frame.
	 */
	public WindowAdministrador() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}

}