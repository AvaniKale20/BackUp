package com.bridgelabz.fundooNotes.dto;

public class NoteDto {
 private String title;
 private String description;
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
@Override
public String toString() {
	return "NoteDto [Title=" + title + ", Description=" + description + "]";
}
 
 
}
