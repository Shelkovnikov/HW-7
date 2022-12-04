import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.ValueSource;


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
                .HeaderNamesCheck(Name);
    }


    @ParameterizedTest(name = "Проверка содержимого верхнего меню главной страницы {0}")
    @ValueSource(strings = {"Отели", "Музеи", "Экскурсии", "Авиабилеты", "Ж/Д билеты", "Направления"})
    public void test01(String Name) {
        new CheckName()
                .HeaderNamesCheck(Name);

    }
}
