package fr.iutvalence.java.Notit.swing;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;

public class MyButton extends JButton{
	
	private int id;
	
	public MyButton(){
		super();
		this.setBorder(null);
		this.setFocusPainted(false);
		this.setBackground(Color.WHITE);
	}
	
	public MyButton(String nom, int theID){
		super(nom);
		this.id = theID;
		this.setBackground(Color.WHITE);
		this.setFont(new Font("Lao UI", 1, 15));
		this.setFocusPainted(false);
		this.setBorder(null);
		
	}
	
	public int getID(){
		return this.id;
	}

}
