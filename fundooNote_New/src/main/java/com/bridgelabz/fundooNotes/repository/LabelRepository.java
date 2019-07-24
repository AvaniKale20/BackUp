package com.bridgelabz.fundooNotes.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bridgelabz.fundooNotes.model.Label;





public interface LabelRepository extends JpaRepository<Label, Long> {

	public Label findByLabelIdAndUserId(long LableId , long UserId);
	public Optional<Label> findByUserIdAndLabelName(long UserId, String LabelName);
	public List<Label> findByUserId(long UserId);
}
