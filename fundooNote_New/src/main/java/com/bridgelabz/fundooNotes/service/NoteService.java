package com.bridgelabz.fundooNotes.service;

import java.util.List;

import com.bridgelabz.fundooNotes.dto.CollaboratorDto;
import com.bridgelabz.fundooNotes.dto.NoteDto;
import com.bridgelabz.fundooNotes.model.Note;
import com.bridgelabz.fundooNotes.response.Response;

public interface NoteService {

public Response updateNote(NoteDto noteDto,String token, Long noteId);
public Response retrieveNote(String token, long noteId);
public Response deleteNote(String token, long noteId);
public Response deleteNotePermenantly(String token, long noteId);
public Response setColour(String token, long noteId, String color);

public Response checkPinOrNot(String token, long noteId);
public Response checkArchieveOrNot(String token, long noteId);

public List<Note> getPinnedNote(String token);
public List<Note> getArchievedNote(String token);

public List<Note> restoreTrashNotes(String token);

Response setReminder(String token, long noteId, String time);
Response deleteReminder(String token, long noteId);

Note findNoteFromUser(String title, String description);
public Response createNote(NoteDto noteDto, String token);

public Response addCollaboratorToNote(String token, long noteId, CollaboratorDto collaboratordto);
public Response deleteCollaboratorToNote(String token, long noteId, String emailId);

}
