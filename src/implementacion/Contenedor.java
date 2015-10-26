package ar.edu.untref.simuladordegases.implementacion;

import java.awt.Color;

@SuppressWarnings("serial")
public class Contenedor extends JPanel {

	private List<Particula> particulas;

	private Integer ancho;
	private Integer alto;
	private Integer x;
	private Integer y;
	private Double numAleatorio;
	private Integer comb1x;
	private Integer comb2x;
	private Integer comb1y;
	private Integer comb2y;	
	private Float velocidadParticulas = (float) 1;
	private Color colorDeParticulas;
	private Float xaParticulas = (float) 1;
	private Float yaParticulas = (float) 1;

	public Contenedor(){		
		this.particulas = new LinkedList<Particula>();			
	}

		public void agitar() {

		//Se posiciona en cada partícula de la lista.
		for(int i = 0 ; i < this.particulas.size() ; i++){

			numAleatorio = Math.random();			
			Particula particulaActual = this.particulas.get(i);

			//Se posiciona en otra partícula de la lista.
			for(int j = 0 ; j < this.particulas.size(); j++){

				// Si i es diferente de j porque una partícula no se va a colisionar con ella misma
				// por eso no tiene sentido probar el if(colisión) si i es igual a j.				
				if(i != j){

					Particula particulaOtra = this.particulas.get(j);

					//Verifica la condicion de colision
					if (colision(particulaActual,particulaOtra)){
						
						if(numAleatorio > 0.0 && numAleatorio < 0.25){
							
							comb1x = -1;
							comb2x = 1;
							comb1y = 1;
							comb2y = -1;
							
						} else if(numAleatorio >= 0.25 && numAleatorio < 0.50){
							
							comb1x = 1;
							comb2x = -1;
							comb1y = -1;
							comb2y = 1;
							
						} else if(numAleatorio >= 0.50 && numAleatorio < 0.75){
							
							comb1x = -1;
							comb2x = 1;
							comb1y = -1;
							comb2y = 1;
							
						} else if(numAleatorio >= 0.75 && numAleatorio < 1.0){
							
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
			this.particulas.get(k).mover();			
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
	
	public void precipitar() throws InterruptedException{

		while (true) {
			this.agitar();
			this.repaint();	
			Thread.sleep(10);
		}			
	}	

	/** Modifica la temperatura del contenedor
	 */
	public void modificarTemperaturaDeParticulas(Float temperatura){	
		
		this.calcularColorDeParticulas(temperatura);

		for(int i = 0 ; i < this.particulas.size() ; i++){
			Particula particulaActual = this.particulas.get(i);
			particulaActual.setXa(temperatura/100);
			particulaActual.setYa(temperatura/100);
			particulaActual.setVelocidad(temperatura/100);
			particulaActual.setColor(this.getColorDeParticulas());
		}
		this.setVelocidadParticulas(temperatura/100);
		this.setXaParticulas(temperatura/100);
		this.setYaParticulas(temperatura/100);		
	}

	private void calcularColorDeParticulas(Float temperatura) {
		Integer verde = (int) (255.0 * ((temperatura - 100.0) / 500.0));
		Color colorDeParticulas = new Color(255, 255 - verde, 0);	
		this.setColorDeParticulas(colorDeParticulas);
	}

	/** El metodo colision tendria que detectar que se esta chocando contra algo (objeto o pared)
	 * y la pelota tendria que cambiar el sentido en el que rebota
	 * por otro lado, el metodo intersects devuelve true si el obj de la izquierda se choca con el de la derecha
	 * */
	private boolean colision(Particula particula, Particula particula1) {		
		return particula.getLimite().intersects(particula1.getLimite()); 
	}

	/**
	 * Modifica cantidad de particulas
	 */	
	public void modificarCantidadDeMoles(int cantidadDeParticulas){

		if(cantidadDeParticulas >= this.particulas.size()){
			this.agregarParticulas(cantidadDeParticulas - this.particulas.size());
		} else {
			this.eliminarParticulas(this.particulas.size() - cantidadDeParticulas);
		}
	}

	/** 
	 * Agregar un determinado paquete de particulas
	 */
	public void agregarParticulas(int cantidadDeParticulas){	

		for(int i = 0; i < cantidadDeParticulas; i++){
			this.particulas.add(new Particula(this,10,10,this.getXaParticulas(),this.getYaParticulas(),this.getVelocidadParticulas()));		
			this.particulas.get(i).setColor(this.getColorDeParticulas());
		}
		
	}

	/**
	 * Elimina un determinado paquete de particulas
	 */
	public void eliminarParticulas(int cantidadDeParticulas){
		
		for(int i = 0; i < cantidadDeParticulas; i++){		
			this.particulas.remove(this.particulas.size() - 1);		
		}
		
	}

	public void agregarParticula(Particula particula) {		
		this.particulas.add(particula);		
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

	public Float getVelocidadParticulas() {
		return velocidadParticulas;
	}

	public void setVelocidadParticulas(Float float1) {
		this.velocidadParticulas = float1;
	}

	public Color getColorDeParticulas() {
		return colorDeParticulas;
	}

	public void setColorDeParticulas(Color colorDeParticulas) {
		this.colorDeParticulas = colorDeParticulas;
	}

	
}
