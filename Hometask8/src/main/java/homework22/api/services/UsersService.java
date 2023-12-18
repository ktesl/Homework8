package homework22.api.services;

import homework22.api.dto.UserDTO;
import io.restassured.response.Response;

public class UsersService extends BaseService {
    protected static final String usersPath = "/api/users";

    public Response getSingleUser() {
        return setRequestSpec().when()
                .get(usersPath + "/2");
    }

    public Response getSingleUserNotFound() {
        return setRequestSpec().when()
                .get(usersPath + "/23");
    }

    public Response postCreate(UserDTO user) {
        return setRequestSpec()
                .body(user)
                .when().post(usersPath);
    }

    public Response deleteDelete() {
        return setRequestSpec().when()
                .delete(usersPath + "/2");
    }
}
