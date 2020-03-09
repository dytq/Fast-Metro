package fastmetro;

import  javax.swing.*;

import  java.awt.*;
 
public class Fenetre extends JFrame {

	private static final long serialVersionUID = 1L;

	private JPanel pan = new JPanel();   
	
	public Fenetre(String nom){
        super(nom);                 
        setSize(new Dimension(1008,735));            
        
        BoxLayout bl=new BoxLayout(pan,BoxLayout.Y_AXIS);  
        pan.setLayout(bl);  

        setContentPane(pan);      
        setVisible(true);          
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
	  }
	public void importerImage(String chemin) {        	
        this.setContentPane(new ImagePanel(chemin));
	}
	public void afficherCoords() {
		this.addMouseListener(new Souris());
	}
}