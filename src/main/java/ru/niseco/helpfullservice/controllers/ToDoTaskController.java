package ru.niseco.helpfullservice.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.niseco.helpfullservice.dtos.ToDoTaskDTO;
import ru.niseco.helpfullservice.services.ToDoTaskService;

import java.util.List;
// класс контроллер, простыми словами - ручки за которые мы дергаем на сайте и получаем результат.
@RestController //обозначение класса как контроллера RESTful веб-службы
@RequiredArgsConstructor//автоматически генерирует конструктор для всех final полей класса
@RequestMapping("/todo_list")//используется для маппинга HTTP-запросов к методам контроллера
public class ToDoTaskController {
    private final ToDoTaskService toDoTaskService;
    /* Спринг использует IoC - Invercion of Control
     и DI - dependency injection.
     DI - может быть в сеттерах, конструкторах и полях.
     в данном случае как best practice мы используем DI в конструкторе.
     Мы инжектим (вставляем ссылку) класс, который потом будем использовать
    */

    @GetMapping("/")
    /*используется для маппинга методов контроллера с HTTP GET-запросами.
    Эта аннотация указывает, что метод должен быть вызван, когда клиент
    отправляет GET-запрос на указанный URL-путь. В нашем случае это localhost:8081/todo_list/.*/
    public List<ToDoTaskDTO> showAll() {// метод который показывает нам все задачи
        return toDoTaskService.showAllToDoTasks();//тут мы у нашего сервиса вызываем метод "покажи все задачи"
    }

    @GetMapping("/find_by_id/{id}")
    /*Аналогично но по пути localhost:8081/todo_list/find_by_id/ и передаем id*/
    public ToDoTaskDTO findById(@PathVariable Long id) {
        return toDoTaskService.findById(id);
    }

    @DeleteMapping("/delete/{id}")
    /*Аналогично GetMapping, но только запрос Delete по адресу localhost:8081/todo_list/delete/и передаем id  */
    public void deleteById(@PathVariable Long id) {//метод для удаления задачи
        toDoTaskService.deleteToDoTask(id);//у скрвиса вызываем метод "удали по id"
    }

    @PostMapping("/create")
    /*Аналогично GetMapping, но только запрос Post по адресу localhost:8081/todo_list/create/ */
    public ToDoTaskDTO createNewToDoTask(@RequestBody ToDoTaskDTO dto) {// метод для создания задачи
        return toDoTaskService.createToDoTask(dto);//у сервиса вызываем метод "создай задачу" и передаем поля с фронта от пользователя
    }

    @PutMapping("/update")
    /*Аналогично GetMapping, но только запрос Put по адресу localhost:8081/todo_list/update/ */
    public ToDoTaskDTO updateToDoTask(@RequestBody ToDoTaskDTO dto) {// метод для корректировки задачи
        return toDoTaskService.updateToDoTask(dto); //у сервиса вызываем метод "создай задачу" и передаем поля с фронта от пользователя
    }

    @PutMapping("/done/{id}")
    public ToDoTaskDTO makeDone(@PathVariable Long id) {//метод для отметки задачи "Сделано"
        return toDoTaskService.makeDone(id);//у сервиса вызываем метод "сделано" и передаем id
    }

    @GetMapping("/show_deadline/{id}")
    public String showDeadline(@PathVariable Long id) {
        return toDoTaskService.showDeadLine(id);
    }

}

/*
GET: Используется для запроса данных с сервера.
GET-запрос не должен изменять состояние сервера и не должен иметь побочных эффектов.
Он просто запрашивает данные и возвращает их клиенту.

POST: Используется для отправки данных на сервер для обработки.
POST-запрос может изменять состояние сервера и выполнять различные операции,
такие как создание новых ресурсов или обновление существующих.

PUT: Используется для обновления существующего ресурса на сервере или создания нового ресурса,
если он не существует. PUT-запрос полностью заменяет существующий ресурс новыми данными.

DELETE: Используется для удаления ресурса на сервере.
DELETE-запрос удаляет указанный ресурс, если он существует.
 */
