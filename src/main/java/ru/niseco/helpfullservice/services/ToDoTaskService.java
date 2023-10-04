package ru.niseco.helpfullservice.services;

import org.springframework.stereotype.Service;
import ru.niseco.helpfullservice.dtos.ToDoTaskDTO;

import java.util.List;

@Service
public interface ToDoTaskService {

    ToDoTaskDTO findById(Long id);

    List<ToDoTaskDTO> showAllToDoTasks();

    ToDoTaskDTO createToDoTask(ToDoTaskDTO dto);
    ToDoTaskDTO updateToDoTask(ToDoTaskDTO dto);

    void deleteToDoTask(Long id);

    ToDoTaskDTO makeDone(Long id);
}
