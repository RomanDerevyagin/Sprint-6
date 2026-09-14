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
    public void clickAndSendName(String username){
        driver.findElement(name).click();
        driver.findElement(name).sendKeys(username);
    }
    public void clickAndSendSurname(String secondName){
        driver.findElement(surname).click();
        driver.findElement(surname).sendKeys(secondName);
    }
    public void clickAndSendAddress(String add){
        driver.findElement(address).click();
        driver.findElement(address).sendKeys(add);
    }
    public void clickMetro(){
        driver.findElement(metro).click();
    }
    public void waitForMetroList() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(
                        By.cssSelector(".select-search__select")
                ));
    }
    public void sendMetro(){
        driver.findElement(sokolniki).click();
    }
    public void clickAndSendPhone(String number){
        driver.findElement(phone).click();
        driver.findElement(phone).sendKeys(number);
    }
    public void clickNext(){
        driver.findElement(next).click();
    }
    public void clickAndSendDate(String calendar){
        driver.findElement(date).click();
        driver.findElement(date).sendKeys(calendar);
        driver.findElement(date).sendKeys(Keys.ENTER);
    }
    public void clickRental(){
        driver.findElement(rentalPeriod).click();
    }
    public void clickRental1(){
        driver.findElement(rentalPeriod1).click();
    }
    public void clickColor(){
        driver.findElement(color).click();
    }
    public void clickFinish(){
        driver.findElement(finish).click();
    }
    public void waitYes() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(
                        By.xpath("//button[text()='Да']")
                ));
    }
    public void clickYes(){
        driver.findElement(yes).click();
    }
    public void waitForFinalScreen() {
        new WebDriverWait(driver, Duration.ofSeconds(15))
                .until(ExpectedConditions.visibilityOfElementLocated(
                        By.className("Order_ModalHeader__3FDaJ")
                ));
    }
    public String finalText(){
        return driver.findElement(successScreen).getText();
    }
}
