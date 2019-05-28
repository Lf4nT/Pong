import javax.swing.JOptionPane;

public class Juego extends javax.swing.JFrame {

	private Pelota pelota;
	private Raqueta1 raqueta1;
	private Raqueta2 raqueta2;
	private int golpes;
	private int golpes2;

	public void Acciones() {
		if (Colision()) {
			golpes = golpes + 1;
		} else if (Colision2()) {
			golpes2 = golpes2 + 1;
		} else if (pelota.TocaFondo()) {
			GameOver();
		}
	}

	public boolean Colision() {
		return pelota.limiteBola().intersects(raqueta1.limiteRaqueta1());
	}

	public boolean Colision2() {
		return pelota.limiteBola().intersects(raqueta2.limiteRaqueta2());
	}

	public void GameOver() {
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
		if (Pelota.x + (Pelota.diametro / 2) == 629) {
			GameOver();
		} else if (Pelota.x + (Pelota.diametro / 2) == 1) {
			GameOver();
		}
	}
}