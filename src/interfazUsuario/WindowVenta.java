package interfazUsuario;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import images.ImagenVF;
import logicaPrograma.Helper;

import java.awt.List;
import java.net.MalformedURLException;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.help.HelpSetException;
import javax.swing.JButton;

public class WindowVenta extends JFrame {

	private JPanel contentPane;
	private JPanel logoPanel;
	private JTextField textField;



	/**
	 * Create the frame.
	 * @param windowFarmacia 
	 */
	public WindowVenta(WindowFarmacia windowFarmacia) {
		setTitle("Bienvenido");
		setBackground(new Color(255, 255, 255));
		setFont(new Font("Consolas", Font.PLAIN, 13));
	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 950, 671);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new Color(255, 255, 255));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setResizable(false);
		
		/*
		 * LOGO
		 */
		logoPanel = new ImagenVF(547, 382);
		logoPanel.setBackground(Color.WHITE);
		logoPanel.setBounds(0, 0, 547, 382);
		contentPane.add(logoPanel);
		
		List list = new List();
		list.setBounds(553, 34, 381, 537);
		contentPane.add(list);
		
		JLabel lblSuma = new JLabel("Suma:");
		lblSuma.setFont(new Font("Arial", Font.PLAIN, 12));
		lblSuma.setBounds(592, 597, 46, 14);
		contentPane.add(lblSuma);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(677, 591, 257, 28);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblProducto = new JLabel("Producto:");
		lblProducto.setFont(new Font("Arial", Font.PLAIN, 12));
		lblProducto.setBounds(557, 14, 68, 14);
		contentPane.add(lblProducto);
		
		JLabel lblCantidad = new JLabel("Cantidad:");
		lblCantidad.setFont(new Font("Arial", Font.PLAIN, 12));
		lblCantidad.setBounds(713, 14, 67, 14);
		contentPane.add(lblCantidad);
		
		JLabel lblPrecio = new JLabel("Precio:");
		lblPrecio.setFont(new Font("Arial", Font.PLAIN, 12));
		lblPrecio.setBounds(858, 14, 68, 14);
		contentPane.add(lblPrecio);
		
		JButton btnAadirProducto = new JButton("Añadir producto");
		btnAadirProducto.setFont(new Font("Arial", Font.PLAIN, 12));
		btnAadirProducto.setBounds(403, 393, 144, 28);
		contentPane.add(btnAadirProducto);
		
		JButton btnEliminarProducto = new JButton("Eliminar producto");
		btnEliminarProducto.setBounds(403, 432, 144, 28);
		contentPane.add(btnEliminarProducto);
		
		JButton btnAyuda = new JButton("Ayuda");
		btnAyuda.setBounds(403, 591, 144, 23);
		contentPane.add(btnAyuda);
		try {
			Helper.getInstance().openHelp(btnAyuda, "venta");
		} catch (MalformedURLException | HelpSetException e1) {
			javax.swing.JOptionPane.showMessageDialog(null, "Ha habido un error con el acceso a la\nayuda, disculpe las molestias.", "ERROR", javax.swing.JOptionPane.ERROR_MESSAGE);
		}
	}
}
