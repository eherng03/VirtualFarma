package interfazUsuario;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import images.ImagenVF;
import logicaPrograma.Farmacia;
import logicaPrograma.Producto;
import persistencia.BBDDFarmacias;
import persistencia.BBDDProductos;

import javax.swing.border.EmptyBorder;

import excepciones.AlreadyExistException;
import excepciones.InvalidCIFException;
import excepciones.InvalidCuentaException;
import excepciones.InvalidNameException;
import excepciones.InvalidPasswordException;
import excepciones.InvalidTelefoneException;

public class ListadoProductos extends JFrame {

	private static final long serialVersionUID = 1L;
	private String cifFarmacia;

	private JPanel contentPane;
	private JPanel logoPanel;
	private JPanel jPanel1;
	private JLabel jLabel1;
	private JTextField jTextFieldNombre;
	private JLabel jLabel2;
	private JTextField jTextFieldPrecio;
	private JTextField jTextFieldDisponibilidad;
	private JLabel jLabel3;
	private JButton btnAyuda;
	private JButton btnAtrs;
	

	
	ArrayList<Producto> lista;

	JList<Producto> listaProductos;
	
	DefaultListModel<Producto> modelo = new DefaultListModel<>();
	private ListadoProductos listadoProductos;
	private JButton btnEliminarProducto;
	private JButton btnEditarProducto;
	private Producto productoSeleccionado;


	public ListadoProductos(String cif, JFrame ventanaAnterior, boolean esFarmacia) {
		listadoProductos = this;
    	setResizable(false);
    	  
    	listaProductos = new JList<>();
    	
    	try {
			modelo = BBDDProductos.getInstance().getProductos(cif);
		} catch (SQLException e) {
			javax.swing.JOptionPane.showMessageDialog(null, "Ha habido un error en la conexión con la\nbase de datos, disculpe las molestias", "ERROR", javax.swing.JOptionPane.ERROR_MESSAGE);
		}
    	listaProductos.setModel(modelo);  
        
    	
        setTitle("Lista de farmacias");
        jPanel1.setLayout(null);
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
		
		
		
        jPanel1 = new JPanel();
        jPanel1.setBackground(Color.WHITE);
        jPanel1.setBounds(10, 404, 309, 227);
        jPanel1.setLayout(null);
        
        jLabel1 = new JLabel();
        jLabel1.setBackground(Color.WHITE);
        jLabel1.setFont(new Font("Arial", Font.PLAIN, 12));
        jLabel1.setBounds(13, 11, 49, 19);
        jLabel1.setText("Nombre");
        jLabel1.setBorder(null);
        jPanel1.add(jLabel1);
        
        
        jTextFieldNombre = new JTextField();
        jTextFieldNombre.setBackground(Color.WHITE);
        jTextFieldNombre.setEditable(false);
        jTextFieldNombre.setFont(new Font("Tahoma", Font.PLAIN, 12));
        jTextFieldNombre.setBounds(72, 10, 227, 21);
        jPanel1.add(jTextFieldNombre);
        
        jLabel2 = new JLabel();
        jLabel2.setBackground(Color.WHITE);
        jLabel2.setFont(new Font("Arial", Font.PLAIN, 12));
        jLabel2.setBounds(13, 42, 45, 19);
        jLabel2.setText("Precio");
        jLabel2.setBorder(null);
        jPanel1.add(jLabel2);
        
        jTextFieldPrecio = new JTextField();
        jTextFieldPrecio.setBackground(Color.WHITE);
        jTextFieldPrecio.setEditable(false);
        jTextFieldPrecio.setFont(new Font("Tahoma", Font.PLAIN, 12));
        jTextFieldPrecio.setBounds(72, 41, 227, 21);
        jPanel1.add(jTextFieldPrecio);
        
        jLabel3 = new javax.swing.JLabel();
        jLabel3.setBackground(Color.WHITE);
        jLabel3.setFont(new Font("Arial", Font.PLAIN, 12));
        jLabel3.setBounds(13, 74, 80, 19);
        jLabel3.setText("Disponible:");
        jLabel3.setBorder(null);
        jPanel1.add(jLabel3);
        
        jTextFieldDisponibilidad = new JTextField();
        jTextFieldDisponibilidad.setBackground(Color.WHITE);
        jTextFieldDisponibilidad.setEditable(false);
        jTextFieldDisponibilidad.setFont(new Font("Tahoma", Font.PLAIN, 12));
        jTextFieldDisponibilidad.setBounds(88, 73, 211, 21);
        if(productoSeleccionado.getCuantia() < 0){
        	jTextFieldDisponibilidad.setText("SI");
        }else{
        	jTextFieldDisponibilidad.setText("NO");
        }
        jPanel1.add(jTextFieldDisponibilidad);
        
        
        
        contentPane.add(jPanel1);
        
        btnAyuda = new JButton("Ayuda");
        btnAyuda.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		//TODO ayuda
        	}
        });
        btnAyuda.setBounds(10, 180, 139, 36);
        jPanel1.add(btnAyuda);
        
        btnAtrs = new JButton("Atrás");
        btnAtrs.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		listadoProductos.setVisible(false);
        		ventanaAnterior.setVisible(true);
        	}
        });
        btnAtrs.setBounds(160, 180, 139, 36);
        jPanel1.add(btnAtrs);
        
        if(esFarmacia){
        	btnEliminarProducto = new JButton("Eliminar producto");
            btnEliminarProducto.setBounds(10, 130, 139, 36);
            btnEliminarProducto.addActionListener(new ActionListener() {
            	public void actionPerformed(ActionEvent e) {
            		try {
						BBDDProductos.getInstance().eliminarProducto(cif, productoSeleccionado.getNombre());
					} catch (SQLException e1) {
						// TODO mensaje de error
					}
            	}
			});
            jPanel1.add(btnEliminarProducto);
            
            btnEditarProducto = new JButton("Editar producto");
            btnEditarProducto.addActionListener(new ActionListener() {
            	public void actionPerformed(ActionEvent e) {
            		FormProducto formProducto = new FormProducto(productoSeleccionado, cif, listadoProductos);
            	}
            });
            btnEditarProducto.setBounds(160, 130, 139, 39);
            jPanel1.add(btnEditarProducto);
        }
        
        
        listaProductos.setBounds(329, 404, 228, 227);
        contentPane.add(listaProductos);

        listaProductos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
            	jListProductosMouseReleased(evt);
            }
        });
    }


    private void jListProductosMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jListPersonasMouseReleased
        if(modelo.isEmpty()){
            JOptionPane.showMessageDialog(this,"La lista esta vacia");
        }else{
            Object objeto = listaProductos.getSelectedValue();
            Producto producto = (Producto) objeto;
            rellenarDatosProducto(producto);
        }
    }
    
    /**
     * Reyena los campos de texto de la ventana dependiendo del producto que se haya seleccionado de la lista
     * @param producto
     */
    private void rellenarDatosProducto(Producto producto) {
		jTextFieldNombre.setText(producto.getNombre());
		jTextFieldPrecio.setText(Double.toString(producto.getPrecio()) + "€");
		productoSeleccionado = producto;
			
	}

		

}