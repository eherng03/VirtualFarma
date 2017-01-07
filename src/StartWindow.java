
import java.awt.Color;
import java.awt.Font;

import java.awt.event.ActionListener;

import java.awt.event.ActionEvent;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.border.EmptyBorder;




public class StartWindow extends JFrame {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = -8217358516629805849L;
	
	private JPanel contentPane;
	private JButton btnInitPaciente;
	private JButton btnInitAdmin;
	private JButton btnInitFarmacia;
	private JButton btnInitMedico;
	private JButton btnAyuda;

	private MySql db = new MySql();
	private JPanel logoPanel;
	private JButton btnRegistrarPaciente;
	

    public StartWindow() {
        initComponents();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
    	
    	btnInitFarmacia = new JButton();
    	btnAyuda = new JButton();
    	btnInitPaciente = new JButton();
    	btnInitAdmin = new JButton();
    	btnInitMedico = new JButton();
    	
    	//Conectar bbdd
    	
    
    	
		setResizable(false);
		setTitle("Bienvenido");
		setBackground(new Color(255, 255, 255));
		setFont(new Font("Consolas", Font.PLAIN, 13));
	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 573, 671);
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
		
		
	
	/*
	 * AYUDA	
	 */
		btnAyuda.setText("Ayuda");
		btnAyuda.setBounds(244, 604, 88, 23);
		btnInitAdmin.setVisible(true);
		btnAyuda.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
    			abrirAyuda();
    		}
		});
		contentPane.add(btnAyuda);
		
	/*
	 * ADMIN
	 */
		btnInitAdmin.setText("Iniciar sesión como administrador.");
		btnInitAdmin.setForeground(new Color(139, 0, 0));
		btnInitAdmin.setBackground(new Color(245, 245, 220));
		btnInitAdmin.setFont(new Font("Lucida Sans Unicode", Font.PLAIN, 14));
		btnInitAdmin.setBounds(141, 393, 269, 31);
		btnInitAdmin.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
    			iniciarSesionX("admin");
    		}
    	});
		contentPane.add(btnInitAdmin);
		
	/*
	 * FARMACIA
	 */
		btnInitFarmacia.setText("Iniciar sesión como farmacia.");
		btnInitFarmacia.setForeground(new Color(139, 0, 0));
		btnInitFarmacia.setBackground(new Color(245, 245, 220));
		btnInitFarmacia.setBounds(141, 435, 269, 31);
		btnInitFarmacia.setFont(new Font("Lucida Sans Unicode", Font.PLAIN, 14));
		btnInitFarmacia.setVisible(true);
		btnInitFarmacia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				iniciarSesionX("farmacia");
			}
		});
		contentPane.add(btnInitFarmacia);	
		
	/*
	 * PACIENTE
	 */
		
		//INICIO DE SESION
		
		btnInitPaciente.setToolTipText("Si no tiene cuenta de usuario haga clic en crear cuenta de usuario");
		btnInitPaciente.setText("Iniciar sesión como usuario.");
		btnInitPaciente.setFont(new Font("Lucida Sans Unicode", Font.PLAIN, 14));
		btnInitPaciente.setForeground(new Color(139, 0, 0));
		btnInitPaciente.setBackground(new Color(245, 245, 220));
		btnInitPaciente.setBounds(141, 520, 269, 31);
		btnInitPaciente.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
    			iniciarSesionX("paciente");
    		}
    	});
		contentPane.add(btnInitPaciente);
		
		//REGISTRO
		
		btnRegistrarPaciente = new JButton();
		btnRegistrarPaciente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				registrarPaciente();
			}
		});
		btnRegistrarPaciente.setText("Crear cuenta de usuario.");
		btnRegistrarPaciente.setForeground(new Color(139, 0, 0));
		btnRegistrarPaciente.setFont(new Font("Lucida Sans Unicode", Font.PLAIN, 14));
		btnRegistrarPaciente.setBackground(new Color(245, 245, 220));
		btnRegistrarPaciente.setBounds(141, 562, 269, 31);
		contentPane.add(btnRegistrarPaciente);
	
	/*
	 * MEDICO
	 */
		btnInitMedico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				iniciarSesionX("medico");
			}
		});
		btnInitMedico.setToolTipText("Si no tiene cuenta de médico pongase en contacto con administración.");
		btnInitMedico.setText("Iniciar sesión como médico.");
		btnInitMedico.setForeground(new Color(139, 0, 0));
		btnInitMedico.setFont(new Font("Lucida Sans Unicode", Font.PLAIN, 14));
		btnInitMedico.setBackground(new Color(245, 245, 220));
		btnInitMedico.setBounds(141, 478, 269, 31);
		contentPane.add(btnInitMedico);
			
	}

	


	protected void registrarPaciente() {
		FormPaciente registro = new FormPaciente();
		registro.setPadre(this);
		registro.setVisible(true);
		this.setVisible(false);
	}

	protected void abrirAyuda() {
		
		
	}

	protected void iniciarSesionX(String rol) {
		IniciarSesion ini = new IniciarSesion(rol);
		ini.setPadre(this);
		ini.setVisible(true);
		this.setVisible(false);
	}

	private void jButtonConnectActionPerformed(ActionEvent evt) {
		db.MySQLConnection("root", "", "Gym");
		
        btnInitAdmin.setEnabled(true);
        btnInitPaciente.setEnabled(true);
        
		
	}
}