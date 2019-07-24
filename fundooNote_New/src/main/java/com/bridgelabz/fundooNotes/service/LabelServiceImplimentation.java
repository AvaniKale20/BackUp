package com.bridgelabz.fundooNotes.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.bridgelabz.fundooNotes.dto.LabelDto;
import com.bridgelabz.fundooNotes.dto.NoteDto;
import com.bridgelabz.fundooNotes.exception.UserException;
import com.bridgelabz.fundooNotes.model.Label;
import com.bridgelabz.fundooNotes.model.Note;
import com.bridgelabz.fundooNotes.model.User;
import com.bridgelabz.fundooNotes.repository.LabelRepository;
import com.bridgelabz.fundooNotes.repository.NoteRepository;
import com.bridgelabz.fundooNotes.repository.UserRepository;
import com.bridgelabz.fundooNotes.response.Response;
import com.bridgelabz.fundooNotes.utility.ResponseHelper;
import com.bridgelabz.fundooNotes.utility.Token;

@Service("LableService")
@PropertySource("classpath:Msg.properties")
public class LabelServiceImplimentation implements LabelService {

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private Environment enviornment;

	@Autowired
	private Token userToken;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private LabelRepository labelRepository;

	@Autowired
	private NoteRepository noteRepository;
	@Override
	public Response createLabel(LabelDto labeldto, String token) {
		// TODO Auto-generated method stub
		System.out.println("in service");
		long userId = userToken.decodeToken(token);
		Optional<User> user = userRepository.findById(userId);

		if (!user.isPresent()) {
			throw new UserException(100, "invalid user");
		}

		Optional<Label> labelPresent = labelRepository.findByUserIdAndLabelName(userId, labeldto.getLabelName());

		if (labelPresent.isPresent()) {
			throw new UserException(101, "label already exist");
		}

		Label label = modelMapper.map(labeldto, Label.class);

		label.setLabelName(labeldto.getLabelName());
		label.setUserId(userId);
		label.setCreated(LocalDateTime.now());
		label.setModified(LocalDateTime.now());

		user.get().getLabel().add(label);

		labelRepository.save(label);
		userRepository.save(user.get());

		Response response = ResponseHelper.statusResponse(200, enviornment.getProperty("status.label.created"));
		System.out.println("back to the service");
		return response;
	}

	@Override
	public Response updateLabel(LabelDto labeldto, String token, long labelId) {
		// TODO Auto-generated method stub

		long userId = userToken.decodeToken(token);
		Optional<User> user = userRepository.findById(userId);

		if (!user.isPresent()) {
			throw new UserException(100, "invalid user");
		}

		Label label = labelRepository.findByLabelIdAndUserId(labelId, userId);
		if (label == null) {
			throw new UserException(-6, "No label exist");
		}

		Optional<Label> labelPresent = labelRepository.findByUserIdAndLabelName(userId, labeldto.getLabelName());

		if (labelPresent.isPresent()) {
			throw new UserException(101, "label already exist");
		}

		label.setLabelName(labeldto.getLabelName());
		label.setModified(LocalDateTime.now());
		labelRepository.save(label);

		Response response = ResponseHelper.statusResponse(300, enviornment.getProperty("status.label.updated"));
		return response;

	}

	@Override
	public Response deleteLabel(String token, long labelId) {
		// TODO Auto-generated method stub
		long userId = userToken.decodeToken(token);
		Optional<User> user = userRepository.findById(userId);

		if (!user.isPresent()) {
			throw new UserException(100, "Invalid user");
		}

		Label label = labelRepository.findByLabelIdAndUserId(labelId, userId);
		if (label == null) {
			throw new UserException(101, "label not exist");
		}
		labelRepository.delete(label);

		Response response = ResponseHelper.statusResponse(400, enviornment.getProperty("status.label.deleted"));
		return response;
	
	}

