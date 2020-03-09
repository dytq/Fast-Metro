package fastmetro;

import  javax.swing.*;

import  java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.geom.Point2D;
import java.awt.geom.Point2D.Double;
 
public class Fenetre extends JFrame {

	/* error default eclipse */
	private static final long serialVersionUID = 1L;
	
	/* Un pannel pour l'affichage d'un fenetre */
	private JPanel pan = new JPanel();   
	
	/**
	 * Permet d'initialiser une fenêtre
	 * @param nom de la fenetre
	 */
	public Fenetre(String nom){
        super(nom);                 
        setSize(new Dimension(1008,735));            
        
        BoxLayout bl=new BoxLayout(pan,BoxLayout.Y_AXIS);  
        pan.setLayout(bl);  

        setContentPane(pan);      
        setVisible(true);          
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
	  }
	
	/**
	 * Importation d'une image
	 * @param chemin de l'image à afficher dans le pannel
	 */
	public void importerImage(String chemin) {        	
        this.setContentPane(new ImagePanel(chemin));
	}
	
	/**
	 * Recupere donné souris
	 * @return les coordonnées d'une souris
	 */
	public void drawStation(String chemin) {
		ClickDrawStation c = new ClickDrawStation();
		c.setChemin(chemin);
		this.addMouseListener(c);
	}
	
}