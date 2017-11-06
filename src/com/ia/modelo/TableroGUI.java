package com.ia.modelo;

import javax.swing.*;

public class TableroGUI extends javax.swing.JPanel 
{
    /**
	 * 
	 */
	private static final long serialVersionUID = 7656663036625016567L;
	private ImageIcon agua,tierra, tocado,humano;
    private boolean tipoTablero;
    private CasillasGUI [][] casillas ;
    private int anchoTablero = 1000;
    private int altoTablero = 600;
    private String personajeActivado;
  
    
    
    public TableroGUI() {
        initComponents();
    }
    
    public TableroGUI(ArchivoTxt txt, boolean tipo) {
        initComponents();
        int x,y;
        int width = txt.getWidth();
        int height = txt.getHeight();
        
        setLayout(new java.awt.GridLayout( height	, width));
        this.tipoTablero = tipo;
        cargarImagenes();
        
        casillas = new CasillasGUI[height][width];
        
        for (int i = 0; i < height; i++)
        {
            for (int j = 0; j < width; j++)
            {
            	String tipoTerreno = txt.getValues()[i][j];
                casillas[i][j] = new CasillasGUI(this); 
                casillas[i][j].setFondo(colorTerreno(tipoTerreno));
                casillas[i][j].setTipoTerreno(tipoTerreno);
                x = (i * anchoTablero/width) +1;
                y = (j * altoTablero/height) +1;
                casillas[i][j].setBounds(x, y, anchoTablero/width, altoTablero/height);
                
                this.add(casillas[i][j]);
            }
        }
    }
    
    public boolean getTipoTablero(){
        return this.isTipoTablero();
    }
    
    public void pintar(int x, int y,ImageIcon icon)
    {
    	if(icon != null)
    	{
    		this.casillas[x][y].setFondo(icon);
          
    	}
    	else
    	{
    		this.casillas[x][y].setFondo(tocado);
    	}
    	  this.repaint();
        
    }
    
    @SuppressWarnings("static-access")
	private void cargarImagenes() 
    {
        this.agua = this.cargarFondo("../imagenes/agua.gif");
        this.tocado = this.cargarFondo("../imagenes/tocado.gif");
        this.tierra= this.cargarFondo("../imagenes/tierra.jpg");
        this.humano = this.cargarFondo("../imagenes/humano.png");
    }
    private ImageIcon colorTerreno(String tipo)
    {
    	switch (tipo) 
    	{
			case "0":
					return agua;	
			case "1":
					return tierra;
			case "2":
				return tocado;
			case "3":
				return humano;

		default:
			return agua;
		}
    }
    
    protected static ImageIcon cargarFondo(String ruta) 
    {
        java.net.URL localizacion = TableroGUI.class.getResource(ruta);
        if (localizacion != null) {
            return new ImageIcon(localizacion);
        } else {
            System.err.println("No se ha encontrado el archivo: " + ruta);
            return null;
        }
    }
    
    public int[] getCoordenadas(CasillasGUI casilla) {
        int [] coordenadas = new int[2];
        for (int i=0; i < this.casillas.length; i++) {
            for (int j=0; j < this.casillas.length; j++) {
                if (this.casillas[i][j] == casilla) {
                    coordenadas[0] = i;
                    coordenadas[1] = j;
                }
            }
        }
        return coordenadas;
    }
    
    private void initComponents() {
    	personajeActivado=null;
        setLayout(null);
        setBackground(new java.awt.Color(0, 0, 0));
        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        setPreferredSize(new java.awt.Dimension(anchoTablero, altoTablero));
    }    
    
    public CasillasGUI[][] getCasillas() {
        return casillas;
    }
    
    public void setCasillas(CasillasGUI[][] casillas) {
        this.casillas = casillas;
    }
    
    public boolean isTipoTablero() {
        return tipoTablero;
    }    
    public void setTipoTablero(boolean tipoTablero) {
        this.tipoTablero = tipoTablero;
    }
                              
    public ImageIcon getAgua() {
		return agua;
	}

	public void setAgua(ImageIcon agua) {
		this.agua = agua;
	}

	public ImageIcon getTocado() {
		return tocado;
	}

	public void setTocado(ImageIcon tocado) {
		this.tocado = tocado;
	}

	public int getAnchoTablero() {
		return anchoTablero;
	}

	public void setAnchoTablero(int anchoTablero) {
		this.anchoTablero = anchoTablero;
	}

	public int getAltoTablero() {
		return altoTablero;
	}

	public void setAltoTablero(int altoTablero) {
		this.altoTablero = altoTablero;
	}

	public ImageIcon getTierra() {
		return tierra;
	}

	public void setTierra(ImageIcon tierra) {
		this.tierra = tierra;
	}

	public String getPersonajeActivado() {
		return personajeActivado;
	}

	public void setPersonajeActivado(String personajeActivado) {
		this.personajeActivado = personajeActivado;
	}

	public ImageIcon getHumano() {
		return humano;
	}

	public void setHumano(ImageIcon humano) {
		this.humano = humano;
	}

	                  
                     
}