package interfazUsuario;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class ListadoRecetas extends JFrame {

	private JPanel contentPane;


	/**
	 * Create the frame.
	 * @param windowPaciente 
	 * @param string 
	 */
	public ListadoRecetas(String dni, WindowPaciente windowPaciente) {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		/*TODO 
		 * 
		 */
	}

}
