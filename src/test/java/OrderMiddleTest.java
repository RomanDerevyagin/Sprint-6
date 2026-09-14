import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import samokat.HomePage;
import samokat.OrderPage;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class OrderMiddleTest {
    private WebDriver driver;
    // Запускаю в Safari , так как в Chrome баг с кнопкой Да
    @ParameterizedTest
    @MethodSource("order")
    public void checkOrder(String name, String surname, String address,
                           String phone, String date) {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox", "--disable-dev-shm-usage");
        driver = new ChromeDriver(options);
        driver.get("https://qa-scooter.education-services.ru");

        OrderPage op = new OrderPage(driver);
        HomePage hp = new HomePage(driver);
        hp.clickCookie();
        hp.clickMiddle();
        op.clickAndSendName(name);
        op.clickAndSendSurname(surname);
        op.clickAndSendAddress(address);
        op.clickMetro();
        ((JavascriptExecutor) driver).executeScript(
                "var b = document.querySelector('.App_CookieConsent__1yUIN'); if (b) b.remove();"
        );
        op.waitForMetroList();
        op.sendMetro();
        op.clickAndSendPhone(phone);
        op.clickNext();
        op.clickAndSendDate(date);
        driver.findElement(By.className("App_App__15LM-")).click();
        op.clickRental();
        op.clickRental1();
        op.clickColor();
        op.clickFinish();
        op.waitYes();
        op.clickYes();
        op.waitForFinalScreen();
        String screen = op.finalText();
        assertTrue(screen.contains("Номер заказа"));
    }

    @AfterEach
    public void teardown() {

        driver.quit();
    }

    static Stream<Arguments> order() {
        return Stream.of(
                Arguments.of("Лол", "Кек", "Санкт-Петербург 42", "89281234567", "20.01.2026"),
                Arguments.of("Иван", "Иванов", "Москва, Ленина 1", "89991234567", "21.01.2026")
        );
    }
}


