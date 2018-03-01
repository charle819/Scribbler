package com.scrapbox.Scribbler.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class NoteData {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(length = 65535, columnDefinition = "Text")
	private String noteBody;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNoteBody() {
		return noteBody;
	}

	public void setNoteBody(String noteBody) {
		this.noteBody = noteBody;
	}

	public NoteData() {
		// for hibernate
	}

	public NoteData(int id, String noteBody) {
		super();
		this.id = id;
		this.noteBody = noteBody;
	}

}
