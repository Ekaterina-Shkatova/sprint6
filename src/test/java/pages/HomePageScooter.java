package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HomePageScooter {
    private WebDriver driver;

    // Маленькая кнопка Заказать на чердаке
    private By headerOrderButton = By.xpath(".//button[text()='Заказать'][1]");
    // Большая кнопка Заказать на странице
    private By pageOrderButton = By.xpath(".//div[contains(@class, 'Home_FinishButton')]/button");
    // Кнопка Принять куки
    private By pageCookieButton = By.xpath(".//button[text()='да все привыкли']");
    // Список вопросов
    private By pageFAQList = By.xpath(".//div[@class='accordion']");

    public HomePageScooter(WebDriver driver){
        this.driver = driver;
    }
    // Метод скролит вниз до пояления FAQ
    public void scrollDown(){
        WebElement tableFAQ = driver.findElement(pageFAQList);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", tableFAQ);
    }

    // Метод для раскрытия вопросов
    public void clickQuestion(String path) {
        By question = By.xpath(path);
        driver.findElement(question).click();
    }

    // Метод для сравнения ответа на вопрос с правильным текстом
    public void isCorrectText(String answer, String text) {
        assertEquals(text, answer);
    }
    // Геттер для получения текса ответа
    public String getAnswer(String path) {
        By answer = By.id(path);
        return driver.findElement(answer).getText();
    }

    // Методы для клика по кнопкам Заказать
    public void clickHeaderOrderButton() {
        driver.findElement(headerOrderButton).click();
    }

    public void clickPageOrderButton() {
        // Проскролить до появления кнопки
        WebElement bigButton = driver.findElement(pageOrderButton);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", bigButton);
        driver.findElement(pageOrderButton).click();
    }

    public void acceptCookieButtonClick() {
        driver.findElement(pageCookieButton).click();
    }


}
