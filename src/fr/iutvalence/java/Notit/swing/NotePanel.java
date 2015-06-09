package fr.iutvalence.java.Notit.swing;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSplitPane;

import fr.iutvalence.java.Notit.Application;
import fr.iutvalence.java.Notit.DayNote;
import fr.iutvalence.java.Notit.GeneralNote;

public class NotePanel extends JPanel implements ActionListener{

	private JLabel noteName;
	private JLabel descriptionNote;
	private JButton deleteNote;
	private JButton editNote;
	private JSplitPane buttonSplit;
	private JSplitPane labelSplit;
	private GeneralNote generalNote;
	private DayNote dayNote;
	private Application application;
	private MainFrame theFrame;
	private DayPanel panel;

	public NotePanel(GeneralNote generalNote, MainFrame theFrame){
		this.generalNote=generalNote;
		display(generalNote.getTitle(), generalNote.getContent(), theFrame);
	}

	public NotePanel(DayNote dayNote, MainFrame theFrame){
		this.dayNote = dayNote;
		display(dayNote.getTitle(), dayNote.getContent(), theFrame);
	}

	public NotePanel(DayNote dayNote, DayPanel panel, MainFrame theFrame){
		this.panel = panel;
		this.dayNote = dayNote;
		display(dayNote.getTitle(), dayNote.getContent(), theFrame);
	}

	public void display(String name, String content, MainFrame theFrame){
		this.theFrame = theFrame;
		this.application = theFrame.getApplication();
		Dimension dimForButton = new Dimension(70, 30);
		Dimension dimForLabel = new Dimension(150,30);

		this.setPreferredSize(new Dimension(250, 75));

		/**
		 * JLabel
		 */
		this.noteName = new JLabel(name);
		this.noteName.setPreferredSize(dimForLabel);
		this.descriptionNote = new JLabel(content);
		this.descriptionNote.setPreferredSize(dimForLabel);

		/**
		 * JButton
		 */
		this.deleteNote = new JButton("delete");
		this.deleteNote.setPreferredSize(dimForButton);
		this.editNote = new JButton("edit");
		this.editNote.setPreferredSize(dimForButton);

		this.deleteNote.addActionListener(this);
		this.editNote.addActionListener(this);
		/**
		 * JSplitPane
		 */
		this.buttonSplit = new JSplitPane(JSplitPane.VERTICAL_SPLIT, deleteNote, editNote);
		this.labelSplit = new JSplitPane(JSplitPane.VERTICAL_SPLIT, noteName, descriptionNote);	

		this.buttonSplit.setDividerSize(0);
		this.labelSplit.setDividerSize(0);

		this.add(buttonSplit, BorderLayout.WEST);
		this.add(labelSplit, BorderLayout.EAST);


	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if(e.getSource()==this.deleteNote){     
			
			int jop = JOptionPane.showConfirmDialog(
				    this.theFrame,
				    "Would you delete this Not'it?",
				    "Delete",
				    JOptionPane.YES_NO_OPTION);
			
			if(jop==JOptionPane.YES_OPTION){
				if( this.generalNote == null){
					try {
						this.application.deleteDayNotes(this.dayNote);
					} catch (IOException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}	

					if(this.panel==null)
					{
						try {
							this.theFrame.getHomePage().displayDayNote();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
					else{
						try {
							this.panel.displayDayNotePanel();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}

				}
				else{
					try {
						this.application.deleteGNotes(this.generalNote);
						this.theFrame.getHomePage().displayGeneralNote();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}


		}

		if(e.getSource()==this.editNote){
			if( this.generalNote == null){
				if(this.panel==null)
				{
					new EditNoteFrame(this.dayNote, this.theFrame);
				}
				else{
					new EditNoteFrame(this.dayNote, this.panel, this.theFrame);
				}
			}
			else{
				new EditNoteFrame(this.generalNote, this.theFrame);
			}


		}

	}

}
