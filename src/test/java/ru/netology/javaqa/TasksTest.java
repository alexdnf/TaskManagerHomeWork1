package ru.netology.javaqa;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TasksTest {
    @Test
    public void shouldFindByQueryInSimpleTalk() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        simpleTask.matches("Позвонить родителям");

        String expected = "Позвонить родителям";
        String actual = simpleTask.getTitle();

        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void shouldFindByQueryInEpic() {
        String[] subtasks = {"Забрать телефон", "Выбрать чехол", "Выбрать наушники"};
        Epic epic = new Epic(8, subtasks);

        epic.matches("Забрать телефон");

        String[] expected = {"Забрать телефон", "Выбрать чехол", "Выбрать наушники"};
        String[] actual = epic.getSubtasks();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindByQueryInMeetingTopic() {
        Meeting meeting = new Meeting(1, "Релиз новой версии", "Приложение для подсчета шагов", "Понедельник полдень");

        meeting.matches("Релиз новой версии");

        String expected = "Релиз новой версии";
        String actual = meeting.getTopic();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldFindByQueryInMeetingProject() {
        Meeting meeting = new Meeting(1, "Релиз новой версии", "Приложение для подсчета шагов", "Понедельник полдень");

        meeting.matches("Приложение для подсчета шагов");

        String expected = "Приложение для подсчета шагов";
        String actual = meeting.getProject();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldFindByQueryInMeetingTimeStart() {
        Meeting meeting = new Meeting(1, "Релиз новой версии", "Приложение для подсчета шагов", "Понедельник полдень");

        meeting.matches("Понедельник полдень");

        String expected = "Понедельник полдень";
        String actual = meeting.getStart();

        Assertions.assertEquals(expected, actual);
    }
}
