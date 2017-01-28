package interfazUsuario;


import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.sql.SQLException;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.awt.event.ActionEvent;

import javax.help.HelpSetException;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import excepciones.AlreadyExistException;
import excepciones.InvalidCIFException;
import excepciones.InvalidCuentaException;
import excepciones.InvalidNameException;
import excepciones.InvalidPasswordException;
import excepciones.InvalidTelefoneException;
import images.ImagenVF;
import logicaPrograma.Farmacia;
import logicaPrograma.Helper;
import persistencia.BBDDFarmacias;


/**
 * Clase que muestra un listado de farmacias, de las que se pueden saber los datos, 
 * y la lista de sus productos.
 * @author Eva y Alba
 *
 */
public class ListadoFarmacias extends JFrame {

	private static final long serialVersionUID = 1L;
	private ListadoFarmacias listadoFarmacias;

	JList<Farmacia> listaFarmacias;
	
	DefaultListModel<Farmacia> modelo; 
	
	private JPanel contentPane;
	private JPanel logoPanel;
	private JPanel jPanel1;
	private JLabel jLabel1;
	private JTextField jTextFieldNombre;
	private JLabel jLabel2;
	private JTextField jTextFieldHorario;
	private JTextField jTextFieldDireccion;
	private JLabel jLabel3;
	private JLabel jLabel4;
	private JTextField jTextFieldTelefono;
	private JButton jButtonProductos;
	private JButton btnAyuda;
	private JButton btnAtrs;
	
	private JButton btnVerDetallesDe;
	
	private Farmacia farmaciaSeleccionada;
	

