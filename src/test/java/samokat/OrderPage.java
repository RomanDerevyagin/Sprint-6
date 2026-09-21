package samokat;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class OrderPage {
    private WebDriver driver;
    // Поле имя
    private By name = By.cssSelector("input[placeholder='* Имя']");
    // Поле фамилия
    private By surname = By.cssSelector("input[placeholder='* Фамилия']");
    // Поле Адрес
    private By address = By.cssSelector("input[placeholder='* Адрес: куда привезти заказ']");
    // Поле Метро
    private By metro = By.cssSelector("input[placeholder='* Станция метро']");
    // Окно с выбором метро
    private  By metroPage = By.cssSelector(".select-search__select");
    // Поле телефон
    private By phone = By.cssSelector("input[placeholder='* Телефон: на него позвонит курьер']");
    // Кнопка далее
    private By next = By.cssSelector(".Button_Button__ra12g.Button_Middle__1CSJM");
    // Станция Сокольники
    private By sokolniki = By.cssSelector("li[data-index='3']");
    // Поле Когда прмвезти самокат
    private By date = By.cssSelector("input[placeholder='* Когда привезти самокат']");
    // Поле Срок аренды
    private By rentalPeriod = By.cssSelector(".Dropdown-placeholder");
    // Выпадающий список срока аренды
    private By rentalPeriod1 = By.xpath("//div[text()='трое суток']");
    // Цвет самоката
    private By color = By.id("black");
    // Кнопка заказать
    private By finish = By.xpath("//button[contains(@class,'Button_Middle') and text()='Заказать']");
    //Кнопка да
    private By yes = By.xpath("//button[contains(@class,'Button_Middle') and text()='Да']");
    // Заголовок финального экрана
    private By successScreen = By.className("Order_ModalHeader__3FDaJ");

    public OrderPage(WebDriver driver){
        this.driver = driver;
    }
    public void orderBase(String username, String secondName, String add, String number , String calendar){
        // Заполнение имени
        new WebDriverWait(driver, Duration.ofSeconds(15))
                .until(ExpectedConditions.visibilityOfElementLocated(
                        name
                ));
        driver.findElement(name).click();
        driver.findElement(name).sendKeys(username);
        //Заполнение фамилии
        driver.findElement(surname).click();
        driver.findElement(surname).sendKeys(secondName);
        // Заполнение адреса
        driver.findElement(address).click();
        driver.findElement(address).sendKeys(add);
        // Заполнение метро
        driver.findElement(metro).click();
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(
                        metroPage
                ));
        driver.findElement(sokolniki).click();
        //  Заполнение номера телефона
        driver.findElement(phone).click();
        driver.findElement(phone).sendKeys(number);
        // Кнопка далее
        driver.findElement(next).click();
        // Заполнение даты
        new WebDriverWait(driver, Duration.ofSeconds(15))
                .until(ExpectedConditions.visibilityOfElementLocated(
                        date
                ));
        driver.findElement(date).click();
        driver.findElement(date).sendKeys(calendar);
        driver.findElement(date).sendKeys(Keys.ENTER);
        // Заполение срока аренды
        new WebDriverWait(driver, Duration.ofSeconds(15))
                .until(ExpectedConditions.visibilityOfElementLocated(
                        rentalPeriod
                ));
        driver.findElement(rentalPeriod).click();
        driver.findElement(rentalPeriod1).click();
        // Заполенение цвета
        driver.findElement(color).click();
        // клик по кнопке заказать
        driver.findElement(finish).click();
        // ожидание и клик по кнопке да
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(
                        yes
                ));
        driver.findElement(yes).click();
        // ожидание финального экрана
        new WebDriverWait(driver, Duration.ofSeconds(15))
                .until(ExpectedConditions.visibilityOfElementLocated(
                        successScreen
                ));

    }
    public String finalText(){
        return driver.findElement(successScreen).getText();
    }
}
