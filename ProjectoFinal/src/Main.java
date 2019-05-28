import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class Main {

	public static void main(String[] args) throws IOException {
		Lienzo lienzo;
		JFrame frame = new JFrame("Bing Bang Bong");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		lienzo = new Lienzo(630, 450);
		frame.add(lienzo);
		frame.pack();
		frame.setLocationRelativeTo(null);
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				frame.setVisible(true);
				lienzo.iniciarAnimacion();
			}
		});
	}

}