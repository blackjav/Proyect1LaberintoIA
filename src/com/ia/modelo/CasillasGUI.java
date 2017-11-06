package com.ia.modelo;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class CasillasGUI extends javax.swing.JPanel implements MouseListener 
{
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private TableroGUI tablero;
    private ImageIcon fondo;
    private String tipoTerreno;
    private static int [] casillaMarcada = new int[2];
    
    public CasillasGUI() 
    {        
    }
    
    public CasillasGUI(TableroGUI t) 
    {
        initComponents();        
        this.tablero = t;
        if(this.tablero.getTipoTablero() == true)
        {
            this.addMouseListener(this);
        }
    }

    private void initComponents() 
    {
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
	            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGap(0, 161, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
	            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGap(0, 193, Short.MAX_VALUE)
        );
    }                       
    
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.drawImage(fondo.getImage(), 0,0,this.getWidth(),this.getHeight(),this);
    }
    
//    TODO EVENTOS 
    public void mouseClicked(MouseEvent e){}
    public void mouseEntered(MouseEvent e){}
    public void mouseExited(MouseEvent e){}
    public void mouseReleased(MouseEvent e){}
    
    
//    TODO este pedo cambia el color de la celda segun el fuking personaje
    @SuppressWarnings("static-access")
	public void mousePressed(MouseEvent e)
    {
    	
        this.setCasillaMarcada(tablero.getCoordenadas((CasillasGUI)e.getComponent())); 
        
        String personaje = tablero.getPersonajeActivado();
        if(personaje != null)
        {
            this.tablero.pintar(this.getCasillaMarcada()[0],this.getCasillaMarcada()[1],tablero.getHumano());
        }
        else
        {
            this.tablero.pintar(this.getCasillaMarcada()[0],this.getCasillaMarcada()[1],null);

        }
    }
    
    public static int[] getCasillaMarcada() {
        return casillaMarcada;
    }
    public static void setCasillaMarcada(int[] aCasillaMarcada) {
        casillaMarcada = aCasillaMarcada;
    }   
    
    public void setFondo(ImageIcon fondo){
        this.fondo = fondo;
    }
    
    public ImageIcon getFondo(){        
        return this.fondo;
    }

	public TableroGUI getTablero() {
		return tablero;
	}

	public void setTablero(TableroGUI tablero) {
		this.tablero = tablero;
	}

	public String getTipoTerreno() {
		return tipoTerreno;
	}

	public void setTipoTerreno(String tipoTerreno) {
		this.tipoTerreno = tipoTerreno;
	}
    
    
}