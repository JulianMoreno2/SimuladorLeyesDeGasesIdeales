package interfaz;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.text.DecimalFormat;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;

import implementacion.Contenedor;

public class Simulador extends JFrame {
	
	/**
	 * Atributos
	 */
	private static final long serialVersionUID = 1L;
	private JSlider sliderMoles;
	private JSlider sliderTemperatura;
	private JSlider sliderVolumen;
	private String presion = "12.3";
	private Integer moles = 25;
	private Float temperatura = (float) 300;
	private Float volumen = (float) 50;	
	
	/**
	 * Launch the application.
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
	
		Simulador frame = new Simulador();
		frame.setBounds(0, 0, 930, 650);	
		frame.setVisible(true);		
		frame.getContentPane().setLayout(null); 
		//frame.setBackground(Color.GRAY);
		
		SpringLayout springLayout = new SpringLayout();
		frame.getContentPane().setLayout(springLayout);
		
		/**
		 * Contenedor de particulas
		 */
		JPanel contenedor = new Contenedor();
		((Contenedor) contenedor).setLimites(80,80,220,220);
		springLayout.putConstraint(SpringLayout.NORTH, contenedor, 80, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, contenedor, 80, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, contenedor, 300, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, contenedor, 300, SpringLayout.WEST, frame.getContentPane());
		contenedor.setBackground(Color.WHITE);
		contenedor.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		frame.getContentPane().add(contenedor);
		
		/**
		 * Etiqueta "SIMULADOR DE GASES" y sus propiedades
		 */		
		JLabel lblSimuladorDeGases = new JLabel("SIMULADOR DE GASES");
		springLayout.putConstraint(SpringLayout.NORTH, lblSimuladorDeGases, 0, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, lblSimuladorDeGases, 63, SpringLayout.WEST, frame.getContentPane());
		lblSimuladorDeGases.setForeground(SystemColor.desktop);
		lblSimuladorDeGases.setFont(new Font("Droid Sans", Font.BOLD, 40));
		frame.getContentPane().add(lblSimuladorDeGases);
	
		/**
		 * Etiqueta "PRESION RESULTANTE" y sus propiedades
		 */		
		JLabel lblPresionResultante = new JLabel("PRESION RESULTANTE");
		springLayout.putConstraint(SpringLayout.NORTH, lblPresionResultante, 53, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, lblPresionResultante, 606, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, lblPresionResultante, 80, SpringLayout.NORTH, frame.getContentPane());
		lblPresionResultante.setFont(new Font("Droid Sans", Font.BOLD, 20));
		frame.getContentPane().add(lblPresionResultante);
		
		/**
		 * Etiqueta que muestra la presion resultante
		 */		
		final JLabel lblAtm = new JLabel(frame.presion + " atm.");
		springLayout.putConstraint(SpringLayout.NORTH, lblAtm, 85, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, lblAtm, 667, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, lblAtm, 118, SpringLayout.NORTH, frame.getContentPane());
		lblAtm.setForeground(new Color(128, 0, 128));
		lblAtm.setFont(new Font("Droid Sans", Font.BOLD, 20));
		frame.getContentPane().add(lblAtm);
				
		/**
		 * Etiqueta "moles"
		 */		
		JLabel lblMoles = new JLabel("Moles");
		springLayout.putConstraint(SpringLayout.NORTH, lblMoles, 167, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, lblMoles, 690, SpringLayout.WEST, frame.getContentPane());
		lblMoles.setHorizontalAlignment(SwingConstants.CENTER);
		lblMoles.setFont(new Font("Droid Sans", Font.BOLD, 14));
		lblMoles.setForeground(new Color(0, 128, 0));
		frame.getContentPane().add(lblMoles);	
		
		/**
		 * Slider que define la cantidad de moles de gas
		 */
		/**
		JSlider sliderMoles = new JSlider();	
		springLayout.putConstraint(SpringLayout.NORTH, sliderMoles, 189, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, sliderMoles, 553, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, sliderMoles, 868, SpringLayout.WEST, frame.getContentPane());
		sliderMoles.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				JSlider source = (JSlider) e.getSource();
				frame.setMoles(source.getValue());
			}
		});
		sliderMoles.setValue(25);
		sliderMoles.setMaximum(50);
		sliderMoles.setMajorTickSpacing(5);
		sliderMoles.setMinorTickSpacing(10);
		sliderMoles.setPaintTicks(true);
		sliderMoles.setPaintLabels(true);
		frame.getContentPane().add(sliderMoles);
		*/
		
