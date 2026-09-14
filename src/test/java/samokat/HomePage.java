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
    // Первый вопрос о важном
    private By firstQuestion = By.id("accordion__heading-0");
    // Первый ответ
    private By firstAnswer = By.id("accordion__panel-0");
    // Второй вопрос о важном
    private By secondQuestion = By.id("accordion__heading-1");
    // Второй ответ
    private By secondAnswer = By.id("accordion__panel-1");
    // Третий вопрос о важном
    private By thirdQuestion = By.id("accordion__heading-2");
    // Третий ответ
    private By thirdAnswer = By.id("accordion__panel-2");
    // Четвертый вопрос о важном
    private By fourthQuestion = By.id("accordion__heading-3");
    // Четвертый ответ
    private By fourthAnswer = By.id("accordion__panel-3");
    // Пятый вопрос о важном
    private By fifthQuestion = By.id("accordion__heading-4");
    // Пятый ответ
    private By fifthAnswer = By.id("accordion__panel-4");
    // Шестой вопрос о важном
    private By sixQuestion = By.id("accordion__heading-5");
    // Шестой ответ
    private By sixAnswer = By.id("accordion__panel-5");
    // Седьмой вопрос о важном
    private By sevenQuestion = By.id("accordion__heading-6");
    // Седьмой ответ
    private By sevenAnswer = By.id("accordion__panel-6");
    // Восьмой вопрос о важном
    private By eightQuestion = By.id("accordion__heading-7");
    // Восьмой ответ
    private By eighthAnswer = By.id("accordion__panel-7");
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
    public void clickFirst(){
        driver.findElement(firstQuestion).click();
    }
    public String textFirst(){
        return driver.findElement(firstAnswer).getText();
    }
    public void clickSecond(){
        driver.findElement(secondQuestion).click();
    }
    public String textSecond(){
        return driver.findElement(secondAnswer).getText();
    }
    public void clickThird(){
        driver.findElement(thirdQuestion).click();
    }
    public void clickFourth(){
        driver.findElement(fourthQuestion).click();
    }
    public void clickFifth(){
        driver.findElement(fifthQuestion).click();
    }
    public void clickSix(){
        driver.findElement(sixQuestion).click();
    }
    public void clickSeven(){
        driver.findElement(sevenQuestion).click();
    }
    public void clickEight(){
        driver.findElement(eightQuestion).click();
    }
}
