package homework22.api;

import com.github.javafaker.Faker;
import homework22.api.dto.UserDTO;

public class TestData {
static int userId = 2;
static int userNotFoundId = 23;

    public static UserDTO buildDefaultUserData() {
        Faker faker = new Faker();
        return UserDTO.builder()
                .name(faker.name().fullName())
                .job(faker.job().position())
                .build();
    }
}
