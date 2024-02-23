package com.medilaboNotes.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medilaboNotes.model.Declencheurs;
import com.medilaboNotes.model.Note;
import com.medilaboNotes.repositories.NoteRepository;

@Service
public class NoteService {

	@Autowired
	private NoteRepository noteRepository;

	public List<Note> findAllNotes() {
		return noteRepository.findAll();
	}

	public Note saveNote(Note note) {
		return noteRepository.insert(note);
	}

	public List<Note> findNoteById(Integer id) {
		return noteRepository.findByPatId(id);
	}

	public List<Object> getPatientGroups() {
		return noteRepository.groupByPatient();
	}

	public Object getPatientNotes() {
		return noteRepository.findAllNotes();
	}

	public List<Note> findPatientAndNote(String patient, Declencheurs symp) {
		return noteRepository.findPatientAndNote(patient, symp);
	}

	public List<String> getPatientNotesContaining(String patient) {
//		String symptomes[] = new String[] { "Hémoglobine", "Microalbumine", "Taille", "Poids", "Fumeu", "Anormal",
//				"Cholestérol", "Vertige", "Rechute", "Réaction", "Anticorps" };

		List<Declencheurs> list = Arrays.asList(Declencheurs.values());
		List<String> count = new ArrayList<>();

		list.forEach(symp -> {
			List<Note> listSymp = noteRepository.findPatientAndNote(patient, symp);
			if (listSymp.size() > 0) {
				count.add(symp.toString());
			}
		});

		String decl = "fume";
		System.out.println(list);
		return count;
	}
}
