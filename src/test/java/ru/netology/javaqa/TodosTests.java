package ru.netology.javaqa;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.javaqa.Todos;

public class TodosTests {
    @Test
    public void shouldAddThreeTasksOfDifferentType() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {simpleTask, epic, meeting};
        Task[] actual = todos.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindByQueryOfAllTasks() {
        SimpleTask simpleTask = new SimpleTask(1, "Обновить ПО");

        String[] subtasks = {"Купить клавиатуру", "Купить мышку", "Купить зарядник"};
        Epic epic = new Epic(6, subtasks);

        Meeting meeting = new Meeting(9, "Собеседование", "Новая компания", "Четверг 10.00");

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {simpleTask};
        Task[] actual = todos.search("Обновить ПО");

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldFindByQueryOfAllTasks2() {
        SimpleTask simpleTask = new SimpleTask(1, "Обновить ПО");

        String[] subtasks = {"Купить клавиатуру", "Купить мышку", "Купить зарядник"};
        Epic epic = new Epic(6, subtasks);

        Meeting meeting = new Meeting(9, "Собеседование", "Новая компания", "Четверг 10.00");

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {epic};
        Task[] actual = todos.search("Купить клавиатуру");

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldFindByQueryOfAllTasks3() {
        SimpleTask simpleTask = new SimpleTask(1, "Обновить ПО");

        String[] subtasks = {"Купить клавиатуру", "Купить мышку", "Купить зарядник"};
        Epic epic = new Epic(6, subtasks);

        Meeting meeting = new Meeting(9, "Собеседование", "Новая компания", "Четверг 10.00");

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {meeting};
        Task[] actual = todos.search("Собеседование");

        Assertions.assertArrayEquals(expected, actual);

    }
    @Test
    public void shouldFindSeveralTasksByQuery() {
        SimpleTask simpleTask = new SimpleTask(1, "Купить подписку на ПО");

        String[] subtasks = {"Купить клавиатуру", "Купить мышку", "Купить зарядник"};
        Epic epic = new Epic(6, subtasks);

        Meeting meeting = new Meeting(9, "Собеседование", "Новая компания", "Четверг 10.00");

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {simpleTask, epic};
        Task[] actual = todos.search("Купить");

        Assertions.assertArrayEquals(expected, actual);

    }
    @Test public void shouldNotFindTasksByQuery() {
        SimpleTask simpleTask = new SimpleTask(1, "Купить подписку на ПО");

        String[] subtasks = {"Купить клавиатуру", "Купить мышку", "Купить зарядник"};
        Epic epic = new Epic(6, subtasks);

        Meeting meeting = new Meeting(9, "Собеседование", "Новая компания", "Четверг 10.00");

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {};
        Task[] actual = todos.search("Выбрать");

        Assertions.assertArrayEquals(expected, actual);
    }

}
