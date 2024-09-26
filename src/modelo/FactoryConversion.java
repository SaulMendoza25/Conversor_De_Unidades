package modelo;

import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;

public class FactoryConversion {

	public FactoryConversion(JComboBox<String> option1, JComboBox<String> option2) {
		this.options.add(option1);
		this.options.add(option2);
	}

	public double getTemperatura(String campo) {
		double resultado = 0;
		try {
			resultado = Double.parseDouble(campo);
			if (options.get(0).getSelectedItem() == "Celsius") {
				switch (options.get(1).getSelectedItem() + "") {
				case "Fahrenheit" -> resultado = (resultado * 9 / 5) + 32;
				case "Kelvin" -> resultado += 273.15;
				}
			}
			if (options.get(0).getSelectedItem() == "Fahrenheit") {
				switch (options.get(1).getSelectedItem() + "") {
				case "Celsius" -> resultado = (resultado - 32) / 1.8;
				case "Kelvin" -> resultado = ((resultado - 32) / 1.8) + 273.15;
				}
			}
			if (options.get(0).getSelectedItem() == "Kelvin") {
				switch (options.get(1).getSelectedItem() + "") {
				case "Celsius" -> resultado = resultado - 273.15;
				case "Fahrenheit" -> resultado = ((resultado - 273.15) * 1.8) + 32;
				}
			}
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Solo puede ingresar numeros", "ERROR", JOptionPane.ERROR_MESSAGE);
		}
		return resultado;
	}

	public double getMasa(String campo) {
		double resultado = 0;
		try {
			resultado = Double.parseDouble(campo);
			if (options.get(0).getSelectedItem() == "gramos") {
				switch (options.get(1).getSelectedItem() + "") {
				case "kilogramos" -> resultado /= 1000;
				case "libras" -> resultado *= 0.00220462;
				case "onzas" -> resultado *= 0.035274;
				}
			}
			if (options.get(0).getSelectedItem() == "kilogramos") {
				switch (options.get(1).getSelectedItem() + "") {
				case "gramos" -> resultado *= 1000;
				case "libras" -> resultado *= 2.20462;
				case "onzas" -> resultado *= 35.274;
				}
			}
			if (options.get(0).getSelectedItem() == "libras") {
				switch (options.get(1).getSelectedItem() + "") {
				case "gramos" -> resultado *= 453.592;
				case "kilogramos" -> resultado /= 2.20462;
				case "onzas" -> resultado *= 16;
				}

			}
			if (options.get(0).getSelectedItem() == "onzas") {
				switch (options.get(1).getSelectedItem() + "") {
				case "gramos" -> resultado *= 28.3495;
				case "kilogramos" -> resultado /= 35.274;
				case "libras" -> resultado /= 16;
				}

			}
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Solo puede ingresar numeros", "ERROR", JOptionPane.ERROR_MESSAGE);
		}

		return resultado;
	}

	public double getLongitud(String campo) {
		double resultado = 0;
		try {
			resultado = Double.parseDouble(campo);

			if (options.get(0).getSelectedItem() == "km") {
				switch (options.get(1).getSelectedItem() + "") {
				case "mi" -> resultado *= 0.621371;
				case "m" -> resultado *= 1000;
				case "ft" -> resultado *= 3280.84;
				case "cm" -> resultado *= 100000;

				}
			}
			if (options.get(0).getSelectedItem() == "mi") {
				switch (options.get(1).getSelectedItem() + "") {
				case "km" -> resultado *= 1.60934;
				case "m" -> resultado *= 1609.34;
				case "ft" -> resultado *= 5280;
				case "cm" -> resultado *= 160934;
				}
			}
			if (options.get(0).getSelectedItem() == "m") {
				switch (options.get(1).getSelectedItem() + "") {
				case "mi" -> resultado *= 0.000621371;
				case "km" -> resultado /= 1000;
				case "ft" -> resultado *= 3.28084;
				case "cm" -> resultado *= 100;
				}
			}
			if (options.get(0).getSelectedItem() == "ft") {
				switch (options.get(1).getSelectedItem() + "") {
				case "mi" -> resultado /= 5280;
				case "km" -> resultado /= 3280.84;
				case "m" -> resultado /= 3.28084;
				case "cm" -> resultado *= 30.48;
				}
			}
			if (options.get(0).getSelectedItem() == "cm") {
				switch (options.get(1).getSelectedItem() + "") {
				case "mi" -> resultado *= 0.00000621371;
				case "km" -> resultado /= 100000;
				case "m" -> resultado /= 100;
				case "ft" -> resultado *= 0.0328084;
				}
			}
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Solo puede ingresar numeros", "ERROR", JOptionPane.ERROR_MESSAGE);
		}
		return resultado;
	}

	public static String[] getGrados() {
		return grados;
	}

	public static String[] getLongitudes() {
		return longitudes;
	}

	public static String[] getMasas() {
		return masas;
	}

	public static String[] getStringCategorias() {
		return stringCategorias;
	}

	private static String[] grados = { "Celsius", "Kelvin", "Fahrenheit" };
	private static String[] longitudes = { "km", "mi", "m", "ft", "cm" };
	private static String[] masas = { "gramos", "kilogramos", "libras", "onzas" };
	private static String[] stringCategorias = { "Temperatura", "Masas", "Longitud" };
	private ArrayList<JComboBox<String>> options = new ArrayList<JComboBox<String>>();
}
