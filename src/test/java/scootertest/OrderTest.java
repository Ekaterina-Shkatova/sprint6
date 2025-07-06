package scootertest;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pages.HomePageScooter;
import pages.OrderPageScooter;
import java.time.Duration;

import static scootertest.Resources.*;

public class OrderTest {
    private WebDriver driver;

    @BeforeEach
    public void startDriver(){
        // Создать веб-драйвер для Firefox
        driver = new FirefoxDriver();
        // Очистить куки
        driver.manage().deleteAllCookies();
        // Установить отображения элемента страницы - 10 секунд
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        // Установить время ожидания загрузки страницы - 10 секунд
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
    }

    @ParameterizedTest
    @MethodSource("getDateSetForOrder")
    public void orderPositiveTest(String name, String surname, String address, String subway, String phoneNumber, String date, String rentalPeriod, String color, String comment) throws Exception {
        // Открыть страницу заказа Яндекс Самокат
        driver.get(MAIN_PAGE_SCOOTER);
        // Создать объект класса с домашней страницей
        HomePageScooter objHomePage = new HomePageScooter(driver);
        // Принять куки
        objHomePage.acceptCookieButtonClick();
        // Нажать на кнопку Заказать на чердаке
        objHomePage.clickHeaderOrderButton();
        // Создать объект класса со страницей заказа
        OrderPageScooter objOrderPage = new OrderPageScooter(driver);
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
        objOrderPage.isPageOpen(objOrderPage.getConfirmHeader(), CONFIRM_HEADER);
    }

    public static Object[][] getDateSetForOrder() {
        return new Object[][]{
                {"Мария", "Ивановна", "г. Москва, ул. Молдавская, д.2", "Кунцевская", "89990000000", "27.06.2090", "сутки", "серая безысходность", "Не стучать"},
                {"Василий", "Курочкин", "улица Александра Солженицына, 23", "Таганская", "+79999996666", "18.12.2089", "двое суток", "чёрный жемчуг", "Привезите рабочий самокат"}
        };
    }

    @AfterEach
    void tearDown() { driver.quit();
    }
}
