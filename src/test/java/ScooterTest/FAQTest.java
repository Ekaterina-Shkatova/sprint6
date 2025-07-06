package scootertest;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.HomePageScooter;
import java.time.Duration;

import static scootertest.Resources.*;

public class FAQTest {
    private WebDriver driver;

    @BeforeEach
    public void startDriver(){
        // Создать веб-драйвер для Google Chrome
        driver = new ChromeDriver();
        // Очистить куки
        driver.manage().deleteAllCookies();
        // Установить отображения элемента страницы - 10 секунд
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        // Установить время ожидания загрузки страницы - 10 секунд
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
    }

    @ParameterizedTest
    @MethodSource("getDateSetFAQ")
    public void FAQCorrectAnswerText(String question, String answer, String answerText) {
        // Открыть страницу домашнюю Яндекс Самокат
        driver.get(MAIN_PAGE_SCOOTER);
        // Создать объект класса с домашней страницей
        HomePageScooter objHomePage = new HomePageScooter(driver);
        // Принять куки
        objHomePage.acceptCookieButtonClick();
        // Проскролить страницу до появления таблицы с вопросами
        objHomePage.scrollDown();
        // Проверка соответствия текста ответа с ожидаемым
        objHomePage.clickQuestion(question);
        objHomePage.isCorrectText(objHomePage.getAnswer(answer), answerText);
    }

    public static Object[][] getDateSetFAQ() {
        return new Object[][]{
                {QUESTION_PAYMENT, ANSWER_PAYMENT, ANSWER_PAYMENT_TEXT},
                {QUESTION_QUANTITY, ANSWER_QUANTITY, ANSWER_QUANTITY_TEXT},
                {QUESTION_RENT, ANSWER_RENT, ANSWER_RENT_TEXT},
                {QUESTION_ORDER, ANSWER_ORDER, ANSWER_ORDER_TEXT},
                {QUESTION_RETURN, ANSWER_RETURN, ANSWER_RETURN_TEXT},
                {QUESTION_LOADING, ANSWER_LOADING, ANSWER_LOADING_TEXT},
                {QUESTION_CANCEL, ANSWER_CANCEL, ANSWER_CANCEL_TEXT},
                {QUESTION_DELIVERY_AREA, ANSWER_DELIVERY_AREA, ANSWER_DELIVERY_AREA_TEXT}
        };
    }

    @AfterEach
    public void tearDown() { driver.quit(); }
}
