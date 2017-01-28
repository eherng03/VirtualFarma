package interfazUsuario;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.SystemColor;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import excepciones.AlreadyExistException;
import images.ImagenVF;
import logicaPrograma.Helper;
import logicaPrograma.Producto;
import persistencia.BBDDProductos;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.help.HelpSetException;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class FormProducto extends JFrame {

	private JPanel contentPane;
	private JPanel logoPanel;
	private JFrame windowFarmacia;
	private FormProducto formProducto;
	private JTextField textFieldNombre;
	private JTextField textFieldPrecio;
	private JTextField textFieldCantidad;
	private String cifFarmacia;


	/**
	 * Create the frame.
	 * @param window 
	 */
	public FormProducto(Producto producto, String cif, JFrame window) {
		//TODO testear
		cifFarmacia = cif;
		formProducto = this;
		this.windowFarmacia = window;
		
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 584, 671);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(SystemColor.textHighlightText);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		/*
		 * LOGO
		 */
		logoPanel = new ImagenVF(547, 382);
		logoPanel.setBackground(Color.WHITE);
		logoPanel.setBounds(10, 0, 547, 382);
		contentPane.add(logoPanel);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNombre.setBounds(10, 427, 58, 14);
		contentPane.add(lblNombre);
		
		JLabel lblPrecio = new JLabel("Precio");
		lblPrecio.setFont(new Font("Arial", Font.PLAIN, 12));
		lblPrecio.setBounds(10, 462, 58, 14);
		contentPane.add(lblPrecio);
		
		JLabel lblCantidad = new JLabel("Cantidad");
		lblCantidad.setFont(new Font("Arial", Font.PLAIN, 12));
		lblCantidad.setBounds(10, 496, 58, 14);
		contentPane.add(lblCantidad);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setBounds(90, 425, 467, 20);
		contentPane.add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
		textFieldPrecio = new JTextField();
		textFieldPrecio.setBounds(90, 460, 467, 20);
		contentPane.add(textFieldPrecio);
		textFieldPrecio.setColumns(10);
		
		textFieldCantidad = new JTextField();
		textFieldCantidad.setBounds(90, 494, 467, 20);
		contentPane.add(textFieldCantidad);
		textFieldCantidad.setColumns(10);
		
		JButton btnIntroducir = new JButton("Introducir");
		btnIntroducir.addActionListener(new ActionListener() {
			//TODO test
			public void actionPerformed(ActionEvent e) {
				if(producto == null){
					try {
						BBDDProductos.getInstance().introducirProducto(cifFarmacia, textFieldNombre.getText(), 
								textFieldPrecio.getText(), textFieldCantidad.getText());
					} catch (NumberFormatException |SQLException e1) {
						javax.swing.JOptionPane.showMessageDialog(null, "Ha habido un error en la conexión con la\nbase de datos, disculpe las molestias", "ERROR", javax.swing.JOptionPane.ERROR_MESSAGE);
					} catch (AlreadyExistException e1) {
						javax.swing.JOptionPane.showMessageDialog(null, e1.getMessage(), "ERROR", javax.swing.JOptionPane.ERROR_MESSAGE);

					}
				}else{
					//TODO editar producto
				}
			}
		});
		
		btnIntroducir.setFont(new Font("Arial", Font.PLAIN, 12));
		btnIntroducir.setBounds(10, 535, 547, 33);
		contentPane.add(btnIntroducir);
		
		JButton btnAyuda = new JButton("Ayuda");
		btnAyuda.setFont(new Font("Arial", Font.PLAIN, 12));
		btnAyuda.setBounds(294, 579, 263, 33);
		contentPane.add(btnAyuda);
		try {
			if(producto == null){
					Helper.getInstance().openHelp(btnAyuda, "crear_producto");
			}else{
					Helper.getInstance().openHelp(btnAyuda, "editar_producto");
			}
		} catch (MalformedURLException | HelpSetException e1) {
			javax.swing.JOptionPane.showMessageDialog(null, "Ha habido un error con el acceso a la\nayuda, disculpe las molestias.", "ERROR", javax.swing.JOptionPane.ERROR_MESSAGE);
		}
		
		JButton btnAtrs = new JButton("Atrás");
		btnAtrs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				volverAtras();
			}
		});
		btnAtrs.setFont(new Font("Arial", Font.PLAIN, 12));
		btnAtrs.setBounds(10, 579, 263, 33);
		contentPane.add(btnAtrs);
		
		if(producto != null){
			textFieldCantidad.setText(Integer.toString(producto.getCuantia()));
			textFieldNombre.setText(producto.getNombre());
			textFieldPrecio.setText(Double.toString(producto.getPrecio()));
		}
	}


	protected void volverAtras() {
		formProducto.setVisible(false);
		windowFarmacia.setVisible(true);
	}

}
