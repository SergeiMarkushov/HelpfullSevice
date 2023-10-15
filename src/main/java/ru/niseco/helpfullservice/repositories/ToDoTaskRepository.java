package ru.niseco.helpfullservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.niseco.helpfullservice.entities.ToDoTask;
@Repository
public interface ToDoTaskRepository extends JpaRepository<ToDoTask, Long> {
}
/*
это интерфейс, который представляет собой
репозиторий для работы с сущностями типа ToDoTask в базе данных.
Этот интерфейс определен для использования с фреймворком Spring Data JPA,
который предоставляет удобные средства для выполнения
операций CRUD (Create, Read, Update, Delete) с данными в базе данных
без написания многочисленных SQL-запросов вручную.

extends JpaRepository<ToDoTask, Long> - это указание,
что ToDoTaskRepository расширяет интерфейс JpaRepository.
JpaRepository является частью Spring Data JPA и
предоставляет готовые методы для работы с базой данных.
В данном случае, интерфейс ToDoTaskRepository работает с сущностями типа ToDoTask,
и каждая сущность имеет уникальный идентификатор типа Long.

Итак, интерфейс ToDoTaskRepository наследует функциональность JpaRepository,
что означает, что можно использовать методы, предоставляемые JpaRepository,
такие как save(), findById(), findAll(), delete(), и другие,
для выполнения операций с объектами ToDoTask в базе данных, без необходимости создавать их вручную.

Это упрощает и ускоряет разработку, так как большинство стандартных операций
с базой данных уже реализованы в JpaRepository, и нужно лишь создать методы-обертки для вызова этих операций.
 */