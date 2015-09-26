package interfaz;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;

import implementacion.Particula;
import implementacion.Vaso;

public class VentanaPrincipal extends JFrame {
	
	private static final long serialVersionUID = 1L;
	/**
	 * Proximo objetivo: agregar un boton para meter mas particulas en el vaso de precipitados.
	 */	
	
	/**
	 * Launch the application.
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
				
		JFrame frame = new JFrame("Vaso de Precipitados");
		
		Vaso vaso = new Vaso();
		vaso.setAncho(400);
		vaso.setAlto(300);				
		vaso.setBounds(0, 0, vaso.getAncho(), vaso.getAlto());
		vaso.setBorder(BorderFactory.createLineBorder(Color.black)); 	
		
		frame.setBounds(100, 100, 745, 533);	
		frame.getContentPane().setLayout(null);
		frame.add(vaso);			
		frame.setVisible(true);				
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);					
			
		JButton btnAddParticle = new JButton("Agregar particula");
		btnAddParticle.setBounds(410, 10, 120, 39);
		frame.getContentPane().add(btnAddParticle);
		btnAddParticle.addActionListener(new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent arg0) {
				vaso.agregarParticula(new Particula(vaso,40,40,2,2,2));
			}		
		});	
		
		vaso.precipitar();
	/*
		JButton btnStart = new JButton("Start");
		btnStart.setBounds(623, 445, 89, 39);
		frame.getContentPane().add(btnStart);
		
		btnStart.addActionListener(new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent arg0) {
			
			 * EDIT Juli: Intente poner el vaso.precipitar(); aca pero se cuelga. 
			 * La idea es que cuando se haga click en "start" se muevan las particulas
			 * Otra opcion es que la velocidad, cantidad y tamaño de las particulas 
			 * varie al mismo tiempo que se ingresan los datos
			 
			}		
		});				
 	*/		 
	}
}