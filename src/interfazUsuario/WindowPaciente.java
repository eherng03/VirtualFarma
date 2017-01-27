package interfazUsuario;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import images.ImagenVF;
import logicaPrograma.Paciente;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class WindowPaciente extends JFrame {

	private JPanel contentPane;
	private JPanel logoPanel;
	private JButton btnConsultarRecetas;
	private Paciente paciente;
	private IniciarSesion padre;


	/**
	 * Create the frame.
	 * @param iniciarSesion 
	 */
	public WindowPaciente(Paciente paciente, IniciarSesion iniciarSesion) {
		
		this.padre = iniciarSesion;
		this.paciente = paciente;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 584, 671);
		contentPane = new JPanel();		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
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
		
		JButton btnShowChemistry = new JButton("Ver lista de farmacias y/o \r\ndisponibilidad de un medicamento");
		btnShowChemistry.setFont(new Font("Arial", Font.PLAIN, 12));
		btnShowChemistry.setBackground(SystemColor.activeCaption);
		btnShowChemistry.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				showWindowChemistryList();
			}
		});
		btnShowChemistry.setBounds(10, 449, 547, 34);
		contentPane.add(btnShowChemistry);
		
		btnConsultarRecetas = new JButton("Consultar recetas");
		btnConsultarRecetas.setFont(new Font("Arial", Font.PLAIN, 12));
		btnConsultarRecetas.setBackground(SystemColor.activeCaption);
		btnConsultarRecetas.setBounds(10, 404, 547, 34);
		contentPane.add(btnConsultarRecetas);
		
		JButton btnDarseDeBaja = new JButton("Darse de baja");
		btnDarseDeBaja.setFont(new Font("Arial", Font.PLAIN, 12));
		btnDarseDeBaja.setBackground(SystemColor.activeCaption);
		btnDarseDeBaja.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//TODO ventana de introduzca la contraseeña para comprobar su identidad.
				try {
					paciente.eliminar();
				} catch (SQLException e) {
					javax.swing.JOptionPane.showMessageDialog(null, "Ha habido un error en la conexión con la\nbase de datos, disculpe las molestias", "ERROR", javax.swing.JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnDarseDeBaja.setBounds(10, 494, 547, 34);
		contentPane.add(btnDarseDeBaja);
		
		
		JButton btnAyuda = new JButton("Ayuda");
		btnAyuda.setBackground(SystemColor.activeCaption);
		btnAyuda.setFont(new Font("Arial", Font.PLAIN, 12));
		btnAyuda.setBounds(238, 608, 89, 23);
		contentPane.add(btnAyuda);
		
		
	}
	
	protected void showWindowChemistryList() {
		// TODO Auto-generated method stub
		
	}

	public void darDeBaja(){
		
	}
}
