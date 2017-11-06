package com.ia.modelo;

import java.awt.*;
import java.awt.event.*;

public class MenuGUI {
   private String personajes[];
   private TableroGUI tablero;

   public MenuGUI(TableroGUI tablero)
   {
	   this.tablero = tablero;
   }

   public MenuBar showMenuDemo(){
      //create a menu bar
      final MenuBar menuBar = new MenuBar();

      //Menu bar
      Menu juegoMenuHeader = new Menu("Juego");
      Menu empezarMenuHeader = new Menu("Emepzar"); 
      final Menu aboutMenu = new Menu("About");

      //subMenu juego
      MenuItem personajesSubMenu = new MenuItem("Personajes");
      personajesSubMenu.setActionCommand("Personajes");

      //subMenu empezar
      MenuItem cutMenuItem = new MenuItem("Algoritmo A*");
      cutMenuItem.setActionCommand("Algoritmo A*");
   


      //add menu items to menus
      juegoMenuHeader.add(personajesSubMenu);

      empezarMenuHeader.add(cutMenuItem);

      //add menu to menubar
      menuBar.add(juegoMenuHeader);
      menuBar.add(empezarMenuHeader);
      menuBar.add(aboutMenu);
      
      personajesSubMenu.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("A huevo papi");
			System.out.println(tablero.getHeight());
			//TODO aqui activar que se va a operar con jugador humano 
			tablero.setPersonajeActivado("Humano");
			
		}
	});

      //add menubar to the frame
      
      return menuBar;
   }

   
}
