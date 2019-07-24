package com.bridgelabz.fundooNotes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bridgelabz.fundooNotes.model.Note;


@Repository
public interface NoteRepository extends JpaRepository<Note, Long> {
	public Note findByUserIdAndNoteId(long userId, long noteId);

	public Note findByTitleAndDescription(String title, String description);
}
