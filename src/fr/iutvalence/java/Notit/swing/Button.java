package fr.iutvalence.java.Notit.swing;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Button extends JButton
{
	
	
	public Button(ImageIcon img, Dimension size){
		super();
		this.setIcon(img);
		this.setPreferredSize(size);
		this.setBorderPainted(false);
		this.setFocusPainted(false);
	}
	
	
	public Button(ImageIcon img, Dimension size, String text){
		super(text);
		this.setIcon(img);
		this.setPreferredSize(size);
		this.setBorderPainted(false);
		this.setFocusPainted(false);
		this.setForeground(Color.WHITE);
	}
}
