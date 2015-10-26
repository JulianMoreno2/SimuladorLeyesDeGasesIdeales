package ar.edu.untref.simuladordegases.implementacion;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;

public class Particula {

	//Posicion de la pelota en el contenedor
	private int x = 0;
	private int y = 0;

	//xa y ya representan el movimiento de la pelota
	private Float xa;
	private Float ya;
	
	private Float velocidad;
	private Color color;
	
	private Contenedor contenedor;
	private int height;
	private int width;
	
	Shape circle = new Ellipse2D.Float(this.height, this.width,this.x,this.y);		

	public Particula(Contenedor contenedor, int width, int height, Float xa, Float ya, Float vel) {
		this.contenedor= contenedor;
		this.width = width;
		this.height = height;
		this.setXa(xa);
		this.setYa(ya);
		this.velocidad = vel;
	}

	void mover() {
		
		if (x + xa < 0)
			xa = velocidad;
		if (x + xa > contenedor.getAncho() - this.width)
			xa = -velocidad;
		if (y + ya < 0)
			ya = velocidad;
		if (y + ya > contenedor.getAlto() - this.height)
			ya = -velocidad;
		
		x = (int) (x + xa);
		y = (int) (y + ya);
	}

	/* crea un rectangulo alrededor de la pelota para hacer mas facil el metodo colision*/
	public Rectangle getLimite() {
		return new Rectangle(this.x, this.y, this.width, this.height);
		
	}		

	public void paint(Graphics2D g) {
		g.fillOval(this.x, this.y, this.width, this.height);
		g.setColor(this.getColor());
	}

	public Float getVelocidad() {
		return this.velocidad;
	}

	public void setVelocidad(float f) {
		this.velocidad = (float) f;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public void setXa(Float float1){
		this.xa = float1;
	}
	
	public void setYa(Float float1){
		this.ya = float1;
	}

	public Float getXa() {
		// TODO Auto-generated method stub
		return this.xa;
	}

	public Float getYa() {
		// TODO Auto-generated method stub
		return this.ya;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}
	
}
