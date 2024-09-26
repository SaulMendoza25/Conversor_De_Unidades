package conversor_de_unidades;
import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controlador.AccionConvertir;
import modelo.FactoryConversion;

public class LaminaPrincipal extends JPanel {

	private static final long serialVersionUID = -8685448599655473712L;

	public LaminaPrincipal() {
//		setLayout(new BorderLayout());
		setBackground(new Color(252, 226, 85));
		add(getBox());
	}

	private Box getBox() {
		boxMain = Box.createVerticalBox();
		for (int i = 0; i < 4; i++) {
			Box generateBox = Box.createHorizontalBox();

			if (i == 0) {
				JLabel titulo = new JLabel("Conversor de unidades (longitud, masa, temperatura)");
				titulo.setFont(new Font("Serial", Font.BOLD, 32));

				generateBox.add(titulo);
			} else if (i == 1) {
				boxMain.add(Box.createVerticalStrut(40));
				categorias = new JComboBox<String>(FactoryConversion.getStringCategorias());

				generateBox.add(categorias);
				categorias.addActionListener(new AccionConvertir(categorias, option1, option2));
				generateBox.add(Box.createGlue());

			} else if (i == 2) {

				boxMain.add(Box.createVerticalStrut(40));
				campo1 = new JTextField();
				generateBox.add(option1);
				generateBox.add(Box.createGlue());
				generateBox.add(Box.createHorizontalStrut(30));
				generateBox.add(campo1);
				generateBox.add(Box.createHorizontalStrut(30));
				generateBox.add(option2);
				generateBox.add(Box.createGlue());

			} else if (i == 3) {
				boxMain.add(Box.createVerticalStrut(40));
				convertir = new JButton("Convertir");
				campo2 = new JTextField();
				campo2.setDisabledTextColor(Color.black);
				campo2.setBorder(BorderFactory.createLineBorder(getBackground()));
				campo2.setEnabled(false);
				restablecer = new JButton("Restablecer");
				convertir.addActionListener(new AccionConvertir(categorias, campo1, campo2));
				restablecer.addActionListener(new AccionConvertir(campo1, campo2));
				generateBox.add(convertir);
				generateBox.add(Box.createGlue());
				generateBox.add(Box.createHorizontalStrut(50));
				generateBox.add(campo2);
				generateBox.add(Box.createHorizontalStrut(38));
				generateBox.add(restablecer);
				generateBox.add(Box.createGlue());
			}

			boxMain.add(generateBox);

		}
		return boxMain;
	}

	private JComboBox<String> categorias;
	private JComboBox<String> option1 = new JComboBox<String>(FactoryConversion.getGrados());;
	private JComboBox<String> option2 = new JComboBox<String>(FactoryConversion.getGrados());;
	private JTextField campo1;
	private JButton convertir;
	private JTextField campo2;
	private JButton restablecer;
	private Box boxMain;

}
