package com.ia.init;

import com.ia.modelo.MenuGUI;
import com.ia.modelo.ArchivoTxt;
import com.ia.modelo.TableroGUI;

public class Main extends javax.swing.JFrame {
    
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private TableroGUI tableroGUI1; 
	private MenuGUI menu;
	private ArchivoTxt txtFile;
	
    public Main(ArchivoTxt txt) 
    {
    	this.txtFile = txt;
        initComponents();
    }
                          
    private void initComponents() 
    {
    	
        tableroGUI1 = new TableroGUI(txtFile,true);
        menu = new MenuGUI(tableroGUI1);
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        javax.swing.GroupLayout tableroGUI1Layout = new javax.swing.GroupLayout(tableroGUI1);
        tableroGUI1.setLayout(tableroGUI1Layout);
        
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        
        
        this.setMenuBar(menu.showMenuDemo());
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tableroGUI1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(tableroGUI1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(0, Short.MAX_VALUE))
        );
        pack();
    }
    
    
    public TableroGUI getTableroGUI1() {
		return tableroGUI1;
	}

	public void setTableroGUI1(TableroGUI tableroGUI1) {
		this.tableroGUI1 = tableroGUI1;
	}

	public ArchivoTxt getTxtFile() {
		return txtFile;
	}

	public void setTxtFile(ArchivoTxt txtFile) {
		this.txtFile = txtFile;
	}

	public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() 
            {
            	//Leer un archivo de texto
            	ArchivoTxt txt = new ArchivoTxt();
            	txt.leerArchivo("C:\\Users\\Javier HM\\Desktop\\mapa.txt");
            	
            	int width = txt.getWidth();
            	int height = txt.getHeight();
            	//
                new Main(txt).setVisible(true);
            }
        });
    }
                        
                 
    
}
