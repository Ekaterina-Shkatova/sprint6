package ScooterTest;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import static ScooterTest.Resources.*;

public class OrderTest {
    private WebDriver driver;

    @ParameterizedTest
    @MethodSource("getDateSetForOrder")
    public void OrderPositiveTest(String name, String surname, String address, String subway, String phoneNumber, String date, String rentalPeriod, String color, String comment) throws Exception {
        // Создать веб-драйвер для Firefox
        driver = new FirefoxDriver();
        // Открыть страницу заказа Яндекс Самокат
        driver.get("https://qa-scooter.praktikum-services.ru");
        // Создать объект класса с домашней страницей
        HomePageScooter objHomePage = new HomePageScooter(driver);
        // Нажать на кнопку Заказать на чердаке
        objHomePage.clickHeaderOrderButton();
        // Создать объект класса со страницей заказа
        OrderPageScooter objOrderPage = new OrderPageScooter(driver);
        // Принять куки
        objOrderPage.acceptCookieButtonClick();
        // Позитивный сценарий оформления заказа
        objOrderPage.setName(name);
        objOrderPage.setSurname(surname);
        objOrderPage.setAddress(address);
        objOrderPage.setSubway(subway);
        objOrderPage.setPhoneNumber(phoneNumber);
        objOrderPage.clickOrderNextButton();
        objOrderPage.setDate(date);
        objOrderPage.setRentalPeriod(rentalPeriod);
        objOrderPage.setColor(color);
        objOrderPage.setComment(comment);
        objOrderPage.clickOrderCreateButton();
        objOrderPage.clickOrderConfirmButton();
        // Проверить, что открылась страница успешного создания заказа
        objOrderPage.isPageOpen(objOrderPage.getConfirmHeader(), confirmHeader);
    }

    public static Object[][] getDateSetForOrder() {
        return new Object[][]{
                {"Мария", "Ивановна", "г. Москва, ул. Молдавская, д.2", "Кунцевская", "89990000000", "27.06.2090", "сутки", "серая безысходность", "Не стучать"},
                {"Василий", "Курочкин", "улица Александра Солженицына, 23", "Таганская", "+79999996666", "18.12.2089", "двое суток", "чёрный жемчуг", "Привезите рабочий самокат"}
        };
    }

    @AfterEach
    void teardown() { driver.quit();
    }
}