    public ListadoFarmacias(WindowPaciente windowPaciente) {
    	
    	listadoFarmacias = this;
    	setResizable(false);
    	  
    	listaFarmacias = new JList<>();
    	listaFarmacias.setBorder(new LineBorder(new Color(0, 0, 0)));
    	
    	try {
			modelo = BBDDFarmacias.getInstance().getFarmacias();
		} catch (SQLException | InvalidNameException | InvalidCIFException | InvalidCuentaException
				| InvalidTelefoneException | InvalidPasswordException | AlreadyExistException e) {
			javax.swing.JOptionPane.showMessageDialog(null, "Ha habido un error en la conexión con la\nbase de datos, disculpe las molestias", "ERROR", javax.swing.JOptionPane.ERROR_MESSAGE);
		}
    	listaFarmacias.setModel(modelo);  
        
    	
        setTitle("Lista de farmacias");
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
        jTextFieldNombre.setFont(new Font("Tahoma", Font.PLAIN, 12));
        jTextFieldNombre.setBounds(72, 10, 227, 21);
        jPanel1.add(jTextFieldNombre);
        
        jLabel2 = new JLabel();
        jLabel2.setBackground(Color.WHITE);
        jLabel2.setFont(new Font("Arial", Font.PLAIN, 12));
        jLabel2.setBounds(13, 42, 45, 19);
        jLabel2.setText("Horario");
        jLabel2.setBorder(null);
        jPanel1.add(jLabel2);
        
        jTextFieldHorario = new JTextField();
        jTextFieldHorario.setBackground(Color.WHITE);
        jTextFieldHorario.setEditable(false);
        jTextFieldHorario.setFont(new Font("Tahoma", Font.PLAIN, 12));
        jTextFieldHorario.setBounds(72, 41, 227, 21);
        jPanel1.add(jTextFieldHorario);
        
        jLabel3 = new javax.swing.JLabel();
        jLabel3.setBackground(Color.WHITE);
        jLabel3.setFont(new Font("Arial", Font.PLAIN, 12));
        jLabel3.setBounds(13, 74, 56, 19);
        jLabel3.setText("Dirección");
        jLabel3.setBorder(null);
        jPanel1.add(jLabel3);
        
        jTextFieldDireccion = new JTextField();
        jTextFieldDireccion.setBackground(Color.WHITE);
        jTextFieldDireccion.setEditable(false);
        jTextFieldDireccion.setFont(new Font("Tahoma", Font.PLAIN, 12));
        jTextFieldDireccion.setBounds(72, 73, 227, 21);
        jPanel1.add(jTextFieldDireccion);
        
        jLabel4 = new javax.swing.JLabel();
        jLabel4.setBackground(Color.WHITE);
        jLabel4.setFont(new Font("Arial", Font.PLAIN, 12));
        jLabel4.setBounds(13, 105, 52, 19);
        jLabel4.setText("Telefono");
        jLabel4.setBorder(null);
        jPanel1.add(jLabel4);

        
        jTextFieldTelefono = new JTextField();
        jTextFieldTelefono.setBackground(Color.WHITE);
        jTextFieldTelefono.setEditable(false);
        jTextFieldTelefono.setFont(new Font("Arial", Font.PLAIN, 12));
        jTextFieldTelefono.setBounds(72, 104, 227, 21);
        jPanel1.add(jTextFieldTelefono);
        
        jButtonProductos = new JButton();
        jButtonProductos.setBackground(SystemColor.activeCaption);
        jButtonProductos.setFont(new Font("Arial", Font.PLAIN, 12));
        jButtonProductos.setBounds(13, 146, 289, 45);
        jButtonProductos.setText("Ver los productos de la farmacia");
        jButtonProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                if(farmaciaSeleccionada.getCIF() != null){
                	ListadoProductos lista = new ListadoProductos(farmaciaSeleccionada.getCIF(), listadoFarmacias, false);
                	lista.setVisible(true);
                	listadoFarmacias.setVisible(false);
                }else{
                	javax.swing.JOptionPane.showMessageDialog(null, "Debe seleccionar una farmacia para ver sus productos");
                }
            }
        });
        jPanel1.add(jButtonProductos);
        
        
        contentPane.add(jPanel1);
        
        btnAyuda = new JButton("Ayuda");
        btnAyuda.setBackground(SystemColor.activeCaption);
        btnAyuda.setFont(new Font("Arial", Font.PLAIN, 12));
        btnAyuda.setBounds(13, 202, 125, 36);
        try {
			Helper.getInstance().openHelp(btnAyuda, "lista_farmacias");
		} catch (MalformedURLException | HelpSetException e1) {
			javax.swing.JOptionPane.showMessageDialog(null, "Ha habido un error con el acceso a la\nayuda, disculpe las molestias.", "ERROR", javax.swing.JOptionPane.ERROR_MESSAGE);
		}
        jPanel1.add(btnAyuda);
        
        btnAtrs = new JButton("Atrás");
        btnAtrs.setBackground(SystemColor.activeCaption);
        btnAtrs.setFont(new Font("Arial", Font.PLAIN, 12));
        btnAtrs.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		listadoFarmacias.setVisible(false);
        		windowPaciente.setVisible(true);
        	}
        });
        btnAtrs.setBounds(174, 202, 125, 36);
        jPanel1.add(btnAtrs);
        
        listaFarmacias.setBounds(329, 404, 239, 200);
        listaFarmacias.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        contentPane.add(listaFarmacias);
        
        btnVerDetallesDe = new JButton("Detalles de la farmacia seleccionada");
        btnVerDetallesDe.setBackground(SystemColor.activeCaption);
        btnVerDetallesDe.setFont(new Font("Arial", Font.PLAIN, 12));
        btnVerDetallesDe.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		seleccionarFarmacia();
        	}
        });
        btnVerDetallesDe.setBounds(329, 608, 239, 23);
        contentPane.add(btnVerDetallesDe);
    }


    private void seleccionarFarmacia() {
        if(modelo.isEmpty()){
            JOptionPane.showMessageDialog(this,"La lista esta vacia");
        }else{
            Object objeto = listaFarmacias.getSelectedValue();
            farmaciaSeleccionada = (Farmacia) objeto;
            rellenarDatosFarmacia(farmaciaSeleccionada);
        }
    }
    
    private void rellenarDatosFarmacia(Farmacia farmacia) {
        jTextFieldNombre.setText(farmacia.getNombre());
        jTextFieldHorario.setText(farmacia.getHorario());
        jTextFieldDireccion.setText(farmacia.getDireccion());
        jTextFieldTelefono.setText(farmacia.getTelefono());
    }

 
}
