package dev.ivrogo.todoapirest.DTO;

public class CreateTaskDTO {
    private String Description;

    public CreateTaskDTO(String description) {
        Description = description;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }
}
