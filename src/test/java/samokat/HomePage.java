package samokat;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
    private WebDriver driver;
    // Кнопка Заказать в хедере
    private By orderUp = By.className("Button_Button__ra12g");
    // Кнопка заказать в середине экрана
    private By orderMid = By.cssSelector(".Button_Button__ra12g.Button_Middle__1CSJM");
    // Блок вопросов о важном
    private By block = By.cssSelector(".Home_FAQ__3uVm4");
    // Вопросы
    public void clickQuestion(int index){
        By question = By.id("accordion__heading-" + index);
        driver.findElement(question).click();
    }
    // Ответы
    public String getAnswerText(int index){
        By answer = By.id("accordion__panel-" + index);
        return driver.findElement(answer).getText();
    }
    // Кнопка про куки
    private By cookie = By.id("rcc-confirm-button");

    public HomePage(WebDriver driver){
        this.driver=driver;
    }
    public void clickUp(){
        driver.findElement(orderUp).click();
    }
    public void clickMiddle(){
        driver.findElement(orderMid).click();
    }
    public void clickCookie(){
        driver.findElement(cookie).click();
    }
    public void scrollToFaq() {
        WebElement header = driver.findElement(block);
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView(true);", header
        );
    }
}
