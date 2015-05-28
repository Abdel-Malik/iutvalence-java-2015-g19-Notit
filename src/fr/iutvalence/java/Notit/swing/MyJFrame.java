package fr.iutvalence.java.Notit.swing;

import javax.swing.JFrame;

public class MyJFrame extends JFrame{

	public MyJFrame(){
		  this.setTitle("NotIt");
		  this.setSize(800, 800);
		  this.setResizable(false);
		  this.setLocationRelativeTo(null);
		  this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    
		  
		  this.setVisible(true);
	}
}
