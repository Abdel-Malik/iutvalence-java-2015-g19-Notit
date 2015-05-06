package fr.iutvalence.java.Notit;

/**
 * A note.
 * @author G19
 */

public abstract class Note {
	
	private final int number;
	private String title;
	
	private String content;
	
	protected Note(int number, String title, String content){
		this.number = number;
		this.title = title;
		this.content = content;
		
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	

}
