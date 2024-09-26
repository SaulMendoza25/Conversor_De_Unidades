package conversor_de_unidades;

import java.awt.BorderLayout;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MarcoPrincipal extends JFrame {

	private static final long serialVersionUID = -6392429261174595945L;

	public MarcoPrincipal() {
		setLayout(new BorderLayout());
		setTitle("Conversor de unidades");
		setBounds(getScreenDimension()[0] / 4, getScreenDimension()[1] / 4, getScreenDimension()[0] / 2,
				(getScreenDimension()[1] / 2) - 250);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		add(new LaminaPrincipal(),BorderLayout.CENTER);
	}

	private int[] getScreenDimension() {
		Toolkit getScreenDefault = Toolkit.getDefaultToolkit();
		int x = getScreenDefault.getScreenSize().width;
		int y = getScreenDefault.getScreenSize().height;
		int[] dimension = { x, y };
		return dimension;
	}
}
