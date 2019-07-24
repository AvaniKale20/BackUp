package com.bridgelabz.fundooNotes.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bridgelabz.fundooNotes.model.Collaborator;




@Repository
public interface CollaboratorRepository extends JpaRepository<Collaborator, Long> {

	public Optional<Collaborator> findByEmailId(String EmailId);
}
