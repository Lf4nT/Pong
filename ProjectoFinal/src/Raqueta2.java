import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

@SuppressWarnings("unused")
public class Raqueta2 {
	private int y = 0;
	private int dy = 1;
	private int alto = 110;
	private int largo = 70;
	private Color color = Color.RED;

	public Raqueta2(int alto) {
		this.alto = alto;
	}

	public Raqueta2(int alto, Color color) {
		this.alto = alto;
		this.color = color;
	}

	public Raqueta2(int alto, Color color, int largo) {
		this.alto = alto;
		this.color = color;
		this.largo = largo;
	}

	public void moverRaquetaabajo2() {
		if (y - 20 > -207) {
			y = y - 20;
		}
	}

	public void moverRaquetaarriba2() {
		if (y + alto / 2 < 242) {
			y = y + 20;
		}
	}

	public void paint(Graphics g) {
		g.fillRoundRect(603, 207 - y, 20, largo, 25, 25);
	}

	public Rectangle limiteRaqueta2() {
		return new Rectangle(603, 207 - y, 20, largo);
	}

}