package com.bridgelabz.fundooNotes.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.bridgelabz.fundooNotes.exception.UserException;
import com.bridgelabz.fundooNotes.dto.CollaboratorDto;
import com.bridgelabz.fundooNotes.dto.NoteDto;
import com.bridgelabz.fundooNotes.model.Collaborator;
import com.bridgelabz.fundooNotes.model.EmailId;
import com.bridgelabz.fundooNotes.model.Note;
import com.bridgelabz.fundooNotes.model.User;
import com.bridgelabz.fundooNotes.repository.CollaboratorRepository;
import com.bridgelabz.fundooNotes.repository.NoteRepository;
import com.bridgelabz.fundooNotes.repository.UserRepository;
import com.bridgelabz.fundooNotes.response.Response;
import com.bridgelabz.fundooNotes.utility.ResponseHelper;
import com.bridgelabz.fundooNotes.utility.Token;
import com.bridgelabz.fundooNotes.utility.Utility;


@Service
@PropertySource("classpath:Msg.properties")
public class NoteServiceImplimentation implements NoteService {

	@Autowired
	private Token Token;

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private NoteRepository noteRepository;

	@Autowired
	private Environment environment;
	
	@Autowired
	private CollaboratorRepository collaboratorRepository;

	@Override
	public Response createNote(NoteDto noteDto, String token) {
		// TODO Auto-generated method stub
		long id = Token.decodeToken(token);
		 token=Token.createToken(id);
		 System.out.println(token);
		System.out.println("id"+id);

		if (noteDto.getTitle().isEmpty() && noteDto.getDescription().isEmpty()) {

			throw new UserException(-5, "Title and description are empty");

		}
		Note note = modelMapper.map(noteDto, Note.class);
		Optional<User> user = userRepository.findById(id);
		note.setUserId(id);
		note.setCreated(LocalDateTime.now());
		note.setModified(LocalDateTime.now());
		user.get().getNotes().add(note);
		noteRepository.save(note);
		userRepository.save(user.get());

		Response response = ResponseHelper.statusResponse(100,
				environment.getProperty("status.notes.createdSuccessfull"));
		return response;
	}

	@Override
	public Response updateNote(NoteDto noteDto, String token, Long noteId) {
		// TODO Auto-generated method stub
		if (noteDto.getTitle().isEmpty() && noteDto.getDescription().isEmpty()) {
			throw new UserException(-5, "Title and description are empty");
		}

		long id = Token.decodeToken(token);
		Note note = noteRepository.findByUserIdAndNoteId(id, noteId);
		note.setTitle(noteDto.getTitle());
		note.setDescription(noteDto.getDescription());
		note.setModified(LocalDateTime.now());
		noteRepository.save(note);

		Response response = ResponseHelper.statusResponse(200,
				environment.getProperty("status.notes.updatedSuccessfull"));
		return response;	}

	@Override
	public Response retrieveNote(String token, long noteId) {
		// TODO Auto-generated method stub
		long id = Token.decodeToken(token);
		Note note = noteRepository.findByUserIdAndNoteId(id, noteId);
		String title = note.getTitle();
		System.out.println(title);

		String description = note.getDescription();
		System.out.println(description);

		Response response = ResponseHelper.statusResponse(300, "retrieved successfully");
		return response;	}

	@Override
	public Response deleteNote(String token, long noteId) {
		// TODO Auto-generated method stub
		long id = Token.decodeToken(token);

		Note note = noteRepository.findByUserIdAndNoteId(id, noteId);

		if (note.isTrash() == false) {
			note.setTrash(true);
			note.setModified(LocalDateTime.now());
			noteRepository.save(note);
			Response response = ResponseHelper.statusResponse(100, environment.getProperty("status.note.trashed"));
			return response;
		}

		Response response = ResponseHelper.statusResponse(100, environment.getProperty("status.note.trashError"));
		return response;	}

