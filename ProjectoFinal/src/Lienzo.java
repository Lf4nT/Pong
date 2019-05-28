
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

@SuppressWarnings("unused")
public class Lienzo extends JPanel implements KeyListener {

	private Dimension d;
	private Thread t;
	private Pelota pelota;
	private Raqueta1 raqueta1;
	private Raqueta2 raqueta2;
	private BufferedImage fondo;

	public Lienzo(int w, int h) throws IOException {
		d = new Dimension(w, h);
		pelota = new Pelota(Color.RED, 10, 100, 100, (float) Math.PI / 4, 100, d);
		raqueta1 = new Raqueta1(20, Color.RED, 80);
		raqueta2 = new Raqueta2(20, Color.YELLOW, 80);
		fondo = ImageIO.read(getClass().getResource("/mesapinpong1.jpg"));
		setFocusable(true);
		addKeyListener(this);
	}

	@Override
	public Dimension getPreferredSize() {
		return d;
	}

	public void iniciarAnimacion() {
		t = new Thread(() -> {
			long t0 = System.nanoTime(), t1, t;
			while (true) {
				t1 = System.nanoTime();
				t = t1 - t0;
				t0 = t1;
				pelota.mover(t);
				repaint();
			}
		});
		t.start();
	}

	@Override
	protected void paintComponent(Graphics g) {
		g.drawImage(fondo, 0, 0, this);
		pelota.paint(g);
		g.setColor(Color.RED);
		raqueta1.paint(g);
		g.setColor(Color.YELLOW);
		raqueta2.paint(g);
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_A) {
			raqueta1.moverRaquetaarriba1();
		} else if (e.getKeyCode() == KeyEvent.VK_Z) {
			raqueta1.moverRaquetaabajo1();
		} else if (e.getKeyCode() == KeyEvent.VK_UP) {
			raqueta2.moverRaquetaarriba2();
		} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			raqueta2.moverRaquetaabajo2();
		}
	}

	@Override
	public void keyReleased(KeyEvent arg0) {

	}

	@Override
	public void keyTyped(KeyEvent arg0) {

	}

}