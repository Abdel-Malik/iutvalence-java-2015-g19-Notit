package fr.iutvalence.java.Notit.swing;

import java.util.StringTokenizer;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MultiLineLabel extends JPanel {

	public MultiLineLabel(String text){
		super();
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		StringTokenizer st = new StringTokenizer(text, "\n");
		while(st.hasMoreTokens()) { 
            this.add(new JLabel(st.nextToken())); 
      } 
	}
}
