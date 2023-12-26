package homework23.api;

import com.github.javafaker.Faker;
import homework23.api.dto.BookDTO;
import homework23.api.dto.OrderDTO;
import homework23.api.dto.OrderDetailDTO;
import homework23.api.dto.UserDTO;

import java.time.LocalDate;
import java.util.Collections;


public class TestData {
    public static String getGender() {
        Faker faker = new Faker();
        return faker.random().nextInt(0,1) == 0 ? "Male" : "Female";
    }

    public static UserDTO buildDefaultUserData() {
        Faker faker = new Faker();
        return UserDTO.builder()
                .firstName(faker.name().firstName())
                .lastName(faker.name().lastName())
                .username(faker.name().username())
                .password("securePassword")
                .gender(getGender())
                .build();
    }

    public static UserDTO buildUserDataWithoutPasswordField() {
        Faker faker = new Faker();
        return UserDTO.builder()
                .firstName(faker.name().firstName())
                .lastName(faker.name().lastName())
                .username(faker.name().username())
                .gender(getGender())
                .build();
    }

    public static UserDTO buildUserDataWithWrongFieldType() {
        Faker faker = new Faker();
        return UserDTO.builder()
                .firstName(faker.name().firstName())
                .lastName(faker.name().lastName())
                .username(faker.name().username())
                .password(null)
                .gender(getGender())
                .build();
    }

    public static OrderDTO buildAddCheckoutOrder() {
        Faker faker = new Faker();
        int cartTotal = faker.random().nextInt(1, 100);
        return OrderDTO.builder()
                .orderId(faker.random().nextInt(1, 100).toString())
                .orderDetails(Collections.singletonList(
                        OrderDetailDTO.builder()
                                .book(BookDTO.builder()
                                        .bookId(faker.random().nextInt(1, 100))
                                        .title(faker.book().title())
                                        .author(faker.name().fullName())
                                        .category(faker.book().genre())
                                        .price(faker.random().nextDouble())
                                        .coverFileName(faker.book().title())
                                        .build())
                                .quantity(cartTotal)
                                .build()
                ))
                .cartTotal(cartTotal)
                .orderDate(LocalDate.now().toString())
                .build();
    }
}
