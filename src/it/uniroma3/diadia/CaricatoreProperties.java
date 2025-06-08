package it.uniroma3.diadia;

import java.io.*;
import java.util.Properties;

public class CaricatoreProperties {
	private static Properties prop;

	public static int get(String parametro) {
		if (prop==null)
			creaFile();
		try {
			return Integer.parseInt((String) prop.get(parametro));
		} catch (NumberFormatException e) {}
		return 0;
	}

	public static void creaFile() {
		prop = new Properties();
		try {
			String pathFile = "properties";
			prop.load(new FileReader(pathFile));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
