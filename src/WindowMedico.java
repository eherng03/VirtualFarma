import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class WindowMedico extends JFrame {
	/**
	 * Ventana que se muestra a los médicos. Mientras esté abierta almacenará los datos del medico que la esté usando
	 * para que sea mas facil la tarea de elaborar recetas.
	 */

	private JPanel contentPane;



	/**
	 * Create the frame.
	 */
	public WindowMedico() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		setResizable(false);
	}

}
