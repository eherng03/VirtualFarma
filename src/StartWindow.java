
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
	private JButton btnUser;
	private JButton btnAdmin;
	private JButton btnConect;
	private JButton btnAyuda;

	private MySql db = new MySql();
	private JPanel logoPanel;
	

    public StartWindow() {
        initComponents();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
    	
    	btnConect = new JButton();
    	btnAyuda = new JButton();
    	btnUser = new JButton();
    	btnAdmin = new JButton();
    	
    	
    	
    
    	
		setResizable(false);
		setTitle("Bienvenido");
		setBackground(new Color(255, 255, 255));
		setFont(new Font("Consolas", Font.PLAIN, 13));
	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 573, 595);
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
	 * CONECTAR
	 */
		btnConect.setText("Conectar a base de datos.");
		btnConect.setForeground(new Color(139, 0, 0));
		btnConect.setBackground(new Color(245, 245, 220));
		btnConect.setBounds(145, 395, 277, 31);
		btnConect.setFont(new Font("Lucida Sans Unicode", Font.PLAIN, 14));
		btnConect.setVisible(true);
		btnConect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				jButtonConnectActionPerformed(evt);
			}
		});
		contentPane.add(btnConect);
	/*
	 * AYUDA	
	 */
		btnAyuda.setText("Ayuda");
		btnAyuda.setBounds(239, 532, 88, 23);
		btnAdmin.setVisible(true);
		btnAyuda.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
    			abrirAyuda();
    		}
		});
		contentPane.add(btnAyuda);
		
	/*
	 * ADMIN
	 */
		btnAdmin.setText("Iniciar sesión como administrador.");
		btnAdmin.setEnabled(false);
		btnAdmin.setForeground(new Color(139, 0, 0));
		btnAdmin.setBackground(new Color(245, 245, 220));
		btnAdmin.setFont(new Font("Lucida Sans Unicode", Font.PLAIN, 14));
		btnAdmin.setBounds(145, 437, 277, 31);
		btnAdmin.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
    			iniciarSesionAdmin();
    		}
    	});
		contentPane.add(btnAdmin);
		
		
	/*
	 * USER
	 */
		btnUser.setToolTipText("Si no tienes cuenta de usuario ponte en contacto con recepción.");
		btnUser.setText("Iniciar sesión como usuario.");
		btnUser.setEnabled(false);
		btnUser.setFont(new Font("Lucida Sans Unicode", Font.PLAIN, 14));
		btnUser.setForeground(new Color(139, 0, 0));
		btnUser.setBackground(new Color(245, 245, 220));
		btnUser.setBounds(145, 479, 277, 31);
		btnUser.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
    			iniciarSesionUser();
    		}
    	});
		contentPane.add(btnUser);
		
		
	
		
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
		
        btnAdmin.setEnabled(true);
        btnUser.setEnabled(true);
        
		
	}
}