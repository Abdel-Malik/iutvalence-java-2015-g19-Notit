package fr.iutvalence.java.Notit.swing;

import javax.swing.JButton;

public class MyButton extends JButton{
	
	private int id;
	
	public MyButton(){
		super();
	}
	
	public MyButton(String nom, int theID){
		super(nom);
		this.id = theID;
	}
	
	public int getID(){
		return this.id;
	}

}
