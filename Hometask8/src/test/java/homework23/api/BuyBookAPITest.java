package homework23.api;

import homework23.api.dto.CartResponseDTO;
import homework23.api.dto.OrderDTO;
import homework23.api.dto.UserResponseDTO;
import homework23.api.dto.UserDTO;
import homework23.api.services.UsersService;
import io.restassured.RestAssured;
import io.restassured.parsing.Parser;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;

public class BuyBookAPITest {
    UserDTO defaultUser;
    String token;
    String userId;
    int bookId = 2;
    UsersService usersService = new UsersService();

    @Test
    public void createNewUserTest() {
        RestAssured.defaultParser = Parser.JSON;
        defaultUser = TestData.buildDefaultUserData();

        Response response = usersService.createNewUser(defaultUser);

        response.then().statusCode(200).extract().asString();
    }

    @Test
    public void createNewUserWithoutRequiredDataEntryTest() {
        RestAssured.defaultParser = Parser.JSON;
        UserDTO expectedUser = TestData.buildUserDataWithoutPasswordField();

        Response response = usersService.createNewUser(expectedUser);

        response.then().statusCode(500).extract().asString();
    }

    @Test
    public void createNewUserWithWrongFieldTypeTest() {
        RestAssured.defaultParser = Parser.JSON;
        UserDTO expectedUser = TestData.buildUserDataWithWrongFieldType();

        Response response = usersService.createNewUser(expectedUser);

        response.then().statusCode(500).extract().asString();
    }

    @Test
    public void loginUserTest() {
        RestAssured.defaultParser = Parser.JSON;
        createNewUserTest();

        Response response = usersService.loginUser(defaultUser);

        UserResponseDTO actualResponseDto = response.then().statusCode(200)
                .extract().as(UserResponseDTO.class);
        token = actualResponseDto.getToken();
        userId = response.then().extract().body().jsonPath().getString("userDetails.userId");
    }

    @Test
    public void loginUserNotFoundTest() {
        RestAssured.defaultParser = Parser.JSON;
        defaultUser = TestData.buildDefaultUserData();

        Response response = usersService.loginUser(defaultUser);

        response.then().statusCode(401).extract().asString();
    }

    @Test
    public String addToCartTest() {
        RestAssured.defaultParser = Parser.JSON;
        loginUserTest();

        Response response = usersService.addToCartPath(Integer.parseInt(userId), bookId);

        String cartItems = response.then().statusCode(200).extract().asString();
        return cartItems;
    }

    @Test
    public void addToCartWithoutRequiredDataTest() {
        RestAssured.defaultParser = Parser.JSON;
        loginUserTest();

        Response response = usersService.addToCartWithoutUserIdPath(bookId );

        response.then().statusCode(405).extract().asString();
    }

    @Test
    public void checkShoppingCartTest() {
        String cartItems = addToCartTest();

        Response response = usersService.checkShoppingCartPath(Integer.parseInt(userId));
        List<CartResponseDTO> actualResponseDtoList = response.then().statusCode(200)
                .extract().body().jsonPath().getList("", CartResponseDTO.class);

        int sum = actualResponseDtoList.stream()
                .mapToInt(cart -> Integer.parseInt(cart.getQuantity()))
                .sum();
        assertEquals(sum, Integer.parseInt(cartItems));
    }

    @Test
    public void checkShoppingCartWithWrongParameterTest() {
        addToCartTest();
        Response response = usersService.checkShoppingCartWithWrongParameterPath(Integer.parseInt(userId), bookId );
        response.then().statusCode(405).extract().asString();
    }

    @Test
    public void addCheckoutOrderTest() {
        RestAssured.defaultParser = Parser.JSON;
        loginUserTest();
        OrderDTO order = TestData.buildAddCheckoutOrder();
        Response response = usersService.addCheckoutOrderPath(Integer.parseInt(userId), order, token);

        response.then().statusCode(200).extract().asString();
    }

    @Test
    public void addCheckoutOrderWithoutBearerTokenTest() {
        RestAssured.defaultParser = Parser.JSON;
        loginUserTest();
        OrderDTO order = TestData.buildAddCheckoutOrder();
        Response response = usersService.addCheckoutOrderWithoutBearerTokenPath(Integer.parseInt(userId), order);

        response.then().statusCode(401).extract().asString();
    }
}
