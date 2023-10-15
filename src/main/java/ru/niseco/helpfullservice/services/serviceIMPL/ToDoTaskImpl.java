package ru.niseco.helpfullservice.services.serviceIMPL;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import ru.niseco.helpfullservice.converters.ToDoTaskConverter;
import ru.niseco.helpfullservice.dtos.ToDoTaskDTO;
import ru.niseco.helpfullservice.entities.ToDoTask;
import ru.niseco.helpfullservice.exceptions.ResourceNotFoundException;
import ru.niseco.helpfullservice.repositories.ToDoTaskRepository;
import ru.niseco.helpfullservice.services.ToDoTaskService;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ToDoTaskImpl implements ToDoTaskService {
    private final ToDoTaskRepository repository;
    private final ToDoTaskConverter converter;
    private final ModelMapper modelMapper;

    @Override
    public ToDoTaskDTO findById(Long id) {
        return converter.entityToDto(repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Задача не найдена по id:" + id)));
    }

    @Override
    public List<ToDoTaskDTO> showAllToDoTasks() {
        return repository.findAll().stream().map((element) -> modelMapper.map(element, ToDoTaskDTO.class)).collect(Collectors.toList());
    }

    @Override
    public ToDoTaskDTO createToDoTask(ToDoTaskDTO dto) {
        ToDoTask task = modelMapper.map(dto, ToDoTask.class);
        task.setCompleted(false);
        task = repository.save(task);
        return modelMapper.map(task, ToDoTaskDTO.class);
    }

    @Override
    public ToDoTaskDTO updateToDoTask(ToDoTaskDTO dto) {
        ToDoTask oldTask = repository.findById(dto.getId()).orElseThrow(() -> new ResourceNotFoundException("Задача не найдена"));
        if (dto.getCompleted() == null) {
            dto.setCompleted(false);
        }
        oldTask.setTitle(dto.getTitle());
        oldTask.setDescription(dto.getDescription());
        oldTask.setCompleted(dto.getCompleted());
        oldTask.setDeadline(dto.getDeadline());
        oldTask.setUpdated_at(LocalDateTime.now());
        repository.save(oldTask);
        return modelMapper.map(oldTask, ToDoTaskDTO.class);
    }

    @Override
    public void deleteToDoTask(Long id) {
        repository.deleteById(id);
    }

    @Override
    public ToDoTaskDTO makeDone(Long id) {
        ToDoTask taskToDone = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Задача не найдена"));
        if (taskToDone.getCompleted()) {
            taskToDone.setCompleted(false);
            repository.save(taskToDone);
            return modelMapper.map(taskToDone, ToDoTaskDTO.class);
        }
        taskToDone.setCompleted(true);
        repository.save(taskToDone);

        return modelMapper.map(taskToDone, ToDoTaskDTO.class);
    }

    @Override
    public String showDeadLine(Long id) {

        ToDoTask task = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Задача не найдена"));

        if (task.getDeadline() != null) {
            LocalDateTime deadline = task.getDeadline();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMMM yyyy", new Locale("ru", "RU"));
            String formattedDeadline = deadline.format(formatter);
            return "{\"deadline\":\"" + formattedDeadline + "\"}"; // Обернуть строку в JSON объект
        } else {
            return "{\"deadline\":\"Дедлайн не установлен\"}"; // Обернуть строку в JSON объект
        }

    }
}
