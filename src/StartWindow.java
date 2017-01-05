
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
	private JButton btnInitUser;
	private JButton btnInitAdmin;
	private JButton btnInitFarmacia;
	private JButton btnInitMedico;
	private JButton btnAyuda;

	private MySql db = new MySql();
	private JPanel logoPanel;
	private JButton btnRegistrarUser;
	

    public StartWindow() {
        initComponents();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
    	
    	btnInitFarmacia = new JButton();
    	btnAyuda = new JButton();
    	btnInitUser = new JButton();
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
    			iniciarSesionAdmin();
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
				//jButtonConnectActionPerformed(evt);
			}
		});
		contentPane.add(btnInitFarmacia);	
		
	/*
	 * USER
	 */
		
		//INICIO DE SESION
		
		btnInitUser.setToolTipText("Si no tiene cuenta de usuario haga clic en crear cuenta de usuario");
		btnInitUser.setText("Iniciar sesión como usuario.");
		btnInitUser.setFont(new Font("Lucida Sans Unicode", Font.PLAIN, 14));
		btnInitUser.setForeground(new Color(139, 0, 0));
		btnInitUser.setBackground(new Color(245, 245, 220));
		btnInitUser.setBounds(141, 520, 269, 31);
		btnInitUser.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
    			iniciarSesionUser();
    		}
    	});
		contentPane.add(btnInitUser);
		
		//REGISTRO
		
		btnRegistrarUser = new JButton();
		btnRegistrarUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				registrarUsuario();
			}
		});
		btnRegistrarUser.setText("Crear cuenta de usuario.");
		btnRegistrarUser.setForeground(new Color(139, 0, 0));
		btnRegistrarUser.setFont(new Font("Lucida Sans Unicode", Font.PLAIN, 14));
		btnRegistrarUser.setBackground(new Color(245, 245, 220));
		btnRegistrarUser.setBounds(141, 562, 269, 31);
		contentPane.add(btnRegistrarUser);
	
	/*
	 * MEDICO
	 */
		btnInitMedico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
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

	protected void registrarUsuario() {
		// TODO Auto-generated method stub
		
	}

	protected void abrirAyuda() {
		
		
	}

	protected void iniciarSesionAdmin() {
		IniciarSesion ini = new IniciarSesion(true);
		ini.setPadre(this);
		ini.setVisible(true);
		
	}

	protected void iniciarSesionUser() {
		IniciarSesion ini = new IniciarSesion(false);
		
	}

	private void jButtonConnectActionPerformed(ActionEvent evt) {
		db.MySQLConnection("root", "", "Gym");
		
        btnInitAdmin.setEnabled(true);
        btnInitUser.setEnabled(true);
        
		
	}
}