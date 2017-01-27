package interfazUsuario;
import javax.swing.JPanel;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;

import java.awt.Color;
import java.awt.Font;
import java.sql.SQLException;
import java.util.ArrayList;

import images.ImagenVF;
import logicaPrograma.Producto;
import persistencia.BBDDProductos;

import javax.swing.border.EmptyBorder;

public class ListadoProductos extends JFrame {

	private static final long serialVersionUID = 1L;
	private String cifFarmacia;

	private JPanel contentPane;
	private JPanel logoPanel;
	
	ArrayList<Producto> lista;

	JList<Producto> listaProductos;
	
	DefaultListModel<Producto> modelo = new DefaultListModel();


	public ListadoProductos(String cif, JFrame ventanaAnterior) {
		listaProductos = new JList<Producto>();
		listaProductos.setModel(modelo);
		
		try {
			modelo = BBDDProductos.getInstance().getProductos(cif);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		cifFarmacia = cif;
		
		setTitle("Listado de productos.");
		setBackground(new Color(255, 255, 255));
		setFont(new Font("Consolas", Font.PLAIN, 13));
	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 584, 671);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new Color(255, 255, 255));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		/*
		 * LOGO
		 */
		logoPanel = new ImagenVF(547, 382);
		logoPanel.setBackground(Color.WHITE);
		logoPanel.setBounds(10, 0, 547, 382);
		contentPane.add(logoPanel);
		
	}


}