		/**
		 * Etiqueta "temperatura"
		 */		
		JLabel lblTemperatura = new JLabel("Temperatura (K)");
		springLayout.putConstraint(SpringLayout.NORTH, lblTemperatura, 290, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, lblTemperatura, 653, SpringLayout.WEST, frame.getContentPane());
		lblTemperatura.setFont(new Font("Droid Sans", Font.BOLD, 14));
		lblTemperatura.setForeground(Color.RED);
		frame.getContentPane().add(lblTemperatura);
		
		/**
		 * Slider que define la temperatura del recipiente
		 */
		/**
		sliderTemperatura = new JSlider();
		springLayout.putConstraint(SpringLayout.NORTH, sliderTemperatura, 312, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, sliderTemperatura, 553, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, sliderTemperatura, 868, SpringLayout.WEST, getContentPane());
		sliderTemperatura.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				JSlider source = (JSlider) e.getSource();
				setTemperatura((float) source.getValue());
			}
		});
		sliderTemperatura.setValue(300);
		sliderTemperatura.setMaximum(600);
		sliderTemperatura.setMajorTickSpacing(100);
		sliderTemperatura.setMinorTickSpacing(50);
		sliderTemperatura.setPaintTicks(true);
		sliderTemperatura.setPaintLabels(true);
		getContentPane().add(sliderTemperatura);
		*/
		/**
		 * Etiqueta "volumen"
		 */
		
		JLabel lblVolumen = new JLabel("Volumen (l)");
		springLayout.putConstraint(SpringLayout.NORTH, lblVolumen, 402, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, lblVolumen, 670, SpringLayout.WEST, frame.getContentPane());
		lblVolumen.setFont(new Font("Droid Sans", Font.BOLD, 14));
		lblVolumen.setForeground(Color.BLUE);
		frame.getContentPane().add(lblVolumen);
		
		/**
		 * Slider que define el volumen del recipiente
		 */
		/**
		sliderVolumen = new JSlider();
		springLayout.putConstraint(SpringLayout.NORTH, sliderVolumen, 424, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, sliderVolumen, 553, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, sliderVolumen, 868, SpringLayout.WEST, getContentPane());
		sliderVolumen.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				JSlider source = (JSlider) e.getSource();
				setVolumen((float) source.getValue());
			}
		});
		sliderVolumen.setValue(50);
		sliderVolumen.setMaximum(100);
		sliderVolumen.setMajorTickSpacing(10);
		sliderVolumen.setMinorTickSpacing(5);
		sliderVolumen.setPaintTicks(true);
		sliderVolumen.setPaintLabels(true);
		getContentPane().add(sliderVolumen);
		*/
		/**
		 * Boton que actualiza el valor de la presion y el comportamiento de las particulas del gas en el recipiente
		 */
		/**
		JButton btnActualizar = new JButton("Actualizar");
		springLayout.putConstraint(SpringLayout.NORTH, btnActualizar, 42, SpringLayout.SOUTH, sliderVolumen);
		springLayout.putConstraint(SpringLayout.WEST, btnActualizar, 0, SpringLayout.WEST, lblTemperatura);
		springLayout.putConstraint(SpringLayout.SOUTH, btnActualizar, 550, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, btnActualizar, 131, SpringLayout.WEST, lblTemperatura);
		btnActualizar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				actualizar();
				lblAtm.setText(presion + " atm.");
			}
		});
		btnActualizar.setFont(new Font("Droid Sans", Font.BOLD, 16));
		getContentPane().add(btnActualizar);
		 */
		
		((Contenedor) contenedor).precipitar();	
	}
	
	/**
	 * Create the frame.
	 * @throws InterruptedException 
	 */
	public Simulador() throws InterruptedException {
		
		
	}
	
	/**
	 * Accion ejecutada al presionar el boton "actualizar"
	 * El valor de la presion resultante y el movimiento de las particulas deben actualizarse aqui
	 */
	private void actualizar(){
		this.presion = this.leyDeGasesIdeales();			
	}
	
	/**
	 * Calculo de presion basado en la Ley de los Gases Ideales
	 */
	public String leyDeGasesIdeales(){
		Float constanteDeGases = new Float(0.082);
		Float presionResultante = (this.getMoles() * constanteDeGases * this.getTemperatura())/this.getVolumen();
		DecimalFormat numberFormat = new DecimalFormat("#.000");		
		return numberFormat.format(presionResultante);
	}

	public Integer getMoles() {
		return moles;
	}

	public void setMoles(Integer moles) {
		this.moles = moles;
	}

	public Float getTemperatura() {
		return temperatura;
	}

	public void setTemperatura(Float temperatura) {
		this.temperatura = temperatura;
	}

	public Float getVolumen() {
		return volumen;
	}

	public void setVolumen(Float volumen) {
		this.volumen = volumen;
	}

	public String getPresion() {
		return presion;
	}

	public void setPresion(String presion) {
		this.presion = presion;
	}	
}

