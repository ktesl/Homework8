package homework23.api.services;

import homework23.api.dto.OrderDTO;
import homework23.api.dto.UserDTO;
import io.restassured.response.Response;

public class UsersService extends BaseService {
    protected static final String newUserPath = "/api/User";
    protected static final String loginUserPath = "/api/Login";
    protected static final String addToCartPath = "/api/ShoppingCart/AddToCart/";
    protected static final String checkShoppingCartPath = "/api/ShoppingCart/";
    protected static final String checkoutOrderPath = "/api/CheckOut/";

    public Response createNewUser(UserDTO user) {
        return setRequestSpec()
                .body(user)
                .when().post(newUserPath);
    }

    public Response loginUser(UserDTO user) {
        return setRequestSpec()
                .body(user)
                .when().post(loginUserPath);
    }

    public Response addToCartPath(int userId, int bookId) {
        return setRequestSpec()
                .body(userId)
                .when().post(addToCartPath + userId + "/" + bookId);
    }

    public Response addToCartWithoutUserIdPath(int bookId) {
        return setRequestSpec()
                .body(bookId)
                .when().post(addToCartPath + bookId);
    }

    public Response checkShoppingCartPath(int userId) {
        return setRequestSpec()
                .when().get(checkShoppingCartPath + userId);
    }

    public Response checkShoppingCartWithWrongParameterPath(int userId, int bookId) {
        return setRequestSpec()
                .when().get(checkShoppingCartPath + userId + "/" + bookId);
    }

    public Response addCheckoutOrderPath(int userId, OrderDTO order, String token) {
        return setRequestSpec()
                .header("Authorization", "Bearer " + token)
                .body(order)
                .when().post(checkoutOrderPath + userId);

    }

    public Response addCheckoutOrderWithoutBearerTokenPath(int userId, OrderDTO order) {
        return setRequestSpec()
                .body(order)
                .when().post(checkoutOrderPath + userId);

    }
}
