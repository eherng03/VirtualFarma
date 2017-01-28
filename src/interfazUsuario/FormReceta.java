package interfazUsuario;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.sql.SQLException;

import javax.help.HelpSetException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JCheckBox;
import javax.swing.JSpinner;

import excepciones.AlreadyExistException;
import images.ImagenVF;
import logicaPrograma.Helper;
import persistencia.BBDDRecetas;


/**
 * Clase formulario para crear recetas
 * @author Eva y alba
 *
 */
public class FormReceta extends JFrame {

	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private String dniMedico;
	private WindowMedico windowMedico;
	private FormReceta formReceta;
	private JPanel logoPanel;
	private JTextField textFieldDNIPaciente;
	private JTextField textFieldNombreMedicamento;
	private JTextField textFieldFecha;
	private JTextField textFieldDuracion;
	private JTextField textFieldInstrucciones;
	private JCheckBox chckbxRecetaCrnica;
	private JSpinner spinnerNEnvases;
	private JSpinner spinnerUnidades;
	private JSpinner spinnerFrecuencia;

	public FormReceta(String dniMedicoX, WindowMedico windowMedico) {
		//TODO testear
		this.dniMedico = dniMedicoX;
		formReceta = this;
		this.windowMedico = windowMedico;
		
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 584, 671);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(SystemColor.textHighlightText);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		/*
		 * LOGO
		 */
		logoPanel = new ImagenVF(547, 382);
		logoPanel.setBackground(Color.WHITE);
		logoPanel.setBounds(10, 0, 547, 382);
		contentPane.add(logoPanel);
		
		
		
