package implementacion;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Vaso extends JPanel {

	private List<Particula> particulas;
	
	private int ancho;
	private int alto;
	private double numAleatorio;
	private int comb1x;
	private int comb2x;
	private int comb1y;
	private int comb2y;	

	public Vaso(){
		
		this.particulas = new LinkedList<Particula>();
		
		//Particulas en la lista para probar (Deberían insertarse desde la ventana principal)
		/**
		this.particulas.add(new Particula(this,20,20,3,3,3));
		this.particulas.add(new Particula(this,20,20,4,4,4));
		this.particulas.add(new Particula(this,20,20,5,5,5));
		this.particulas.add(new Particula(this,20,20,2,2,2));
		this.particulas.add(new Particula(this,20,20,3,3,3));
		*/		
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

	/**Este Método se llamaba anteriormente move(), pero ya que move() 
	  * es también un método de la clase Partícula, para no confundirse le ponemos agitar() para el Vaso.
	*/
	public void agitar() {

		//Se posiciona en cada partícula de la lista.
		for(int i = 0 ; i < this.particulas.size() ; i++){
			
			numAleatorio = Math.random();
			
			Particula particulaActual = this.particulas.get(i);
			
			//Se posiciona en otra partícula de la lista.
			for(int j = 0 ; j < this.particulas.size(); j++){
				
				/**Si i es diferente de j porque una partícula no se va a colisionar con ella misma, 
				  * por eso no tiene sentido probar el if(colisión) si i es igual a j.
				*/
				if(i != j){
					
					Particula particulaOtra = this.particulas.get(j);
					
					//Verifica la condicion de colision
					if (colision(particulaActual,particulaOtra)){
						/**
						 * La idea de generar el numero aleatorio es que las particulas reboten hacia cualquier direccion
						 * de esta manera solvento (de manera muuy precaria) la idea del limite de la particula como
						 * un rectangulo y no como un circulo.
						 * Proximamente habra que establecer la colision de las particulas suponiendo que son redondas
						 * y no rectangulares.
						 */
						if(numAleatorio > 0.0 && numAleatorio < 0.25){
							comb1x = -1;
							comb2x = 1;
							comb1y = 1;
							comb2y = -1;
						}else if(numAleatorio >= 0.25 && numAleatorio < 0.50){
							comb1x = 1;
							comb2x = -1;
							comb1y = -1;
							comb2y = 1;
						}else if(numAleatorio >= 0.50 && numAleatorio < 0.75){
							comb1x = -1;
							comb2x = 1;
							comb1y = -1;
							comb2y = 1;
						}else if(numAleatorio >= 0.75 && numAleatorio < 1.0){
							comb1x = 1;
							comb2x = -1;
							comb1y = 1;
							comb2y = -1;
							
						}
						
						particulaActual.setXa(comb1x*particulaActual.getVelocidad());
						particulaOtra.setXa(comb2x*particulaOtra.getVelocidad());
						
						particulaActual.setYa(comb1y*particulaActual.getVelocidad());
						particulaOtra.setYa(comb2y*particulaOtra.getVelocidad());			
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

	public void agregarParticula(Particula particula) {		
		this.particulas.add(particula);		
	}
	
}