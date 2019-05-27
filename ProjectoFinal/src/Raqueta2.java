import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

@SuppressWarnings("unused")
public class Raqueta2 {
	private int y;
	private int dy;
	private int alto;
	private int largo;
	private Color color;

	public Raqueta2(int alto) {
		y = 0;
		dy = 1;
		largo = 70;
		color = Color.red;
		this.alto = alto;
	}

	public Raqueta2(int alto, Color color) {
		this.alto = alto;
		this.color = color;
		y = 0;
		dy = 1;
	}

	public Raqueta2(int alto, Color color, int largo) {
		this.alto = alto;
		this.color = color;
		this.largo = largo;
		y = 0;
		dy = 1;
	}

	public void moverRaquetaabajo2() {
		if (y - 20 > -207) {
			y = y - 20;
		}
	}

	public void moverRaquetaarriba2() {
		if (y + largo + 20 < alto - 242) {
			y = y + 20;
		}
	}

	public Rectangle limiteRaqueta2() {
		return new Rectangle(603, 207 - y, 20, largo);
	}

	public void paint(Graphics g) {
		g.setColor(color);
		g.fillRect(603, 207 - y, 20, largo);
		g.setColor(Color.YELLOW);
		g.drawRect(603, 207 - y, 20, largo);
	}

	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			moverRaquetaarriba2();
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			moverRaquetaabajo2();
		}
	}

	public void keyReleased(KeyEvent e) {

	}

	public void keyTyped(KeyEvent e) {

	}

}
