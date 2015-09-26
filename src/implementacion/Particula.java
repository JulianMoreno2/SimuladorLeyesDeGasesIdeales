package implementacion;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;

public class Particula {

	// x e y representan la posicion de la pelota en el habitaculo
	private int x = 0;
	private int y = 0;

	// xa y ya representan el movimiento de la pelota
	private int xa;
	private int ya;
	private int velocidad;
	
	private Vaso vaso;
	private int height;
	private int width;
	
	Shape circle = new Ellipse2D.Float(this.height, this.width,this.x,this.y);

	public Particula(Vaso vaso, int width, int height, int xa, int ya, int velocidad) {
		this.vaso= vaso;
		setXa(xa);
		setYa(ya);
		this.width = width;
		this.height = height;
		this.velocidad = velocidad;
	}

	void move() {
		
		if (x + xa < 0)
			xa = velocidad;
		if (x + xa > vaso.getAncho() - this.width)
			xa = -velocidad;
		if (y + ya < 0)
			ya = velocidad;
		if (y + ya > vaso.getAlto() - this.height)
			ya = -velocidad;
		
		x = x + xa;
		y = y + ya;
	}

	/* crea un rectangulo alrededor de la pelota para hacer mas facil el metodo colision*/
	public Rectangle getLimite() {
		return new Rectangle(this.x, this.y, this.width, this.height);
		
	}		

	public void paint(Graphics2D g) {
		g.fillOval(this.x, this.y, this.width, this.height);
	}

	public int getVelocidad() {
		return this.velocidad;
	}

	public void setVelocidad(int velocidad) {
		this.velocidad = velocidad;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public void setXa(int xa){
		this.xa = xa;
	}
	
	public void setYa(int ya){
		this.ya = ya;
	}
	
}