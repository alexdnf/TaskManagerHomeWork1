package ru.netology.javaqa;

public class Epic extends Task {
    protected String[] subtasks;

    public Epic(int id, String[] subtasks) {
        super(id);
        this.subtasks = subtasks;
    }

    public String[] getSubtasks() {
        return subtasks;
    }


    public boolean matches(String query) {
        for (String s : subtasks) {
            if (s.contains(query)) {
                return true;
            }
        }
        return false;
    }

}
