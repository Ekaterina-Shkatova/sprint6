package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LogoPageOpen {
    private WebDriver driver;
    // Логотип Самокат
    private By logoScooter = By.xpath(".//img[@alt='Scooter']");
    // Логотип Яндекс
    private By logoYandex = By.xpath(".//img[@alt='Yandex']");
    // Кнопка Принять куки
    private By pageCookieButton = By.xpath(".//button[text()='да все привыкли']");

    public LogoPageOpen(WebDriver driver){
        this.driver = driver;
    }

    public void acceptCookieButtonClick() {
        driver.findElement(pageCookieButton).click();
    }

    // Методы для клика на логотипы
    public void clickLogoScooter() {
        driver.findElement(logoScooter).click();
    }
    public void clickLogoYandex() {
        driver.findElement(logoYandex).click();
    }
    // Методы проверяют результат
    public String getCurrentPage() {
        return driver.getCurrentUrl();
    }

    public void isCurrentPage(String expectedUrl) {
        String currentUrl = getCurrentPage();
        assertEquals(expectedUrl, currentUrl);
    }

}






