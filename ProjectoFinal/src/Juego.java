import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("unused")
public class Juego<pelota> extends javax.swing.JFrame {

	private JPanel panel;
	private Pelota pelota;
	private Raqueta1 raqueta1;
	private Raqueta2 raqueta2;
	private int golpes, golpes2, c;
	private JLabel labelcontador;
	private JLabel fondo;
	private JLabel labelcontador2;

	public Juego() {
		pelota = new Pelota(getWidth(), getHeight());
		raqueta1 = new Raqueta1(getHeight());
		raqueta2 = new Raqueta2(getHeight());
		golpes = 0;
		golpes2 = 0;
	}

	public void Acciones() {
		if (Colision()) {
			golpes = golpes + 1;
			labelcontador.setText(String.valueOf(golpes / 2));
		}
		if (Colision2()) {
			golpes2 = golpes2 + 1;
			labelcontador2.setText(String.valueOf(golpes2 / 2));
		}
		if (pelota.TocaFondo()) {
			gameOver();
		}
	}

	public boolean Colision() {
		return pelota.limiteBola().intersects(raqueta1.limiteRaqueta1());
	}

	public boolean Colision2() {
		return pelota.limiteBola().intersects(raqueta2.limiteRaqueta2());
	}

	public void gameOver() {
		if (golpes == golpes2) {
			JOptionPane.showMessageDialog(this, "El Jugador 1 Ganó", "Game Over", JOptionPane.YES_NO_OPTION);
			golpes = 0;
			golpes2 = 0;
		} else {
			JOptionPane.showMessageDialog(this, "El Jugador 2 Ganó", "Game Over", JOptionPane.YES_NO_OPTION);
			golpes = 0;
			golpes2 = 0;
		}
	}

	public void TocaFondo() {
		if (Pelota.x == 630) {
			gameOver();
		} else if (Pelota.x == 0) {
			gameOver();
		}
	}

}