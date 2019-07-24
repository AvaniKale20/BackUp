package com.bridgelabz.fundooNotes.service;

import java.util.List;


import com.bridgelabz.fundooNotes.dto.NoteDto;
import com.bridgelabz.fundooNotes.model.Label;
import com.bridgelabz.fundooNotes.response.Response;



public interface LabelService {
	
	public Response createLabel(LabelDto labeldto , String token);

	public Response updateLabel(LabelDto labeldto, String token, long labelId);

	public Response deleteLabel(String token, long labeId);

	public List<Label> getAllLabelFromUser(String token);

	public Response removeLabelFromNote(long labelId , String token ,long noteId);

	public Response addLabelToNote(long labelId, String token, long noteId);

	public List<LabelDto> getLabelsOfNote(String token, long noteId);

	public List<NoteDto> getNotesOfLabel(String token, long labelId);
}
