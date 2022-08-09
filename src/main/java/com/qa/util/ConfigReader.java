package com.qa.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import javax.imageio.IIOException;



public class ConfigReader {

	private Properties prop;
	
	public Properties init_prop() {
		prop = new Properties();
		
		try {
			FileInputStream ip = new FileInputStream("C:\\Users\\Janki_project\\BDD_Framwork_nopcommerce\\rc\\test\\recorses\\config\\com.properties");
			prop.load(ip);

		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}catch (IOException e) {
				e.printStackTrace();
		}
		return prop;
	}
	}
