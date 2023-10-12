package ru.niseco.helpfullservice.services.serviceIMPL;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import ru.niseco.helpfullservice.dtos.NotesDTO;
import ru.niseco.helpfullservice.entities.Notes;
import ru.niseco.helpfullservice.exceptions.ResourceNotFoundException;
import ru.niseco.helpfullservice.repositories.NotesRepository;
import ru.niseco.helpfullservice.services.NoteService;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class NotesServiceImpl implements NoteService {
    private final NotesRepository notesRepository;
    private final ModelMapper mapper;


    @Override
    public List<NotesDTO> getAllNotes() {
        List<NotesDTO> notesDTOS = new ArrayList<>();
        List<Notes> notes = notesRepository.findAll();
        for (Notes note : notes) {
            notesDTOS.add(mapper.map(note, NotesDTO.class));
        }
        return notesDTOS;
        // return notesRepository.findAll().stream().map(note -> mapper.map(note,NotesDTO.class)).collect(Collectors.toList());
    }

    @Override
    public NotesDTO getNoteByID(Long id) { //возвращает заметку по её идентификатору, если ее нет вернет null
        return mapper.map(notesRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Данной заметки нет в списке!")), NotesDTO.class);
    }

    @Override
    public void createNote(NotesDTO note) {
        Notes notes = new Notes();
        notes.setTitle(note.getTitle());
        notes.setContent(note.getContent());
        notes.setCreatedAt(note.getCreatedAt());
        notesRepository.save(notes);
    }

    @Override
    public void updateNote(NotesDTO note) {
        Notes notes = notesRepository.findById(note.getId()).orElseThrow(() ->
                new ResourceNotFoundException("Данной заметки нет в списке!"));
        notes.setTitle(note.getTitle());
        notes.setContent(note.getContent());
        notes.setUpdated_at(LocalDateTime.now());
        notesRepository.save(notes);
    }

    @Override
    public void deleteNoteById(Long id) {
        notesRepository.deleteById(id);
    }
}