		JButton btnIntroducir = new JButton("Introducir");
		btnIntroducir.addActionListener(new ActionListener() {
			//TODO test
			public void actionPerformed(ActionEvent e) {
				try {
					String cronica = "false";
					if(chckbxRecetaCrnica.isSelected()){
						cronica = "true";
					}
					BBDDRecetas.getInstance().introducirReceta(textFieldDNIPaciente.getText(), dniMedico, textFieldNombreMedicamento.getText(), cronica,
							textFieldFecha.getText(), spinnerUnidades.getValue().toString(), spinnerFrecuencia.getValue().toString(), textFieldDuracion.getText(), 
							textFieldInstrucciones.getText(), spinnerNEnvases.getValue().toString());
				} catch (SQLException | AlreadyExistException e1) {
					javax.swing.JOptionPane.showMessageDialog(null, "Ha habido un error en la conexión con la\nbase de datos, disculpe las molestias.", "ERROR", javax.swing.JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		btnIntroducir.setFont(new Font("Arial", Font.PLAIN, 12));
		btnIntroducir.setBounds(10, 554, 547, 33);
		contentPane.add(btnIntroducir);
		
		JButton btnAyuda = new JButton("Ayuda");
		btnAyuda.setFont(new Font("Arial", Font.PLAIN, 12));
		btnAyuda.setBounds(294, 598, 263, 33);
		contentPane.add(btnAyuda);
		try {
			Helper.getInstance().openHelp(btnAyuda, "crear_receta");
		} catch (MalformedURLException | HelpSetException e1) {
			javax.swing.JOptionPane.showMessageDialog(null, "Ha habido un error con el acceso a la\nayuda, disculpe las molestias.", "ERROR", javax.swing.JOptionPane.ERROR_MESSAGE);
		}
		
		JButton btnAtrs = new JButton("Atrás");
		btnAtrs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				volverAtras();
			}
		});
		btnAtrs.setFont(new Font("Arial", Font.PLAIN, 12));
		btnAtrs.setBounds(10, 598, 263, 33);
		contentPane.add(btnAtrs);
		
		JLabel lblDniPaciente = new JLabel("DNI paciente:");
		lblDniPaciente.setFont(new Font("Arial", Font.PLAIN, 12));
		lblDniPaciente.setBounds(10, 393, 81, 14);
		contentPane.add(lblDniPaciente);
		
		textFieldDNIPaciente = new JTextField();
		textFieldDNIPaciente.setBounds(91, 391, 163, 20);
		contentPane.add(textFieldDNIPaciente);
		textFieldDNIPaciente.setColumns(10);
		
		chckbxRecetaCrnica = new JCheckBox("Receta crónica");
		chckbxRecetaCrnica.setFont(new Font("Arial", Font.PLAIN, 12));
		chckbxRecetaCrnica.setBackground(Color.WHITE);
		chckbxRecetaCrnica.setBounds(446, 389, 126, 23);
		contentPane.add(chckbxRecetaCrnica);
		
		spinnerNEnvases = new JSpinner();
		spinnerNEnvases.setBounds(390, 391, 29, 20);
		contentPane.add(spinnerNEnvases);
		
		JLabel lblNumeroDeEnvases = new JLabel("Numero de envases");
		lblNumeroDeEnvases.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNumeroDeEnvases.setBounds(264, 394, 116, 14);
		contentPane.add(lblNumeroDeEnvases);
		
		JLabel lblNombreMedicamento = new JLabel("Nombre medicamento");
		lblNombreMedicamento.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNombreMedicamento.setBounds(10, 418, 131, 14);
		contentPane.add(lblNombreMedicamento);
		
		textFieldNombreMedicamento = new JTextField();
		textFieldNombreMedicamento.setBounds(142, 416, 415, 20);
		contentPane.add(textFieldNombreMedicamento);
		textFieldNombreMedicamento.setColumns(10);
		
		JLabel lblFecha = new JLabel("Fecha");
		lblFecha.setFont(new Font("Arial", Font.PLAIN, 12));
		lblFecha.setBounds(10, 443, 46, 14);
		contentPane.add(lblFecha);
		
		textFieldFecha = new JTextField();
		textFieldFecha.setBounds(66, 441, 162, 20);
		contentPane.add(textFieldFecha);
		textFieldFecha.setColumns(10);
		
		JLabel lblUnidadesPorToma = new JLabel("Unidades por toma");
		lblUnidadesPorToma.setFont(new Font("Arial", Font.PLAIN, 12));
		lblUnidadesPorToma.setBounds(269, 443, 126, 14);
		contentPane.add(lblUnidadesPorToma);
		
		spinnerUnidades = new JSpinner();
		spinnerUnidades.setBounds(390, 441, 29, 20);
		contentPane.add(spinnerUnidades);
		
		JLabel lblFrecuencia = new JLabel("Frecuencia");
		lblFrecuencia.setFont(new Font("Arial", Font.PLAIN, 12));
		lblFrecuencia.setBounds(444, 443, 74, 14);
		contentPane.add(lblFrecuencia);
		
		spinnerFrecuencia = new JSpinner();
		spinnerFrecuencia.setBounds(528, 441, 29, 20);
		contentPane.add(spinnerFrecuencia);
		
		JLabel lblDuracionDelTratamiento = new JLabel("Duracion del tratamiento");
		lblDuracionDelTratamiento.setFont(new Font("Arial", Font.PLAIN, 12));
		lblDuracionDelTratamiento.setBounds(10, 471, 149, 14);
		contentPane.add(lblDuracionDelTratamiento);
		
		textFieldDuracion = new JTextField();
		textFieldDuracion.setBounds(159, 469, 398, 20);
		contentPane.add(textFieldDuracion);
		textFieldDuracion.setColumns(10);
		
		JLabel lblInstruccionesEspeciales = new JLabel("Instrucciones especiales");
		lblInstruccionesEspeciales.setFont(new Font("Arial", Font.PLAIN, 12));
		lblInstruccionesEspeciales.setBounds(10, 511, 149, 14);
		contentPane.add(lblInstruccionesEspeciales);
		
		textFieldInstrucciones = new JTextField();
		textFieldInstrucciones.setBounds(159, 496, 398, 47);
		contentPane.add(textFieldInstrucciones);
		textFieldInstrucciones.setColumns(10);
	}


	protected void volverAtras() {
		formReceta.setVisible(false);
		windowMedico.setVisible(true);
	}
}
