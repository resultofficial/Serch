package tests;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;


import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;


@DisplayName("Поиск элементов в интернете")//неименование тест кейсов
public class SearchElement extends BaseTest {

    @BeforeEach
    void setUp() {
        open("https://duckduckgo.com/");
    }


    @Tags({
            @Tag("Web"),
            @Tag("Smoke")
    })
    @CsvFileSource(resources = "/testData/suarchInInternetElement.csv")
    @ParameterizedTest(name = "Для поискового запроса {0} в первой карточке должен быть")
    void suarchInInternetElement(String serchQuery, String expectedLink) {
        $("#searchbox_input").setValue(serchQuery).pressEnter();
        $("[data-testid='mainline'] li[data-layout='organic']")
                .shouldHave(text(expectedLink));


    }

}


