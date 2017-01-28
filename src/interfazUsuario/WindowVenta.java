package interfazUsuario;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import images.ImagenVF;
import logicaPrograma.Helper;
import logicaPrograma.Producto;

import java.net.MalformedURLException;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.help.HelpSetException;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;

public class WindowVenta extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel logoPanel;
	private JTextField textFieldSuma;
	private JList<Producto> lista;
	private WindowVenta windowVenta;

	DefaultListModel<Producto> modelo;

	/**
	 * Create the frame.
	 * @param windowFarmacia 
	 */
	public WindowVenta(WindowFarmacia windowFarmacia, String cif) {
		lista = new JList<>();
		modelo = new DefaultListModel<>();
		lista.setModel(modelo);
		
		setTitle("Nueva venta");
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
		
		
		lista.setBounds(553, 34, 381, 537);
		contentPane.add(lista);
		
		JLabel lblSuma = new JLabel("Suma:");
		lblSuma.setFont(new Font("Arial", Font.PLAIN, 12));
		lblSuma.setBounds(592, 597, 46, 14);
		contentPane.add(lblSuma);
		
		textFieldSuma = new JTextField();
		textFieldSuma.setFont(new Font("Arial", Font.PLAIN, 12));
		textFieldSuma.setEditable(false);
		textFieldSuma.setBounds(677, 591, 257, 28);
		contentPane.add(textFieldSuma);
		textFieldSuma.setColumns(10);
		
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
		btnAadirProducto.setBackground(SystemColor.activeCaption);
		btnAadirProducto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListadoProductos lista = new ListadoProductos(cif, windowVenta, true);
				lista.setVisible(true);
			}
		});
		btnAadirProducto.setFont(new Font("Arial", Font.PLAIN, 12));
		btnAadirProducto.setBounds(283, 393, 251, 38);
		contentPane.add(btnAadirProducto);
		
		JButton btnEliminarProducto = new JButton("Eliminar producto");
		btnEliminarProducto.setFont(new Font("Arial", Font.PLAIN, 12));
		btnEliminarProducto.setBackground(SystemColor.activeCaption);
		btnEliminarProducto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Producto productoSeleccionado = null;
				if(modelo.isEmpty()){
		            JOptionPane.showMessageDialog(null,"La lista esta vacia");
		        }else{
		            Object objeto = lista.getSelectedValue();
		            productoSeleccionado = (Producto) objeto;
		        }
				modelo.removeElement(productoSeleccionado);
			}
		});
		btnEliminarProducto.setBounds(283, 442, 251, 38);
		contentPane.add(btnEliminarProducto);
		

		JButton btnVerRecetaDe = new JButton("Ver receta de un paciente");
		btnVerRecetaDe.setFont(new Font("Arial", Font.PLAIN, 12));
		btnVerRecetaDe.setBackground(SystemColor.activeCaption);
		btnVerRecetaDe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String dni = JOptionPane.showInputDialog("Introduzca el Dni del paciente");
				ListadoRecetas lista = new ListadoRecetas(dni, true);
				lista.setVisible(true);
			}
		});
		btnVerRecetaDe.setBounds(10, 393, 251, 87);
		contentPane.add(btnVerRecetaDe);
		
		JButton btnAtrs = new JButton("Atrás");
		btnAtrs.setFont(new Font("Arial", Font.PLAIN, 12));
		btnAtrs.setBackground(SystemColor.activeCaption);
		btnAtrs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				windowVenta.setVisible(false);
				windowFarmacia.setVisible(true);
			}
		});
		btnAtrs.setBounds(10, 576, 251, 38);
		contentPane.add(btnAtrs);
		
		JButton btnActualizarSuma = new JButton("Actualizar suma");
		btnActualizarSuma.setFont(new Font("Arial", Font.PLAIN, 12));
		btnActualizarSuma.setBackground(SystemColor.activeCaption);
		btnActualizarSuma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double suma = 0;
				for(int i = 0; i < modelo.size(); i++){
					suma = suma + modelo.get(i).getPrecio();
				}
				textFieldSuma.setText(Double.toString(suma) + "€");
				
			}
		});
		btnActualizarSuma.setBounds(283, 491, 251, 38);
		contentPane.add(btnActualizarSuma);
		
		JButton btnRegistrarVenta = new JButton("Registrar venta");
		btnRegistrarVenta.setFont(new Font("Arial", Font.PLAIN, 12));
		btnRegistrarVenta.setBackground(SystemColor.activeCaption);
		btnRegistrarVenta.setBounds(10, 491, 251, 38);
		contentPane.add(btnRegistrarVenta);
		
		JButton btnAyuda = new JButton("Ayuda");
		btnAyuda.setFont(new Font("Arial", Font.PLAIN, 12));
		btnAyuda.setBackground(SystemColor.activeCaption);
		btnAyuda.setBounds(283, 576, 251, 38);
		contentPane.add(btnAyuda);
		try {
			Helper.getInstance().openHelp(btnAyuda, "venta");
			
		} catch (MalformedURLException | HelpSetException e1) {
			javax.swing.JOptionPane.showMessageDialog(null, "Ha habido un error con el acceso a la\nayuda, disculpe las molestias.", "ERROR", javax.swing.JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void addProducto(Producto producto){
		modelo.addElement(producto);
	}
}