	@Override
	public Response deleteNotePermenantly(String token, long noteId) {
		// TODO Auto-generated method stub
		long id = Token.decodeToken(token);

		Optional<User> user = userRepository.findById(id);
		Note note = noteRepository.findByUserIdAndNoteId(id, noteId);

		if (note.isTrash() == true) {
			user.get().getNotes().remove(note);
			userRepository.save(user.get());
			noteRepository.delete(note);
			Response response = ResponseHelper.statusResponse(200, environment.getProperty("status.note.deleted"));
			return response;
		} else {
			Response response = ResponseHelper.statusResponse(100, environment.getProperty("status.note.noteDeleted"));
			return response;
		}	}


	@Override
	public Response setColour(String token, long noteId, String color) {
		// TODO Auto-generated method stub

		long userId = Token.decodeToken(token);
		Note note = noteRepository.findByUserIdAndNoteId(userId, noteId);
		if (note == null) {
			throw new UserException(100, "invalid note or not exist");
		}

		note.setColour(color);
		noteRepository.save(note);

		Response response = ResponseHelper.statusResponse(200, environment.getProperty("status.note.color"));
		return response;
	}

	@Override
	public Response checkPinOrNot(String token, long noteId) {
		// TODO Auto-generated method stub

		long userId = Token.decodeToken(token);
		Note note = noteRepository.findByUserIdAndNoteId(userId, noteId);

		if (note == null) {
			throw new UserException(100, "note is not exist");
		}

		if (note.isArchieve() == false) {
			note.setArchieve(true);
			noteRepository.save(note);

			Response response = ResponseHelper.statusResponse(200, environment.getProperty("status.note.archieved"));
			return response;
		} else {
			note.setArchieve(false);
			noteRepository.save(note);

			Response response = ResponseHelper.statusResponse(200, environment.getProperty("status.note.unarchieved"));
			return response;
		}

	}

	@Override
	public Response checkArchieveOrNot(String token, long noteId) {
		// TODO Auto-generated method stub
		long userId = Token.decodeToken(token);
		Note note = noteRepository.findByUserIdAndNoteId(userId, noteId);

		if (note == null) {
			throw new UserException(100, "note is not exist");
		}

		if (note.isArchieve() == false) {
			note.setArchieve(true);
			noteRepository.save(note);

			Response response = ResponseHelper.statusResponse(200, environment.getProperty("status.note.archieved"));
			return response;
		} else {
			note.setArchieve(false);
			noteRepository.save(note);

			Response response = ResponseHelper.statusResponse(200, environment.getProperty("status.note.unarchieved"));
			return response;
		}
	}

	@Override
	public Response setReminder(String token, long noteId, String time) {
		// TODO Auto-generated method stub
		long userId = Token.decodeToken(token);
		Note note = noteRepository.findByUserIdAndNoteId(userId, noteId);

		if (note == null) {
			throw new UserException(-5, "invalid note");
		}

		System.out.println("time is" + time);
		DateTimeFormatter datetimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
		LocalDateTime localDateTime = LocalDateTime.parse(time, datetimeFormatter);
		System.out.println(localDateTime);
		LocalDateTime CurrentDateAndTime = LocalDateTime.now();
		System.out.println(CurrentDateAndTime);
		if (CurrentDateAndTime.compareTo(localDateTime) < 0) {
			note.setRemainder(localDateTime);
			noteRepository.save(note);
			Response response = ResponseHelper.statusResponse(100, environment.getProperty("note.status.remainder"));
			return response;
		}

		Response response = ResponseHelper.statusResponse(101, environment.getProperty("note.status.remainderfail"));

		return response;	}

	@Override
	public Response deleteReminder(String token, long noteId) {
		// TODO Auto-generated method stub
		long userId = Token.decodeToken(token);
		Note note = noteRepository.findByUserIdAndNoteId(userId, noteId);
		if (note == null) {
			throw new UserException(-5, "note invalid");
		}

		note.setRemainder(null);
		noteRepository.save(note);

		Response response = ResponseHelper.statusResponse(100, environment.getProperty("note.status.deleteRemainder"));

		return response;
	}

	@Override
	public Note findNoteFromUser(String title, String description) {
		// TODO Auto-generated method stub
		Note note = noteRepository.findByTitleAndDescription(title, description);
		System.out.println(note);
		if (note == null) {
			throw new UserException(-6, "note is not available");
		}

		return note;	}

