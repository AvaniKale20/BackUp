package com.bridgelabz.fundooNotes.model;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
public class Label {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long labelId;
	
	@NotNull
	@NotEmpty(message = "label name should not be empty")
	private String LabelName;
	
	private LocalDateTime created;
	private LocalDateTime modified;
	private long userId;
	public long getLabelId() {
		return labelId;
	}
	public void setLabelId(long labelId) {
		this.labelId = labelId;
	}
	public String getLabelName() {
		return LabelName;
	}
	public void setLabelName(String labelName) {
		this.LabelName = LabelName;
	}
	public LocalDateTime getCreated() {
		return created;
	}
	public void setCreated(LocalDateTime created) {
		this.created = created;
	}
	public LocalDateTime getModified() {
		return modified;
	}
	public void setModified(LocalDateTime modified) {
		this.modified = modified;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	@Override
	public String toString() {
		return "Label [labelId=" + labelId + ", labelName=" + LabelName + ", created=" + created + ", modified="
				+ modified + ", userId=" + userId + "]";
	}
	@ManyToMany(cascade = CascadeType.ALL)
	public List<Note> notes;
	
	public List<Note> getNotes() {
		return notes;
	}
	public void setNotes(List<Note> notes) {
		this.notes = notes;
	}
	


}
