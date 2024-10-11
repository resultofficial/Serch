package tests;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import tests.data.Language;

import java.util.List;
import java.util.stream.Stream;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Configuration.*;
import static com.codeborne.selenide.Selenide.*;

public class PoiskBiletov2 extends BaseTest{

    static Stream<Arguments> poiskCity() {
        return Stream.of(
                Arguments.of(
                        Language.EN,
                        List.of("Quick start",
                                "Docs", "FAQ", "Blog", "Javadoc", "Users", "Quotes")
                ),
                Arguments.of(
                        Language.RU,
                        List.of("С чего начать?",
                                "Док", "ЧАВО", "Блог", "Javadoc", "Пользователи", "Отзывы", "Мы говорим спасибо")
                )
        );
    }

    @ParameterizedTest
    @MethodSource
    void poiskCity(Language Language, List<String> Buttons) {
        open("org");
        $$("#languages a").find(text(Language.name())).click();
        $$(".main-menu-pages a").shouldHave(texts(Buttons));
    }
}
