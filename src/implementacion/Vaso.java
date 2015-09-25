package implementacion;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.LinkedList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Vaso extends JPanel {

	private List<Particula> particulas;
	
	private int ancho;
	private int alto;

	public Vaso(){
		
		this.particulas = new LinkedList<Particula>();
		
		//Particulas en la lista para probar (Deberían insertarse desde la ventana principal)
		this.particulas.add(new Particula(this,20,20,3,3,3));
		this.particulas.add(new Particula(this,20,20,4,4,4));
		this.particulas.add(new Particula(this,20,20,5,5,5));
		this.particulas.add(new Particula(this,20,20,2,2,2));
		this.particulas.add(new Particula(this,20,20,3,3,3));		
	}
	
	public void precipitar() throws InterruptedException{
			
		while (true) {
			this.agitar();
			this.repaint();	
			Thread.sleep(10);
		}	
		
	}
	
	public int getAncho(){			
		return this.ancho;		
	}
	
	public int getAlto(){
		return this.alto;		
	}
		
	public void setAncho(int ancho) {
		this.ancho = ancho;
	}

	public void setAlto(int alto) {
		this.alto = alto;
	}

	//Este Método se llamaba anteriormente move(), pero ya que move() es también un método de la clase Partícula, para no confundirse le ponemos agitar() para el Vaso.
	public void agitar() {

		//Se posiciona en cada partícula de la lista.
		for(int i = 0 ; i < this.particulas.size() ; i++){
			
			Particula particulaActual = this.particulas.get(i);
			
			//Se posiciona en otra partícula de la lista.
			for(int j = 0 ; j < this.particulas.size(); j++){
				
				//Si i es diferente de j porque una partícula no se va a colisionar con ella misma, por eso no tiene sentido probar el if(colisión) si i es igual a j.
				if(i != j){
					
					Particula particulaOtra = this.particulas.get(j);
					
					//Verifica la condicion
					if (colision(particulaActual,particulaOtra)){
						
						particulaActual.setXa(-particulaActual.getVelocidad());
						particulaOtra.setXa(particulaOtra.getVelocidad());
						
						particulaActual.setYa(particulaActual.getVelocidad());
						particulaOtra.setYa(-particulaOtra.getVelocidad());			
					}
					
				}
				
			}
			
		}
		
		//Mueve a todas las partículas una vez que se probaron todas las alternativas de colisiones entre ellas
		for(int k = 0 ; k < this.particulas.size() ; k++){
			
			this.particulas.get(k).move();
			
		}
		
	}

	/* el metodo colision tendria que detectar que se esta chocando contra algo (objeto o pared)
	 * y la pelota tendria que cambiar el sentido en el que rebota
	 * 
	 * por otro lado, el metodo intersects devuelve true si el obj de la izquierda se choca con el de la derecha*/
	private boolean colision(Particula particula, Particula particula1) {			
		return particula.getLimite().intersects(particula1.getLimite());		
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
				
		for(int i = 0; i < this.particulas.size() ; i++){
			
			this.particulas.get(i).paint(g2d);
			
		}
		
	}
		
	/**
	public static void main(String[] args) throws InterruptedException {
		

		JFrame frame = new JFrame("Vaso de Precipitados");
	
		Vaso vaso = new Vaso();
		vaso.setAncho(400);
		vaso.setAlto(300);				
		vaso.setBounds(0, 0, vaso.getAncho(), vaso.getAlto());
		vaso.setBorder(BorderFactory.createLineBorder(Color.black)); 	
		
		frame.setSize(1000, 600);			 
		frame.add(vaso);			
		frame.setVisible(true);				
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);					
		vaso.precipitar();

		
		JButton btnStart = new JButton("Start");
		btnStart.setBounds(100, 100, 89, 39);
		frmMainWindow.getContentPane().add(btnStart);
		btnStart.addActionListener(new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent arg0) {
			}		
		});				
		
	}
	 */
}