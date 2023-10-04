package ru.niseco.helpfullservice.entities;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity//Аннотация обозначает что данный бин является сущностью(Hibernate)
@Getter//Делает Getterы (Lombok)
@Setter//Делает Setterы (Lombok)
@NoArgsConstructor //Делает конструктор без аргументов(Lombok)
@AllArgsConstructor //Делает конструктор с аргументами (Lombok)
@Builder//механгизм для использования шаблона Builder (Lombok)
@Table(name = "to_do_tasks") // Задает имя таблицы в БД (Hibernate)
public class ToDoTask {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//генерация последовательности для ID поля сущности.
    @Column(name = "id")//название колонки id, NotNull
    private Long id; // Bigserial \ bigint primarykey
    @Column(name = "title", nullable = false)//название колонки,NotNull
    private String title;
    @Column(name = "description")//название колонки
    private String description;
    @Column(name = "completed", columnDefinition = "boolean default false")//название колонки и по дефолту все значения false
    private Boolean completed;
    @CreationTimestamp//аннотация для даты создания
    @Column(name = "created_at")//название колонки
    private LocalDateTime createdAt;
    @UpdateTimestamp//аннотация для даты обновления
    @Column(name = "updated_at")//название колонки
    private LocalDateTime updated_at;
    @Column(name = "deadline")//название колонки
    private LocalDateTime deadline;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ToDoTask toDoTask = (ToDoTask) o;
        return Objects.equals(id, toDoTask.id) && Objects.equals(title, toDoTask.title) && Objects.equals(description, toDoTask.description) && Objects.equals(completed, toDoTask.completed) && Objects.equals(createdAt, toDoTask.createdAt) && Objects.equals(updated_at, toDoTask.updated_at) && Objects.equals(deadline, toDoTask.deadline);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, description, completed, createdAt, updated_at, deadline);
    }
}

/*
Entity (сущность) - это объект, представляющий данные в базе данных.
В контексте разработки приложений, особенно в приложениях,
использующих реляционные базы данных, сущность представляет собой абстракцию для данных,
которые могут быть сохранены и извлечены из базы данных.
Сущности могут соответствовать таблицам в базе данных и обычно имеют поля (атрибуты),
которые соответствуют столбцам в этих таблицах.
*/
