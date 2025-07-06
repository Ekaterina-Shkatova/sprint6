package scootertest;

public class Resources {
    public static final String ANSWER_PAYMENT_TEXT = "Сутки — 400 рублей. Оплата курьеру — наличными или картой.";
    public static final String ANSWER_QUANTITY_TEXT = "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.";
    public static final String ANSWER_RENT_TEXT = "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.";
    public static final String ANSWER_ORDER_TEXT = "Только начиная с завтрашнего дня. Но скоро станем расторопнее.";
    public static final String ANSWER_RETURN_TEXT = "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.";
    public static final String ANSWER_LOADING_TEXT = "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.";
    public static final String ANSWER_CANCEL_TEXT = "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.";
    public static final String ANSWER_DELIVERY_AREA_TEXT = "Да, обязательно. Всем самокатов! И Москве, и Московской области.";
    public static final String ORDER_HEADER = "Для кого самокат";
    public static final String CONFIRM_HEADER = "Посмотреть статус";

    public static final String MAIN_PAGE_SCOOTER = "https://qa-scooter.praktikum-services.ru/";
    public static final String MAIN_PAGE_YANDEX = "https://ya.ru";
    public static final String MAIN_PAGE_SCOOTER_ORDER = "https://qa-scooter.praktikum-services.ru/order";

    // Сколько это стоит? И как оплатить?
    public static final String QUESTION_PAYMENT = ".//div[@id='accordion__heading-0']";
    // Хочу сразу несколько самокатов! Так можно?
    public static final String QUESTION_QUANTITY = ".//div[@id='accordion__heading-1']";
    // Как рассчитывается время аренды?
    public static final String QUESTION_RENT = ".//div[@id='accordion__heading-2']";
    // Можно ли заказать самокат прямо на сегодня?
    public static final String QUESTION_ORDER = ".//div[@id='accordion__heading-3']";
    // Можно ли продлить заказ или вернуть самокат раньше?
    public static final String QUESTION_RETURN = ".//div[@id='accordion__heading-4']";
    // Вы привозите зарядку вместе с самокатом?
    public static final String QUESTION_LOADING = ".//div[@id='accordion__heading-5']";
    // Можно ли отменить заказ?
    public static final String QUESTION_CANCEL = ".//div[@id='accordion__heading-6']";
    // Я живу за МКАДом, привезёте?
    public static final String QUESTION_DELIVERY_AREA = ".//div[@id='accordion__heading-7']";

    // Сутки — 400 рублей. Оплата курьеру — наличными или картой.
    public static final String ANSWER_PAYMENT = "accordion__panel-0";
    // Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.
    public static final String ANSWER_QUANTITY = "accordion__panel-1";
    // Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.
    public static final String ANSWER_RENT = "accordion__panel-2";
    // Только начиная с завтрашнего дня. Но скоро станем расторопнее.
    public static final String ANSWER_ORDER = "accordion__panel-3";
    // Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.
    public static final String ANSWER_RETURN = "accordion__panel-4";
    // Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.
    public static final String ANSWER_LOADING = "accordion__panel-5";
    // Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.
    public static final String ANSWER_CANCEL = "accordion__panel-6";
    // Да, обязательно. Всем самокатов! И Москве, и Московской области.
    public static final String ANSWER_DELIVERY_AREA = "accordion__panel-7";


}