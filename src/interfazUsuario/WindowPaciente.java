package interfazUsuario;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import images.ImagenVF;
import logicaPrograma.Paciente;

import javax.swing.JButton;
import java.awt.event.ActionListener;
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
		
		JButton btnShowChemistry = new JButton("Ver lista de farmacias y/o \r\ndisponibilidad de un medicamento");
		btnShowChemistry.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				showWindowChemistryList();
			}
		});
		btnShowChemistry.setBounds(117, 449, 335, 34);
		contentPane.add(btnShowChemistry);
		
		btnConsultarRecetas = new JButton("Consultar recetas");
		btnConsultarRecetas.setBounds(117, 404, 335, 34);
		contentPane.add(btnConsultarRecetas);
		
		JButton btnDarseDeBaja = new JButton("Darse de baja");
		btnDarseDeBaja.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//TODO ventana de introduzca la contraseeña para comprobar su identidad.
				paciente.eliminar();
			}
		});
		btnDarseDeBaja.setBounds(117, 494, 335, 34);
		contentPane.add(btnDarseDeBaja);
		
		
	}
	
	protected void showWindowChemistryList() {
		// TODO Auto-generated method stub
		
	}

	public void darDeBaja(){
		
	}
}