	@Override
	public List<Note> getPinnedNote(String token) {
		// TODO Auto-generated method stub
		long userId = Token.decodeToken(token);

		User user = userRepository.findById(userId).orElseThrow(() -> new UserException("No note is available"));
		List<Note> pinNote = user.getNotes().stream().filter(data -> (data.isPin() == true))
				.collect(Collectors.toList());
		user.getNotes().stream().filter(data1 -> (data1.isPin() == true)).collect(Collectors.toList()).forEach(System.out::println);
		
		return pinNote;
	}

	@Override
	public List<Note> getArchievedNote(String token) {
		// TODO Auto-generated method stub
		long userId = Token.decodeToken(token);

		User user = userRepository.findById(userId).orElseThrow(() -> new UserException("No note is available"));
		List<Note> archieveNote = user.getNotes().stream().filter(data -> (data.isArchieve() == true))
				.collect(Collectors.toList());

		user.getNotes().stream().filter(data1 -> (data1.isArchieve() == true)).collect(Collectors.toList()).forEach(System.out::println);
		return archieveNote;	}

	@Override
	public List<Note> restoreTrashNotes(String token) {
		// TODO Auto-generated method stub
		long userId = Token.decodeToken(token);
		User user = userRepository.findById(userId)
				.orElseThrow(() -> new UserException("Sorry ! Note are not available"));
		List<Note> userNote = user.getNotes().stream().filter(data -> (data.isTrash() == true))
				.collect(Collectors.toList());
		
		return userNote;
	}

public Response addCollaboratorToNote(String token, long noteId, CollaboratorDto collaboratordto) {
	EmailId emailId = new EmailId();
	long userId = Token.decodeToken(token);

	Note note = noteRepository.findByUserIdAndNoteId(userId, noteId);

	if (note == null) {
		throw new UserException(-5, "note invalid");
	}
	Optional<Collaborator> userCollaborator = collaboratorRepository.findByEmailId(collaboratordto.getEmailId());

	if (userCollaborator.isPresent()) {
		throw new UserException(-5, "collaborator already present");
	}

	Collaborator collaborator = modelMapper.map(collaboratordto, Collaborator.class);
	Optional<User> mainUser = userRepository.findById(userId);
	Optional<User> collaborateUser = userRepository.findByEmailId(collaboratordto.getEmailId());
	System.out.println(collaborateUser);
	collaborator.setEmailId(collaboratordto.getEmailId());
	collaborator.setNoteId(noteId);
	collaborator.setUserId(userId);
	collaborator.setCreatedAt(LocalDateTime.now());

	collaborateUser.get().getCollaboratedNotes().add(note);
	
	note.getCollaboratedUser().add(collaborateUser.get());

	collaboratorRepository.save(collaborator);
	noteRepository.save(note);

	emailId.setFrom("earthjain143@gmail.com");
	emailId.setTo(collaboratordto.getEmailId());
	emailId.setSubject("Note collaborate to user");
	emailId.setBody("note collaboration from" + mainUser.get().getEmailId() + "to collaborating to"
			+ collaboratordto.getEmailId() + " for following note : title" + note.getTitle() + "and Description is"
			+ note.getDescription());

	Utility.sendEmail(emailId);

	Response response = ResponseHelper.statusResponse(100, environment.getProperty("collaborator.status.create"));

	return response;

}

@Override
public Response deleteCollaboratorToNote(String token, long noteId, String emailId) {
	long userId = Token.decodeToken(token);
	Optional<User> user = userRepository.findByEmailId(emailId);

	if (!user.isPresent()) {
		throw new UserException(-5, "user is not exist");
	}

	Note note = noteRepository.findByUserIdAndNoteId(userId, noteId);
	if (note == null) {
		throw new UserException(-5, "note is not exist");
	}

	Optional<Collaborator> collaborator = collaboratorRepository.findByEmailId(emailId);
	if (collaborator == null) {
		throw new UserException(-5, "collaborator is not exist");
	}
	
	user.get().getCollaboratedNotes().remove(note);
	note.getCollaboratedUser().remove(user.get());

	collaboratorRepository.delete(collaborator.get());
	userRepository.save(user.get());
	noteRepository.save(note);

	Response response = ResponseHelper.statusResponse(100, environment.getProperty("status.collaborator.deleted"));
	return response;
}



	

}
