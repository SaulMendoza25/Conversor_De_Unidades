package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import modelo.FactoryConversion;

public class AccionConvertir implements ActionListener {
	public AccionConvertir(JTextField camp1, JTextField camp2) {
		// TODO Auto-generated constructor stub
		this.camp1 = camp1;
		this.camp2 = camp2;
	}

	public AccionConvertir(JComboBox<String> categoria, JTextField camp1, JTextField camp2) {
		this.categorias = categoria;
		this.camp1 = camp1;
		this.camp2 = camp2;
	}

	public AccionConvertir(JComboBox<String> categoria, JComboBox<String> option1, JComboBox<String> option2) {
		this.categorias = categoria;
		this.option1 = option1;
		this.option2 = option2;
		factoryConversion = new FactoryConversion(option1, option2);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String typeEvent = e.getActionCommand();
		if (e.getSource() == this.categorias) {
			typeConversion(this.categorias);
		}

		if (typeEvent == "Convertir") {
			choiceElection();
		}
		if (typeEvent == "Restablecer") {
			camp1.setText("");
			camp2.setText("");
		}

	}

	private void choiceElection() {
		switch ((String) this.categorias.getSelectedItem()) {
		case "Temperatura" -> camp2.setText(factoryConversion.getTemperatura(this.camp1.getText()) + "");
		case "Longitud" -> camp2.setText(factoryConversion.getLongitud(this.camp1.getText()) + "");
		case "Masas" -> camp2.setText(factoryConversion.getMasa(camp1.getText()) + "");
		}
	}

	private void typeConversion(JComboBox<String> categoria) {
		switch ((String) categoria.getSelectedItem()) {
		case "Temperatura" -> getOptions(FactoryConversion.getGrados());
		case "Longitud" -> getOptions(FactoryConversion.getLongitudes());
		case "Masas" -> getOptions(FactoryConversion.getMasas());
		}
	}

	private void getOptions(String[] opciones) {
		if (option1.getItemCount() > 0 || option2.getItemCount() > 0) {
			option1.removeAllItems();
			option2.removeAllItems();
		}
		for (String opcion : opciones) {
			option1.addItem(opcion);
			option2.addItem(opcion);
		}

	}

	private static FactoryConversion factoryConversion;
	private JTextField camp1, camp2;
	private JComboBox<String> categorias, option1, option2;;
}
