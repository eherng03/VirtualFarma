package interfazUsuario;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.awt.event.ActionEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.help.HelpSetException;
import javax.swing.JButton;

import images.ImagenVF;
import logicaPrograma.Helper;


/**
 * Ventana que contiene todas las operaciones que puede realizar un médico
 * @author Eva y Alba
 *
 */
public class WindowMedico extends JFrame {
	
	private static final long serialVersionUID = 1L;
	

	private JPanel contentPane;
	private IniciarSesion iniciarSesion;
	private WindowMedico windowMedico;
	private JPanel logoPanel;




	public WindowMedico(String dniMedico, IniciarSesion iniciarSesionX) {
		windowMedico = this;
		this.iniciarSesion = iniciarSesionX;
		
		setTitle("Medico");
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
		
		JButton btnCrearReceta = new JButton("Crear receta");
		btnCrearReceta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FormReceta formReceta = new FormReceta(dniMedico, windowMedico);
				formReceta.setVisible(true);
				windowMedico.setVisible(false);
			}
		});
		btnCrearReceta.setBackground(SystemColor.activeCaption);
		btnCrearReceta.setFont(new Font("Arial", Font.PLAIN, 15));
		btnCrearReceta.setBounds(10, 393, 547, 164);
		contentPane.add(btnCrearReceta);
		
		JButton btnAtrs = new JButton("Cerrar sesión");
		btnAtrs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				windowMedico.setVisible(false);
				iniciarSesion.setVisible(true);
			}
		});
		btnAtrs.setBackground(SystemColor.activeCaption);
		btnAtrs.setFont(new Font("Arial", Font.PLAIN, 15));
		btnAtrs.setBounds(10, 568, 262, 63);
		contentPane.add(btnAtrs);
		
		JButton btnAyuda = new JButton("Ayuda");
		btnAyuda.setBackground(SystemColor.activeCaption);
		btnAyuda.setFont(new Font("Arial", Font.PLAIN, 15));
		btnAyuda.setBounds(295, 568, 262, 63);
		contentPane.add(btnAyuda);
		try {
			Helper.getInstance().openHelp(btnAyuda, "ventana_medico");
		} catch (MalformedURLException | HelpSetException e1) {
			javax.swing.JOptionPane.showMessageDialog(null, "Ha habido un error con el acceso a la\nayuda, disculpe las molestias.", "ERROR", javax.swing.JOptionPane.ERROR_MESSAGE);
		}
		
	}
}
