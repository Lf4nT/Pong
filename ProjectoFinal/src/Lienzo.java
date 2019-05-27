
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

@SuppressWarnings("unused")
public class Lienzo extends JPanel {

	private Dimension d;
	private Thread t;
	private Pelota pelota;
	private Raqueta1 raqueta1;
	private Raqueta2 raqueta2;
	private BufferedImage fondo;

	public Lienzo(int w, int h) throws IOException {
		d = new Dimension(w, h);
		pelota = new Pelota(Color.RED, 10, 100, 100, (float) Math.PI / 4, 100, d);
		raqueta1 = new Raqueta1(160, Color.RED, 25);
		raqueta2 = new Raqueta2(160, Color.YELLOW, 25);
		fondo = ImageIO.read(getClass().getResource("/mesapinpong1.jpg"));
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
	
}