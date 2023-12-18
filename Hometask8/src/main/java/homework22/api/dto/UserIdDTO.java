package homework22.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class UserIdDTO {
    @JsonProperty("id")
    private int id;

    public UserIdDTO() {
    }

    public UserIdDTO(int id) {
        this.id = id;
    }

    public UserIdDTO(String id) {
        this.id = Integer.parseInt(id);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "UserIdDTO{" +
                "id=" + id +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserIdDTO that = (UserIdDTO) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
