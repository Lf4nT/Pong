
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

@SuppressWarnings("unused")
public class Pelota {
	private float x;
	private float y;
	private float dx;
	private float dy;
	private float alto;
	private float ancho;
	private Color color;
	private double vx;
	private double vy;
	private int diametro;
	private Dimension marco;

	public Pelota(Color color, int radio, float x, float y, float d, float v, Dimension marco) {
		this.color = color;
		this.x = x - radio;
		this.y = y - radio;
		vx = v * Math.cos(d);
		vy = v * Math.sin(d);
		diametro = 2 * radio;
		this.marco = marco;
	}

	public Pelota(int alto, int ancho) {
		this.alto = y;
		this.ancho = x;
	}

	public void mover(long t) {
		double dx = t * vx / 250000000d;
		double dy = t * vy / 250000000d;
		x += dx;
		y += dy;
		if (x <= 0 || x + diametro >= marco.width)
			vx *= -1;
		else if (y <= 0 || y + diametro >= marco.height)
			vy *= -1;
	}

	public void paint(Graphics g) {
		g.setColor(color);
		g.fillOval((int) x, (int) y, diametro, diametro);
		g.setColor(Color.BLACK);
		g.drawOval((int) x, (int) y, diametro, diametro);
	}

	public Rectangle limiteBola() {
		return new Rectangle();
	}

	public boolean TocaFondo() {
		if (1 == 2) {
			return true;
		} else {
			return false;
		}
	}
	
}
