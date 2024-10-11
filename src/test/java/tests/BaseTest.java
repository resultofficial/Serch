package tests;

import org.junit.jupiter.api.BeforeAll;
import static com.codeborne.selenide.Configuration.*;

public class BaseTest {
    @BeforeAll
    public static void beforeAll() {
        browserSize = "1920x1080";// Увеличиваем размер окна для видимости элементов
        baseUrl = "https://selenide.";//обсалютный путь
        pageLoadStrategy = "eager";
        holdBrowserOpen = true;//оставлять браузер открытый после теста
        timeout = 5000; // default 4000
    }
}
