import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import samokat.BaseTest;
import samokat.HomePage;
import samokat.OrderPage;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class OrderUpTest extends BaseTest {
    @BeforeEach
    void browser(){
        browserStart();
    }
    @ParameterizedTest
    @MethodSource("order")
    public void checkOrder(String name, String surname, String address,
                           String phone, String date) {
        OrderPage op = new OrderPage(driver);
        HomePage hp = new HomePage(driver);
        hp.clickCookie();
        hp.clickUp();
        op.OrderBase(name,surname,address,phone,date);
        String screen = op.finalText();
        assertTrue(screen.contains("Номер заказа"));
    }

    @AfterEach
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }

    static Stream<Arguments> order() {
        return Stream.of(
                Arguments.of("Тест", "тестович", "лол 42", "89281234567", "20.01.2026"),
                Arguments.of("Иван", "Иванов", "Москва, Ленина 1", "89991234567", "21.01.2026")
        );
    }
}

