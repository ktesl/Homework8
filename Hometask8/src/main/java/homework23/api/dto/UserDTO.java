package homework23.api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDTO {
    public int userId;
    public String firstName;
    public String lastName;
    public String username;
    public String password;
    public String gender;
    public int userTypeId;
}
