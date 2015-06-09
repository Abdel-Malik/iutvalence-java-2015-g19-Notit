package fr.iutvalence.java.Notit.swing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.TileObserver;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.plaf.DimensionUIResource;

import fr.iutvalence.java.Notit.Date;
import fr.iutvalence.java.Notit.DayNote;
import fr.iutvalence.java.Notit.GeneralNote;
import fr.iutvalence.java.Notit.Path;

public class NewNoteFrame extends JFrame implements ActionListener{

	private MainFrame theFrame;
	private Button addNoteButton;
	private JLabel titleLabel;
	private JLabel contentsLabel;
	private JTextField titleText;
	private JTextArea contentsText;
	private JSplitPane titleSplitPane;
	private JSplitPane contentsSplitPane;
	private Date date;
	private DayPanel panel;
	
	public NewNoteFrame(MainFrame frame){
		displayOfFrame(frame);
	}
	
	public NewNoteFrame(Date date, MainFrame frame){
		this.date=date;
		displayOfFrame(frame);
	}
	
	public NewNoteFrame(Date date, DayPanel panel, MainFrame frame){
		this.panel = panel;
		this.date=date;
		displayOfFrame(frame);
	}
	
	private void displayOfFrame(MainFrame frame){
		this.setTitle("Not'It : Nouvelle note");
		ImageIcon img = new ImageIcon("img/calendar_icon.png");
		this.setIconImage(img.getImage());
		this.setSize(500, 380); 
		this.setResizable(false); 
		this.setLocationRelativeTo(null);
		this.theFrame = frame;
		
		/**
		 * JButton
		 */
		this.addNoteButton = new Button(null, new Dimension(500, 40), "Add");
		this.addNoteButton.setBackground(new Color(231, 76, 60));
		this.addNoteButton.setFont(new Font("Lao UI", 1, 20));
		this.addNoteButton.addActionListener(this);
		
		/**
		 * JLabel
		 */
		this.titleLabel = new JLabel("Title :");
		this.titleLabel.setFont(new Font("Lao UI", 1, 18));
		this.contentsLabel = new JLabel("Contents :");
		this.contentsLabel.setFont(new Font("Lao UI", 1, 18));
		
		this.titleLabel.setPreferredSize(new Dimension(500, 40));
		this.contentsLabel.setPreferredSize(new Dimension(500, 40));
		
		/**
		 * JTextField
		 */
		this.titleText = new JTextField("Title", 30);
		this.titleText.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(231, 76, 60)));
		this.contentsText = new JTextArea("Content");
		this.contentsText.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(231, 76, 60)));
		
		this.titleText.setPreferredSize(new Dimension(500, 20));
		this.contentsText.setPreferredSize(new Dimension(500, 240));

		/**
		 * JSplitPane
		 */
		this.titleSplitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, this.titleLabel, this.titleText);
		this.contentsSplitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, this.contentsLabel, this.contentsText);
		this.titleSplitPane.setBackground(Color.WHITE);
		this.contentsSplitPane.setBackground(Color.WHITE);
		this.titleSplitPane.setBorder(null);
		this.contentsSplitPane.setBorder(null);
		this.titleSplitPane.setDividerSize(0);
		this.contentsSplitPane.setDividerSize(0);
				
		this.add(titleSplitPane, BorderLayout.PAGE_START);
		this.add(contentsSplitPane, BorderLayout.CENTER);
		this.add(addNoteButton, BorderLayout.PAGE_END);
		
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==this.addNoteButton)
			if(this.date==null){
				try {
					this.theFrame.getApplication().createGNotes(this.titleText.getText(), this.contentsText.getText());
					this.dispose();
					this.theFrame.getHomePage().displayGeneralNote();
					
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
			else{
				if(this.panel==null)
				{
					try {
						this.theFrame.getApplication().createDayNotes(this.titleText.getText(), this.contentsText.getText(), this.date);
						this.dispose();
						this.theFrame.getHomePage().displayDayNote();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
				else{
					try {
						this.theFrame.getApplication().createDayNotes(this.titleText.getText(), this.contentsText.getText(), this.date);
						this.dispose();
						this.panel.displayDayNotePanel();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
				
			}
	}
}
