package ru.netology.javaqa;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TasksTest {
    @Test
    public void shouldFindByQueryInSimpleTask() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        boolean expected = true;
        boolean actual = simpleTask.matches("Позвонить родителям");

        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void shouldNotFindByQueryInSimpleTask() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        boolean expected = false;
        boolean actual = simpleTask.matches("Сделать список покупок");

        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void shouldFindByQueryInEpic() {
        String[] subtasks = {"Забрать телефон", "Выбрать чехол", "Выбрать наушники"};
        Epic epic = new Epic(8, subtasks);

        epic.getSubtasks();

        boolean expected = true;
        boolean actual = epic.matches("Выбрать наушники");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldNotFindByQueryInEpic() {
        String[] subtasks = {"Забрать телефон", "Выбрать чехол", "Выбрать наушники"};
        Epic epic = new Epic(8, subtasks);

        epic.getSubtasks();

        boolean expected = false;
        boolean actual = epic.matches("Купить задярник");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldFindByQueryInMeetingByTopic() {
        Meeting meeting = new Meeting(1, "Релиз новой версии", "Приложение для подсчета шагов", "Понедельник полдень");

        boolean expected = true;
        boolean actual = meeting.matches("Релиз новой версии");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldFindByQueryInMeetingByProject() {
        Meeting meeting = new Meeting(1, "Релиз новой версии", "Приложение для подсчета шагов", "Понедельник полдень");

        boolean expected = true;
        boolean actual = meeting.matches("Приложение для подсчета шагов");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldNotFindByQueryInMeeting() {
        Meeting meeting = new Meeting(1, "Релиз новой версии", "Приложение для подсчета шагов", "Понедельник полдень");

        boolean expected = false;
        boolean actual = meeting.matches("Тестирование требований");

        Assertions.assertEquals(expected, actual);
    }


}
