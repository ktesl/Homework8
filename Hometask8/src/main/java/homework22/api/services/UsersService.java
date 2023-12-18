package homework22.api.services;

import homework22.api.dto.UserDTO;
import io.restassured.response.Response;

public class UsersService extends BaseService {
    protected static final String usersPath = "/api/users/";

    public Response getSingleUser(int id) {
        return setRequestSpec().when()
                .get(usersPath + id);
    }

    public Response getSingleUserNotFound(int id) {
        return setRequestSpec().when()
                .get(usersPath + id);
    }

    public Response postCreate(UserDTO user) {
        return setRequestSpec()
                .body(user)
                .when().post(usersPath);
    }

    public Response deleteDelete(int id) {
        return setRequestSpec().when()
                .delete(usersPath + id);
    }
}
