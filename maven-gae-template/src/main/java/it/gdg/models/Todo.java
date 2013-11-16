package it.gdg.models;

import javax.ws.rs.FormParam;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;

@Entity
public class Todo {

	@Id
	@FormParam("id")
	private Long id;

	@FormParam("title")
	private String title;

	@FormParam("text")
	private String text;

	@FormParam("completed")
	private boolean completed;

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getText() {
		return this.text;
	}

	public void setText(String message) {
		this.text = message;
	}

	public boolean isCompleted() {
		return this.completed;
	}

	public void setCompleted(boolean completed) {
		this.completed = completed;
	}
}
