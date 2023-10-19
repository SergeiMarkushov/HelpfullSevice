package ru.niseco.helpfullservice.services;

import org.springframework.stereotype.Service;
import ru.niseco.helpfullservice.dtos.NotesDTO;

import java.util.List;
@Service
public interface NoteService {
    List<NotesDTO> getAllNotes();

    NotesDTO getNoteByID(Long id);

    void createNote(NotesDTO note);

    void updateNote(NotesDTO note);

    void deleteNoteById(Long id);
}
