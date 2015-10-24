package implementacion;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Contenedor extends JPanel {

	private List<Particula> particulas;
	
	private int ancho;
	private int alto;
	private int x;
	private int y;
	private double numAleatorio;
	private int comb1x;
	private int comb2x;
	private int comb1y;
	private int comb2y;	
	private Float velocidadParticulas = (float) 1;
	private Float xaParticulas = (float) 1;
	private Float yaParticulas = (float) 1;

	public Contenedor(){		
		this.particulas = new LinkedList<Particula>();			
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

	/** Este Método se llamaba anteriormente move(), pero ya que move() 
	  * es también un método de la clase Partícula, para no confundirse le ponemos agitar() para el Vaso.
	  */
	public void agitar() {

		//Se posiciona en cada partícula de la lista.
		for(int i = 0 ; i < this.particulas.size() ; i++){
			
			numAleatorio = Math.random();
			
			Particula particulaActual = this.particulas.get(i);
			
			//Se posiciona en otra partícula de la lista.
			for(int j = 0 ; j < this.particulas.size(); j++){
				
				/** Si i es diferente de j porque una partícula no se va a colisionar con ella misma, 
				 *  por eso no tiene sentido probar el if(colisión) si i es igual a j.
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
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		
		for(int i = 0; i < this.particulas.size() ; i++){
			
			this.particulas.get(i).paint(g2d);
			
		}		
	}
	
	/** Modifica la temperatura del sistema
	 * Divido por 100 a la temperatura para que no se mueva
	 * tan rapido la imagen de las particulas
	 * Mejorar la velocidad de las particulas, "punto medio"
	 * Cuando la temp es menor a cero las particulas se paran, mejorarlo graficamente
	 */
	public void modificarTemperaturaDeParticulas(Float temp){	
				
		for(int i = 0 ; i < this.particulas.size() ; i++){
			Particula particulaActual = this.particulas.get(i);
			
			particulaActual.setXa(temp/100);
			particulaActual.setYa(temp/100);
			particulaActual.setVelocidad(temp/100);
		}
		this.setVelocidadParticulas(temp/100);
		this.setXaParticulas(temp/100);
		this.setYaParticulas(temp/100);
	}

	/** El metodo colision tendria que detectar que se esta chocando contra algo (objeto o pared)
	 * y la pelota tendria que cambiar el sentido en el que rebota
	 * por otro lado, el metodo intersects devuelve true si el obj de la izquierda se choca con el de la derecha
	 * */
	private boolean colision(Particula particula, Particula particula1) {		
		return particula.getLimite().intersects(particula1.getLimite()); 
	}
	
	/**
	 * Modificar cantidad de particulas 
	 * Mejorar la manera en que salen las particulas en el contenedor (Grafico)
	 */
	public void modificarCantidadDeMoles(int cantParticulas){
		
		if(cantParticulas >= this.particulas.size()){
			
			this.agregarMoles(cantParticulas - this.particulas.size());
		
		}else{
			
			eliminarMoles(this.particulas.size() - cantParticulas);
		}
	}
	
	/** 
	 * Agregar un determinado paquete de particulas
	 */
	public void agregarMoles(int cantParticulas){	
		for(int i = 0; i < cantParticulas; i++){
			this.particulas.add(new Particula(this,10,10,this.getXaParticulas(),this.getYaParticulas(),this.getVelocidadParticulas()));
		}	
	}
	
	/**
	 * Elimina un determinado paquete de particulas
	 */
	public void eliminarMoles(int cantParticulas){
		this.particulas.remove(cantParticulas);		
	}
	
	public void agregarParticula(Particula particula) {		
		this.particulas.add(particula);		
	}

	public Float getVelocidadParticulas() {
		return velocidadParticulas;
	}

	public void setVelocidadParticulas(Float float1) {
		this.velocidadParticulas = float1;
	}

	public Float getXaParticulas() {
		return xaParticulas;
	}

	public void setXaParticulas(Float float1) {
		this.xaParticulas = float1;
	}

	public Float getYaParticulas() {
		return yaParticulas;
	}

	public void setYaParticulas(Float float1) {
		this.yaParticulas = float1;
	}

	public void setLimites(int x, int y, int ancho, int alto) {
		this.setX(x);
		this.setY(x);
		this.ancho = ancho;
		this.alto = alto;		
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	
	
}