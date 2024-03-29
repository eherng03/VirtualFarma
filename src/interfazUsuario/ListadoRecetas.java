package interfazUsuario;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.sql.SQLException;

import javax.help.HelpSetException;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import excepciones.AlreadyExistException;
import images.ImagenVF;
import logicaPrograma.Helper;
import logicaPrograma.Receta;
import persistencia.BBDDRecetas;

/**
 * Clase contenedora de la ventana con el listado de recetas de un determinado paciente.
 * @author Eva
 *
 */
public class ListadoRecetas extends JFrame {


	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	private DefaultListModel<Receta> modelo;
	private JList<Receta> listaRecetas;
	
	private ImagenVF logoPanel;
	private JPanel jPanel1;
	private JLabel jLabel1;
	private JTextField jTextFieldNombre;
	private JLabel jLabel2;
	private JTextField jTextFieldCronica;
	private JLabel jLabel3;
	private JTextField jTextFieldDisponibilidad;
	private JButton btnAyuda;
	private JTextField textFieldNumEnvases;
	private JButton btnEliminar;
	
	private Receta recetaSeleccionada;
	private JButton btnVerDetallesDel;
	private JLabel lblNombreYFecha;


	/**
	 * Create the frame.
	 * @param windowPaciente 
	 * @param string 
	 */
	public ListadoRecetas(String dni, boolean desdeFarmacia) {
		
    	setResizable(false);
    	  
    	listaRecetas = new JList<>();
    	listaRecetas.setBorder(new LineBorder(new Color(0, 0, 0)));
    	
    	try {
			modelo = BBDDRecetas.getInstance().getRecetas(dni);
		} catch (SQLException e) {
			javax.swing.JOptionPane.showMessageDialog(null, "Ha habido un error en la conexión con la\nbase de datos, disculpe las molestias", "ERROR", javax.swing.JOptionPane.ERROR_MESSAGE);
		} catch (AlreadyExistException e1) {
			javax.swing.JOptionPane.showMessageDialog(null, "Ha habido un error en la conexión con la\nbase de datos, disculpe las molestias", "ERROR", javax.swing.JOptionPane.ERROR_MESSAGE);
		}
    	listaRecetas.setModel(modelo);  
        
    	
        setTitle("Lista de recetas");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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
        jPanel1.setBounds(10, 393, 309, 249);
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
        jTextFieldNombre.setFont(new Font("Arial", Font.PLAIN, 12));
        jTextFieldNombre.setBounds(72, 10, 227, 21);
        jPanel1.add(jTextFieldNombre);
        
        jLabel2 = new JLabel();
        jLabel2.setBackground(Color.WHITE);
        jLabel2.setFont(new Font("Arial", Font.PLAIN, 12));
        jLabel2.setBounds(13, 42, 45, 19);
        jLabel2.setText("Cronica");
        jLabel2.setBorder(null);
        jPanel1.add(jLabel2);
        
        jTextFieldCronica = new JTextField();
        jTextFieldCronica.setBackground(Color.WHITE);
        jTextFieldCronica.setEditable(false);
        jTextFieldCronica.setFont(new Font("Arial", Font.PLAIN, 12));
        jTextFieldCronica.setBounds(72, 41, 227, 21);
        jPanel1.add(jTextFieldCronica);
        
        jLabel3 = new JLabel();
        jLabel3.setBackground(Color.WHITE);
        jLabel3.setFont(new Font("Arial", Font.PLAIN, 12));
        jLabel3.setBounds(13, 74, 137, 19);
        jLabel3.setText("Fecha de disponibilidad");
        jLabel3.setBorder(null);
        jPanel1.add(jLabel3);
        
        jTextFieldDisponibilidad = new JTextField();
        jTextFieldDisponibilidad.setBackground(Color.WHITE);
        jTextFieldDisponibilidad.setEditable(false);
        jTextFieldDisponibilidad.setFont(new Font("Arial", Font.PLAIN, 12));
        jTextFieldDisponibilidad.setBounds(160, 73, 139, 21);
        jPanel1.add(jTextFieldDisponibilidad);
        
        
        
        contentPane.add(jPanel1);
        
        btnAyuda = new JButton("Ayuda");
        btnAyuda.setBackground(SystemColor.activeCaption);
        btnAyuda.setFont(new Font("Arial", Font.PLAIN, 12));
       
        btnAyuda.setBounds(10, 202, 139, 36);
        try {
			if(desdeFarmacia){
				Helper.getInstance().openHelp(btnAyuda, "lista_recetas_farmacias");
			}else{
				Helper.getInstance().openHelp(btnAyuda, "lista_recetas_pacientes");
			}
		} catch (MalformedURLException | HelpSetException e1) {
			javax.swing.JOptionPane.showMessageDialog(null, "Ha habido un error con el acceso a la\nayuda, disculpe las molestias.", "ERROR", javax.swing.JOptionPane.ERROR_MESSAGE);
		}
        jPanel1.add(btnAyuda);
       
        
        JLabel lblNumeroDeEnvases = new JLabel("Numero de envases");
        lblNumeroDeEnvases.setFont(new Font("Arial", Font.PLAIN, 12));
        lblNumeroDeEnvases.setBounds(13, 108, 137, 14);
        jPanel1.add(lblNumeroDeEnvases);
        
        textFieldNumEnvases = new JTextField();
        textFieldNumEnvases.setBackground(Color.WHITE);
        textFieldNumEnvases.setEditable(false);
        textFieldNumEnvases.setFont(new Font("Arial", Font.PLAIN, 12));
        textFieldNumEnvases.setBounds(160, 105, 139, 20);
        jPanel1.add(textFieldNumEnvases);
        textFieldNumEnvases.setColumns(10);
        
        if(desdeFarmacia){
        	btnEliminar = new JButton("Eliminar");
        	btnEliminar.setBounds(10, 130, 139, 36);
        	btnEliminar.setBackground(SystemColor.activeCaption);
        	btnEliminar.addActionListener(new ActionListener() {
            	public void actionPerformed(ActionEvent e) {
            		try {
						BBDDRecetas.getInstance().eliminarReceta(recetaSeleccionada.getDniPaciente(), recetaSeleccionada.getNombreMedicamento(), recetaSeleccionada.getFecha());
						JOptionPane.showMessageDialog(null,"El producto se ha eliminado con éxito");
					} catch (SQLException e1) {
						javax.swing.JOptionPane.showMessageDialog(null, "Ha habido un error en la conexión con la\nbase de datos, disculpe las molestias", "ERROR", javax.swing.JOptionPane.ERROR_MESSAGE);
					}
            	}
			});
            jPanel1.add(btnEliminar);
            
        }
        
        listaRecetas.setBounds(329, 415, 239, 187);
        contentPane.add(listaRecetas);
        
        btnVerDetallesDel = new JButton("Detalles de la receta seleccionada");
        btnVerDetallesDel.setBackground(SystemColor.activeCaption);
        btnVerDetallesDel.setFont(new Font("Arial", Font.PLAIN, 12));
        btnVerDetallesDel.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		seleccionarReceta();
        	}
        });
        btnVerDetallesDel.setBounds(329, 608, 239, 23);
        contentPane.add(btnVerDetallesDel);
        
        lblNombreYFecha = new JLabel("Nombre y fecha de la receta:");
        lblNombreYFecha.setFont(new Font("Arial", Font.PLAIN, 12));
        lblNombreYFecha.setBounds(329, 393, 228, 14);
        contentPane.add(lblNombreYFecha);
		
	}
	
	   private void seleccionarReceta() {
	        if(modelo.isEmpty()){
	            JOptionPane.showMessageDialog(this,"La lista esta vacia");
	        }else{
	            Object objeto = listaRecetas.getSelectedValue();
	            recetaSeleccionada = (Receta) objeto;
	            rellenarDatosReceta(recetaSeleccionada);
	        }
	    }
	   
	   
	    /**
	     * Reyena los campos de texto de la ventana dependiendo del producto que se haya seleccionado de la lista
	     * @param producto
	     */
	    private void rellenarDatosReceta(Receta receta) {
			jTextFieldNombre.setText(receta.getNombreMedicamento());
			textFieldNumEnvases.setText(receta.getnEnvases());
			if(receta.isCrónica()){
				jTextFieldCronica.setText("SI");
			}else{
				jTextFieldCronica.setText("NO");
			}
			jTextFieldDisponibilidad.setText(receta.getFecha());
			recetaSeleccionada = receta;
		}
	   
	   
}
