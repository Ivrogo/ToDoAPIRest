package dev.ivrogo.todoapirest.DTO;

public class UpdateTaskDTO {

    private String description;

    public UpdateTaskDTO(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
