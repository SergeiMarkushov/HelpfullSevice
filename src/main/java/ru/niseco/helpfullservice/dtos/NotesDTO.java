package ru.niseco.helpfullservice.dtos;

import lombok.*;

import java.time.LocalDateTime;
import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NotesDTO {
    private Long id;
    private String title;
    private String content;
    private LocalDateTime createdAt;
    private LocalDateTime updated_at;


    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NotesDTO notesDTO = (NotesDTO) o;
        return Objects.equals(id, notesDTO.id) && Objects.equals(title, notesDTO.title) && Objects.equals(content, notesDTO.content) && Objects.equals(createdAt, notesDTO.createdAt) && Objects.equals(updated_at, notesDTO.updated_at);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, content, createdAt, updated_at);
    }
}
