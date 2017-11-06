package com.ia.modelo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class ArchivoTxt {
	
	private int width;
	private int height;
	private String values[][];
	
	public void leerArchivo(String pathStr)
	{
		try 
		{
			Path path = Paths.get(pathStr);
			List<String> texto=Files.readAllLines(path);
			this.width = texto.size();
			this.height = texto.get(0).split(",").length;
			
			values = new String[width][height];
			int i=0;
			for(String cadena:texto) 
			{
				String fila [] = cadena.split(",");
				int j=0;
				for(String f : fila)
				{
					this.values[i][j]= f;
					j++;
				}
				i++;
				
			}
			 
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public String[][] getValues() {
		return values;
	}
	public void setValues(String[][] values) {
		this.values = values;
	}
	
	

}
