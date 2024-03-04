package com.medilaboNotes.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.medilaboNotes.model.Note;
import com.medilaboNotes.services.NoteService;

@RestController
@RequestMapping("/notes")
public class NoteController {

	private static final Logger logger = LoggerFactory.getLogger(NoteController.class);

	@Autowired
	private NoteService noteService;

	@GetMapping("/findAllNotes")
	public List<Note> getNotes() {
		return noteService.findAllNotes();
	}

	@PostMapping("/addNote")
	public void saveNote(@RequestBody Note note) {
		noteService.saveNote(note);
	}

	@GetMapping("/{id}")
	public List<Note> getNotesById(@PathVariable("id") int id) {
		return noteService.findNoteById(id);
	}

	@GetMapping("/declencheurs/{patient}")
	public List<String> getPatientNotesContaining(@PathVariable("patient") String patient) {

		return noteService.getPatientNotesContaining(patient);
	}

	@GetMapping("/patient")
	public Object getPatientGroups() {
		return noteService.getPatientGroups();
	}

	@GetMapping("/notes")
	public Object getPatientNotes() {
		return noteService.getPatientNotes();
	}
}
