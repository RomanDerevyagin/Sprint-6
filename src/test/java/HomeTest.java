import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import samokat.HomePage;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HomeTest {
    private WebDriver driver;
    // Таким образом можно проверить каждый вопрос из списка. Не стал расписывать до конца, из задания не очень ясно нужно ли проверить каждый вопрос или достаточно одного.
    @Test
    public void checkFAQ() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox", "--disable-dev-shm-usage");
        driver = new ChromeDriver(options);
        driver.get("https://qa-scooter.education-services.ru");

        HomePage hp = new HomePage(driver);
        hp.scrollToFaq();
        hp.clickFirst();
        String text = hp.textFirst();
        assertEquals("Сутки — 400 рублей. Оплата курьеру — наличными или картой." , text , "Не совдает текст");
    }
    @Test
    public void checkFAQ1() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox", "--disable-dev-shm-usage");
        driver = new ChromeDriver(options);
        driver.get("https://qa-scooter.education-services.ru");

        HomePage hp = new HomePage(driver);
        hp.scrollToFaq();
        hp.clickSecond();
        String text = hp.textSecond();
        assertEquals("Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим." , text , "Не совдает текст");
    }
    @AfterEach
    public void teardown() {
        driver.quit();
    }
}
