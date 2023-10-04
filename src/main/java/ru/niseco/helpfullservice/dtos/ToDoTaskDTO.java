package ru.niseco.helpfullservice.dtos;

import lombok.*;

import java.time.LocalDateTime;
import java.util.Objects;

@Getter//делает getterы
@Setter//делает setterы
@AllArgsConstructor//Делает конструктор с аргументами (Lombok)
@NoArgsConstructor//Делает конструктор без аргументов(Lombok)
@Builder//механгизм для использования шаблона Builder (Lombok)
public class ToDoTaskDTO { //Data Transfer Object(DTO)

    private Long id;
    private String title;
    private String description;
    private Boolean completed;
    private LocalDateTime createdAt;
    private LocalDateTime updated_at;
    private LocalDateTime deadline;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ToDoTaskDTO toDoTaskDTO = (ToDoTaskDTO) o;
        return Objects.equals(id, toDoTaskDTO.id) && Objects.equals(title, toDoTaskDTO.title) && Objects.equals(description, toDoTaskDTO.description) && Objects.equals(completed, toDoTaskDTO.completed) && Objects.equals(createdAt, toDoTaskDTO.createdAt) && Objects.equals(updated_at, toDoTaskDTO.updated_at) && Objects.equals(deadline, toDoTaskDTO.deadline);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, description, completed, createdAt, updated_at, deadline);
    }
}

/*
DTO (Data Transfer Object) - это паттерн проектирования,
который используется в разработке программного обеспечения
для передачи данных между компонентами приложения.
Основная цель DTO - это упростить передачу данных
и уменьшить количество запросов между клиентом и сервером, особенно в случаях,
когда объекты данных имеют множество полей, но не все из них нужны в данном контексте.
 */
