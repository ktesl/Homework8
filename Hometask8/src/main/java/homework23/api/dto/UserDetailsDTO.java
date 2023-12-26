package homework23.api.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserDetailsDTO{
    @JsonProperty("userId") int userId;
    @JsonProperty("firstName") String firstName;
    @JsonProperty("lastName") String lastName;
    @JsonProperty("username") String username;
    @JsonProperty("password") String password;
    @JsonProperty("gender") String gender;
    @JsonProperty("userTypeId") int userTypeId;
}

