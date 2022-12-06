import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;


import java.util.stream.Stream;

import static com.codeborne.selenide.Selenide.open;

public class RusspassTest {


    @BeforeEach
    public void openGeneralPage() {
        open("https://russpass.ru/");

    }


    @CsvFileSource(resources = "names.csv")
    @ParameterizedTest(name = "Проверка содержимого верхнего меню главной страницы {0}")
    public void test02(String Name) {
        new CheckName()
                .headerNamesCheck(Name);
    }


    @ParameterizedTest(name = "Проверка содержимого верхнего меню главной страницы {0}")
    @ValueSource(strings = {"Отели", "Музеи", "Экскурсии", "Авиабилеты", "Ж/Д билеты", "Направления"})
    public void test01(String Name) {
        new CheckName()
                .headerNamesCheck(Name);

    }

    public static Stream<Arguments> test03() {
        return Stream.of(
                Arguments.of("Отели"),
                Arguments.of("Музеи"),
                Arguments.of("Экскурсии"),
                Arguments.of("Авиабилеты"),
                Arguments.of("Ж/Д билеты"),
                Arguments.of("Направления")
        );
    }

    @MethodSource
    @ParameterizedTest(name = "Проверка содержимого верхнего меню главной страницы {0}")

    public void test03(String Name) {
        new CheckName()
                .headerNamesCheck(Name);

    }
}