	@Override
	public List<Label> getAllLabelFromUser(String token) {
		// TODO Auto-generated method stub
		long userId = userToken.decodeToken(token);
		Optional<User> user = userRepository.findById(userId);
		if (!user.isPresent()) {
			throw new UserException("Invalid input");
		}

		List<Label> labels = labelRepository.findByUserId(userId);
		List<Label> listLabel = new ArrayList<>();
		for (Label noteLabel : labels) {
			Label labelDto = modelMapper.map(noteLabel, Label.class);
			listLabel.add(labelDto);
		}
		return listLabel;
	}

	@Override
	public Response removeLabelFromNote(long labelId, String token, long noteId) {
		// TODO Auto-generated method stub
		long userId = userToken.decodeToken(token);
		Optional<User> user = userRepository.findById(userId);

		if (user == null) {
			throw new UserException(-6, "invalid input");
		}

		Note note = noteRepository.findByUserIdAndNoteId(userId, noteId);
		if (note == null) {
			throw new UserException(-6, "invalid note");
		}

		Label label = labelRepository.findByLabelIdAndUserId(labelId, userId);
		if (label == null) {
			throw new UserException(-6, "invalid label");
		}

		note.getListLabel().add(label);
		note.setModified(LocalDateTime.now());
		label.getNotes().add(note);
		label.setModified(LocalDateTime.now());
		noteRepository.save(note);
		labelRepository.save(label);

		Response response = ResponseHelper.statusResponse(100, enviornment.getProperty("status.label.addtonote"));
		return response;
	}

	@Override
	public Response addLabelToNote(long labelId, String token, long noteId) {
		// TODO Auto-generated method stub
		long userId = userToken.decodeToken(token);
		Optional<User> user = userRepository.findById(userId);

		if (user == null) {
			throw new UserException(-6, "invalid input");
		}

		Note note = noteRepository.findByUserIdAndNoteId(userId, noteId);
		if (note == null) {
			throw new UserException(-6, "invalid note");
		}

		Label label = labelRepository.findByLabelIdAndUserId(labelId, userId);
		if (label == null) {
			throw new UserException(-6, "invalid label");
		}

		note.getListLabel().add(label);
		note.setModified(LocalDateTime.now());
		label.getNotes().add(note);
		label.setModified(LocalDateTime.now());
		noteRepository.save(note);
		labelRepository.save(label);

		Response response = ResponseHelper.statusResponse(100, enviornment.getProperty("status.label.addtonote"));
		return response;
	}


	@Override
	public List<LabelDto> getLabelsOfNote(String token, long noteId) {
		// TODO Auto-generated method stub
		long userId = userToken.decodeToken(token);
		Optional<User> user = userRepository.findById(userId);
		if (!user.isPresent()) {
			throw new UserException(-6, "User does not exist");
		}
		Optional<Note> note = noteRepository.findById(noteId);
		if (!note.isPresent()) {
			throw new UserException(-6, "Note does not exist");
		}
		List<Label> label = note.get().getListLabel();
		List<LabelDto> listLabel = new ArrayList<>();
		for (Label noteLabel : label) {
			LabelDto labelDto = modelMapper.map(noteLabel, LabelDto.class);
			listLabel.add(labelDto);
		}
		return listLabel;
	}

	@Override
	public List<NoteDto> getNotesOfLabel(String token, long labelId) {
		// TODO Auto-generated method stub}
		long userId = userToken.decodeToken(token);
		Optional<User> user = userRepository.findById(userId);

		if (!user.isPresent()) {
			throw new UserException(-6, "invalid user");
		}

		Label label = labelRepository.findByLabelIdAndUserId(labelId, userId);
		if (label == null) {
			throw new UserException(-6, "invalid label");
		}

		List<Note> notes = label.getNotes();
		List<NoteDto> noteList = new ArrayList<>();

		for (Note note : notes) {
			NoteDto noteDto = modelMapper.map(note, NoteDto.class);
			noteList.add(noteDto);

		}
		return noteList;
	}
	}


