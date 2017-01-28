package interfazUsuario;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import images.ImagenVF;
import logicaPrograma.Helper;

import javax.help.HelpSetException;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.SystemColor;

public class WindowFarmacia extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel logoPanel;
	private WindowFarmacia windowFarmacia;
	private IniciarSesion iniciarSesion;


	/**
	 * Create the frame.
	 */
	public WindowFarmacia(String cif, IniciarSesion iniciarSesion) {
		
		windowFarmacia = this;
		this.iniciarSesion = iniciarSesion;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 584, 671);
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
		logoPanel.setBounds(10, 0, 547, 382);
		contentPane.add(logoPanel);
		
		JButton btnNuevaVenta = new JButton("Nueva venta");
		btnNuevaVenta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				WindowVenta nuevaVenta = new WindowVenta(windowFarmacia);
				nuevaVenta.setVisible(true);
				windowFarmacia.setVisible(false);
			}
		});
		btnNuevaVenta.setBackground(SystemColor.activeCaption);
		btnNuevaVenta.setFont(new Font("Arial", Font.PLAIN, 12));
		btnNuevaVenta.setBounds(10, 393, 547, 38);
		contentPane.add(btnNuevaVenta);
		
		JButton btnIntroducirProductoEn = new JButton("Introducir producto en la base de datos");
		btnIntroducirProductoEn.setBackground(SystemColor.activeCaption);
		btnIntroducirProductoEn.setFont(new Font("Arial", Font.PLAIN, 12));
		btnIntroducirProductoEn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FormProducto formProducto = new FormProducto(null, cif, windowFarmacia);
				windowFarmacia.setVisible(false);
				formProducto.setVisible(true);
			}
		});
		btnIntroducirProductoEn.setBounds(10, 442, 547, 38);
		contentPane.add(btnIntroducirProductoEn);
		
		JButton btnEditarProductoDe = new JButton("Editar producto de la base de datos, o ver lista de productos");
		btnEditarProductoDe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListadoProductos lista = new ListadoProductos(cif, windowFarmacia, true);
				windowFarmacia.setVisible(false);
				lista.setVisible(true);
			}
		});
		btnEditarProductoDe.setBackground(SystemColor.activeCaption);
		btnEditarProductoDe.setFont(new Font("Arial", Font.PLAIN, 12));
		btnEditarProductoDe.setBounds(10, 491, 547, 38);
		contentPane.add(btnEditarProductoDe);
		
		JButton btnEliminarPr = new JButton("Eliminar producto");
		btnEliminarPr.setBackground(SystemColor.activeCaption);
		btnEliminarPr.setFont(new Font("Arial", Font.PLAIN, 12));
		btnEliminarPr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListadoProductos lista = new ListadoProductos(cif, windowFarmacia, true);
				windowFarmacia.setVisible(false);
				lista.setVisible(true);
			}
		});
		btnEliminarPr.setBounds(10, 540, 547, 38);
		contentPane.add(btnEliminarPr);
		
		JButton btnAyuda = new JButton("Ayuda");
		btnAyuda.setBackground(SystemColor.activeCaption);
		btnAyuda.setFont(new Font("Arial", Font.PLAIN, 12));
		btnAyuda.setBounds(288, 589, 269, 42);
		contentPane.add(btnAyuda);
		try {
			Helper.getInstance().openHelp(btnAyuda, "ventana_farmacia");
		} catch (MalformedURLException | HelpSetException e1) {
			javax.swing.JOptionPane.showMessageDialog(null, "Ha habido un error con el acceso a la\nayuda, disculpe las molestias.", "ERROR", javax.swing.JOptionPane.ERROR_MESSAGE);
		}
		
		JButton btnAtrs = new JButton("Atrás");
		btnAtrs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				volverAtras();
			}
		});
		btnAtrs.setBackground(SystemColor.activeCaption);
		btnAtrs.setFont(new Font("Arial", Font.PLAIN, 12));
		btnAtrs.setBounds(10, 589, 269, 42);
		contentPane.add(btnAtrs);
	}


	protected void volverAtras() {
		windowFarmacia.setVisible(false);
		iniciarSesion.setVisible(true);
	}
}
