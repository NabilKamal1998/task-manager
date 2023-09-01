package app;

import java.time.LocalDate;

public class Task {
    private String name;
    private String description;
    private LocalDate dueDate;
    private boolean isComplete;

    public Task(String name, String description){
        this.name = name;
        this.description = description;
        this.dueDate = dueDate;
        this.isComplete = isComplete;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getDescription(){
        return description;
    }

    public void setDescription(String description){
        this.description = description;
    }

}
