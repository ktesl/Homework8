package homework22.api;

import homework22.api.dto.UserDTO;
import homework22.api.dto.UserIdDTO;
import homework22.api.dto.UserResponseDTO;
import homework22.api.services.UsersService;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertEquals;

public class UsersTest {
    UsersService usersService = new UsersService();

    @Test
    public void getSingleUserTestV2() {
        UserIdDTO expectedId = new UserIdDTO(2);
        Response response = usersService.getSingleUser();

        int userId = response.then()
                .statusCode(200)
                .extract()
                .body().jsonPath().getInt("data.id");

        assertEquals(userId, expectedId.getId());
    }

    @Test
    public void getSingleUserNotFoundTestV2() {
        UserIdDTO expectedId = new UserIdDTO();
        expectedId.setId(23);
        Response response = usersService.getSingleUserNotFound();

        response.then()
                .statusCode(404)
                .body("isEmpty()", equalTo(true));

    }

    @Test
    public void postCreateTest() {
        UserDTO expectedUser = TestData.buildDefaultUserData();

        Response response = usersService.postCreate(expectedUser);

        UserResponseDTO actualResponseDto = response.then().statusCode(201)
                .extract().as(UserResponseDTO.class);

        assertEquals(actualResponseDto.getName(), expectedUser.getName());
        assertEquals(actualResponseDto.getJob(), expectedUser.getJob());

    }

    @Test
    public void deleteDeleteTest() {
        Response response = usersService.deleteDelete();

        response.then()
                .statusCode(204)
                .body(isEmptyOrNullString());

    }
}
