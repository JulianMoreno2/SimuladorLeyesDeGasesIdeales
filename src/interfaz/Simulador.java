package ar.edu.untref.simuladordegases.interfaz;

import java.awt.Color;

public class Simulador extends JFrame {
		
	/**
	 * Atributos
	 */
	private static final long serialVersionUID = 1L;
	private String presion = "12.300";
	private Integer moles = 25;
	private Float temperatura = (float) 300;
	private Integer volumen = 50;	
	private Color colorDePresion;
	
	/**
	 * Launch the application.
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
	
		final Simulador frame = new Simulador();
		frame.setBounds(0, 0, 930, 650);	
		frame.getContentPane().setLayout(null);
		
		final SpringLayout springLayout = new SpringLayout();
		frame.getContentPane().setLayout(springLayout);
		
		/**
		 * Contenedor de particulas
		 */		
		final JPanel contenedor = new Contenedor();		
		((Contenedor) contenedor).setLimites(80,80,380,450);
		springLayout.putConstraint(SpringLayout.NORTH, contenedor, 100, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, contenedor, 70, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, contenedor, 550, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, contenedor, 450, SpringLayout.WEST, frame.getContentPane());
		contenedor.setBackground(Color.WHITE);
		contenedor.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		frame.getContentPane().add(contenedor);
	
		/**
		 * Etiqueta "SIMULADOR DE GASES" y sus propiedades
		 */		
		JLabel lblSimuladorDeGases = new JLabel("SIMULADOR DE GASES");
		springLayout.putConstraint(SpringLayout.NORTH, lblSimuladorDeGases, 15, SpringLayout.NORTH, frame.getContentPane());
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
		sliderMoles.setMaximum(100);
		sliderMoles.setValue(50);
		sliderMoles.setMajorTickSpacing(10);
		sliderMoles.setMinorTickSpacing(5);
		sliderMoles.setPaintTicks(true);
		sliderMoles.setPaintLabels(true);
		frame.getContentPane().add(sliderMoles);
		
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
		JSlider sliderTemperatura = new JSlider();
		springLayout.putConstraint(SpringLayout.NORTH, sliderTemperatura, 312, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, sliderTemperatura, 553, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, sliderTemperatura, 868, SpringLayout.WEST, frame.getContentPane());
		
		sliderTemperatura.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				JSlider source = (JSlider) e.getSource();
				frame.setTemperatura((float) source.getValue());
			}
		});
		sliderTemperatura.setMaximum(600);
		sliderTemperatura.setMinimum(100);
		sliderTemperatura.setValue(350);
		sliderTemperatura.setMajorTickSpacing(100);
		sliderTemperatura.setMinorTickSpacing(50);
		sliderTemperatura.setPaintTicks(true);
		sliderTemperatura.setPaintLabels(true);
		frame.getContentPane().add(sliderTemperatura);
		
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
		JSlider sliderVolumen = new JSlider();
		springLayout.putConstraint(SpringLayout.NORTH, sliderVolumen, 424, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, sliderVolumen, 553, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, sliderVolumen, 868, SpringLayout.WEST, frame.getContentPane());
		sliderVolumen.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				JSlider source = (JSlider) e.getSource();
				frame.setVolumen((int) source.getValue());
			}
		});
		sliderVolumen.setMinimum(30);
		sliderVolumen.setMaximum(100);
		sliderVolumen.setValue(100);
		sliderVolumen.setMajorTickSpacing(10);
		sliderVolumen.setMinorTickSpacing(5);
		sliderVolumen.setPaintTicks(true);
		sliderVolumen.setPaintLabels(true);
		frame.getContentPane().add(sliderVolumen);
		
		/**
		 * Boton que actualiza el valor de la presion, el volumen y la temperatura del gas
		 */		
		JButton btnActualizar = new JButton("Actualizar");
		springLayout.putConstraint(SpringLayout.NORTH, btnActualizar, 42, SpringLayout.SOUTH, sliderVolumen);
		springLayout.putConstraint(SpringLayout.WEST, btnActualizar, 0, SpringLayout.WEST, lblTemperatura);
		springLayout.putConstraint(SpringLayout.SOUTH, btnActualizar, 550, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, btnActualizar, 131, SpringLayout.WEST, lblTemperatura);
		btnActualizar.addMouseListener(new MouseAdapter() {			
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.actualizar();
				//Modificación de la temperatura del gas
				((Contenedor)contenedor).modificarTemperaturaDeParticulas(frame.getTemperatura());	
				//Modificación de la cantidad de moles de gas
				((Contenedor)contenedor).modificarCantidadDeMoles(frame.getMoles());
				//Modificación del volumen del recipiente
				Integer nuevoBordeSur = (int) (550 * (frame.getVolumen()/100.0));
				Integer nuevoBordeEste = (int) (450 * (frame.getVolumen()/100.0));				
				((Contenedor)contenedor).setAncho(nuevoBordeEste - 70);
				((Contenedor)contenedor).setAlto(nuevoBordeSur - 100);
				springLayout.putConstraint(SpringLayout.SOUTH, contenedor, nuevoBordeSur, SpringLayout.NORTH, frame.getContentPane());
				springLayout.putConstraint(SpringLayout.EAST, contenedor, nuevoBordeEste, SpringLayout.WEST, frame.getContentPane());
				//Modificación de la etiqueta de presion
				lblAtm.setText(frame.getPresion() + " atm.");					
				lblAtm.setForeground(frame.getColorDePresion());
				
			}
		});
		btnActualizar.setFont(new Font("Droid Sans", Font.BOLD, 16));
		frame.getContentPane().add(btnActualizar);
		 		
		/*
		 * Primero genera todo el contenido y luego lo hace visible
		 * NOTA: Si esta sentencia esta al principio del main NO SE MUESTRA NADA
		 * NOTA2: Si esta sentencia esta al final del main, el frame nunca se hace visible porque precipitar() es infinito
		 */
	    frame.setVisible(true);
	    ((Contenedor) contenedor).precipitar();	
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
		this.calcularColorDePresion(presionResultante);
		DecimalFormat numberFormat = new DecimalFormat("#.000");		
		return numberFormat.format(presionResultante);
	}
	
	private void calcularColorDePresion(float PresionResultante) {
		Integer verde = (int) (255.0 * ((PresionResultante - 0.082) / 164.0));
		Color colorDePresion = new Color(255, 255 - verde, 0);	
		this.setColorDePresion(colorDePresion);
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

	public int getVolumen() {
		return volumen;
	}

	public void setVolumen(int volumen) {
		this.volumen = volumen;
	}

	public String getPresion() {
		return presion;
	}

	public void setPresion(String presion) {
		this.presion = presion;
	}

	public Color getColorDePresion() {
		return colorDePresion;
	}

	public void setColorDePresion(Color colorDePresion) {
		this.colorDePresion = colorDePresion;
	}	
}
