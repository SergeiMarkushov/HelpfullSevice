package ru.niseco.helpfullservice.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.web.bind.annotation.*;
import ru.niseco.helpfullservice.dtos.NotesDTO;
import ru.niseco.helpfullservice.services.NoteService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/notes")
public class NotesController {
    private final NoteService noteService;
    @GetMapping
    public List<NotesDTO> showAllNotes(){
        return noteService.getAllNotes();
    }
    @GetMapping("/{id}")
    public NotesDTO showNoteId(@PathVariable Long id){
       return noteService.getNoteByID(id);
    }
    @DeleteMapping("/delete/{id}")
    public void deleteNoteId(@PathVariable Long id){
        noteService.deleteNoteById(id);
    }
    @PostMapping("/create")
    public void createNote(@RequestBody NotesDTO note){
        noteService.createNote(note);
    }
    @PutMapping("/update")
    public void updateNoteId(@RequestBody NotesDTO note){
        noteService.updateNote(note);
    }
}
