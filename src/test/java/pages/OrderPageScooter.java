package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OrderPageScooter {
    private WebDriver driver;
    private By orderHeader = By.xpath(".//div[text()='Для кого самокат']");
    private By aboutOrderHeader = By.xpath(".//div[text()='Про аренду']");
    private By nameField = By.xpath(".//input[@placeholder='* Имя']");
    // Фамилия
    private By surnameField = By.xpath(".//input[@placeholder='* Фамилия']");
    // Адрес: куда привезти заказ
    private By addressField = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");
    // Селектор со списком станций метро
    private By subwayField = By.xpath(".//input[@placeholder='* Станция метро']");
    // Телефон: на него позвонит курьер
    private By phoneNumberField = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");
    // Кнопка Далее
    private By orderNextButton = By.xpath(".//button[text()='Далее']");
    // Когда привезти самокат
    private By dateField = By.xpath(".//input[@placeholder='* Когда привезти самокат']");
    // Поле Срок аренды
    private By rentalPeriodField = By.xpath(".//div[@class='Dropdown-placeholder']");
    // Комментарий для курьера
    private By commentField = By.xpath(".//input[@placeholder='Комментарий для курьера']");
    // Кнопка Заказать
    private By orderCreateButton = By.xpath("//div[contains(@class,'Order_Buttons')]/button[text()='Заказать']");
    // Кнопка подтверждения заказа
    private By orderConfirmButton = By.xpath("//button[@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Да']");
    // Кнопка посмотреть статус
    private By confirmHeader = By.xpath(".//button[text()='Посмотреть статус']");

    public OrderPageScooter(WebDriver driver){
        this.driver = driver;
    }
    // Геттер для получения текста заголовка страницы заказа
    public String getOrderHeader() {
        return driver.findElement(orderHeader).getText();
    }
    // Геттер для получения текста на кнопке для просмотра статуса заказа
    public String getConfirmHeader() { return driver.findElement(confirmHeader).getText(); }
    // Метод для проверки открытия страницы
    public void isPageOpen(String headerText, String text) {
        assertEquals(text, headerText);
    }
    // Метод для заполнения поля * Имя
    public void setName(String name) {
        driver.findElement(nameField).sendKeys(name);
    }
    // Метод для заполнения поля * Фамилия
    public void setSurname(String surname) {
        driver.findElement(surnameField).sendKeys(surname);
    }
    // Метод для заполнения поля * Адрес: куда привезти заказ
    public void setAddress(String address) {
        driver.findElement(addressField).sendKeys(address);
    }
    // Метод для заполнения поля * Станция метро
    public void setSubway(String subway) {
        String xpath = String.format(".//div[text()='%s']", subway);
        driver.findElement(subwayField).click();
        driver.findElement(By.xpath(xpath)).click();
    }
    // Метод для заполнения поля * Телефон: на него позвонит курьер
    public void setPhoneNumber(String phoneNumber) {
        driver.findElement(phoneNumberField).sendKeys(phoneNumber);
    }
    // Метод для перехода ко второй странице создания заказа
    public void clickOrderNextButton() {
        driver.findElement(orderNextButton).click();
    }
    // Метод для заполнения поля * Когда привезти самокат
    public void setDate(String date) {
        driver.findElement(dateField).sendKeys(date);
    }
    // Метод для заполнения поля Срок аренды
    public void setRentalPeriod(String rentalPeriod) {
        String xpath = String.format(".//div[text()='%s']", rentalPeriod);
        driver.findElement(aboutOrderHeader).click();
        driver.findElement(rentalPeriodField).click();
        driver.findElement(By.xpath(xpath)).click();
    }
    // Метод для заполнения поля Цвет самоката
    public void setColor(String color) {
        String xpath = String.format(".//label[text()='%s']", color);
        driver.findElement(By.xpath(xpath)).click();
    }
    // Метод для заполнения поля Комментарий для курьера
    public void setComment(String comment) {
        driver.findElement(commentField).sendKeys(comment);
    }
    // Метод для перехода к подтверждению заказа
    public void clickOrderCreateButton() {
        driver.findElement(orderCreateButton).click();
    }
    // Метод для подтверждения заказа
    public void clickOrderConfirmButton() { driver.findElement(orderConfirmButton).click(); }
}
